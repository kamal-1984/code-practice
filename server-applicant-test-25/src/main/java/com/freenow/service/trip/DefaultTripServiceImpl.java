/*
 * 
 */
package com.freenow.service.trip;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.freenow.controller.mapper.TripMapper;
import com.freenow.dataaccessobject.TripRepository;
import com.freenow.datatransferobject.TripDTO;
import com.freenow.domainobject.CarDO;
import com.freenow.domainobject.DriverDO;
import com.freenow.domainobject.TripDO;
import com.freenow.domainvalue.OnlineStatus;
import com.freenow.exception.CarAlreadyInUseException;
import com.freenow.exception.ConstraintsViolationException;
import com.freenow.exception.EntityNotFoundException;
import com.freenow.service.car.CarService;
import com.freenow.service.driver.DriverService;


// TODO: Auto-generated Javadoc
/**
 * The Class DefaultTripServiceImpl.
 */
@Service
public class DefaultTripServiceImpl implements TripService {
	
	/** The trip repository. */
	@Autowired
	private TripRepository tripRepository;
	
	/** The car service. */
	@Autowired
	private CarService carService;
	
	/** The driver service. */
	@Autowired
	private DriverService driverService;

	/**
	 * Creates the.
	 *
	 * @param tripDO the trip DO
	 * @return the trip DO
	 */
	@Override
	public TripDO create(TripDO tripDO) {
		return this.tripRepository.save(tripDO);
	}

	/**
	 * Find.
	 *
	 * @return the list
	 */
	@Override
	public List<TripDO> find() {
		return (List<TripDO>) this.tripRepository.findAll();
	}

	/**
	 * Find by driver id and car and live status.
	 *
	 * @param driverId the driver id
	 * @param licensePlate the license plate
	 * @param isLive the is live
	 * @return the trip DO
	 */
	@Override
	public TripDO findByDriverIdAndLicensePlateAndIsLive(Long driverId, String licensePlate, boolean isLive) {
		return this.tripRepository.findByDriverIdAndLicensePlateAndIsLive(driverId, licensePlate, isLive);
	}

	/**
	 * Close trip.
	 *
	 * @param tripDO the trip DO
	 * @return the trip DO
	 */
	@Override
	public TripDO update(TripDO tripDO) {
		return this.tripRepository.save(tripDO);
	}

	/**
	 * Creates the new trip.
	 *
	 * @param tripDTO the trip DTO
	 * @return the string
	 * @throws CarAlreadyInUseException the car already in use exception
	 * @throws EntityNotFoundException the entity not found exception
	 */
	@Override
	@Transactional
	public String createNewTrip(TripDTO tripDTO) throws CarAlreadyInUseException,EntityNotFoundException{
    	try {
			final CarDO carDO = this.carService.find(tripDTO.getLicensePlate());
			final DriverDO driverDO = this.driverService.find(tripDTO.getDriverId());
			if(!carDO.isAvailable()) {
				throw new CarAlreadyInUseException("Selected car already in use");
			}
			
			if(OnlineStatus.OFFLINE.equals(driverDO.getOnlineStatus())) {
				return "Driver is OFFLINE, cannot assign a car";
			}
			
			if(driverDO.isCarSelected()!=null && driverDO.isCarSelected()) {
				return "Driver already selected a car, can't select another car at the same time";
			}
				
			TripDO tripDO = this.create(TripMapper.makeTripDOStart(tripDTO,driverDO));
			if(tripDO!=null) {
				carDO.setAvailable(false);
				this.carService.create(carDO);
				try {
					driverDO.setLicensePlate(carDO.getLicensePlate());
					driverDO.setRating(carDO.getRating());
					driverDO.setCarSelected(true);
					this.driverService.create(driverDO);
					return "Trip Created Successfully";
				} catch (ConstraintsViolationException e) {
					return "Driver entity constraint violation";
				}
			}
				
		} catch (EntityNotFoundException e) {
			throw  new EntityNotFoundException("entity not found :");
		}
		return null;
    }

	/**
	 * Close trip.
	 *
	 * @param tripDTO the trip DTO
	 * @return the string
	 * @throws EntityNotFoundException the entity not found exception
	 */
	@Override
	@Transactional
	public String closeTrip(TripDTO tripDTO) throws EntityNotFoundException {
    		final TripDO tripDO = this.findByDriverIdAndLicensePlateAndIsLive(tripDTO.getDriverId(), tripDTO.getLicensePlate(), true);
    		if(tripDO==null) {
    			return "Live or active trip not found with driver id: "+tripDTO.getDriverId()+" and car licenseplate: "+tripDTO.getLicensePlate();
    		}
    		
			this.update(TripMapper.makeTripDOClose(tripDO));
			if(!tripDO.isLive()) {
				final CarDO carDO = this.carService.find(tripDTO.getLicensePlate());
				final DriverDO driverDO = this.driverService.find(tripDTO.getDriverId());
				carDO.setAvailable(true);
				this.carService.create(carDO);
				try {
					driverDO.setLicensePlate(null);
					driverDO.setRating(null);
					driverDO.setCarSelected(false);
					this.driverService.create(driverDO);
					return "Trip Closed Successfully";
				} catch (ConstraintsViolationException e) {
					return "Driver entity Constraint violation";
				}
			}
					
		return null;
    }

}
