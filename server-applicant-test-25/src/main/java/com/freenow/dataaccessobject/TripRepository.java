/*
 * 
 */
package com.freenow.dataaccessobject;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.freenow.domainobject.TripDO;

// TODO: Auto-generated Javadoc
/**
 * The Interface TripRepository.
 */
public interface TripRepository extends CrudRepository<TripDO, Long> {
	
	/**
	 * Find by id.
	 *
	 * @param tripId the trip id
	 * @return the trip DO
	 */
	@Override
	Optional<TripDO> findById(Long tripId);
	
	/**
	 * Find by driver id and car and live status.
	 *
	 * @param driverId the driver id
	 * @param licensePlate the license plate
	 * @param isLive the is live
	 * @return the trip DO
	 */
	TripDO findByDriverIdAndLicensePlateAndIsLive(Long driverId, String licensePlate, boolean isLive);

}
