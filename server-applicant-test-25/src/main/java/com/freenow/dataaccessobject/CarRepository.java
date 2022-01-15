/*
 * 
 */
package com.freenow.dataaccessobject;

import org.springframework.data.repository.CrudRepository;

import com.freenow.domainobject.CarDO;

// TODO: Auto-generated Javadoc
/**
 * The Interface CarRepository.
 */
public interface CarRepository extends CrudRepository<CarDO, Long> {
	
	/**
	 * Find by license plate.
	 *
	 * @param licensePlate the license plate
	 * @return the car DO
	 */
	CarDO findByLicensePlate(String licensePlate);

	/**
	 * Delete by license plate.
	 *
	 * @param licensePlate the license plate
	 */
	void deleteByLicensePlate(String licensePlate);

}
