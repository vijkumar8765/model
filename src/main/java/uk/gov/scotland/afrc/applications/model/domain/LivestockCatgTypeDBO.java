/*
 * Project : AFRC Futures
 * Copyright (C) 2013 Scottish Government AFRC Programme
 * AFRC PROPRIETARY/CONFIDENTIAL
 */
package uk.gov.scotland.afrc.applications.model.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

import uk.gov.scotland.afrc.applications.model.base.BaseTable;
import uk.gov.scotland.afrc.applications.model.base.BaseTableAware;
import uk.gov.scotland.afrc.applications.model.base.BaseTableListener;

/**
 * The persistent class for the LIVESTOCK_CATG_TYPE database table.
 * 
 */
@Entity
@Table(name="LIVESTOCK_CATG_TYPE")
@javax.persistence.Cacheable
@EntityListeners(BaseTableListener.class)
@NamedQuery(name="LivestockCatgType.findAll", query="SELECT l FROM LivestockCatgTypeDBO l")
public class LivestockCatgTypeDBO implements Serializable, BaseTableAware {
	private static final long serialVersionUID = 1L;

	@Id
    @Column(name = "CODE")
    private Long code;

    @Column(name="BUSINESS_PRIORITY")
	private Long businessPriority;

	@Column(name="DEFAULT_CHOICE")
	private boolean defaultChoice;

    @Column(name = "DESCRIPTION")
	private String description;

	@Temporal(TemporalType.DATE)
	@Column(name="END_DATE")
	private Date endDate;

	@Column(name="JPA_VERSION_NUMBER")
	@Version
	private Long jpaVersionNumber;

    @Column(name = "NAME")
	private String name;

	//bi-directional many-to-one association to LivestockType
	@OneToMany(mappedBy="livestockCatgType")
	private List<LivestockTypeDBO> livestockTypes;

    @Embedded
    private BaseTable baseTable;

	public LivestockCatgTypeDBO() {
	}

    public Long getCode() {
		return this.code;
	}

    public void setCode(Long code) {
		this.code = code;
	}

	public Long getBusinessPriority() {
		return this.businessPriority;
	}

	public void setBusinessPriority(Long businessPriority) {
		this.businessPriority = businessPriority;
	}

	public boolean getDefaultChoice() {
		return this.defaultChoice;
	}

	public void setDefaultChoice(boolean defaultChoice) {
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

	public List<LivestockTypeDBO> getLivestockTypes() {
		return this.livestockTypes;
	}

	public void setLivestockTypes(List<LivestockTypeDBO> livestockTypes) {
		this.livestockTypes = livestockTypes;
	}

	public LivestockTypeDBO addLivestockType(LivestockTypeDBO livestockType) {
		getLivestockTypes().add(livestockType);
		livestockType.setLivestockCatgType(this);

		return livestockType;
	}

	public LivestockTypeDBO removeLivestockType(LivestockTypeDBO livestockType) {
		getLivestockTypes().remove(livestockType);
		livestockType.setLivestockCatgType(null);

		return livestockType;
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

}