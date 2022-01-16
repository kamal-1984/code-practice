/*
 * 
 */
package com.freenow.service.car;

import java.util.List;

import org.springframework.stereotype.Service;

import com.freenow.domainobject.CarDO;
import com.freenow.exception.ConstraintsViolationException;
import com.freenow.exception.EntityNotFoundException;

// TODO: Auto-generated Javadoc
/**
 * The Interface CarService.
 */
@Service
public interface CarService {
	
	/**
	 * Find car.
	 *
	 * @param licensePlate the license plate
	 * @return the car DO
	 * @throws EntityNotFoundException the entity not found exception
	 */
	public abstract CarDO find(String licensePlate) throws EntityNotFoundException;
	
	/**
	 * Creates the.
	 *
	 * @param cardo the cardo
	 * @return the car DO
	 */
	public abstract CarDO create(CarDO cardo);
	
	/**
	 * Delete.
	 *
	 * @param licensePlate the license plate
	 * @throws EntityNotFoundException the entity not found exception
	 */
	public void delete(String licensePlate) throws EntityNotFoundException;
	
	/**
	 * Gets the all cars.
	 *
	 * @return the all cars
	 */
	public abstract List<CarDO> getAllCars();
	
}