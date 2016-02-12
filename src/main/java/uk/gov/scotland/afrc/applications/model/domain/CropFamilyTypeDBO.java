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
 * The persistent class for the CROP_FAMILY_TYPE database table.
 * 
 */
@Entity
@Table(name = "CROP_FAMILY_TYPE")
@javax.persistence.Cacheable
@EntityListeners(BaseTableListener.class)
@NamedQueries({
    @NamedQuery(name = "CropFamilyTypeDBO.findAll", query = "SELECT cft FROM CropFamilyTypeDBO cft order by cft.description"),
    @NamedQuery(name = "CropFamilyTypeDBO.findByCode", query = "SELECT cft FROM CropFamilyTypeDBO cft where cft.code=:code"),
    @NamedQuery(name = "CropFamilyTypeDBO.findByName", query = "SELECT cft FROM CropFamilyTypeDBO cft where cft.name=:name")})
public class CropFamilyTypeDBO implements Serializable, BaseTableAware {
	private static final long serialVersionUID = 1L;

    @Embedded
    private BaseTable baseTable;

	@Id
	@Column(name="CODE")
	private long code;

    @Column(name="NAME")
	private String name;

	@Column(name="DESCRIPTION")
	private String description;

    @Column(name = "BUSINESS_PRIORITY")
    private Long businessPriority;

	@Temporal(TemporalType.DATE)
	@Column(name="START_DATE")
	private Date startDate;

	@Temporal(TemporalType.DATE)
	@Column(name="END_DATE")
	private Date endDate;

	@Column(name="DEFAULT_CHOICE")
    private Long defaultChoice;
	
	@Temporal(TemporalType.DATE)
	@Column(name="LAST_UPDATED_DATE")
	private Date lastUpdatedDate;
	
	@Column(name="LAST_UPDATED_BY")
	private Long lastUpdatedBy;

	@Column(name="JPA_VERSION_NUMBER")
	@Version
    private Long jpaVersionNumber;

	public CropFamilyTypeDBO() {
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

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getLastUpdatedDate() {
		return lastUpdatedDate;
	}

	public void setLastUpdatedDate(Date lastUpdatedDate) {
		this.lastUpdatedDate = lastUpdatedDate;
	}

	public Long getLastUpdatedBy() {
		return lastUpdatedBy;
	}

	public void setLastUpdatedBy(Long lastUpdatedBy) {
		this.lastUpdatedBy = lastUpdatedBy;
	}

}