/*
 * Project : AFRC Futures
 * Copyright (C) 2013 Scottish Government AFRC Programme
 * AFRC PROPRIETARY/CONFIDENTIAL
 */
package uk.gov.scotland.afrc.applications.model.domain;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

import uk.gov.scotland.afrc.applications.model.base.BaseTable;
import uk.gov.scotland.afrc.applications.model.base.BaseTableAware;
import uk.gov.scotland.afrc.applications.model.base.BaseTableListener;

@Entity
@Table(name = "APPLICATION")
@EntityListeners(BaseTableListener.class)
@NamedQueries(
    value = {
    		 @NamedQuery(
    	                name = "Application.findByTypeAndStatus",
    	                query = "SELECT d FROM ApplicationDBO d WHERE d.applicationTypeCode = :applicationTypeCode AND d.currentStatusType = :currentStatusType"),
            @NamedQuery(
                name = "Application.findByBrnAndStatus",
                query = "SELECT d FROM ApplicationDBO d WHERE d.brn = :brn AND d.currentStatusType = :currentStatusType"),
            @NamedQuery(
                    name = "Application.getSubmittedRefByApplicationId",
                    query = "SELECT d FROM ApplicationDBO d WHERE d.applicationId = :applicationId"),
            @NamedQuery(
                name = "Application.findByBrnAndYear",
                query = "SELECT d FROM ApplicationDBO d ,ApplicationTypeDBO t WHERE d.brn = :brn  AND t.applicableYear = :year AND d.applicationTypeCode = t.applicationTypeCode"),
            @NamedQuery(
                    name = "Application.findByBrn",
                    query = "SELECT d FROM ApplicationDBO d ,ApplicationTypeDBO t WHERE d.brn = :brn AND d.applicationTypeCode = t.applicationTypeCode"),
            @NamedQuery(
            		name = "Application.findRcentByBrn",
                    query = "SELECT d FROM ApplicationDBO d ,ApplicationTypeDBO t WHERE d.brn = :brn AND d.applicationTypeCode = t.applicationTypeCode AND d.currentStatusType <> 1 and d.submittedRef is not null order by d.lastUpdatedDate desc"),
            @NamedQuery(
                name = "Application.findByBrnAndType",
                query = "SELECT d FROM ApplicationDBO d WHERE d.brn = :brn AND d.applicationTypeCode = :applicationTypeCode"),
            @NamedQuery(
                    name = "Application.findByBrnAndTypeAndRef",
                    query = "SELECT d FROM ApplicationDBO d WHERE d.brn = :brn AND d.applicationTypeCode = :applicationTypeCode and d.submittedRef is not null"),
            @NamedQuery(name = "Application.findByBrnAndTypeAndStatus",
                query = "SELECT d FROM ApplicationDBO d where d.brn = :brn "
                    + "         AND d.applicationTypeCode = :applicationType "
                    + "         AND (d.currentStatusType = :currentStatusType or d.currentStatusType is null)"),
            @NamedQuery(name = "Application.findByBrnAndAppId",
                query = "SELECT d FROM ApplicationDBO d WHERE d.brn = :brn and d.applicationId = :applicationId"),

            @NamedQuery(
                name = "Application.eligibleLandUseTypes",
                query = "SELECT lut FROM ApplicationDBO a JOIN a.applicationSchemes aps JOIN aps.scheme s JOIN s.schemeOptions so JOIN so.eligibleLandUse elu JOIN elu.landUseType lut where a.applicationId = :applicationId"),

            @NamedQuery(name = "Application.findApplicationByID",
            	query = "SELECT d FROM ApplicationDBO d WHERE d.applicationId = :applicationId"),
            @NamedQuery(
                name = "Application.findApplicationTypeByApplicationId",
                        query = "SELECT new uk.gov.scotland.afrc.applications.model.dto.CodeNameDTO(t.applicationTypeCode, t.name)  FROM ApplicationDBO d , ApplicationTypeDBO t "
                        		+ " WHERE d.applicationId = :applicationId AND d.applicationTypeCode = t.applicationTypeCode"),
            @NamedQuery(name = "Application.findApplicationBySubmittedRefNumber",
                        query = "SELECT d FROM ApplicationDBO d WHERE d.submittedRef = :submittedRef"),
            @NamedQuery(name = "Application.findBrnByApplicationID", 
                		query = " SELECT app "
                			  + " FROM ApplicationDBO app "
                			  + " WHERE app.applicationId = :applicationId")
            
    })
public class ApplicationDBO implements Serializable, BaseTableAware {

	private static final long serialVersionUID = 1L;

    private static final long RECEIPT_METH_PAPER_COUNTER = 1L;
    private static final long RECEIPT_METH_PAPER_POST = 2L;

	@Column(name = "JPA_VERSION_NUMBER")
    @Version
    private Long jpaVersionNumber;

    @Embedded
    private BaseTable baseTable;

    @Id
    @Column(name = "APPLICATION_ID")
    @SequenceGenerator(name = "APPLICATION_SEQ_GENERATOR", sequenceName = "APPLICATION_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "APPLICATION_SEQ_GENERATOR")
    private long applicationId;

    @Column(name = "APPLICATION_TYPE_CODE")
    private Long applicationTypeCode;

    @Column(name = "BRN")
    private Long brn;

    @Column(name = "CURRENT_STS_TYPE_CODE")
    private Long currentStatusType;

    @Column(name = "CURRENT_STS_REASON_TYPE_CODE")
    private Long currentStatusReasonType;

    @Column(name = "RECEIPT_METH_TYPE_CODE")
    private Long receiptMethodType;

    @Column(name = "AREA_OFFICE_TYPE_CODE")
    private Long areaOfficeType;

    @Column(name = "SUBMIT_USER_ID")
    private Long userId;

    @Column(name = "SUBMITTED_REF")
    private String submittedRef;

    @Column(name = "APP_DESCRIPTION")
    private String applicationDescription;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "STS_DATE")
    private Date statusDate;

    @Column(name = "NO_OF_SHEETS")
    private Long numberOfSheets;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "SUBMITTED_DATE")
    private Date submittedDate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "RECEIVED_DATE")
    private Date receivedDate;

    @Column(name = "NO_OF_PAGES")
    private Long numberOfPages;

    @Column(name = "DECLARATION_ACCEPTED_FLAG")
    private boolean declarationAcceptedFlag;

    @OneToMany(mappedBy = "application", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<ApplicationSchemeDBO> applicationSchemes;

	@OneToMany(mappedBy = "application", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<ApplicationSchemeOptionDBO> applicationSchemeOptions;

	@OneToMany(mappedBy = "application", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<ScheduleItemDBO> scheduleItemsDBO;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "APPLICATION_TYPE_CODE")
    private ApplicationTypeDBO applicationTypeDBO;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CURRENT_STS_TYPE_CODE")
    private ApplicationStatusTypeDBO applicationStatusTypeDBO; 
    
	@Column(name = "SIGNATORY", length = 60)
    private String signatory;

    @Column(name = "CHOSE_2013_DATA_FLAG")
    private boolean chose2013DataFlag;

    // removed from DB
    // @Column(name = "IS_DESIGNATED_SITE_FLAG")
    // private Boolean designatedSite;

    @Column(name = "CURRENT_STS_REASON_TYPE_CODE")
    private Long currentStatusReason;

    @Column(name = "CURRENCY_TYPE_CODE")
    private Long currency;

    @Column(name = "BUSINESS_MEMBER_ID")
    private Long busineeMemberId;
	
	@Column(name = "COMMENTS")
    private String comments;
    
    @Temporal(TemporalType.DATE)
    @Column(name = "LAST_UPDATED_DATE")
    private Date lastUpdatedDate;

    public Date getLastUpdatedDate() {
		return lastUpdatedDate;
	}

	public void setLastUpdatedDate(Date lastUpdatedDate) {
		this.lastUpdatedDate = lastUpdatedDate;
	}

	public Long getJpaVersionNumber() {
        return jpaVersionNumber;
    }

    public void setJpaVersionNumber(Long jpaVersionNumber) {
        this.jpaVersionNumber = jpaVersionNumber;
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

    public long getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(long applicationId) {
        this.applicationId = applicationId;
    }

    public Long getApplicationTypeCode() {
        return applicationTypeCode;
    }

    public void setApplicationTypeCode(Long applicationTypeCode) {
        this.applicationTypeCode = applicationTypeCode;
    }

    public Long getBrn() {
        return brn;
    }

    public void setBrn(Long brn) {
        this.brn = brn;
    }

    public Long getCurrentStatusType() {
        return currentStatusType;
    }

    public void setCurrentStatusType(Long currentStatusType) {
        this.currentStatusType = currentStatusType;
    }

    public Long getCurrentStatusReasonType() {
        return currentStatusReasonType;
    }

    public void setCurrentStatusReasonType(Long currentStatusReasonType) {
        this.currentStatusReasonType = currentStatusReasonType;
    }

    public Long getReceiptMethodType() {
        return receiptMethodType;
    }

    public void setReceiptMethodType(Long receiptMethodType) {
        this.receiptMethodType = receiptMethodType;
    }

    public Long getAreaOfficeType() {
        return areaOfficeType;
    }

    public void setAreaOfficeType(Long areaOfficeType) {
        this.areaOfficeType = areaOfficeType;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getApplicationDescription() {
        return applicationDescription;
    }

    public void setApplicationDescription(String applicationDescription) {
        this.applicationDescription = applicationDescription;
    }

    public Date getStatusDate() {
        return statusDate;
    }

    public void setStatusDate(Date statusDate) {
        this.statusDate = statusDate;
    }

    public Long getNumberOfSheets() {
        return numberOfSheets;
    }

    public void setNumberOfSheets(Long numberOfSheets) {
        this.numberOfSheets = numberOfSheets;
    }

    public Date getSubmittedDate() {
        return submittedDate;
    }

    public void setSubmittedDate(Date submittedDate) {
        this.submittedDate = submittedDate;
    }

    public Date getReceivedDate() {
        return receivedDate;
    }

    public void setReceivedDate(Date receivedDate) {
        this.receivedDate = receivedDate;
    }

    public Long getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(Long numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    public boolean isDeclarationAcceptedFlag() {
        return declarationAcceptedFlag;
    }

    public void setDeclarationAcceptedFlag(boolean declarationAcceptedFlag) {
        this.declarationAcceptedFlag = declarationAcceptedFlag;
    }

    public List<ApplicationSchemeDBO> getApplicationSchemes() {
        return applicationSchemes;
    }

    public void setApplicationSchemes(List<ApplicationSchemeDBO> applicationSchemes) {
        this.applicationSchemes = applicationSchemes;
    }

    public List<ApplicationSchemeOptionDBO> getApplicationSchemeOptions() {
        return applicationSchemeOptions;
    }

    public void setApplicationSchemeOptions(List<ApplicationSchemeOptionDBO> applicationSchemeOptions) {
        this.applicationSchemeOptions = applicationSchemeOptions;
    }

    public String getSignatory() {
        return signatory;
    }

    public void setSignatory(String signatory) {
        this.signatory = signatory;
    }

    public boolean isChose2013DataFlag() {
        return chose2013DataFlag;
    }

    public void setChose2013DataFlag(boolean chose2013DataFlag) {
        this.chose2013DataFlag = chose2013DataFlag;
    }

    // public Boolean isDesignatedSite() {
    // return designatedSite;
    // }
    //
    // public void setDesignatedSite(Boolean designatedSite) {
    // this.designatedSite = designatedSite;
    // }

    public Long getCurrentStatusReason() {
        return currentStatusReason;
    }

    public void setCurrentStatusReason(Long currentStatusReason) {
        this.currentStatusReason = currentStatusReason;
    }

    public Long getBusineeMemberId() {
        return busineeMemberId;
    }

    public void setBusineeMemberId(Long busineeMemberId) {
        this.busineeMemberId = busineeMemberId;
    }
    
	public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public void setCurrency(Long currency) {
        this.currency = currency;
    }

    public Long getCurrency() {
        return currency;
    }

    public List<ScheduleItemDBO> getScheduleItemsDBO() {
 		return scheduleItemsDBO;
 	}

 	public void setScheduleItemsDBO(List<ScheduleItemDBO> scheduleItemsDBO) {
 		this.scheduleItemsDBO = scheduleItemsDBO;
 	}

    public String getSubmittedRef() {
        return submittedRef;
    }

    public void setSubmittedRef(String submittedRef) {
        this.submittedRef = submittedRef;
    }

    public ApplicationTypeDBO getApplicationTypeDBO() {
        return applicationTypeDBO;
    }

    public ApplicationStatusTypeDBO getApplicationStatusTypeDBO() {
		return applicationStatusTypeDBO;
	}

	public void setApplicationStatusTypeDBO(
			ApplicationStatusTypeDBO applicationStatusTypeDBO) {
		this.applicationStatusTypeDBO = applicationStatusTypeDBO;
	}

	public void setApplicationTypeDBO(ApplicationTypeDBO applicationTypeDBO) {
        this.applicationTypeDBO = applicationTypeDBO;
    }

    public boolean isPaper() {
        return (this.getReceiptMethodType() != null
            && (this.getReceiptMethodType() == RECEIPT_METH_PAPER_COUNTER || this.getReceiptMethodType() == RECEIPT_METH_PAPER_POST));
    }

    @Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
        result = prime * result + (int) (applicationId ^ (applicationId >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ApplicationDBO other = (ApplicationDBO) obj;
		if (applicationId != other.applicationId)
			return false;
		return true;
	}

	@Override
    public String toString() {
        return "ApplicationDBO [baseTable=" + baseTable + ", applicationId=" + applicationId + ", applicationTypeCode="
            + applicationTypeCode + ", brn=" + brn + ", currentStatusType=" + currentStatusType
            + ", currentStatusReasonType=" + currentStatusReasonType + ", receiptMethodType=" + receiptMethodType
            + ", areaOfficeType=" + areaOfficeType + ", userId=" + userId + ", applicationDescription="
            + applicationDescription + ", statusDate=" + statusDate + ", numberOfSheets=" + numberOfSheets
            + ", submittedDate=" + submittedDate + ", receivedDate=" + receivedDate + ", numberOfPages="
            + numberOfPages + ", declarationAcceptedFlag=" + declarationAcceptedFlag + ", applicationSchemes="
            + applicationSchemes + ", signatory=" + signatory + ", chose2013DataFlag=" + chose2013DataFlag + "]";
          //  + ", currentStatusReason=" + currentStatusReason + "]";
    }
}
