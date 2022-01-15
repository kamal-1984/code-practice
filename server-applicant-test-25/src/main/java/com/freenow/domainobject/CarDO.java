/*
 * 
 */
package com.freenow.domainobject;

import java.time.ZonedDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.springframework.format.annotation.DateTimeFormat;

// TODO: Auto-generated Javadoc
/**
 * The Class CarDO.
 */
// TODO: Auto-generated Javadoc

/**
 * The Class CarDO.
 */
// TODO: Auto-generated Javadoc

/**
 * The Class CarDO.
 */
// TODO: Auto-generated Javadoc

/**
 * The Class CarDO.
 */
@Entity
@Table(name="car",
	  uniqueConstraints = @UniqueConstraint(name = "uc_licensePlate", columnNames = {"licensePlate"}))
public class CarDO {
	
    /** The id. */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /** The date created. */
    @Column(nullable = false)
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private ZonedDateTime dateCreated = ZonedDateTime.now();
    
    /** The license plate. */
    @Column(nullable = false)
    private String licensePlate;
    
    /** The seat count. */
    @Column(nullable = false)
    private short seatCount;
    
    /** The convertible. */
    @Column(nullable = false)
    private String convertible;
    
    /** The rating. */
    @Column(nullable = false)
    private short rating;
    
    /** The engine type. */
    @Column(nullable = false)
    private String engineType;
    
    /** The engine type. */
    @Column(nullable = false)
    private String manufacturer;

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Sets the id.
	 *
	 * @param id the new id
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Gets the license plate.
	 *
	 * @return the license plate
	 */
	public String getLicensePlate() {
		return licensePlate;
	}

	/**
	 * Sets the license plate.
	 *
	 * @param licensePlate the new license plate
	 */
	public void setLicensePlate(String licensePlate) {
		this.licensePlate = licensePlate;
	}

	/**
	 * Gets the seat count.
	 *
	 * @return the seat count
	 */
	public short getSeatCount() {
		return seatCount;
	}

	/**
	 * Sets the seat count.
	 *
	 * @param seatCount the new seat count
	 */
	public void setSeatCount(short seatCount) {
		this.seatCount = seatCount;
	}

	/**
	 * Gets the convertible.
	 *
	 * @return the convertible
	 */
	public String getConvertible() {
		return convertible;
	}

	/**
	 * Sets the convertible.
	 *
	 * @param convertible the new convertible
	 */
	public void setConvertible(String convertible) {
		this.convertible = convertible;
	}

	/**
	 * Gets the rating.
	 *
	 * @return the rating
	 */
	public short getRating() {
		return rating;
	}

	/**
	 * Sets the rating.
	 *
	 * @param rating the new rating
	 */
	public void setRating(short rating) {
		this.rating = rating;
	}

	/**
	 * Gets the engine type.
	 *
	 * @return the engine type
	 */
	public String getEngineType() {
		return engineType;
	}

	/**
	 * Sets the engine type.
	 *
	 * @param engineType the new engine type
	 */
	public void setEngineType(String engineType) {
		this.engineType = engineType;
	}

	/**
	 * Gets the manufacturer.
	 *
	 * @return the manufacturer
	 */
	public String getManufacturer() {
		return manufacturer;
	}

	/**
	 * Sets the manufacturer.
	 *
	 * @param manufacturer the new manufacturer
	 */
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}
    
}
