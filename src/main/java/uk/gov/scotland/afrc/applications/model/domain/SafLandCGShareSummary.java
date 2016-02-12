package uk.gov.scotland.afrc.applications.model.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import uk.gov.scotland.afrc.applications.model.base.BaseTableListener;

/**
 * The persistent class for the V_SAFRPT_LAND_CG_SHARE database table.
 * 
 */
@Entity
@Table(name = "V_SAFRPT_LAND_CG_SHARE")
@EntityListeners(BaseTableListener.class)
@NamedQueries(value = {
            @NamedQuery(
                        name = "SafLandCGShareSummary.findByApplicationId",
                        query = "SELECT cgs FROM SafLandCGShareSummary cgs WHERE cgs.applicationId = :applicationId")})
public class SafLandCGShareSummary implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @Column(name = "APP_CG_SHARE_ID")
    private Long appCgShareId;
    
    @Column(name = "APP_CG_ID")
    private Long appCgId;
  
    @Column(name = "APPLICATION_ID")
    private Long applicationId;
    
    @Column(name = "SHARE_LOCATION_CODE")
    private String shareLocationCode;
    
    @Column(name = "SHARE_LOCATION_ID")
    private Long shareLocationId;

    @Column(name = "SHARE_CROFT_NAME")
    private String shareCroftName;
    
    @Column(name = "APP_TOT_SHEEP_EQUIVALENT")
    private Long appTotalSheepEquivalent;

    @Column(name = "IS_SHAREHOLDER_FLAG")
    private boolean isShareholderFlag;

    @Column(name = "LAND_ACTIVITY")
    private String landActivity;

    @Column(name = "USE_LND_PART_ORGANIC_FLAG")
    private boolean useLandPartOrganicFlag;

	public Long getAppCgShareId() {
		return appCgShareId;
	}

	public void setAppCgShareId(Long appCgShareId) {
		this.appCgShareId = appCgShareId;
	}

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

	public String getShareLocationCode() {
		return shareLocationCode;
	}

	public void setShareLocationCode(String shareLocationCode) {
		this.shareLocationCode = shareLocationCode;
	}

	public Long getShareLocationId() {
		return shareLocationId;
	}

	public void setShareLocationId(Long shareLocationId) {
		this.shareLocationId = shareLocationId;
	}

	public String getShareCroftName() {
		return shareCroftName;
	}

	public void setShareCroftName(String shareCroftName) {
		this.shareCroftName = shareCroftName;
	}

	public Long getAppTotalSheepEquivalent() {
		return appTotalSheepEquivalent;
	}

	public void setAppTotalSheepEquivalent(Long appTotalSheepEquivalent) {
		this.appTotalSheepEquivalent = appTotalSheepEquivalent;
	}

	public boolean isShareholderFlag() {
		return isShareholderFlag;
	}

	public void setShareholderFlag(boolean isShareholderFlag) {
		this.isShareholderFlag = isShareholderFlag;
	}

	public String getLandActivity() {
		return landActivity;
	}

	public void setLandActivity(String landActivity) {
		this.landActivity = landActivity;
	}

	public boolean isUseLandPartOrganicFlag() {
		return useLandPartOrganicFlag;
	}

	public void setUseLandPartOrganicFlag(boolean useLandPartOrganicFlag) {
		this.useLandPartOrganicFlag = useLandPartOrganicFlag;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
    
  

}