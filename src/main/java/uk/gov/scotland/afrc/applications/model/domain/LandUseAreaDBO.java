/*
 * Project : AFRC Futures
 * Copyright (C) 2013 Scottish Government AFRC Programme
 * AFRC PROPRIETARY/CONFIDENTIAL
 */
package uk.gov.scotland.afrc.applications.model.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

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
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Version;

import uk.gov.scotland.afrc.applications.model.base.BaseTable;
import uk.gov.scotland.afrc.applications.model.base.BaseTableAware;
import uk.gov.scotland.afrc.applications.model.base.BaseTableListener;
import uk.gov.scotland.afrc.applications.model.base.LandUseAreaAware;

/**
 * The persistent class for the LAND_USE_AREA database table.
 * 
 */
@Entity
@Table(name = "LAND_USE_AREA")
@EntityListeners(BaseTableListener.class)
@NamedQueries({
        @NamedQuery(name = "LandUseAreaDBO.findByIdAndVersion",
            query = "SELECT l FROM LandUseAreaDBO l where l.lndUseAreaId= :id and l.jpaVersionNumber= :version"),
        @NamedQuery(
            name = "LandUseAreaDBO.getPermLandUseForLndPrcl",
            query = "SELECT l FROM LandUseAreaDBO l, LandUseTypeDBO t WHERE l.lndUseTypeCode = t.code AND l.lndPrclApplicationId = :appLndPrclId AND t.isPermFlag = TRUE"),

        @NamedQuery(
            name = "LandUseAreaDBO.findByApplicationIdAndParcelType",
            query = "SELECT l FROM LandUseAreaDBO l where l.applicationLandParcel.applicationId = :applicationId and l.applicationLandParcel.isConfirmedFlag = :isConfirmed and l.applicationLandParcel.isPermFlag = :isPermanent"),

        @NamedQuery(
            name = "LandUseAreaDBO.findByApplicationIdAndAppLndPrclId",
            query = "SELECT l FROM LandUseAreaDBO l where l.lndPrclApplicationId = :lndPrclApplicationId and l.applicationId = :applicationId"),

        @NamedQuery(name = "LandUseAreaDBO.findByApplicationId",
            query = "SELECT l FROM LandUseAreaDBO l where l.applicationId = :applicationId") })
public class LandUseAreaDBO implements Serializable, BaseTableAware, LandUseAreaAware {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "LND_USE_AREA_ID")
    @SequenceGenerator(name = "LND_USE_AREA_SEQ_GENERATOR", sequenceName = "LAND_USE_AREA_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "LND_USE_AREA_SEQ_GENERATOR")
    private long lndUseAreaId;

    @Embedded
    private BaseTable baseTable;

    @Column(name = "APPLICATION_ID")
    private Long applicationId;

    @Column(name = "AREA_AMT")
    private BigDecimal areaAmt;

    @Column(name = "IS_MAPPED_FLAG")
    private boolean isMappedArea;

    @Column(name = "JPA_VERSION_NUMBER")
    @Version
    private Long jpaVersionNumber;

    @Column(name = "APP_LND_PRCL_ID")
    private Long lndPrclApplicationId;

    @OneToOne
    @JoinColumn(name = "APP_LND_PRCL_ID")
    private AppLndPrclDBO applicationLandParcel;
    
    @OneToMany(mappedBy = "landUseArea", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private List<LandUseClaimDBO> landUseClaims;

    public AppLndPrclDBO getApplicationLandParcel() {
        return applicationLandParcel;
    }

    public void setApplicationLandParcel(AppLndPrclDBO applicationLandParcel) {
        this.applicationLandParcel = applicationLandParcel;
    }

    @Column(name = "LND_USE_TYPE_CODE")
    private Long lndUseTypeCode;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "LND_USE_TYPE_CODE")
    private LandUseTypeDBO landUseType;
    
    @ManyToOne
    @JoinColumn(name = "APP_LND_PRCL_ID")
    private AppLndPrclDBO appLndPrclList;

    public LandUseAreaDBO() {
    }

    public long getLndUseAreaId() {
        return this.lndUseAreaId;
    }

    public void setLndUseAreaId(long lndUseAreaId) {
        this.lndUseAreaId = lndUseAreaId;
    }

    public BaseTable getBaseTable() {
        if (baseTable == null) {
            baseTable = new BaseTable();
        }

        return baseTable;
    }

    public void setBaseTable(BaseTable baseTable) {
        this.baseTable = baseTable;
    }

    public Long getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(Long applicationId) {
        this.applicationId = applicationId;
    }

    public BigDecimal getAreaAmt() {
        return this.areaAmt;
    }

    public void setAreaAmt(BigDecimal areaAmt) {
        this.areaAmt = areaAmt;
    }

    public boolean getIsMappedArea() {
        return this.isMappedArea;
    }

    public void setIsMappedArea(boolean isMappedArea) {
        this.isMappedArea = isMappedArea;
    }

    public Long getJpaVersionNumber() {
        return this.jpaVersionNumber;
    }

    public void setJpaVersionNumber(Long jpaVersionNumber) {
        this.jpaVersionNumber = jpaVersionNumber;
    }

    public Long getLndPrclApplicationId() {
        return this.lndPrclApplicationId;
    }

    public void setLndPrclApplicationId(Long lndPrclApplicationId) {
        this.lndPrclApplicationId = lndPrclApplicationId;
    }

    public Long getLndUseTypeCode() {
        return this.lndUseTypeCode;
    }

    public void setLndUseTypeCode(Long lndUseTypeCode) {
        this.lndUseTypeCode = lndUseTypeCode;
    }

    public boolean isLfa() {
        return getApplicationLandParcel().isLfa();
    }

    public BigDecimal getAreaAmount() {
        return getAreaAmt();
    }

    public LandUseTypeDBO getLandUseType() {
        return landUseType;
    }

    public void setLandUseType(LandUseTypeDBO landUseType) {
        this.landUseType = landUseType;
    }

	public AppLndPrclDBO getAppLndPrclList() {
		return this.appLndPrclList;
	}

	public void setAppLndPrclList(AppLndPrclDBO appLndPrclList) {
		this.appLndPrclList = appLndPrclList;
	}

	public List<LandUseClaimDBO> getLandUseClaims() {
		return landUseClaims;
	}

	public void setLandUseClaims(List<LandUseClaimDBO> landUseClaims) {
		this.landUseClaims = landUseClaims;
	}
}