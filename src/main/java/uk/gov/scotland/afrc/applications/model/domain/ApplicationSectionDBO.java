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
import javax.persistence.FetchType;
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

@SuppressWarnings("serial")
@Entity
@Table(name = "APPLICATION_SECTION")
@EntityListeners(BaseTableListener.class)
@NamedQueries(
    value = {
            @NamedQuery(
                name = "ApplicationSection.findBySectionName",
                query = "SELECT d FROM ApplicationSectionDBO d WHERE d.applicationId = :applicationId AND UPPER(d.applicationSectionType.name) = UPPER(:applicationSectionName)"),
            @NamedQuery(name = "ApplicationSection.findByApplicationId",
                query = "SELECT d FROM ApplicationSectionDBO d WHERE d.applicationId = :applicationId ORDER BY d.applicationSectionType.businessPriority"),
            @NamedQuery(
                name = "ApplicationSection.findErrorSectionByApplicationId",
                query = "SELECT d FROM ApplicationSectionDBO d WHERE d.applicationId = :applicationId and d.applicationSectionType.errorSection = :isErrorSection"),
            @NamedQuery(
                name = "ApplicationSection.findByApplicationIdAndSectionType",
                query = "SELECT d FROM ApplicationSectionDBO d WHERE d.applicationId = :applicationId AND d.applicationSectionType.code = :applicationSectionTypeCode") })
public class ApplicationSectionDBO implements Serializable, BaseTableAware {
    @Column(name = "JPA_VERSION_NUMBER")
    @Version
    private Long jpaVersionNumber;

    @Embedded
    private BaseTable baseTable;

    @Id
    @Column(name = "APP_SECT_ID")
    @SequenceGenerator(name = "APPLICATION_SECTION_SEQ_GENERATOR", sequenceName = "APPLICATION_SECTION_SEQ",
        allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "APPLICATION_SECTION_SEQ_GENERATOR")
    private long applicationSectionId;

    @Column(name = "APPLICATION_ID")
    private Long applicationId;

    // @Column (name = "APP_SECT_STATUS_TYPE_CODE")
    // private long AppSectStatusTypeCode;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "APP_SECT_STATUS_TYPE_CODE")
    private ApplicationSectionStatusTypeDBO applicationSectionStatusType;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "APP_SECT_TYPE_CODE")
    private ApplicationSectionTypeDBO applicationSectionType;

    @Column(name = "NOT_APPLICABLE_FLAG")
    private boolean notApplicableFlag;

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

    public long getApplicationSectionId() {
        return applicationSectionId;
    }

    public void setApplicationSectionId(long applicationSectionId) {
        this.applicationSectionId = applicationSectionId;
    }

    public Long getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(Long applicationId) {
        this.applicationId = applicationId;
    }

    @Override
    public String toString() {
        return "ApplicationSection [applicationSectionId=" + applicationSectionId + ", applicationId=" + applicationId
            + "]";
    }

    public boolean isNotApplicableFlag() {
        return notApplicableFlag;
    }

    public void setNotApplicableFlag(boolean notApplicableFlag) {
        this.notApplicableFlag = notApplicableFlag;
    }

    public ApplicationSectionStatusTypeDBO getApplicationSectionStatusType() {
        return applicationSectionStatusType;
    }

    public void setApplicationSectionStatusType(ApplicationSectionStatusTypeDBO applicationSectionStatusType) {
        this.applicationSectionStatusType = applicationSectionStatusType;
    }

    public ApplicationSectionTypeDBO getApplicationSectionType() {
        return applicationSectionType;
    }

    public void setApplicationSectionType(ApplicationSectionTypeDBO applicationSectionType) {
        this.applicationSectionType = applicationSectionType;
    }

    // public long getAppSectStatusTypeCode() {
    // return AppSectStatusTypeCode;
    // }
    //
    // public void setAppSectStatusTypeCode(long appSectStatusTypeCode) {
    // AppSectStatusTypeCode = appSectStatusTypeCode;
    // }
    
    
}
