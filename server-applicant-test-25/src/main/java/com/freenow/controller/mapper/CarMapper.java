/*
 * 
 */
package com.freenow.controller.mapper;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;

import com.freenow.datatransferobject.CarDTO;
import com.freenow.domainobject.CarDO;

// TODO: Auto-generated Javadoc
/**
 * The Class CarMapper.
 */
public class CarMapper {
	
	/**
	 * Make car DO.
	 *
	 * @param carDTO the car DTO
	 * @return the car DO
	 */
	public static CarDO makeCarDO(CarDTO carDTO) {
		CarDO carDO = new CarDO();
		BeanUtils.copyProperties(carDTO, carDO);
		carDO.setAvailable(true);
		return carDO;
	}
	
	/**
	 * Make car DO.
	 *
	 * @param carDO the car DO
	 * @return the car DO
	 */
	public static CarDTO makeCarDTO(CarDO carDO) {
		CarDTO carDTO = new CarDTO();
		BeanUtils.copyProperties(carDO, carDTO);
		return carDTO;
	}
	
	   /**
   	 * Make driver DTO list.
   	 *
   	 * @param cars the cars
   	 * @return the list
   	 */
   	public static List<CarDTO> makeDriverDTOList(Collection<CarDO> cars)
	    {
	        return cars.stream()
	            .map(CarMapper::makeCarDTO)
	            .collect(Collectors.toList());
	    }
}
