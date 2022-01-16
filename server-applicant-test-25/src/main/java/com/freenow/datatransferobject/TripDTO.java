/*
 * 
 */
package com.freenow.datatransferobject;

import java.time.ZonedDateTime;

// TODO: Auto-generated Javadoc
/**
 * The Class TripDTO.
 */
public class TripDTO {
	
    /** The id. */
    private Long id;

    /** The date created. */
    private ZonedDateTime dateTripStart;
    
    /** The date created. */
    private ZonedDateTime dateTripEnd;
    
    /** The license plate. */
    private String licensePlate;
    
    /** The license plate. */
    private String username;
    
    /** The driver id. */
    private Long driverId;
    
    /** The is live. */
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
	 * Gets the date trip start.
	 *
	 * @return the date trip start
	 */
	public ZonedDateTime getDateTripStart() {
		return dateTripStart;
	}

	/**
	 * Sets the date trip start.
	 *
	 * @param dateTripStart the new date trip start
	 */
	public void setDateTripStart(ZonedDateTime dateTripStart) {
		this.dateTripStart = dateTripStart;
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
