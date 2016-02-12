package uk.gov.scotland.afrc.applications.model.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

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
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

import uk.gov.scotland.afrc.applications.model.base.BaseTable;
import uk.gov.scotland.afrc.applications.model.base.BaseTableAware;
import uk.gov.scotland.afrc.applications.model.base.BaseTableListener;

/**
 * The persistent class for the APPLICATION_STATUS_REASON_TYPE database table.
 * 
 */
@Entity
@Table(name = "APPLICATION_STATUS_REASON_TYPE")
@EntityListeners(BaseTableListener.class)
@javax.persistence.Cacheable
@NamedQuery(name = "ApplicationStatusReasonType.findAll", query = "SELECT l FROM ApplicationStatusReasonTypeDBO l")
public class ApplicationStatusReasonTypeDBO implements Serializable,BaseTableAware {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long code;

    @Column(name = "NAME", length = 20)
    private String name;

    @Column(name = "DESCRIPTION", length = 100)
    private String description;

    @Column(name = "BUSINESS_PRIORITY")
    private long businessPriority;

    @Temporal(TemporalType.DATE)
    @Column(name = "END_DATE")
    private Date endDate;

    @Column(name = "DEFAULT_CHOICE")
    private int defaultChoice;

    @Column(name = "LAST_UPDATED_BY")
    private long lastUpdatedBy;

    @Temporal(TemporalType.DATE)
    @Column(name = "LAST_UPDATED_DATE")
    private Date lastUpdatedDate;
    
    @ManyToOne(fetch=FetchType.LAZY, cascade=CascadeType.PERSIST)
    @JoinColumn(name="APP_STATUS_TYPE_CODE", nullable=false)
    private ApplicationStatusTypeDBO applicationStatusType;
    
    
    @Column(name = "APP_STATUS_TYPE_CODE")
    private Long appStatusTypeCode;

    @Embedded
    private BaseTable baseTable;

    public long getCode() {
        return code;
    }
    
    public void setCode(long code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getBusinessPriority() {
        return businessPriority;
    }

    public void setBusinessPriority(long businessPriority) {
        this.businessPriority = businessPriority;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public int getDefaultChoice() {
        return defaultChoice;
    }

    public void setDefaultChoice(int defaultChoice) {
        this.defaultChoice = defaultChoice;
    }
  
    public long getLastUpdatedBy() {
        return lastUpdatedBy;
    }

    public void setLastUpdatedBy(long lastUpdatedBy) {
        this.lastUpdatedBy = lastUpdatedBy;
    }

    public Date getLastUpdatedDate() {
        return lastUpdatedDate;
    }

    public void setLastUpdatedDate(Date lastUpdatedDate) {
        this.lastUpdatedDate = lastUpdatedDate;
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }
	public ApplicationStatusTypeDBO getApplicationStatusType() {
		return applicationStatusType;
	}
	public void setApplicationStatusType(ApplicationStatusTypeDBO applicationStatusType) {
		this.applicationStatusType = applicationStatusType;
	}
	public Long getAppStatusTypeCode() {
        return appStatusTypeCode;
    }
    public void setAppStatusTypeCode(Long appStatusTypeCode) {
        this.appStatusTypeCode = appStatusTypeCode;
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