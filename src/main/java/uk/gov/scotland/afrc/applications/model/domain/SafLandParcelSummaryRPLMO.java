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
@Table(name = "V_SAFRPT_LAND_RPLMO")
@EntityListeners(BaseTableListener.class)
@NamedQueries({
        @NamedQuery(name = "SafLandParcelSummaryRPLMO.findSafLandParcelRPLMOByApplicationId",
            query = "SELECT s FROM SafLandParcelSummaryRPLMO s where s.applicationId = :applicationId") })
public class SafLandParcelSummaryRPLMO  implements Serializable {

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
	
	@Column(name = "LOCATION_ID")
	protected Long locationId;
	
	@Column(name = "SCHEME_NAME")
	protected String schemeName;
	
	@Column(name = "SCHEME_OPTION_CODE")
	protected String schemeOptionCode;
	
	@Column(name = "LOCATION_CODE")
	protected String locationCode;
	
	@Column(name = "PRCL_ID")
	protected String prclId;
	
	@Column(name = "UNITS_UNDERTAKEN")
	protected BigDecimal unitsUndertaken;
	
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

	public Long getLocationId() {
		return locationId;
	}

	public void setLocationId(Long locationId) {
		this.locationId = locationId;
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

	public String getLocationCode() {
		return locationCode;
	}

	public void setLocationCode(String locationCode) {
		this.locationCode = locationCode;
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
