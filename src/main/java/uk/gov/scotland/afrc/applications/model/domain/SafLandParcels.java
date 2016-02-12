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
@Table(name = "V_SAFRPT_LAND_PARCELS")
@EntityListeners(BaseTableListener.class)
@NamedQueries({
        @NamedQuery(name = "SafLandParcels.findSafLandParcels",
            query = "SELECT s FROM SafLandParcels s where s.applicationId = :applicationId") })
public class SafLandParcels  implements Serializable {

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
	
	@Column(name = "LOCATION_CODE")
	protected String locationCode;
	
	@Column(name = "LOCATION_ID")
	protected Long locationId;
	
	@Column(name = "GROSS_FIELD_AREA")
	protected BigDecimal grossFieldArea;
	
	@Column(name = "PRCL_ID")
	protected String prclId;
	
	@Column(name = "IS_PERM_FLAG")
	protected boolean isPermFlag;
	
	@Column(name = "LAND_ACTIVITY")
	protected String landActivity;
	
	@Column(name = "ORGANIC_FLAG")
	protected boolean organicFlag;

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

	public String getLocationCode() {
		return locationCode;
	}

	public void setLocationCode(String locationCode) {
		this.locationCode = locationCode;
	}

	public Long getLocationId() {
		return locationId;
	}

	public void setLocationId(Long locationId) {
		this.locationId = locationId;
	}

	public BigDecimal getGrossFieldArea() {
		return grossFieldArea;
	}

	public void setGrossFieldArea(BigDecimal grossFieldArea) {
		this.grossFieldArea = grossFieldArea;
	}

	public String getPrclId() {
		return prclId;
	}

	public void setPrclId(String prclId) {
		this.prclId = prclId;
	}

	public boolean isPermFlag() {
		return isPermFlag;
	}

	public void setPermFlag(boolean isPermFlag) {
		this.isPermFlag = isPermFlag;
	}

	public String getLandActivity() {
		return landActivity;
	}

	public void setLandActivity(String landActivity) {
		this.landActivity = landActivity;
	}

	public boolean isOrganicFlag() {
		return organicFlag;
	}

	public void setOrganicFlag(boolean organicFlag) {
		this.organicFlag = organicFlag;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public boolean isPrclAddedInAppFlag() {
		return prclAddedInAppFlag;
	}

	public void setPrclAddedInAppFlag(boolean prclAddedInAppFlag) {
		this.prclAddedInAppFlag = prclAddedInAppFlag;
	}

}