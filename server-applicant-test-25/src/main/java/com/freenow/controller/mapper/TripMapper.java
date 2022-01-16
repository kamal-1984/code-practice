/*
 * 
 */
package com.freenow.controller.mapper;

import java.time.ZonedDateTime;

import org.springframework.beans.BeanUtils;

import com.freenow.datatransferobject.TripDTO;
import com.freenow.domainobject.DriverDO;
import com.freenow.domainobject.TripDO;

// TODO: Auto-generated Javadoc
/**
 * The Class TripMapper.
 */
public class TripMapper {
	
	/**
	 * Make trip DO.
	 *
	 * @param tripDTO the trip DTO
	 * @param driverDO the driver DO
	 * @return the trip DO
	 */
	public static TripDO makeTripDOStart(TripDTO tripDTO,DriverDO driverDO) {
		TripDO tripDO = new TripDO();
		BeanUtils.copyProperties(tripDTO, tripDO);
		tripDO.setLive(true);
		tripDO.setUsername(driverDO.getUsername());
		return tripDO;
	}
	
	/**
	 * Make trip DO close.
	 *
	 * @param tripDO the trip DO
	 * @return the trip DO
	 */
	public static TripDO makeTripDOClose(TripDO tripDO) {
		tripDO.setLive(false);
		tripDO.setDateTripEnd(ZonedDateTime.now());
		return tripDO;
	}

}
