/*
 * Project : AFRC Futures
 * Copyright (C) 2013 Scottish Government AFRC Programme
 * AFRC PROPRIETARY/CONFIDENTIAL
 */
package uk.gov.scotland.afrc.applications.model.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Version;

import uk.gov.scotland.afrc.applications.model.base.BaseTable;
import uk.gov.scotland.afrc.applications.model.base.BaseTableAware;
import uk.gov.scotland.afrc.applications.model.base.BaseTableListener;

/**
 * The persistent class for the APP_LND_PRCL database table.
 * 
 */
@Entity
@Table(name = "APP_LND_PRCL")
@EntityListeners(BaseTableListener.class)
@NamedQueries({
        @NamedQuery(name = "AppLndPrcl.findAll", query = "SELECT a FROM AppLndPrclDBO a"),
        
        @NamedQuery(name = "AppLndPrcl.findByAppAndLocationId",
        query = "SELECT a FROM AppLndPrclDBO a where a.applicationId = :appId and a.locationId = :locationId"),
        
        @NamedQuery(
            name = "AppLndPrcl.findByApplicationIdAndLocationId",
        query = "SELECT a FROM AppLndPrclDBO a where a.applicationId = :applicationId and a.locationId = :locationId"),
        
        @NamedQuery(name = "AppLndPrcl.findByApplicationAndLocationId",
        query = "SELECT a FROM AppLndPrclDBO a where a.application = :application and a.locationId = :locationId"),
        
        @NamedQuery(name = "AppLndPrcl.findSeasonal",
            query = "SELECT a FROM AppLndPrclDBO a where a.applicationId = :appId and a.isPermFlag = FALSE"),
        
            @NamedQuery(
            name = "AppLndPrcl.findByAppAndLocationIdAndPrclId",
            query = "SELECT a FROM AppLndPrclDBO a where a.applicationId = :appId and a.locationId = :locationId and a.prclId = :prclId"),
        
            @NamedQuery(name = "AppLndPrcl.findByApplicationId",
            query = "SELECT d FROM AppLndPrclDBO d where d.applicationId = :applicationId ORDER BY d.prclId"),
            
            @NamedQuery(name = "AppLndPrcl.findNotNullParcelsByApplicationId",
            query = "SELECT d FROM AppLndPrclDBO d where d.applicationId = :applicationId and d.prclId is not null"),
        
            @NamedQuery(name = "AppLndPrcl.findErrorByApplicationId", query = "SELECT DISTINCT a.appLndPrclId, a.prclId "
            + "FROM AppLndPrclDBO a, AppValidationErrDBO e " + " where e.applicationId = :applicationId"
            + " and e.applicationId = a.applicationId" + " and e.appLndPrclId = a.appLndPrclId" + " ORDER BY a.prclId"),
        
            @NamedQuery(
            name = "AppLndPrcl.findByApplicationAndLPISParcel",
            query = "SELECT d FROM AppLndPrclDBO d where d.applicationId = :applicationId and d.appLndPrclId = :appLndPrclId"),
        
        @NamedQuery(
            name = "AppLndPrcl.findByApplicationIdAndLPISParcelId",
            query = "SELECT d FROM AppLndPrclDBO d where d.applicationId = :applicationId and d.lpisLndPrclId = :lpisLndPrclId"),

            @NamedQuery(name = "AppLndPrcl.findByApplicationIdAndParcelId",
            query = "SELECT a FROM AppLndPrclDBO a where a.prclId = :parcelId and a.applicationId = :applicationId"),

        @NamedQuery(
            name = "AppLndPrcl.findByApplicationAndGridReference",
            query = "SELECT a FROM AppLndPrclDBO a where UPPER(a.gridReference) = UPPER(:gridReference) and a.applicationId = :applicationId"),

            @NamedQuery(
            name = "AppLndPrcl.findByApppplicationVerified",
            query = "SELECT a FROM AppLndPrclDBO a where a.applicationId = :applicationId and a.isVerifiedFlag = :isVerified"),

            @NamedQuery(
            name = "AppLndPrcl.findByApppplicationIdAndStatus",
            query = "SELECT a FROM AppLndPrclDBO a where a.applicationId = :applicationId and a.isConfirmedFlag = :isConfirmed and a.isVerifiedFlag = :isVerified"),
        
            @NamedQuery(
            name = "AppLndPrcl.findByApplicationIdAndSchemeId",
            query = "SELECT clm.appLndPrcl FROM ClaimDBO clm where clm.appLndPrcl.isConfirmedFlag = :isConfirmed and clm.appLndPrcl.applicationId = :applicationId and clm.schemeOption.scheme.schemeId = :schemeId"),
            
            @NamedQuery(name = "AppLndPrcl.findDesignatedSiteAppLandParcelsByApplicationId",
            query = "SELECT d FROM AppLndPrclDBO d where d.applicationId = :applicationId and d.isDesignatedSite = :isDesignatedSite"),
        
            @NamedQuery(name= "AppLndPrcl.findByLPISParcelId", 
            query = "SELECT d FROM AppLndPrclDBO d where d.lpisLndPrclId = :lpisLndPrclId" ),            

        @NamedQuery(name = "AppLndPrcl.findByLocationId",
            query = "SELECT a FROM AppLndPrclDBO a where a.locationId = :locationId")

        
})

public class AppLndPrclDBO implements Serializable, BaseTableAware {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "APP_LND_PRCL_ID")
    @SequenceGenerator(name = "APP_LND_PRCL_SEQ_GENERATOR", sequenceName = "APP_LND_PRCL_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "APP_LND_PRCL_SEQ_GENERATOR")
    private Long appLndPrclId;

    @Embedded
    private BaseTable baseTable;

    @Column(name = "APPLICATION_ID")
    private long applicationId;   

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "APPLICATION_ID")
    private ApplicationDBO application;
    
    @OneToMany(mappedBy = "appLndPrcl", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<ClaimDBO> claims;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="LND_USE_ACTIVITY_TYPE_CODE")
    private LandUseActivityTypeDBO  landUseActivityTypeDBO;

    public LandUseActivityTypeDBO getLandUseActivityTypeDBO() {
		return landUseActivityTypeDBO;
	}

    public void setLandUseActivityTypeDBO(LandUseActivityTypeDBO landUseActivityTypeDBO) {
		this.landUseActivityTypeDBO = landUseActivityTypeDBO;
	}

	@Column(name = "APP_LND_PRCL_ALIAS")
    private String appLndPrclAlias;
		
    @Column(name = "DIGITISED_AREA")
    private BigDecimal digitisedArea;

    @Column(name = "BPS_ELIGIBLE_AREA")
    private BigDecimal bpsEligibleArea;

    @Column(name = "IS_CONFIRMED_FLAG")
    private boolean isConfirmedFlag;

    @Column(name = "IS_DESIGNATED_SITE")
    private boolean isDesignatedSite;

    @Column(name = "LFA_CLASS_FLAG")
    private boolean lfa;

    @Column(name = "USE_LND_PART_ORGANIC_FLAG")
    private Boolean partialOrganicFlag;
    
    @Column(name = "GRID_REFERENCE")
    private String gridReference;
    
   //bi-directional many-to-one association to AnnualRecurrentItem
    @OneToMany(mappedBy="appLndParcel", fetch = FetchType.EAGER)
    private List<ScheduleItemDBO> scheduleItems;
	
    @OneToMany(mappedBy="appLndPrclList", cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
	private List<LandUseAreaDBO> landUseArealist;
    
    @OneToMany(mappedBy="appLndPrcl", cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
    private Set<AppValidationErrDBO> validationErrors;

    public String getGridReference() {
        return gridReference;
    }

    public void setGridReference(String gridReference) {
        this.gridReference = gridReference;
    }

    public boolean isLfa() {
        return lfa;
    }

    public void setLfa(boolean lfa) {
        this.lfa = lfa;
    }

    public boolean isDesignatedSite() {
        return isDesignatedSite;
    }

    public void setDesignatedSite(boolean isDesignatedSite) {
        this.isDesignatedSite = isDesignatedSite;
    }

    @Column(name = "IS_PERM_FLAG")
    private boolean isPermFlag;

    @Column(name = "IS_REMOVED_FLAG")
    private boolean isRemovedFlag;

    @Column(name = "IS_VERIFIED_FLAG")
    private boolean isVerifiedFlag;

    @Column(name = "JPA_VERSION_NUMBER")
    @Version
    private long jpaVersionNumber;

    @Column(name = "LOCATION_ID")
    private Long locationId;

    @Column(name = "LPIS_LND_PRCL_ID")
    private Long lpisLndPrclId;

    @Column(name = "PRCL_ID")
    private String prclId;

    @Column(name = "PRCL_ADDED_IN_APP_FLAG")
    private boolean isAddAppFlag;

    public AppLndPrclDBO() {
    }

    public Long getAppLndPrclId() {
        return appLndPrclId;
    }

    public void setAppLndPrclId(Long appLndPrclId) {
        this.appLndPrclId = appLndPrclId;
    }

    public long getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(long applicationId) {
        this.applicationId = applicationId;
    }

    public String getAppLndPrclAlias() {
        return appLndPrclAlias;
    }

    public void setAppLndPrclAlias(String appLndPrclAlias) {
        this.appLndPrclAlias = appLndPrclAlias;
    }

    public BigDecimal getDigitisedArea() {
        return digitisedArea;
    }

    public void setDigitisedArea(BigDecimal digitisedArea) {
        this.digitisedArea = digitisedArea;
    }

    public BigDecimal getBpsEligibleArea() {
        return bpsEligibleArea;
    }

    public void setBpsEligibleArea(BigDecimal bpsEligibleArea) {
        this.bpsEligibleArea = bpsEligibleArea;
    }

    public boolean isConfirmedFlag() {
        return isConfirmedFlag;
    }

    public void setConfirmedFlag(boolean isConfirmedFlag) {
        this.isConfirmedFlag = isConfirmedFlag;
    }

    public boolean isPermFlag() {
        return isPermFlag;
    }

    public void setPermFlag(boolean isPermFlag) {
        this.isPermFlag = isPermFlag;
    }

    public boolean isRemovedFlag() {
        return isRemovedFlag;
    }

    public void setRemovedFlag(boolean isRemovedFlag) {
        this.isRemovedFlag = isRemovedFlag;
    }

    public boolean isVerifiedFlag() {
        return isVerifiedFlag;
    }

    public void setVerifiedFlag(boolean isVerifiedFlag) {
        this.isVerifiedFlag = isVerifiedFlag;
    }

    public long getJpaVersionNumber() {
        return jpaVersionNumber;
    }

    public void setJpaVersionNumber(long jpaVersionNumber) {
        this.jpaVersionNumber = jpaVersionNumber;
    }

    public Long getLocationId() {
        return locationId;
    }

    public void setLocationId(Long locationId) {
        this.locationId = locationId;
    }

    public Long getLpisLndPrclId() {
        return lpisLndPrclId;
    }

    public void setLpisLndPrclId(Long lpisLndPrclId) {
        this.lpisLndPrclId = lpisLndPrclId;
    }

    public String getPrclId() {
        return prclId;
    }

    public void setPrclId(String prclId) {
        this.prclId = prclId;
    }

    @Override
    public BaseTable getBaseTable() {
        if (baseTable == null) {
            baseTable = new BaseTable();
        }

        return baseTable;
    }

    @Override
    public void setBaseTable(BaseTable baseTable) {
        this.baseTable = baseTable;
    }

    public ApplicationDBO getApplication() {
        return application;
    }

    public void setApplication(ApplicationDBO application) {
        this.application = application;
    }

    public boolean isAddAppFlag() {
        return isAddAppFlag;
    }

    public void setAddAppFlag(boolean isAddAppFlag) {
        this.isAddAppFlag = isAddAppFlag;
    }
    
    public boolean isAddedPermanent(){
    	return this.isAddAppFlag && this.isPermFlag;
    }
    
    public boolean isAddedSeasonal(){
    	return this.isAddAppFlag && !this.isPermFlag;
    }

    public List<ScheduleItemDBO> getScheduleItems() {
        return scheduleItems;
    }

    public void setScheduleItems(List<ScheduleItemDBO> scheduleItems) {
        this.scheduleItems = scheduleItems;
    }

    public List<ClaimDBO> getClaims() {
  		return claims;
  	}

  	public void setClaims(List<ClaimDBO> claims) {
  		this.claims = claims;
  	}

	public List<LandUseAreaDBO> getLandUseArealist() {
		return this.landUseArealist;
	}

	public void setLandUseArealist(List<LandUseAreaDBO> landUseArealist) {
		this.landUseArealist = landUseArealist;
	}

	public Set<AppValidationErrDBO> getValidationErrors() {
		return validationErrors;
	}

	public void setValidationErrors(Set<AppValidationErrDBO> validationErrors) {
		this.validationErrors = validationErrors;
	}

    public Boolean getPartialOrganicFlag() {
        return partialOrganicFlag;
    }

    public void setPartialOrganicFlag(Boolean partialOrganicFlag) {
        this.partialOrganicFlag = partialOrganicFlag;
    }
}