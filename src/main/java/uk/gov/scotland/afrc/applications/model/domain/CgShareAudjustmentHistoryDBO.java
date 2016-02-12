/*
 * Project : AFRC Futures
 * Copyright (C) 2013 Scottish Government AFRC Programme
 * AFRC PROPRIETARY/CONFIDENTIAL
 */
package uk.gov.scotland.afrc.applications.model.domain;

import java.io.Serializable;
import java.math.BigDecimal;
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
 * The persistent class for the CG_SHARE_ADJUSTMENT_HISTORY database table.
 * 
 * @author d609030
 */

@Entity
@Table(name = "CG_SHARE_ADJUSTMENT_HISTORY")
@EntityListeners(BaseTableListener.class)
@NamedQueries({
        @NamedQuery(name = "CgShareAudjustmentHistoryDBO.loadCommonGrazingShareAdjustmentHistory",
            query = "SELECT c FROM CgShareAudjustmentHistoryDBO c where c.locationCode = :locationCode"),
        @NamedQuery(
            name = "CgShareAudjustmentHistoryDBO.updateDeleteFlag",
            query = "Update CgShareAudjustmentHistoryDBO l1 set l1.isDeleted= true where l1.locationCode=:locationCode and l1.effectiveDate >= :effectiveDateVal") })
public class CgShareAudjustmentHistoryDBO implements Serializable, BaseTableAware {


	/**
	 * 
	 */
	private static final long serialVersionUID = -1816862035634090155L;


	@Id
	@Column(name = "CG_SHARE_ADJUST_HISTORY_ID")
	@SequenceGenerator(name = "CG_SHARE_ADJUST_HIS_SEQ_GENERATOR", sequenceName = "ADJUSTHISTORYID_SEQ", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CG_SHARE_ADJUST_HIS_SEQ_GENERATOR")
	private long cgShareAdjustHistoryId;

	@Column(name = "BRN")
	private long brn;

	@Embedded
	private BaseTable baseTable;

	@Column(name = "COMMENTS")
	private String comments;

	@Temporal(TemporalType.DATE)
	@Column(name = "EFFECTIVE_DATE")
	private Date effectiveDate;

    @Column(name="JPA_VERSION_NUMBER")
    @Version
    private long jpaVersionNumber;

	@Column(name = "LOCATION_CODE")
	private String locationCode;
    
    @Column(name="REASON")
    private String reason;

	@Column(name = "SHARE_CROFT_NAME")
	private String shareCroftName;

	@Column(name = "TOTAL_SHEEP_EQUIVALENT")
    private BigDecimal totalSheepEquivalent;

	@Column(name = "VACANCY_FLAG")
	private boolean vacancyFlag;

	@Column(name = "LAST_UPDATED_BY_NAME")
	private String lastUpdatedByName;
	

	@Column(name = "REASON_CODE")
    private long reasonCode;
	
    @Column(name = "DELETED_FLAG")
    private boolean isDeleted;

	public String getLastUpdatedByName() {
		return lastUpdatedByName;
	}

	public void setLastUpdatedByName(String lastUpdatedByName) {
		this.lastUpdatedByName = lastUpdatedByName;
	}

	public long getCgShareAdjustHistoryId() {
		return cgShareAdjustHistoryId;
	}

	public CgShareAudjustmentHistoryDBO() {
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

	public void setCgShareAdjustHistoryId(long cgShareAdjustHistoryId) {
		this.cgShareAdjustHistoryId = cgShareAdjustHistoryId;
	}

	public long getBrn() {
		return this.brn;
	}

	public void setBrn(long brn) {
		this.brn = brn;
	}

	public String getComments() {
		return this.comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public Date getEffectiveDate() {
		return this.effectiveDate;
	}

	public void setEffectiveDate(Date effectiveDate) {
		this.effectiveDate = effectiveDate;
	}

	public long getJpaVersionNumber() {
		return this.jpaVersionNumber;
	}

	public void setJpaVersionNumber(long jpaVersionNumber) {
		this.jpaVersionNumber = jpaVersionNumber;
	}

	public String getLocationCode() {
		return this.locationCode;
	}

	public void setLocationCode(String locationCode) {
		this.locationCode = locationCode;
	}

	public String getReason() {
		return reason;
	}

    public void setReason(String reason) {
		this.reason = reason;
	}

	public String getShareCroftName() {
		return this.shareCroftName;
	}

	public void setShareCroftName(String shareCroftName) {
		this.shareCroftName = shareCroftName;
	}

    public BigDecimal getTotalSheepEquivalent() {
		return this.totalSheepEquivalent;
	}

    public void setTotalSheepEquivalent(BigDecimal totalSheepEquivalent) {
		this.totalSheepEquivalent = totalSheepEquivalent;
	}

	public boolean getVacancyFlag() {
		return this.vacancyFlag;
	}

	public void setVacancyFlag(boolean vacancyFlag) {
		this.vacancyFlag = vacancyFlag;
	}

	public long getReasonCode() {
		return reasonCode;
	}

	public void setReasonCode(long reasonCode) {
		this.reasonCode = reasonCode;
	}

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

}
