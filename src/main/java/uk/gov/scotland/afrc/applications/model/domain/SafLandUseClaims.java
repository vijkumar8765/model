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

@Entity
@Table(name = "V_SAFRPT_LAND_USE_CLAIMS")
@EntityListeners(BaseTableListener.class)
@NamedQueries({
        @NamedQuery(name = "SafLandUseClaims.findSafLandParcels",
            query = "SELECT s FROM SafLandUseClaims s where s.applicationId = :applicationId") })
public class SafLandUseClaims  implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "ID")
	protected Long rowId;
		
	@Column(name = "APP_LND_PRCL_ID")
	protected Long appLndPrclId;
		
	@Column(name = "APPLICATION_ID")
	protected Long applicationId;
	
	@Column(name = "BPS_CLAIM_AREA")
	protected BigDecimal bpsClaimArea;
	
	@Column(name = "LFASS_CLAIM_AREA")
	protected BigDecimal lFassClaimArea;
	
	@Column(name = "LND_USE_TYPE_NAME")
	protected String lndUseTypeName;
	
	@Column(name = "DECLARED_AREA")
	protected BigDecimal declaredArea;
	
	@Column(name = "LOCATION_ID")
	protected Long locationId;
	
	@Column(name = "PRCL_ADDED_IN_APP_FLAG")
	protected boolean prclAddedInAppFlag;

	public Long getRowId() {
		return rowId;
	}

	public void setRowId(Long rowId) {
		this.rowId = rowId;
	}

	public Long getAppLndPrclId() {
		return appLndPrclId;
	}

	public void setAppLndPrclId(Long appLndPrclId) {
		this.appLndPrclId = appLndPrclId;
	}

	public Long getApplicationId() {
		return applicationId;
	}

	public void setApplicationId(Long applicationId) {
		this.applicationId = applicationId;
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

	public String getLndUseTypeName() {
		return lndUseTypeName;
	}

	public void setLndUseTypeName(String lndUseTypeName) {
		this.lndUseTypeName = lndUseTypeName;
	}

	public BigDecimal getDeclaredArea() {
		return declaredArea;
	}

	public void setDeclaredArea(BigDecimal declaredArea) {
		this.declaredArea = declaredArea;
	}

	public Long getLocationId() {
		return locationId;
	}

	public void setLocationId(Long locationId) {
		this.locationId = locationId;
	}
	
	public boolean isPrclAddedInAppFlag() {
		return prclAddedInAppFlag;
	}

	public void setPrclAddedInAppFlag(boolean prclAddedInAppFlag) {
		this.prclAddedInAppFlag = prclAddedInAppFlag;
	}


}