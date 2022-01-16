/*
 * 
 */
package com.freenow.service.driver;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import com.freenow.datatransferobject.DriverDTO;
import com.freenow.domainobject.DriverDO;
import com.freenow.domainvalue.OnlineStatus;
import com.freenow.exception.ConstraintsViolationException;
import com.freenow.exception.EntityNotFoundException;

// TODO: Auto-generated Javadoc
/**
 * The Interface DriverService.
 */
public interface DriverService
{

    /**
     * Find.
     *
     * @param driverId the driver id
     * @return the driver DO
     * @throws EntityNotFoundException the entity not found exception
     */
    DriverDO find(Long driverId) throws EntityNotFoundException;

    /**
     * Creates the.
     *
     * @param driverDO the driver DO
     * @return the driver DO
     * @throws ConstraintsViolationException the constraints violation exception
     */
    DriverDO create(DriverDO driverDO) throws ConstraintsViolationException;

    /**
     * Delete.
     *
     * @param driverId the driver id
     * @throws EntityNotFoundException the entity not found exception
     */
    void delete(Long driverId) throws EntityNotFoundException;

    /**
     * Update location.
     *
     * @param driverId the driver id
     * @param longitude the longitude
     * @param latitude the latitude
     * @throws EntityNotFoundException the entity not found exception
     */
    void updateLocation(long driverId, double longitude, double latitude) throws EntityNotFoundException;

    /**
     * Find.
     *
     * @param onlineStatus the online status
     * @return the list
     */
    List<DriverDO> find(OnlineStatus onlineStatus);
    
    /**
     * Gets the all by specification.
     *
     * @param specification the specification
     * @param pageable the pageable
     * @return the all by specification
     */
    Page<DriverDTO> getAllBySpecification(final Specification<DriverDO> specification, final Pageable pageable);

}
