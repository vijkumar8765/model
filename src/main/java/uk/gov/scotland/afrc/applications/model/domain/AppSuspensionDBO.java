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
 *  
 * @author d609030
 *
 */

/**
 * The persistent class for the APP_SUSPENSION database table.
 * 
 */
@Entity
@Table(name = "APP_SUSPENSION")
@EntityListeners(BaseTableListener.class)
@NamedQueries(
    value = {
    		@NamedQuery(name = "AppSuspensionDBO.findAllHoldsByBRN",
                query = "SELECT a FROM AppSuspensionDBO a where a.brn=:brn order by a.resumeOpCustId desc, a.suspendDate desc"),
            @NamedQuery(name = "AppSuspensionDBO.findCustomerHoldExists",
            	query = "SELECT app FROM AppSuspensionDBO app, ApplicationSchemeDBO ash, SchemeDBO sch where app.brn=:brn and app.suspendLevelTypeCode=:holdLevelId and app.suspendTypeCode=:holdTypeId and app.resumeOpCustId=:resumeOpCustId"),
            @NamedQuery(name = "AppSuspensionDBO.findApplicationOrSchemeHoldExists",
                query = "SELECT app FROM AppSuspensionDBO app, ApplicationSchemeDBO ash, SchemeDBO sch where app.applicationId=:applicationId and app.suspendLevelTypeCode=:holdLevelId and app.suspendTypeCode=:holdTypeId and app.resumeOpCustId=:resumeOpCustId"),
            @NamedQuery(name = "AppSuspensionDBO.findApplicationHoldCount",
                query = "SELECT a FROM AppSuspensionDBO a where a.brn=:brn and a.suspendTypeCode=:holdTypeId and a.resumeOpCustId=:resumeOpCustId"),
            @NamedQuery(name = "AppSuspensionDBO.findSchemeTypes",
                query = "select distinct (sch.schemeId),sch.schemeName from ApplicationDBO app, ApplicationSchemeDBO ash, SchemeDBO sch where app.applicationId=ash.applicationId and ash.schemeId=sch.schemeId and app.brn=:brn"),
            @NamedQuery(name = "AppSuspensionDBO.findApplicationsBySchemeId",
                query = "select app from ApplicationDBO app, ApplicationSchemeDBO ash, SchemeDBO sch where app.applicationId=ash.applicationId and ash.schemeId=sch.schemeId and app.submittedRef is not null and app.brn=:brn and ash.schemeId=:schemeId"),
            @NamedQuery(name = "AppSuspensionDBO.findApplicationTypes",
                query = "select distinct (apt.applicationTypeCode), apt.name from ApplicationDBO app, ApplicationTypeDBO apt where app.applicationTypeCode=apt.applicationTypeCode and app.brn=:brn and apt.applicableYear=:year and app.submittedRef is not null"),
            @NamedQuery(name = "AppSuspensionDBO.findApplicationHoldStatus",
                query = "SELECT a FROM AppSuspensionDBO a where a.applicationId=:applicationId and  a.resumeDate is null AND a.resumeReasonCode is null")})
public class AppSuspensionDBO implements Serializable, BaseTableAware {
	
    private static final long serialVersionUID = 1L;

    @Version
    @Column(name = "JPA_VERSION_NUMBER")
    private Long jpaVersionNumber;

    @Id
    @Column(name = "APP_SUSPENSION_ID")
    @SequenceGenerator(name = "SUSPENSIONID_SEQ_GENERATOR", sequenceName = "APP_SUSPENSION_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SUSPENSIONID_SEQ_GENERATOR")
    private Long appSuspensionId;

    @Column(name = "APPLICATION_ID")
    private Long applicationId;

    private Long brn;

    @Temporal(TemporalType.DATE)
    @Column(name = "SUSPEND_DATE")
    private Date suspendDate;

//    @JoinColumn(name="SUSPEND_TYPE_CODE", referencedColumnName="CODE")
    @Column(name = "SUSPEND_TYPE_CODE")
    private Long suspendTypeCode;

//    @JoinColumn(name="SUSPEND_LEVEL_TYPE_CODE", referencedColumnName="CODE")
    @Column(name = "SUSPEND_LEVEL_TYPE_CODE")
    private Long suspendLevelTypeCode;

//    @JoinColumn(name="SUSPEND_REASON_TYPE_CODE", referencedColumnName="CODE")
    @Column(name = "SUSPEND_REASON_TYPE_CODE")
    private Long suspendReasonTypeCode;

    @Temporal(TemporalType.DATE)
    @Column(name = "RESUME_DATE")
    private Date resumeDate;

//    @JoinColumn(name="RESUME_REASON_CODE", referencedColumnName="CODE")
    @Column(name = "RESUME_REASON_CODE")
    private Long resumeReasonCode;

    @Column(name = "SUSPEND_OP_CUST_ID")
    private Long suspendOpCustId;

    @Column(name = "RESUME_OP_CUST_ID")
    private Long resumeOpCustId;

    @Column(name = "APPLICATION_TYPE_CODE")
    private Long applicationTypeCode;

    @Column(name = "APPLICATION_SCHEME_ID")
    private Long applicationSchemeId;

    @Column(name = "HOLD_COMMENT")
    private String holdComment;
    
    @Embedded
    private BaseTable baseTable;
    
    public String getHoldComment() {
		return holdComment;
	}

	public void setHoldComment(String holdComment) {
		this.holdComment = holdComment;
	}

	public AppSuspensionDBO() {
    }

	public Long getAppSuspensionId() {
		return appSuspensionId;
	}

	public void setAppSuspensionId(Long appSuspensionId) {
		this.appSuspensionId = appSuspensionId;
	}

	public Long getApplicationId() {
		return applicationId;
	}

	public void setApplicationId(Long applicationId) {
		this.applicationId = applicationId;
	}

	public Long getBrn() {
		return brn;
	}

	public void setBrn(Long brn) {
		this.brn = brn;
	}

	public Date getSuspendDate() {
		return suspendDate;
	}

	public void setSuspendDate(Date suspendDate) {
		this.suspendDate = suspendDate;
	}

	public Long getSuspendTypeCode() {
		return suspendTypeCode;
	}

	public void setSuspendTypeCode(Long suspendTypeCode) {
		this.suspendTypeCode = suspendTypeCode;
	}

	public Long getSuspendLevelTypeCode() {
		return suspendLevelTypeCode;
	}

	public void setSuspendLevelTypeCode(Long suspendLevelTypeCode) {
		this.suspendLevelTypeCode = suspendLevelTypeCode;
	}

	public Long getSuspendReasonTypeCode() {
		return suspendReasonTypeCode;
	}

	public void setSuspendReasonTypeCode(Long suspendReasonTypeCode) {
		this.suspendReasonTypeCode = suspendReasonTypeCode;
	}

	public Date getResumeDate() {
		return resumeDate;
	}

	public void setResumeDate(Date resumeDate) {
		this.resumeDate = resumeDate;
	}

	public Long getResumeReasonCode() {
		return resumeReasonCode;
	}

	public void setResumeReasonCode(Long resumeReasonCode) {
		this.resumeReasonCode = resumeReasonCode;
	}

	public Long getSuspendOpCustId() {
		return suspendOpCustId;
	}

	public void setSuspendOpCustId(Long suspendOpCustId) {
		this.suspendOpCustId = suspendOpCustId;
	}

	public Long getResumeOpCustId() {
		return resumeOpCustId;
	}

	public void setResumeOpCustId(Long resumeOpCustId) {
		this.resumeOpCustId = resumeOpCustId;
	}

	public Long getApplicationTypeCode() {
		return applicationTypeCode;
	}

	public void setApplicationTypeCode(Long applicationTypeCode) {
		this.applicationTypeCode = applicationTypeCode;
	}

	public Long getApplicationSchemeId() {
		return applicationSchemeId;
	}

	public void setApplicationSchemeId(Long applicationSchemeId) {
		this.applicationSchemeId = applicationSchemeId;
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
    

}