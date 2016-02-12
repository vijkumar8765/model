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

@Entity
@Table(name = "APPLICATION_TYPE")
@javax.persistence.Cacheable
@EntityListeners(BaseTableListener.class)
@NamedQueries(
    value = {
            @NamedQuery(name = "ApplicationType.findAll", query = "SELECT d FROM ApplicationTypeDBO d"),
            @NamedQuery(
                name = "ApplicationType.findByApplicableYearAndDescription",
                query = "SELECT d FROM ApplicationTypeDBO d WHERE d.applicableYear = :year and d.description = :description"),
            @NamedQuery(name = "ApplicationType.findByApplicableYearAndName",
                query = "SELECT d FROM ApplicationTypeDBO d WHERE d.applicableYear = :year and d.name = :name"),
            @NamedQuery(name = "ApplicationType.findByName",
                query = "SELECT d FROM ApplicationTypeDBO d WHERE d.name = :name"),
            @NamedQuery(name = "ApplicationType.findByApplicableYearAndDocSubCategory",
                query = "SELECT a FROM ApplicationTypeDBO a, DocSubCategoryType d  WHERE a.applicableYear = :year and a.name = d.name and d.code = :docSubCategoryCode"),     
             @NamedQuery(name = "ApplicationTypeDBO.findByApplicableYearByCode",
                query = "SELECT d FROM ApplicationTypeDBO d WHERE d.applicationTypeCode = :applicationTypeCode "), 
             @NamedQuery(name = "ApplicationTypeDBO.findByApplicableYearAndCode",
                query = "SELECT d FROM ApplicationTypeDBO d WHERE d.applicableYear = :year and d.applicationTypeCode = :code ")})
public class ApplicationTypeDBO implements Serializable, BaseTableAware {
	
	private static final long serialVersionUID = 1L;

	@Column(name = "JPA_VERSION_NUMBER")
    @Version
    private Long jpaVersionNumber;

    @Embedded
    private BaseTable baseTable;

    @Id
    @Column(name = "CODE")
    private long applicationTypeCode;

    @Column(name = "DESCRIPTION", length = 100)
    private String description;

    @Column(name = "NAME", length = 20)
    private String name;

    @Temporal(TemporalType.DATE)
    @Column(name = "OPENING_DATE")
    private Date openingDate;

    @Temporal(TemporalType.DATE)
    @Column(name = "CLOSING_DATE")
    private Date closingDate;

    @Temporal(TemporalType.DATE)
    @Column(name = "FINAL_DATE")
    private Date finalDate;

    @Column(name = "NO_OF_YEARS")
    private Long numberOfYears;

    @Column(name = "APPLICABLE_YR", length = 4)
    private String applicableYear;

    @Column(name = "MULTIPLE_APPLICATIONS_ALLOWED")
    private boolean multipleApplicationsAllowed;

    @Column(name = "MULTIPLE_DRAFTS_ALLOWED")
    private boolean multipleDraftsAllowed;

    @Temporal(TemporalType.DATE)
    @Column(name = "PENALTY_CLOSING_DATE")
    private Date penaltyClosingDate;

    @Column(name = "BUSINESS_PRIORITY")
    private Long businessPriority;

    @Temporal(TemporalType.DATE)
    @Column(name = "END_DATE")
    private Date endDate;

    @Column(name = "DEFAULT_CHOICE")
    private boolean defaultChoice;
    
    @Temporal(TemporalType.DATE)
    @Column(name = "TURNAROUND_DATE")
    private Date turnaroundDate;

    public Long getJpaVersionNumber() {
        return jpaVersionNumber;
    }

    public void setJpaVersionNumber(Long jpaVersionNumber) {
        this.jpaVersionNumber = jpaVersionNumber;
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

    public long getApplicationTypeCode() {
        return applicationTypeCode;
    }

    public void setApplicationTypeCode(long applicationTypeCode) {
        this.applicationTypeCode = applicationTypeCode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getOpeningDate() {
        return openingDate;
    }

    public void setOpeningDate(Date openingDate) {
        this.openingDate = openingDate;
    }

    public Date getClosingDate() {
        return closingDate;
    }

    public void setClosingDate(Date closingDate) {
        this.closingDate = closingDate;
    }

    public Date getFinalDate() {
        return finalDate;
    }

    public void setFinalDate(Date finalDate) {
        this.finalDate = finalDate;
    }

    public Long getNumberOfYears() {
        return numberOfYears;
    }

    public void setNumberOfYears(Long numberOfYears) {
        this.numberOfYears = numberOfYears;
    }

    public String getApplicableYear() {
        return applicableYear;
    }

    public void setApplicableYear(String applicableYear) {
        this.applicableYear = applicableYear;
    }

    public boolean isMultipleApplicationsAllowed() {
        return multipleApplicationsAllowed;
    }

    public void setMultipleApplicationsAllowed(boolean multipleApplicationsAllowed) {
        this.multipleApplicationsAllowed = multipleApplicationsAllowed;
    }

    public boolean isMultipleDraftsAllowed() {
        return multipleDraftsAllowed;
    }

    public void setMultipleDraftsAllowed(boolean multipleDraftsAllowed) {
        this.multipleDraftsAllowed = multipleDraftsAllowed;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getPenaltyClosingDate() {
        return penaltyClosingDate;
    }

    public void setPenaltyClosingDate(Date penaltyClosingDate) {
        this.penaltyClosingDate = penaltyClosingDate;
    }

    public Long getBusinessPriority() {
        return businessPriority;
    }

    public void setBusinessPriority(Long businessPriority) {
        this.businessPriority = businessPriority;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public boolean isDefaultChoice() {
        return defaultChoice;
    }

    public void setDefaultChoice(boolean defaultChoice) {
        this.defaultChoice = defaultChoice;
    }

    public String toString() {
        return "ApplicationTypeDBO [baseTable=" + baseTable + ", applicationTypeCode=" + applicationTypeCode
            + ", description=" + description + ", name=" + name + ", openingDate=" + openingDate + ", closingDate="
            + closingDate + ", finalDate=" + finalDate + ", numberOfYears=" + numberOfYears + ", applicableYear="
            + applicableYear + ", multipleApplicationsAllowed=" + multipleApplicationsAllowed
            + ", multipleDraftsAllowed=" + multipleDraftsAllowed + ", penaltyClosingDate=" + penaltyClosingDate
            + ", businessPriority=" + businessPriority + ", endDate=" + endDate + ", defaultChoice=" + defaultChoice
            + "]";
    }

    public Date getTurnaroundDate() {
        return turnaroundDate;
    }

    public void setTurnaroundDate(Date turnaroundDate) {
        this.turnaroundDate = turnaroundDate;
    }
}
