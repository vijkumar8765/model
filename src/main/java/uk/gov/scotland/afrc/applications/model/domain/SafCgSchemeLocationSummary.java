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
 * The persistent class for the V_SAFRPT_CG_SCHEME_LOC database table.
 * 
 */
@Entity
@Table(name = "V_SAFRPT_CG_SCHEME_LOC")
@EntityListeners(BaseTableListener.class)
@NamedQueries(value = {
            @NamedQuery(
                        name = "SafCgSchemeLocationSummary.findByApplicationId",
                        query = "SELECT cgs FROM SafCgSchemeLocationSummary cgs WHERE cgs.applicationId = :applicationId")})
public class SafCgSchemeLocationSummary implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @Column(name = "CG_SHARE_LND_USE_AREA_ID")
    private Long cgShareLndUseAreaId;
    
    @Column(name = "APP_CG_SHARE_ID")
    private Long appCgShareId;

    @Column(name = "BPS_CLAIM_AREA")
    private BigDecimal bpsClaimArea;

    @Column(name = "LFASS_CLAIM_AREA")
    private BigDecimal lFassClaimArea;

    @Column(name = "APPLICATION_ID")
    private Long applicationId;
    
    @Column(name = "LND_USE_TYPE_NAME")
    private String landUseTypeName;

    @Column(name = "DECLARED_AREA")
    private BigDecimal declaredArea;
    
    @Column(name = "LOCATION_ID_CG")
    private Long locationIdCg;

	public Long getCgShareLndUseAreaId() {
		return cgShareLndUseAreaId;
	}

	public void setCgShareLndUseAreaId(Long cgShareLndUseAreaId) {
		this.cgShareLndUseAreaId = cgShareLndUseAreaId;
	}

	public BigDecimal getBpsClaimArea() {
		return bpsClaimArea;
	}

	public void setBpsClaimArea(BigDecimal bpsClaimArea) {
		this.bpsClaimArea = bpsClaimArea;
	}

	public BigDecimal getlFassClaimArea() {
		return lFassClaimArea;
	}

	public void setlFassClaimArea(BigDecimal lFassClaimArea) {
		this.lFassClaimArea = lFassClaimArea;
	}

	public Long getApplicationId() {
		return applicationId;
	}

	public void setApplicationId(Long applicationId) {
		this.applicationId = applicationId;
	}

	public String getLandUseTypeName() {
		return landUseTypeName;
	}

	public void setLandUseTypeName(String landUseTypeName) {
		this.landUseTypeName = landUseTypeName;
	}

	public BigDecimal getDeclaredArea() {
		return declaredArea;
	}

	public void setDeclaredArea(BigDecimal declaredArea) {
		this.declaredArea = declaredArea;
	}

	public Long getLocationIdCg() {
		return locationIdCg;
	}

	public void setLocationIdCg(Long locationIdCg) {
		this.locationIdCg = locationIdCg;
	}

	public Long getAppCgShareId() {
		return appCgShareId;
	}

	public void setAppCgShareId(Long appCgShareId) {
		this.appCgShareId = appCgShareId;
	}
    
}