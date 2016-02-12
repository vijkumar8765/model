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
 * The persistent class for the LIVESTOCK database table.
 * 
 */
@Entity
@Table(name = "ADJT_VAL")
@EntityListeners(BaseTableListener.class)

 @NamedQueries(value = {  
		 @NamedQuery(name = "AdjustmentValueDBO.findByAdjustmentId", query =
				  "SELECT l FROM AdjustmentValueDBO l where l.adjustmentId= :adjustmentId"),
		 @NamedQuery(name = "AdjustmentValueDBO.loadAdjustedFields", query =
				 "SELECT l FROM AdjustmentValueDBO l WHERE l.applicationId= :applicationId AND (1=1 OR l.fieldId IN (:uiFieldLabel))")
// SELECT * 
// FROM ADJT ad, ADJT_VAL av
// WHERE ad.adjt_id = av.adjt_id
//
// ADJT_VAL
// CLAIM_ID
// LIVESTOCK_ID
// LND_USE_AREA_ID
// OLD_VAL
// NEW_VAL
// APPLICATION_ID
// FIELD_ID
 //SELECT l FROM AdjustmentDBO l where l.adjustmentId= :adjustmentId and l.claimId= :claimId and l.livestockId = :livestockId and l.lndUseAreaId = :lndUseAreaId 
  })
 
public class AdjustmentValueDBO implements Serializable, BaseTableAware {	
	private static final long serialVersionUID = 1413582346298881448L;
	
	@Id
	@SequenceGenerator(name = "ADJUSTMENTVALUE_SEQ_GENERATOR", sequenceName = "ADJUSTMENTVALUE_SEQ", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ADJUSTMENTVALUE_SEQ_GENERATOR")
	@Column(name = "ADJT_VAL_ID")
	private long adjustmentValueID;
	@Column(name = "JPA_VERSION_NUMBER")
	@Version
	private Long jpaVersionNumber;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "LAST_UPDATED_DATE")
	private Date lastUpdatedDate;	
	@Column(name = "LAST_UPDATED_BY")
	private long lastUpdatedUser;
	@Column(name = "CLAIM_ID",nullable = true)
	private Long claimId;
	@Column(name = "LIVESTOCK_ID",nullable = true)
	private Long livestockId;	
	@Column(name = "LND_USE_AREA_ID",nullable = true)
	private Long lndUseAreaId;
	@Column(name = "ADJT_ID")
	private long adjustmentId;
	@Column(name = "DATA_ELEMENT_CODE")
	private long dataElementCode;
	@Column(name = "OLD_VAL")
	private String oldValue;
	@Column(name = "NEW_VAL")
	private String newValue;	
	@Column(name = "CMT")
	private String cmt;
	@Column(name = "ADJT_REASON_TYPE_CODE")
	private long adjustmentReasonTypeCode;
	@Column(name = "APPLICATION_ID")
	private long applicationId;
	@Column(name = "FIELD_ID")
	private String fieldId;
	@Column(name = "APP_LND_PRCL_ID",nullable = true)
	private Long appLndPrclId;
	@Column(name = "DELETED_DATA_INDICATOR")
	private int deletedDataIndicator;	
	@Column(name = "APP_CG_ID",nullable = true)
	private Long appCGId;	
	@Column(name = "CG_SHARE_LND_USE_AREA_ID",nullable = true)
	private Long commmonGrazingLandUseAreaId;
	
	
	
	@Embedded
	private BaseTable baseTable;

	public AdjustmentValueDBO() {
	}

	public long getAdjustmentValueID() {
		return adjustmentValueID;
	}

	public void setAdjustmentValueID(long adjustmentValueID) {
		this.adjustmentValueID = adjustmentValueID;
	}
	
	public Long getClaimId() {
		return claimId;
	}

	public void setClaimId(Long claimId) {
		this.claimId = claimId;
	}

	public Long getLivestockId() {
		return livestockId;
	}

	public void setLivestockId(Long livestockId) {
		this.livestockId = livestockId;
	}

	public Long getLndUseAreaId() {
		return lndUseAreaId;
	}

	public void setLndUseAreaId(Long lndUseAreaId) {
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

	

	public long getAdjustmentId() {
		return adjustmentId;
	}

	public void setAdjustmentId(long adjustmentId) {
		this.adjustmentId = adjustmentId;
	}
	
	public String getOldValue() {
		return oldValue;
	}

	public void setOldValue(String oldValue) {
		this.oldValue = oldValue;
	}

	public String getNewValue() {
		return newValue;
	}

	public void setNewValue(String newValue) {
		this.newValue = newValue;
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
	
	public long getDataElementCode() {
		return dataElementCode;
	}

	public void setDataElementCode(long dataElementCode) {
		this.dataElementCode = dataElementCode;
	}
	
	public String getCmt() {
		return cmt;
	}

	public void setCmt(String cmt) {
		this.cmt = cmt;
	}

	public long getAdjustmentReasonTypeCode() {
		return adjustmentReasonTypeCode;
	}

	public void setAdjustmentReasonTypeCode(long adjustmentReasonTypeCode) {
		this.adjustmentReasonTypeCode = adjustmentReasonTypeCode;
	}

	public long getApplicationId() {
		return applicationId;
	}

	public void setApplicationId(long applicationId) {
		this.applicationId = applicationId;
	}

	public String getFieldId() {
		return fieldId;
	}

	public void setFieldId(String fieldId) {
		this.fieldId = fieldId;
	}
	
	public Long getAppLndPrclId() {
		return appLndPrclId;
	}

	public void setAppLndPrclId(Long appLndPrclId) {
		this.appLndPrclId = appLndPrclId;
	}

	public int getDeletedDataIndicator() {
		return deletedDataIndicator;
	}

	public void setDeletedDataIndicator(int deletedDataIndicator) {
		this.deletedDataIndicator = deletedDataIndicator;
	}
	
	public Long getAppCGId() {
		return appCGId;
	}

	public void setAppCGId(Long appCGId) {
		this.appCGId = appCGId;
	}

	public Long getCommmonGrazingLandUseAreaId() {
		return commmonGrazingLandUseAreaId;
	}

	public void setCommmonGrazingLandUseAreaId(Long commmonGrazingLandUseAreaId) {
		this.commmonGrazingLandUseAreaId = commmonGrazingLandUseAreaId;
	}


	
}