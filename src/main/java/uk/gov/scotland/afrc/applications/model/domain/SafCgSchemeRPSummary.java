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
 * The persistent class for the V_SAFRPT_CG_RP database table.
 * 
 */
@Entity
@Table(name = "V_SAFRPT_CG_RP")
@EntityListeners(BaseTableListener.class)
@NamedQueries(value = {
            @NamedQuery(
                        name = "SafCgSchemeRPSummary.findByApplicationId",
                        query = "SELECT cgs FROM SafCgSchemeRPSummary cgs WHERE cgs.applicationId = :applicationId")})
public class SafCgSchemeRPSummary implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @Column(name = "ID")
    private String rowId;
    
    @Column(name = "APPLICATION_ID")
    private Long applicationId;
    
    @Column(name = "PRCL_ID")
    private String prclId;
    
    @Column(name = "UNITS_UNDERTAKEN")
    private BigDecimal unitsUndertaken;

    @Column(name = "SCHEME_OPTION_CODE")
    private String schemeOptionCode;
    
    @Column(name = "APP_CG_CROFT_ID")
    private Long appCgCroftId;
    
    @Column(name = "APP_CG_SHARE_ID")
    private Long appCgShareId;

    @Column(name = "LOCATION_ID")
    private Long locationId;
    
    @Column(name = "LOCATION_ID_CG")
    private Long locationIdCg;
    
    @Column(name = "SCHEME_ID")
    private Long schemeId;
    
    @Column(name = "SCHEME_OPT_ID")
    private Long schemeOptId;

	public String getRowId() {
		return rowId;
	}

	public void setRowId(String rowId) {
		this.rowId = rowId;
	}

	public Long getApplicationId() {
		return applicationId;
	}

	public void setApplicationId(Long applicationId) {
		this.applicationId = applicationId;
	}

	public String getPrclId() {
		return prclId;
	}

	public void setPrclId(String prclId) {
		this.prclId = prclId;
	}

	public BigDecimal getUnitsUndertaken() {
		return unitsUndertaken;
	}

	public void setUnitsUndertaken(BigDecimal unitsUndertaken) {
		this.unitsUndertaken = unitsUndertaken;
	}

	public String getSchemeOptionCode() {
		return schemeOptionCode;
	}

	public void setSchemeOptionCode(String schemeOptionCode) {
		this.schemeOptionCode = schemeOptionCode;
	}

	public Long getAppCgCroftId() {
		return appCgCroftId;
	}

	public void setAppCgCroftId(Long appCgCroftId) {
		this.appCgCroftId = appCgCroftId;
	}

	public Long getAppCgShareId() {
		return appCgShareId;
	}

	public void setAppCgShareId(Long appCgShareId) {
		this.appCgShareId = appCgShareId;
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

	public Long getSchemeId() {
		return schemeId;
	}

	public void setSchemeId(Long schemeId) {
		this.schemeId = schemeId;
	}

	public Long getSchemeOptId() {
		return schemeOptId;
	}

	public void setSchemeOptId(Long schemeOptId) {
		this.schemeOptId = schemeOptId;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
    
    
}