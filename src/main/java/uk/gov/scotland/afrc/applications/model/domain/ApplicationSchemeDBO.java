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

import uk.gov.scotland.afrc.applications.model.base.BaseTable;
import uk.gov.scotland.afrc.applications.model.base.BaseTableListener;

/**
 * The persistent class for the APPLICATION_SCHEME database table.
 * 
 */
@Entity
@Table(name = "APPLICATION_SCHEME")
@EntityListeners(BaseTableListener.class)
@NamedQueries(
    value = {
            @NamedQuery(name = "ApplicationSchemeDBO.schemeList",
                query = "SELECT a FROM ApplicationSchemeDBO a where a.applicationId = :applicationId"),
            @NamedQuery(name = "ApplicationSchemeDBO.findByApplicationSchemeIdAndSchemeId",
                query = "SELECT a FROM ApplicationSchemeDBO a where a.applicationId = :applicationId and a.appSchemeId = :applicationSchemeId"),
            @NamedQuery(
                name = "ApplicationSchemeDBO.findByApplicationIdAndSchemeId",
                query = "SELECT a FROM ApplicationSchemeDBO a where a.applicationId = :applicationId and a.schemeId = :schemeId") })
public class ApplicationSchemeDBO implements Serializable, uk.gov.scotland.afrc.applications.model.base.BaseTableAware {
    private static final long serialVersionUID = 1L;

    @Column(name = "JPA_VERSION_NUMBER")
    private Long jpaVersionNumber = 1L;

    @Embedded
    private BaseTable baseTable;

    @Id
    @Column(name = "APP_SCHEME_ID")
    @SequenceGenerator(name = "APPLICATION_SCHEME_SEQ_GENERATOR", sequenceName = "APP_SCHEME_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "APPLICATION_SCHEME_SEQ_GENERATOR")
    private long appSchemeId;

    @Column(name = "APPLICATION_ID")
    private long applicationId;

    @Column(name = "SCHEME_ID")
    private long schemeId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "APPLICATION_ID")
    private ApplicationDBO application;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "SCHEME_ID")
    private SchemeDBO scheme;

    public ApplicationSchemeDBO() {
    }

    public Long getJpaVersionNumber() {
        return this.jpaVersionNumber;
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

    public long getAppSchemeId() {
        return appSchemeId;
    }

    public void setAppSchemeId(long appSchemeId) {
        this.appSchemeId = appSchemeId;
    }

    public long getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(long applicationId) {
        this.applicationId = applicationId;
    }

    public ApplicationDBO getApplication() {
        return application;
    }

    public void setApplication(ApplicationDBO application) {
        this.application = application;
    }

    public long getSchemeId() {
        return schemeId;
    }

    public void setSchemeId(long schemeId) {
        this.schemeId = schemeId;
    }

    public SchemeDBO getScheme() {
        return scheme;
    }

    public void setScheme(SchemeDBO scheme) {
        this.scheme = scheme;
    }

}