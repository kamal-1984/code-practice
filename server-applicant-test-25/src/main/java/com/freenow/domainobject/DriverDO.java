/*
 * 
 */
package com.freenow.domainobject;

import java.time.ZonedDateTime;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import com.freenow.domainvalue.GeoCoordinate;
import com.freenow.domainvalue.OnlineStatus;

// TODO: Auto-generated Javadoc
/**
 * The Class DriverDO.
 */
@Entity
@Table(
    name = "driver",
    uniqueConstraints = @UniqueConstraint(name = "uc_username", columnNames = {"username"})
)
public class DriverDO
{

    /** The id. */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /** The date created. */
    @Column(nullable = false)
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private ZonedDateTime dateCreated = ZonedDateTime.now();

    /** The username. */
    @Column(nullable = false)
    @NotNull(message = "Username can not be null!")
    private String username;

    /** The password. */
    @Column(nullable = false)
    @NotNull(message = "Password can not be null!")
    private String password;

    /** The deleted. */
    @Column(nullable = false)
    private Boolean deleted = false;

    /** The coordinate. */
    @Embedded
    private GeoCoordinate coordinate;

    /** The date coordinate updated. */
    @Column
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private ZonedDateTime dateCoordinateUpdated = ZonedDateTime.now();

    /** The online status. */
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private OnlineStatus onlineStatus;
    
    /** The license plate. */
    @Column(nullable=true)
    private String licensePlate;
    
    /** The rating. */
    @Column(nullable=true)
    private Short rating;
    
    /** The car selected. */
    @Column
    private Boolean carSelected;
    
    /**
     * Instantiates a new driver DO.
     *
     * @param username the username
     * @param password the password
     */
    public DriverDO(String username, String password)
    {
        this.username = username;
        this.password = password;
        this.deleted = false;
        this.coordinate = null;
        this.dateCoordinateUpdated = null;
        this.onlineStatus = OnlineStatus.OFFLINE;
    }


    /**
     * Gets the id.
     *
     * @return the id
     */
    public Long getId()
    {
        return id;
    }


    /**
     * Sets the id.
     *
     * @param id the new id
     */
    public void setId(Long id)
    {
        this.id = id;
    }


    /**
     * Gets the username.
     *
     * @return the username
     */
    public String getUsername()
    {
        return username;
    }


    /**
     * Gets the password.
     *
     * @return the password
     */
    public String getPassword()
    {
        return password;
    }


    /**
     * Gets the deleted.
     *
     * @return the deleted
     */
    public Boolean getDeleted()
    {
        return deleted;
    }


    /**
     * Sets the deleted.
     *
     * @param deleted the new deleted
     */
    public void setDeleted(Boolean deleted)
    {
        this.deleted = deleted;
    }


    /**
     * Gets the online status.
     *
     * @return the online status
     */
    public OnlineStatus getOnlineStatus()
    {
        return onlineStatus;
    }


    /**
     * Sets the online status.
     *
     * @param onlineStatus the new online status
     */
    public void setOnlineStatus(OnlineStatus onlineStatus)
    {
        this.onlineStatus = onlineStatus;
    }


    /**
     * Gets the coordinate.
     *
     * @return the coordinate
     */
    public GeoCoordinate getCoordinate()
    {
        return coordinate;
    }


    /**
     * Sets the coordinate.
     *
     * @param coordinate the new coordinate
     */
    public void setCoordinate(GeoCoordinate coordinate)
    {
        this.coordinate = coordinate;
        this.dateCoordinateUpdated = ZonedDateTime.now();
    }

	/**
	 * Checks if is car selected.
	 *
	 * @return true, if is car selected
	 */
	public Boolean isCarSelected() {
		return carSelected;
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
	 * Gets the rating.
	 *
	 * @return the rating
	 */
	public Short getRating() {
		return rating;
	}


	/**
	 * Sets the rating.
	 *
	 * @param rating the new rating
	 */
	public void setRating(Short rating) {
		this.rating = rating;
	}


	/**
	 * Sets the car selected.
	 *
	 * @param carSelected the new car selected
	 */
	public void setCarSelected(Boolean carSelected) {
		this.carSelected = carSelected;
	}
	
}
