/*
 * 
 */
package com.freenow.service.trip;

import java.util.List;

import com.freenow.datatransferobject.TripDTO;
import com.freenow.domainobject.TripDO;
import com.freenow.exception.CarAlreadyInUseException;
import com.freenow.exception.EntityNotFoundException;

// TODO: Auto-generated Javadoc
/**
 * The Interface TripService.
 */
public interface TripService {
	
	/**
	 * Creates the.
	 *
	 * @param tripDO the trip DO
	 * @return the trip DO
	 */
	TripDO create(TripDO tripDO);
	
	/**
	 * Find.
	 *
	 * @return the list
	 */
	List<TripDO> find();
	
	/**
	 * Find by driver id and car and live status.
	 *
	 * @param driverId the driver id
	 * @param licensePlate the license plate
	 * @param isLive the is live
	 * @return the trip DO
	 * @throws EntityNotFoundException the entity not found exception
	 */
	TripDO findByDriverIdAndLicensePlateAndIsLive(Long driverId,String licensePlate,boolean isLive) throws EntityNotFoundException;
	
	/**
	 * Close trip.
	 *
	 * @param tripDO the trip DO
	 * @return the trip DO
	 */
	TripDO update(TripDO tripDO);
	
	/**
	 * Creates the new trip.
	 *
	 * @param tripDTO the trip DTO
	 * @return the string
	 * @throws CarAlreadyInUseException the car already in use exception
	 * @throws EntityNotFoundException the entity not found exception
	 */
	String createNewTrip(TripDTO tripDTO)  throws CarAlreadyInUseException,EntityNotFoundException;
	
	/**
	 *  The close.
	 *
	 * @param tripDTO the trip DTO
	 * @return the string
	 * @throws EntityNotFoundException the entity not found exception
	 */
	String closeTrip(TripDTO tripDTO)  throws EntityNotFoundException ;

}
