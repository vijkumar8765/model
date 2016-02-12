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

@SuppressWarnings("serial")
@Entity
@Table(name = "APP_SECT_STS_TYPE")
@javax.persistence.Cacheable
@NamedQueries(value = {
        @NamedQuery(name = "ApplicationSectionStatusTypeDBO.findByName", query = "SELECT a FROM ApplicationSectionStatusTypeDBO a where a.name= :name")
	}
)
@EntityListeners(BaseTableListener.class)
public class ApplicationSectionStatusTypeDBO implements Serializable, BaseTableAware {
    @Column(name = "JPA_VERSION_NUMBER")
    @Version
    private Long jpaVersionNumber;

    @Embedded
    private BaseTable baseTable;

    @Id
    @Column(name = "CODE")
    private long code;

    @Column(name = "NAME")
    private String name;

    @Column(name = "DESCRIPTION")
    private String description;

    @Temporal(TemporalType.DATE)
    @Column(name = "END_DATE")
    private Date endDate;

    @Column(name = "BUSINESS_PRIORITY")
    private Long businessPriority;

    @Column(name = "DEFAULT_CHOICE")
    private boolean defaultChoice;

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

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Long getBusinessPriority() {
        return businessPriority;
    }

    public void setBusinessPriority(Long businessPriority) {
        this.businessPriority = businessPriority;
    }

    public boolean isDefaultChoice() {
        return defaultChoice;
    }

    public void setDefaultChoice(boolean defaultChoice) {
        this.defaultChoice = defaultChoice;
    }
}
