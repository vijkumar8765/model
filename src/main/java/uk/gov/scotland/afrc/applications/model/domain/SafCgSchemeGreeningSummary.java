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
 * The persistent class for the V_SAFRPT_CG_GREENING database table.
 * 
 */
@Entity
@Table(name = "V_SAFRPT_CG_GREENING")
@EntityListeners(BaseTableListener.class)
@NamedQueries(value = {
            @NamedQuery(
                        name = "SafCgSchemeGreeningSummary.findByApplicationId",
                        query = "SELECT cgs FROM SafCgSchemeGreeningSummary cgs WHERE cgs.applicationId = :applicationId")})
public class SafCgSchemeGreeningSummary implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @Column(name = "ID" )
    private String id;
    
    @Column(name = "APP_CG_SHARE_ID" )
    private Long appCgShareId;
    
    @Column(name = "APPLICATION_ID")
    private Long applicationId;
    
    @Column(name = "SCHEME_NAME")
    private String schemeName;
    
    @Column(name = "SCHEME_OPTION_CODE")
    private String schemeOptionCode;
    
    @Column(name = "UNITS_UNDERTAKEN")
    private BigDecimal unitsUndertaken;
    
    @Column(name = "LOCATION_CODE")
    private String locationCode;
    
    @Column(name = "APP_CG_CROFT_ID")
    private Long appCgCroftId;
    
    @Column(name = "LOCATION_ID")
    private Long locationId;
    
    @Column(name = "LOCATION_ID_CG")
    private Long locationIdCg;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Long getApplicationId() {
		return applicationId;
	}

	public void setApplicationId(Long applicationId) {
		this.applicationId = applicationId;
	}

	public String getSchemeName() {
		return schemeName;
	}

	public void setSchemeName(String schemeName) {
		this.schemeName = schemeName;
	}

	public String getSchemeOptionCode() {
		return schemeOptionCode;
	}

	public void setSchemeOptionCode(String schemeOptionCode) {
		this.schemeOptionCode = schemeOptionCode;
	}

	public BigDecimal getUnitsUndertaken() {
		return unitsUndertaken;
	}

	public void setUnitsUndertaken(BigDecimal unitsUndertaken) {
		this.unitsUndertaken = unitsUndertaken;
	}

	public String getLocationCode() {
		return locationCode;
	}

	public void setLocationCode(String locationCode) {
		this.locationCode = locationCode;
	}

	public Long getAppCgCroftId() {
		return appCgCroftId;
	}

	public void setAppCgCroftId(Long appCgCroftId) {
		this.appCgCroftId = appCgCroftId;
	}

	public Long getLocationId() {
		return locationId;
	}

	public void setLocationId(Long locationId) {
		this.locationId = locationId;
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