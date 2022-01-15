/*
 * 
 */
package com.freenow.dataaccessobject;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.freenow.domainobject.DriverDO;
import com.freenow.domainvalue.OnlineStatus;

// TODO: Auto-generated Javadoc
/**
 * Database Access Object for driver table.
 * <p/>
 */
public interface DriverRepository extends CrudRepository<DriverDO, Long>
{

    /**
     * Find by online status.
     *
     * @param onlineStatus the online status
     * @return the list
     */
    List<DriverDO> findByOnlineStatus(OnlineStatus onlineStatus);
}
