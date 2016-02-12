/*
 * Project : AFRC Futures
 * Copyright (C) 2013 Scottish Government AFRC Programme
 * AFRC PROPRIETARY/CONFIDENTIAL
 */
package uk.gov.scotland.afrc.applications.model.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

/**
 * ***************************************************************************************************************
 * This is READ ONLY DBO Object to LPIS for the LPIS_LAND_PARCEL database table.
 * This DBO should only be used to read data from LPIS_LAND_PARCEL synonym/table for cloning land use data
 * DO NOT USE IT TO MODIFY ANYTHING IN THE DATABASE
 * ***************************************************************************************************************
 */
@Entity
@Table(name="LPIS_LAND_PARCEL")
@NamedQueries( {
	@NamedQuery(name = "LpisLandParcelDBO.findByLocationId",
    query = "SELECT l FROM LpisLandParcelDBO l WHERE l.locationId = :locationId"),
    @NamedQuery(name = "LpisLandParcel.findByParcelId",
            query = "SELECT a FROM LpisLandParcelDBO a where a.prclId = :parcelId"),
    @NamedQuery(name = "LpisLandParcel.findByLocationIdAndClaim",
            query = "SELECT a FROM LpisLandParcelDBO a, ClaimDBO c where a.lpisLndPrclId = c.lpisLndPrclId and a.locationId=:locationId")        

})
public class LpisLandParcelDBO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
    @Column(name = "LPIS_LND_PRCL_ID", insertable = false, updatable = false)
	private long lpisLndPrclId;

    @Column(name = "DIGITISED_AREA", insertable = false, updatable = false)
    private BigDecimal digitisedArea;

	@Temporal(TemporalType.DATE)
    @Column(name = "END_DATE", insertable = false, updatable = false)
	private Date endDate;

	@Transient
	private Object geometry;

    @Column(name = "JPA_VERSION_NUMBER", insertable = false, updatable = false)
    private Long jpaVersionNumber;

    @Column(name = "LAST_UPDATED_BY", insertable = false, updatable = false)
    private Long lastUpdatedBy;

	@Temporal(TemporalType.DATE)
    @Column(name = "LAST_UPDATED_DATE", insertable = false, updatable = false)
	private Date lastUpdatedDate;

    @Column(name = "LND_PRCL_LINEAGE", insertable = false, updatable = false)
    private Long lndPrclLineage;

    @Column(name = "LOCATION_ID", insertable = false, updatable = false)
    private Long locationId;

    @Column(name = "PRCL_ID", insertable = false, updatable = false)
	private String prclId;

    @Column(name = "PRCL_VER", insertable = false, updatable = false)
    private Long prclVer;

	@Temporal(TemporalType.DATE)
    @Column(name = "START_DATE", insertable = false, updatable = false)
	private Date startDate;

    @Column(name = "IS_INACTIVE_FLAG")
    private boolean isInactiveFlag;
    
    @Column(name = "LND_CHNGE_RECEIVED_FLAG")
    private boolean isLandChangeReceived;
    
    @OneToMany(targetEntity=LpisFeatureDBO.class, mappedBy="lpislandParcel", cascade=CascadeType.MERGE, fetch=FetchType.LAZY)
    private Set<LpisFeatureDBO> features;

	public boolean isLandChangeReceived() {
		return isLandChangeReceived;
	}

	public void setLandChangeReceived(boolean isLandChangeReceived) {
		this.isLandChangeReceived = isLandChangeReceived;
	}

	public LpisLandParcelDBO() {
	}

    public long getLpisLndPrclId() {
		return this.lpisLndPrclId;
	}

	public void setLpisLndPrclId(long lpisLndPrclId) {
		this.lpisLndPrclId = lpisLndPrclId;
	}

    public BigDecimal getDigitisedArea() {
		return this.digitisedArea;
	}

    public void setDigitisedArea(BigDecimal digitisedArea) {
		this.digitisedArea = digitisedArea;
	}

	public Date getEndDate() {
		return this.endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Object getGeometry() {
		return this.geometry;
	}

	public void setGeometry(Object geometry) {
		this.geometry = geometry;
	}

    public Long getJpaVersionNumber() {
		return this.jpaVersionNumber;
	}

    public void setJpaVersionNumber(Long jpaVersionNumber) {
		this.jpaVersionNumber = jpaVersionNumber;
	}

    public Long getLastUpdatedBy() {
		return this.lastUpdatedBy;
	}

    public void setLastUpdatedBy(Long lastUpdatedBy) {
		this.lastUpdatedBy = lastUpdatedBy;
	}

	public Date getLastUpdatedDate() {
		return this.lastUpdatedDate;
	}

	public void setLastUpdatedDate(Date lastUpdatedDate) {
		this.lastUpdatedDate = lastUpdatedDate;
	}

    public Long getLndPrclLineage() {
		return this.lndPrclLineage;
	}

    public void setLndPrclLineage(Long lndPrclLineage) {
		this.lndPrclLineage = lndPrclLineage;
	}

    public Long getLocationId() {
		return this.locationId;
	}

    public void setLocationId(Long locationId) {
		this.locationId = locationId;
	}

	public String getPrclId() {
		return this.prclId;
	}

	public void setPrclId(String prclId) {
		this.prclId = prclId;
	}

    public Long getPrclVer() {
		return this.prclVer;
	}

    public void setPrclVer(Long prclVer) {
		this.prclVer = prclVer;
	}

	public Date getStartDate() {
		return this.startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public boolean isInactiveFlag() {
		return isInactiveFlag;
	}

	public void setIsInactiveFlag(boolean isInactiveFlag) {
		this.isInactiveFlag = isInactiveFlag;
	}

	public Set<LpisFeatureDBO> getFeatures() {
		return features;
	}

	public void setFeatures(Set<LpisFeatureDBO> features) {
		this.features = features;
	}
	
	
}