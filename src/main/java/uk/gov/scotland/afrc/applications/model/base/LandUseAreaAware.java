/*
 * Project : AFRC Futures
 * Copyright (C) 2013 Scottish Government AFRC Programme
 * AFRC PROPRIETARY/CONFIDENTIAL
 */
package uk.gov.scotland.afrc.applications.model.base;

import java.math.BigDecimal;

import uk.gov.scotland.afrc.applications.model.domain.LandUseTypeDBO;

/**
 * LandUseAreaAware is implemented by entities that represent land use.
 */

public interface LandUseAreaAware {

    boolean isLfa();

    BigDecimal getAreaAmount();

    LandUseTypeDBO getLandUseType();
}
