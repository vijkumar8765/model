/*
 * Project : AFRC Futures
 * Copyright (C) 2013 Scottish Government AFRC Programme
 * AFRC PROPRIETARY/CONFIDENTIAL
 */
package uk.gov.scotland.afrc.applications.model.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

import uk.gov.scotland.afrc.applications.model.base.BaseTable;
import uk.gov.scotland.afrc.applications.model.base.BaseTableAware;
import uk.gov.scotland.afrc.applications.model.base.BaseTableListener;

/**
 * The persistent class for the LAND_USE_TYPE database table.
 * 
 */
@Entity
@Table(name = "LAND_USE_TYPE")
@javax.persistence.Cacheable
@EntityListeners(BaseTableListener.class)
@NamedQueries({
        @NamedQuery(name = "LandUseTypeDBO.findAll", query = "SELECT lut FROM LandUseTypeDBO lut order by lut.description"),
        @NamedQuery(name = "LandUseTypeDBO.typeCodesForApplication",
                query = "SELECT lua.lndUseTypeCode FROM LandUseAreaDBO lua JOIN lua.applicationLandParcel alp"
                        + " where alp.applicationId= :applicationId"),
        @NamedQuery(name = "LandUseTypeDBO.findByCode",
                        query = "SELECT lut FROM LandUseTypeDBO lut where lut.name=:code"),
        @NamedQuery(name = "LandUseTypeDBO.findByName",
                query = "SELECT lut FROM LandUseTypeDBO lut where lut.description=:name")})
public class LandUseTypeDBO implements Serializable, BaseTableAware {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="CODE")
	private long code;

    @Embedded
    private BaseTable baseTable;

    @Column(name = "BUSINESS_PRIORITY")
    private Long businessPriority;

	@Column(name="DEFAULT_CHOICE")
    private Long defaultChoice;

	private String description;

	@Temporal(TemporalType.DATE)
	@Column(name="END_DATE")
	private Date endDate;

	@Column(name="IS_LET_OUT_FLAG")
    private Long isLetOutFlag;

	@Column(name="IS_PERM_FLAG")
    private boolean isPermFlag;

	@Column(name="JPA_VERSION_NUMBER")
	@Version
    private Long jpaVersionNumber;

    @Column(name="NAME")
	private String name;

	private String region;

    @ManyToOne
    @JoinColumn(name="EVDNCE_REQT_TYPE_CODE")
    private EvidenceRequirementTypeDBO evidenceRequirementType;
	
	public LandUseTypeDBO() {
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

	public long getCode() {
		return this.code;
	}

	public void setCode(long code) {
		this.code = code;
	}

    public Long getBusinessPriority() {
		return this.businessPriority;
	}

    public void setBusinessPriority(Long businessPriority) {
		this.businessPriority = businessPriority;
	}

    public Long getDefaultChoice() {
		return this.defaultChoice;
	}

    public void setDefaultChoice(Long defaultChoice) {
		this.defaultChoice = defaultChoice;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getEndDate() {
		return this.endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

    public Long getIsLetOutFlag() {
		return this.isLetOutFlag;
	}

    public void setIsLetOutFlag(Long isLetOutFlag) {
		this.isLetOutFlag = isLetOutFlag;
	}

    public boolean getIsPermFlag() {
		return this.isPermFlag;
	}

    public void setIsPermFlag(boolean isPermFlag) {
		this.isPermFlag = isPermFlag;
	}

    public Long getJpaVersionNumber() {
		return this.jpaVersionNumber;
	}

    public void setJpaVersionNumber(Long jpaVersionNumber) {
		this.jpaVersionNumber = jpaVersionNumber;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRegion() {
		return this.region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

    public EvidenceRequirementTypeDBO getEvidenceRequirementType() {
        return evidenceRequirementType;
    }

    public void setEvidenceRequirementType(EvidenceRequirementTypeDBO evidenceRequirementType) {
        this.evidenceRequirementType = evidenceRequirementType;
    }
}