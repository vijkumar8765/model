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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

import uk.gov.scotland.afrc.applications.model.base.BaseTable;
import uk.gov.scotland.afrc.applications.model.base.BaseTableAware;
import uk.gov.scotland.afrc.applications.model.base.BaseTableListener;

/**
 * The persistent class for the ADJUSTMENT database table.
 * 
 */
@Entity
@Table(name = "ADJT")
@EntityListeners(BaseTableListener.class)
@NamedQueries(value = { @NamedQuery(name = "AdjustmentDBO.findByUserId", query = "SELECT l FROM AdjustmentDBO l where l.userIdentifier= :userIdentifier"),
		 })
public class AdjustmentDBO implements Serializable, BaseTableAware {

	private static final long serialVersionUID = 361868933590794711L;
	@Id
	@SequenceGenerator(name = "ADJUSTMENT_SEQ_GENERATOR", sequenceName = "ADJUSTMENT_SEQ", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ADJUSTMENT_SEQ_GENERATOR")
	@Column(name = "ADJT_ID")
	private long adjustmentId;
	@Column(name = "JPA_VERSION_NUMBER")
	@Version
	private Long jpaVersionNumber;
	@Temporal(TemporalType.DATE)
	@Column(name = "LAST_UPDATED_DATE")
	private Date lastUpdatedDate;
	@Column(name = "LAST_UPDATED_BY")
	private long lastUpdatedUser;
	@Column(name = "USER_ID")
	private long userIdentifier;
	@Temporal(TemporalType.DATE)
	@Column(name = "APPLICABILITY_DATE")
	private Date applicabilityDate;
	@Column(name="LINE_ADJT_FLAG")
	private int lineAdjustmentFlag;	

	@Embedded
	private BaseTable baseTable;

	public AdjustmentDBO() {
	}

	public long getAdjustmentId() {
		return adjustmentId;
	}

	public void setAdjustmentId(long adjustmentId) {
		this.adjustmentId = adjustmentId;
	}


	public long getUserIdentifier() {
		return userIdentifier;
	}

	public void setUserIdentifier(long userIdentifier) {
		this.userIdentifier = userIdentifier;
	}


	public Date getApplicabilityDate() {
		return applicabilityDate;
	}

	public void setApplicabilityDate(Date applicabilityDate) {
		this.applicabilityDate = applicabilityDate;
	}

	public Date getLastUpdatedDate() {
		return lastUpdatedDate;
	}

	public void setLastUpdatedDate(Date lastUpdatedDate) {
		this.lastUpdatedDate = lastUpdatedDate;
	}

	public long getLastUpdatedUser() {
		return lastUpdatedUser;
	}

	public void setLastUpdatedUser(long lastUpdatedUser) {
		this.lastUpdatedUser = lastUpdatedUser;
	}

	public Long getJpaVersionNumber() {
		return jpaVersionNumber;
	}

	public void setJpaVersionNumber(Long jpaVersionNumber) {
		this.jpaVersionNumber = jpaVersionNumber;
	}

	public int getLineAdjustmentFlag() {
		return lineAdjustmentFlag;
	}
	
	public void setLineAdjustmentFlag(int lineAdjustmentFlag) {
		this.lineAdjustmentFlag = lineAdjustmentFlag;
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