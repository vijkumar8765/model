/*
 * Project : AFRC Futures
 * Copyright (C) 2013 Scottish Government AFRC Programme
 * AFRC PROPRIETARY/CONFIDENTIAL
 */
package uk.gov.scotland.afrc.applications.model.domain;

/*
 * This class exists in order to be able to update the application section
 * without a JPA version increment.
 * This if for the exclusive benefit of a background update of the complete status 
 */
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import uk.gov.scotland.afrc.applications.model.base.BaseTable;
import uk.gov.scotland.afrc.applications.model.base.BaseTableAware;
import uk.gov.scotland.afrc.applications.model.base.BaseTableListener;

@SuppressWarnings("serial")
@Entity
@Table(name = "APPLICATION_SECTION")
@EntityListeners(BaseTableListener.class)
public class ApplicationSectionDBONoVersion implements Serializable, BaseTableAware {
    @Column(name = "JPA_VERSION_NUMBER")
    // no version annotation - this object is used to be able to update the section status without a version
    // increment.
    private Long jpaVersionNumber;

    @Embedded
    private BaseTable baseTable;

    @Id
    @Column(name = "APP_SECT_ID")
    private long applicationSectionId;

    @Column(name = "APPLICATION_ID")
    private Long applicationId;

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

    public BaseTable getBaseTable() {
        if (baseTable == null) {
            baseTable = new BaseTable();
        }

        return baseTable;
    }

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
}
