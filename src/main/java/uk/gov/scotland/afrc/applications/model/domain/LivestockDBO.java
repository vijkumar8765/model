/*
 * Project : AFRC Futures
 * Copyright (C) 2013 Scottish Government AFRC Programme
 * AFRC PROPRIETARY/CONFIDENTIAL
 */
package uk.gov.scotland.afrc.applications.model.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Version;

import uk.gov.scotland.afrc.applications.model.base.BaseTable;
import uk.gov.scotland.afrc.applications.model.base.BaseTableAware;
import uk.gov.scotland.afrc.applications.model.base.BaseTableListener;

/**
 * The persistent class for the LIVESTOCK database table.
 * 
 */
@Entity
@Table(name="LIVESTOCK")
@EntityListeners(BaseTableListener.class)

@NamedQueries(value = {
        @NamedQuery(name = "Livestock.findAll", query = "SELECT l FROM LivestockDBO l"),
            @NamedQuery(
                name = "LivestockDBO.findLivestockCatgIdByAppId",
                query = "SELECT DISTINCT t.livestockCatgTypeCode FROM LivestockDBO l, LivestockTypeDBO t where l.applicationId = :applicationId AND l.livestockTypeCode = t.code"),
        @NamedQuery(name = "LivestockDBO.findByApplicationId",
            query = "SELECT l FROM LivestockDBO l where l.applicationId = :applicationId") })
public class LivestockDBO implements Serializable, BaseTableAware {
	private static final long serialVersionUID = 1L;

	@Id
    @SequenceGenerator(name = "LIVESTOCK_SEQ_GENERATOR", sequenceName = "LIVESTOCK_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "LIVESTOCK_SEQ_GENERATOR")
	@Column(name="LIVESTOCK_ID")
	private long livestockId;

    @Embedded
    private BaseTable baseTable;

    @Column(name="APPLICATION_ID")
	private Long applicationId;

	@Column(name="IS_HELD_FLAG")
	private boolean isHeldFlag;

	@Column(name="JPA_VERSION_NUMBER")
    @Version
	private Long jpaVersionNumber;

	@Column(name="TOT_LIVESTOCK")
	private Long totLivestock;

	@Column(name="TOT_LIVESTOCK_LFA")
	private Long totLivestockLfa;

    @Column(name = "LIVESTOCK_TYPE_CODE")
    private Long livestockTypeCode;

    // bi-directional many-to-one association to LivestockType
	@ManyToOne
	@JoinColumn(name="LIVESTOCK_TYPE_CODE")
	private LivestockTypeDBO livestockType;

	public LivestockDBO() {
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

    public long getLivestockId() {
		return this.livestockId;
	}

	public void setLivestockId(long livestockId) {
		this.livestockId = livestockId;
	}

	public Long getApplicationId() {
		return this.applicationId;
	}

	public void setApplicationId(Long applicationId) {
		this.applicationId = applicationId;
	}

	public boolean getIsHeldFlag() {
		return this.isHeldFlag;
	}

	public void setIsHeldFlag(boolean isHeldFlag) {
		this.isHeldFlag = isHeldFlag;
	}

	public Long getJpaVersionNumber() {
		return this.jpaVersionNumber;
	}

	public void setJpaVersionNumber(Long jpaVersionNumber) {
		this.jpaVersionNumber = jpaVersionNumber;
	}

    public Long getTotLivestock() {
        return this.totLivestock;
    }

    public void setTotLivestock(Long totLivestock) {
        this.totLivestock = totLivestock;
    }

    public Long getTotLivestockLfa() {
        return this.totLivestockLfa;
    }

    public void setTotLivestockLfa(Long totLivestockLfa) {
        this.totLivestockLfa = totLivestockLfa;
    }

    public LivestockTypeDBO getLivestockType() {
        return this.livestockType;
    }

    public void setLivestockType(LivestockTypeDBO livestockType) {
        this.livestockType = livestockType;
    }

    public Long getLivestockTypeCode() {
        return livestockTypeCode;
    }

    public void setLivestockTypeCode(Long livestockTypeCode) {
        this.livestockTypeCode = livestockTypeCode;
    }
}