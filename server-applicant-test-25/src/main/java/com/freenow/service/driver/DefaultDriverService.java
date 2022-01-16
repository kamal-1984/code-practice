/*
 * 
 */
package com.freenow.service.driver;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.freenow.controller.mapper.DriverMapper;
import com.freenow.dataaccessobject.DriverRepository;
import com.freenow.dataaccessobject.FilterRepository;
import com.freenow.datatransferobject.DriverDTO;
import com.freenow.domainobject.DriverDO;
import com.freenow.domainvalue.GeoCoordinate;
import com.freenow.domainvalue.OnlineStatus;
import com.freenow.exception.ConstraintsViolationException;
import com.freenow.exception.EntityNotFoundException;

// TODO: Auto-generated Javadoc
/**
 * Service to encapsulate the link between DAO and controller and to have business logic for some driver specific things.
 * <p/>
 */
@Service
public class DefaultDriverService implements DriverService
{

    /** The Constant LOG. */
    private static final Logger LOG = LoggerFactory.getLogger(DefaultDriverService.class);

    /** The driver repository. */
    private final DriverRepository driverRepository;
    
    /** The filter repository. */
    private final FilterRepository filterRepository;


    /**
     * Instantiates a new default driver service.
     *
     * @param driverRepository the driver repository
     * @param filterRepository the filter repository
     */
    public DefaultDriverService(final DriverRepository driverRepository,final FilterRepository filterRepository )
    {
        this.driverRepository = driverRepository;
		this.filterRepository = filterRepository;
    }


    /**
     * Selects a driver by id.
     *
     * @param driverId the driver id
     * @return found driver
     * @throws EntityNotFoundException if no driver with the given id was found.
     */
    @Override
    public DriverDO find(Long driverId) throws EntityNotFoundException
    {
        return findDriverChecked(driverId);
    }


    /**
     * Creates a new driver.
     *
     * @param driverDO the driver DO
     * @return the driver DO
     * @throws ConstraintsViolationException if a driver already exists with the given username, ... .
     */
    @Override
    public DriverDO create(DriverDO driverDO) throws ConstraintsViolationException
    {
        DriverDO driver;
        try
        {
            driver = driverRepository.save(driverDO);
        }
        catch (DataIntegrityViolationException e)
        {
            LOG.warn("ConstraintsViolationException while creating a driver: {}", driverDO, e);
            throw new ConstraintsViolationException(e.getMessage());
        }
        return driver;
    }


    /**
     * Deletes an existing driver by id.
     *
     * @param driverId the driver id
     * @throws EntityNotFoundException if no driver with the given id was found.
     */
    @Override
    @Transactional
    public void delete(Long driverId) throws EntityNotFoundException
    {
        DriverDO driverDO = findDriverChecked(driverId);
        driverDO.setDeleted(true);
    }


    /**
     * Update the location for a driver.
     *
     * @param driverId the driver id
     * @param longitude the longitude
     * @param latitude the latitude
     * @throws EntityNotFoundException the entity not found exception
     */
    @Override
    @Transactional
    public void updateLocation(long driverId, double longitude, double latitude) throws EntityNotFoundException
    {
        DriverDO driverDO = findDriverChecked(driverId);
        driverDO.setCoordinate(new GeoCoordinate(latitude, longitude));
    }


    /**
     * Find all drivers by online state.
     *
     * @param onlineStatus the online status
     * @return the list
     */
    @Override
    public List<DriverDO> find(OnlineStatus onlineStatus)
    {
        return driverRepository.findByOnlineStatus(onlineStatus);
    }


    /**
     * Find driver checked.
     *
     * @param driverId the driver id
     * @return the driver DO
     * @throws EntityNotFoundException the entity not found exception
     */
    private DriverDO findDriverChecked(Long driverId) throws EntityNotFoundException
    {
        return driverRepository.findById(driverId)
            .orElseThrow(() -> new EntityNotFoundException("Could not find entity with id: " + driverId));
    }
    
    /**
     * Gets the all by specification.
     *
     * @param specification the specification
     * @param pageable the pageable
     * @return the all by specification
     */
    @Override
    public Page<DriverDTO> getAllBySpecification(final Specification<DriverDO> specification, final Pageable pageable) {
        return filterRepository.findAll(specification, pageable).map(DriverMapper::makeDriverDTO);
    }

}
