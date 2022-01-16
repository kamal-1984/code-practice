/*
 * 
 */
package com.freenow.dataaccessobject;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.freenow.domainobject.DriverDO;

/**
 * The Interface FilterRepository.
 */
public interface FilterRepository  extends JpaRepository<DriverDO, Integer>, JpaSpecificationExecutor<DriverDO> {}
