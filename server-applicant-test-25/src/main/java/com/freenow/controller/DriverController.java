/*
 * 
 */
package com.freenow.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.freenow.controller.mapper.DriverMapper;
import com.freenow.datatransferobject.DriverDTO;
import com.freenow.datatransferobject.DriverFilter;
import com.freenow.datatransferobject.TripDTO;
import com.freenow.domainobject.DriverDO;
import com.freenow.domainvalue.OnlineStatus;
import com.freenow.exception.ConstraintsViolationException;
import com.freenow.exception.EntityNotFoundException;
import com.freenow.service.driver.DriverService;
import com.freenow.service.trip.TripService;

// TODO: Auto-generated Javadoc
/**
 * All operations with a driver will be routed by this controller.
 * <p/>
 *
 * @return the string
 */
@RestController
@RequestMapping("v1/drivers")
public class DriverController
{
    /** The driver service. */
    private final DriverService driverService;

	/** The trip service. */
	private final TripService tripService;

    /**
     * Instantiates a new driver controller.
     *
     * @param driverService the driver service
     * @param tripService the trip service
     */
    @Autowired
    public DriverController(final DriverService driverService, final TripService tripService)
    {
        this.driverService = driverService;
		this.tripService = tripService;
    }


    /**
     * Gets the driver.
     *
     * @param driverId the driver id
     * @return the driver
     * @throws EntityNotFoundException the entity not found exception
     */
    @GetMapping("/{driverId}")
    public DriverDTO getDriver(@PathVariable long driverId) throws EntityNotFoundException
    {
    	DriverDTO driverDTO = DriverMapper.makeDriverDTO(driverService.find(driverId));
        return driverDTO;
    }


    /**
     * Creates the driver.
     *
     * @param driverDTO the driver DTO
     * @return the driver DTO
     * @throws ConstraintsViolationException the constraints violation exception
     */
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public DriverDTO createDriver(@Valid @RequestBody DriverDTO driverDTO) throws ConstraintsViolationException
    {
        DriverDO driverDO = DriverMapper.makeDriverDO(driverDTO);
        return DriverMapper.makeDriverDTO(driverService.create(driverDO));
    }


    /**
     * Delete driver.
     *
     * @param driverId the driver id
     * @throws EntityNotFoundException the entity not found exception
     */
    @DeleteMapping("/{driverId}")
    public void deleteDriver(@PathVariable long driverId) throws EntityNotFoundException
    {
        driverService.delete(driverId);
    }


    /**
     * Update location.
     *
     * @param driverId the driver id
     * @param longitude the longitude
     * @param latitude the latitude
     * @throws EntityNotFoundException the entity not found exception
     */
    @PutMapping("/{driverId}")
    public void updateLocation(
        @PathVariable long driverId, @RequestParam double longitude, @RequestParam double latitude)
        throws EntityNotFoundException
    {
        driverService.updateLocation(driverId, longitude, latitude);
    }


    /**
     * Find drivers.
     *
     * @param onlineStatus the online status
     * @return the list
     */
    @GetMapping()
    public List<DriverDTO> findDrivers(@RequestParam OnlineStatus onlineStatus)
    {
        return DriverMapper.makeDriverDTOList(driverService.find(onlineStatus));
    }
    
    /**
     * Select car.
     *
     * @param tripDTO the trip DTO
     * @return the string
     * @throws Exception the exception
     */
    @PutMapping("/selectCar")
    public String selectCar(@RequestBody TripDTO  tripDTO) throws Exception{
    	/// To make this service thread safe, we can add synchronized block , to avoid 2 drivers trying to book same car from 2 different threads.
    	return this.tripService.createNewTrip(tripDTO);
    }
    
    /**
     * Select car.
     *
     * @param tripDTO the trip DTO
     * @return the string
     * @throws EntityNotFoundException the entity not found exception
     */
    @PutMapping("/deselectCar")
    public String deselectCar(@RequestBody TripDTO  tripDTO) throws EntityNotFoundException{
		return this.tripService.closeTrip(tripDTO);
    }
    
    
    /**
     * Find drivers.
     *
     * @param driverFilter the driver filter
     * @param pageable the pageable
     * @return the list
     */
    @PostMapping("/filterDriver")
    public Page<DriverDTO> findDrivers(@RequestBody DriverFilter driverFilter,Pageable pageable)
    {
        return this.driverService.getAllBySpecification(driverFilter, pageable);
    }
}
