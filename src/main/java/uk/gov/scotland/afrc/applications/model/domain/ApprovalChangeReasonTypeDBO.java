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
 * The persistent class for the APPRVL_CHNGE_REASON_TYPE database table.
 * @author D609051
 *
 */
@Entity
@Table(name = "APPRVL_CHNGE_REASON_TYPE")
@EntityListeners(BaseTableListener.class)
@NamedQueries(value = { @NamedQuery(name = "ApprovalChangeReasonTypeDBO.getAllApprovalChangeReasonTypeCodes",
    query = "SELECT a FROM ApprovalChangeReasonTypeDBO a")

})
public class ApprovalChangeReasonTypeDBO implements Serializable, BaseTableAware {

    private static final long serialVersionUID = -3699786812553958602L;

    @Id
    private long code;

    @Column(name = "BUSINESS_PRIORITY")
    private long businessPriority;

    @Column(name = "DEFAULT_CHOICE")
    private long defaultChoice;

    @Column(name = "DESCRIPTION")
    private String description;

    @Temporal(TemporalType.DATE)
    @Column(name = "END_DATE")
    private Date endDate;

    @Version
    @Column(name = "JPA_VERSION_NUMBER")
    private Long jpaVersionNumber;

    @Column(name = "LAST_UPDATED_BY")
    private long lastUpdatedBy;

    @Temporal(TemporalType.DATE)
    @Column(name = "LAST_UPDATED_DATE")
    private Date lastUpdatedDate;

    @Column(name = "NAME")
    private String name;

    @Embedded
    private BaseTable baseTable;

    public long getCode() {
        return code;
    }

    public void setCode(long code) {
        this.code = code;
    }

    public long getBusinessPriority() {
        return businessPriority;
    }

    public void setBusinessPriority(long businessPriority) {
        this.businessPriority = businessPriority;
    }

    public long getDefaultChoice() {
        return defaultChoice;
    }

    public void setDefaultChoice(long defaultChoice) {
        this.defaultChoice = defaultChoice;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Long getJpaVersionNumber() {
        return jpaVersionNumber;
    }

    public void setJpaVersionNumber(Long jpaVersionNumber) {
        this.jpaVersionNumber = jpaVersionNumber;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /*
     * (non-Javadoc)
     * 
     * @see uk.gov.scotland.afrc.applications.model.base.BaseTableAware#getBaseTable()
     */
    @Override
    public BaseTable getBaseTable() {
        if (baseTable == null) {
            baseTable = new BaseTable();
        }

        return baseTable;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * uk.gov.scotland.afrc.applications.model.base.BaseTableAware#setBaseTable(uk.gov.scotland.afrc.applications.model
     * .base.BaseTable)
     */
    @Override
    public void setBaseTable(BaseTable baseTable) {
        this.baseTable = baseTable;
    }
}