/*
 * 
 */
package com.freenow.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.freenow.controller.mapper.CarMapper;
import com.freenow.datatransferobject.CarDTO;
import com.freenow.domainobject.CarDO;
import com.freenow.exception.ConstraintsViolationException;
import com.freenow.exception.EntityNotFoundException;
import com.freenow.service.car.CarService;

// TODO: Auto-generated Javadoc
/**
 * The Class CarController.
 */
@RestController
@RequestMapping("v1/cars")
public class CarController {
	
	/** The car service. */
	private CarService carService;
	
	/**
	 * Instantiates a new car controller.
	 *
	 * @param carservice the carservice
	 */
	@Autowired
	public CarController(final CarService carservice) {
		this.carService = carservice;
	}
	
    /**
     * Creates the driver.
     *
     * @param carDTO the car DTO
     * @return the driver DTO
     * @throws ConstraintsViolationException the constraints violation exception
     */
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CarDTO createCar(@Valid @RequestBody CarDTO carDTO) throws ConstraintsViolationException
    {
       final CarDO carDO = CarMapper.makeCarDO(carDTO);
       return CarMapper.makeCarDTO(this.carService.create(carDO));
    }
    
    /**
     * Gets the car.
     *
     * @param licensePlate the license plate
     * @return the car
     * @throws EntityNotFoundException the entity not found exception
     */
    @GetMapping("/{licensePlate}")
    public CarDTO getCar(@PathVariable String licensePlate) throws EntityNotFoundException
    {
        return CarMapper.makeCarDTO(this.carService.find(licensePlate));
    }
    
    /**
     * Gets the all cars.
     *
     * @return the all cars
     */
    @GetMapping
    public List<CarDTO> getAllCars(){
    	return CarMapper.makeDriverDTOList(this.carService.getAllCars());
    }

}
