/*
 * 
 */
package com.freenow.service.car;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.freenow.dataaccessobject.CarRepository;
import com.freenow.domainobject.CarDO;
import com.freenow.exception.ConstraintsViolationException;
import com.freenow.exception.EntityNotFoundException;

// TODO: Auto-generated Javadoc
/**
 * The Class DefaultCarServiceImpl.
 */
@Service
public class DefaultCarServiceImpl implements CarService {
	
    /** The Constant LOG. */
    private static final Logger LOG = LoggerFactory.getLogger(DefaultCarServiceImpl.class);

    /** The car repository. */
    private final CarRepository carRepository;


    /**
     * Instantiates a new default car service impl.
     *
     * @param carRepository the car repository
     */
    public DefaultCarServiceImpl(final CarRepository carRepository)
    {
        this.carRepository = carRepository;
    }

	/**
	 * Find.
	 *
	 * @param licensePlate the license plate
	 * @return the car DO
	 * @throws EntityNotFoundException the entity not found exception
	 */
	@Override
	public CarDO find(String licensePlate) throws EntityNotFoundException {
		return this.carRepository.findByLicensePlate(licensePlate);
	}

	/**
	 * Creates the.
	 *
	 * @param cardo the cardo
	 * @return the car DO
	 * @throws ConstraintsViolationException the constraints violation exception
	 */
	@Override
	public CarDO create(CarDO cardo) throws ConstraintsViolationException {
		return this.carRepository.save(cardo);
	}

	/**
	 * Delete.
	 *
	 * @param licensePlate the license plate
	 * @throws EntityNotFoundException the entity not found exception
	 */
	@Override
	public void delete(String licensePlate) throws EntityNotFoundException {
		this.carRepository.deleteByLicensePlate(licensePlate);
	}

	/**
	 * Gets the all cars.
	 *
	 * @return the all cars
	 */
	@Override
	public List<CarDO> getAllCars() {
		return (List<CarDO>) this.carRepository.findAll();
	}

}
