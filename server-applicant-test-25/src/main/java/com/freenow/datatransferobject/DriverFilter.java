/*
 * 
 */
package com.freenow.datatransferobject;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import com.freenow.domainobject.DriverDO;
import com.freenow.domainvalue.OnlineStatus;

// TODO: Auto-generated Javadoc
/**
 * The Class DriverFilter.
 */
public class DriverFilter implements Specification<DriverDO> {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The username. */
	private String username;
	
	/** The status. */
	private OnlineStatus onlineStatus;
	
	/** The license plate. */
	private String licensePlate;
	
	/** The rating. */
	private short rating;

	/**
	 * To predicate.
	 *
	 * @param root the root
	 * @param query the query
	 * @param builder the builder
	 * @return the predicate
	 */
	@Override
	public Predicate toPredicate(Root<DriverDO> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
        List<Predicate> predicates = new ArrayList<>();
        if (username != null) predicates.add(builder.like(builder.upper(root.get("username")), "%" + username.toUpperCase() + "%"));
        if (onlineStatus != null) predicates.add(builder.equal(root.get("onlineStatus"), onlineStatus));
        if (licensePlate != null) predicates.add(builder.equal(root.get("licensePlate"), licensePlate));
        if (rating != 0) predicates.add(builder.equal(root.get("rating"), rating));
        return builder.and(predicates.toArray(new Predicate[0]));
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
	 * Gets the online status.
	 *
	 * @return the online status
	 */
	public OnlineStatus getOnlineStatus() {
		return onlineStatus;
	}

	/**
	 * Sets the online status.
	 *
	 * @param onlineStatus the new online status
	 */
	public void setOnlineStatus(OnlineStatus onlineStatus) {
		this.onlineStatus = onlineStatus;
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

}
