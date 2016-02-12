package uk.gov.scotland.afrc.applications.model.domain;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import uk.gov.scotland.afrc.applications.model.base.BaseTableListener;

/**
 * The persistent class for the V_SAFRPT_LAND_CG database table.
 * 
 */
@Entity
@Table(name = "V_SAFRPT_LAND_CG")
@EntityListeners(BaseTableListener.class)
@NamedQueries(
    value = {
            @NamedQuery(name = "SafLandCGSummary.findByApplicationId",
                query = "SELECT cg FROM SafLandCGSummary cg WHERE cg.applicationId = :applicationId") })
public class SafLandCGSummary implements Serializable {
	
    private static final long serialVersionUID = 1L;
     
    @Id
    @Column(name = "APP_CG_ID")
    private Long appCgId;

    @Column(name = "APPLICATION_ID")
    private Long applicationId;
    
    @Column(name = "LOCATION_CG_TSE")
    private Long appSheepEquivalent;

    @Column(name = "GROSS_AREA")
    private BigDecimal grossArea;
    
    @Column(name = "LFA_FLAG")
    private boolean lfaClassFlag;

    @Column(name = "BPS_ELIGIBLE_AREA")
    private BigDecimal bpsEligibleArea;

    @Column(name = "LOCATION_CODE")
    private String locationCode;

    @Column(name = "LOCATION_NAME")
    private String locationName;
   
    @Column(name = "LOCATION_ID")
    private Long locationId;

	public Long getAppCgId() {
		return appCgId;
	}

	public void setAppCgId(Long appCgId) {
		this.appCgId = appCgId;
	}

	public Long getApplicationId() {
		return applicationId;
	}

	public void setApplicationId(Long applicationId) {
		this.applicationId = applicationId;
	}

	public Long getAppSheepEquivalent() {
		return appSheepEquivalent;
	}

	public void setAppSheepEquivalent(Long appSheepEquivalent) {
		this.appSheepEquivalent = appSheepEquivalent;
	}

	public BigDecimal getGrossArea() {
		return grossArea;
	}

	public void setGrossArea(BigDecimal grossArea) {
		this.grossArea = grossArea;
	}

	public boolean isLfaClassFlag() {
		return lfaClassFlag;
	}

	public void setLfaClassFlag(boolean lfaClassFlag) {
		this.lfaClassFlag = lfaClassFlag;
	}

	public BigDecimal getBpsEligibleArea() {
		return bpsEligibleArea;
	}

	public void setBpsEligibleArea(BigDecimal bpsEligibleArea) {
		this.bpsEligibleArea = bpsEligibleArea;
	}

	public String getLocationCode() {
		return locationCode;
	}

	public void setLocationCode(String locationCode) {
		this.locationCode = locationCode;
	}

	public String getLocationName() {
		return locationName;
	}

	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}

	public Long getLocationId() {
		return locationId;
	}

	public void setLocationId(Long locationId) {
		this.locationId = locationId;
	}
    
    

}