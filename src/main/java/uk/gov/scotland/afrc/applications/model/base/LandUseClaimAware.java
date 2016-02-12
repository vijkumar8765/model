package uk.gov.scotland.afrc.applications.model.base;

import java.math.BigDecimal;

import uk.gov.scotland.afrc.applications.model.domain.LandUseTypeDBO;

public interface LandUseClaimAware {
    BigDecimal getClaimedArea();

    BigDecimal getLandUseAreaAmount();

    Long getLandUseAreaPK();

    LandUseTypeDBO getLandUseType();
}
