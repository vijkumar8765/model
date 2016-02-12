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
 * The persistent class for the APP_SECT_TYPE database table.
 * 
 */
@Entity
@Table(name = "APP_SECT_TYPE")
@javax.persistence.Cacheable
@EntityListeners(BaseTableListener.class)
@NamedQueries(value = {
        @NamedQuery(name = "ApplicationSectionTypeDBO.findAll", query = "SELECT a FROM ApplicationSectionTypeDBO a"),
        @NamedQuery(name = "ApplicationSectionTypeDBO.findBySectionName",
            query = "SELECT a FROM ApplicationSectionTypeDBO a WHERE UPPER(a.name) = UPPER(:applicationSectionName)"),
        @NamedQuery(name = "ApplicationSectionTypeDBO.findErrorByApplicationID", query = "SELECT DISTINCT st.code,st.name FROM"
            + " AppValidationErrDBO v, ValidationTypeDBO vt, ApplicationSectionTypeDBO st"
            + " WHERE v.applicationId =:applicationId" + " and v.validationType.code = vt.code"
            + " and vt.appSectTypeCode = st.code"),
        @NamedQuery(name = "ApplicationSectionTypeDBO.findByApplicationTypeCode",
            query = "SELECT a FROM ApplicationSectionTypeDBO a WHERE a.applicationTypeCode = :applicationTypeCode") })
public class ApplicationSectionTypeDBO implements Serializable, BaseTableAware {
    private static final long serialVersionUID = 1L;

    @Column(name = "JPA_VERSION_NUMBER")
    @Version
    private Long jpaVersionNumber;

    @Embedded
    private BaseTable baseTable;

    @Id
    @Column(name = "CODE")
    private long code;

    @Column(name = "APPLICATION_TYPE_CODE")
    private Long applicationTypeCode;

    @Column(name = "BUSINESS_PRIORITY")
    private Long businessPriority;

    @Column(name = "DEFAULT_CHOICE")
    private Long defaultChoice;

    @Column(name = "DESCRIPTION")
    private String description;

    @Temporal(TemporalType.DATE)
    @Column(name = "END_DATE")
    private Date endDate;

    @Column(name = "NAME")
    private String name;

    @Column(name = "IS_DISPLAYED_FLAG")
    private boolean displayed;

    @Column(name = "IS_ERR_SECT_FLAG")
    private boolean errorSection;

    @Column(name = "IS_NAVIGABLE_FLAG")
    private boolean navigableOnly;

    @Column(name = "LONG_DESCRIPTION")
    private String longDescription;

    @Column(name = "SECT_PAGE")
    private String sectionPage;

    public ApplicationSectionTypeDBO() {
    }

    public long getCode() {
        return this.code;
    }

    public void setCode(long code) {
        this.code = code;
    }

    public Long getApplicationTypeCode() {
        return this.applicationTypeCode;
    }

    public void setApplicationTypeCode(Long applicationTypeCode) {
        this.applicationTypeCode = applicationTypeCode;
    }

    public Long getBusinessPriority() {
        return this.businessPriority;
    }

    public void setBusinessPriority(Long businessPriority) {
        this.businessPriority = businessPriority;
    }

    public Long getDefaultChoice() {
        return this.defaultChoice;
    }

    public void setDefaultChoice(Long defaultChoice) {
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

    public BaseTable getBaseTable() {
        if (baseTable == null) {
            baseTable = new BaseTable();
        }

        return baseTable;
    }

    public void setBaseTable(BaseTable baseTable) {
        this.baseTable = baseTable;
    }

    public boolean isDisplayed() {
        return displayed;
    }

    public void setDisplayed(boolean displayed) {
        this.displayed = displayed;
    }

    public boolean isErrorSection() {
        return errorSection;
    }

    public void setErrorSection(boolean errorSection) {
        this.errorSection = errorSection;
    }

    public String getLongDescription() {
        return longDescription;
    }

    public void setLongDescription(String longDescription) {
        this.longDescription = longDescription;
    }

    public String getSectionPage() {
        return sectionPage;
    }

    public void setSectionPage(String sectionPage) {
        this.sectionPage = sectionPage;
    }

    public boolean isNavigableOnly() {
        return navigableOnly;
    }

    public void setNavigableOnly(boolean navigableOnly) {
        this.navigableOnly = navigableOnly;
    }

}