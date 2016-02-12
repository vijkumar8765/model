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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
 * The persistent class for the LIVESTOCK_TYPE database table.
 * 
 */
@Entity
@Table(name="LIVESTOCK_TYPE")
@javax.persistence.Cacheable
@EntityListeners(BaseTableListener.class)
@NamedQuery(name="LivestockType.findAll", query="SELECT l FROM LivestockTypeDBO l")
public class LivestockTypeDBO implements Serializable, BaseTableAware {
	private static final long serialVersionUID = 1L;

	@Id
	private long code;

    @Column(name="BUSINESS_PRIORITY")
	private Long businessPriority;

	@Column(name="DEFAULT_CHOICE")
	private boolean defaultChoice;

	private String description;

	@Temporal(TemporalType.DATE)
	@Column(name="END_DATE")
	private Date endDate;

	@Column(name="JPA_VERSION_NUMBER")
	@Version
	private Long jpaVersionNumber;

	private String name;

	//bi-directional many-to-one association to Livestock
	@OneToMany(mappedBy="livestockType")
	private List<LivestockDBO> livestocks;

	//bi-directional many-to-one association to LivestockCatgType
	@ManyToOne
	@JoinColumn(name="LIVESTOCK_CATG_TYPE_CODE")
	private LivestockCatgTypeDBO livestockCatgType;

    @Column(name = "LIVESTOCK_CATG_TYPE_CODE")
    private Long livestockCatgTypeCode;

    @Embedded
    private BaseTable baseTable;

    public LivestockTypeDBO() {
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

	public List<LivestockDBO> getLivestocks() {
		return this.livestocks;
	}

	public void setLivestocks(List<LivestockDBO> livestocks) {
		this.livestocks = livestocks;
	}

	public LivestockDBO addLivestock(LivestockDBO livestock) {
		getLivestocks().add(livestock);
		livestock.setLivestockType(this);

		return livestock;
	}

	public LivestockDBO removeLivestock(LivestockDBO livestock) {
		getLivestocks().remove(livestock);
		livestock.setLivestockType(null);

		return livestock;
	}

	public LivestockCatgTypeDBO getLivestockCatgType() {
		return this.livestockCatgType;
	}

	public void setLivestockCatgType(LivestockCatgTypeDBO livestockCatgType) {
		this.livestockCatgType = livestockCatgType;
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