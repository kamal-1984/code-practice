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

import org.springframework.format.annotation.DateTimeFormat;

// TODO: Auto-generated Javadoc
/**
 * The Class TripDO.
 */
@Entity
@Table(name="trip")
public class TripDO {
	
    /** The id. */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /** The date created. */
    @Column(nullable = false)
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private ZonedDateTime dateTripStart = ZonedDateTime.now();
    
    /** The date created. */
    @Column(nullable = true)
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private ZonedDateTime dateTripEnd;
    
    /** The license plate. */
    @Column(nullable = false)
    private String licensePlate;
    
    /** The license plate. */
    @Column(nullable = false)
    private String username;
    
    /** The driver id. */
    @Column(nullable = false)
    private Long driverId;
    
    /** The is live. */
    @Column(nullable = false)
    private boolean isLive;
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
	 * Gets the date trip end.
	 *
	 * @return the date trip end
	 */
	public ZonedDateTime getDateTripEnd() {
		return dateTripEnd;
	}

	/**
	 * Sets the date trip end.
	 *
	 * @param dateTripEnd the new date trip end
	 */
	public void setDateTripEnd(ZonedDateTime dateTripEnd) {
		this.dateTripEnd = dateTripEnd;
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
	 * Gets the username.
	 *
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * Sets the username.
	 *
	 * @param username the new username
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * Gets the driver id.
	 *
	 * @return the driver id
	 */
	public Long getDriverId() {
		return driverId;
	}

	/**
	 * Sets the driver id.
	 *
	 * @param driverId the new driver id
	 */
	public void setDriverId(Long driverId) {
		this.driverId = driverId;
	}

	/**
	 * Checks if is live.
	 *
	 * @return true, if is live
	 */
	public boolean isLive() {
		return isLive;
	}

	/**
	 * Sets the live.
	 *
	 * @param isLive the new live
	 */
	public void setLive(boolean isLive) {
		this.isLive = isLive;
	}
	
}
