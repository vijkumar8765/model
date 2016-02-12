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
import uk.gov.scotland.afrc.applications.model.base.BaseTableListener;

/**
 * The persistent class for the APPLICATION_SCHEME_OPTION database table.
 * 
 */
@Entity
@Table(name = "APPLICATION_SCHEME_OPTION")
@EntityListeners(BaseTableListener.class)
@NamedQueries(
    value = {
            @NamedQuery(name = "ApplicationSchemeOptionDBO.findAll",
                query = "SELECT a FROM ApplicationSchemeOptionDBO a"),
            @NamedQuery(
                name = "ApplicationSchemeOptionDBO.findByApplicationIdAndSchemeId",
                query = "SELECT s FROM ApplicationSchemeOptionDBO s where s.application.applicationId = :applicationId and s.schemeOption.scheme.schemeId = :schemeId"),
            @NamedQuery(
        		name = "ApplicationSchemeOptionDBO.findByApplicationId",
                query = "SELECT s FROM ApplicationSchemeOptionDBO s where s.application.applicationId = :applicationId"),                        
            @NamedQuery(
                name = "ApplicationSchemeOptionDBO.findByApplicationAndSchemeOptionId",
                query = "SELECT s FROM ApplicationSchemeOptionDBO s where s.application.applicationId = :applicationId and s.schemeOption.schemeOptionId = :schemeOptionId")})
                        
                        

public class ApplicationSchemeOptionDBO implements Serializable,
    uk.gov.scotland.afrc.applications.model.base.BaseTableAware {
    private static final long serialVersionUID = 1L;

    @Column(name = "JPA_VERSION_NUMBER")
    @Version
    private Long jpaVersionNumber;

    @Embedded
    private BaseTable baseTable;

    @Id
    @Column(name = "APP_SCHEME_OPT_ID")
    @SequenceGenerator(name = "APPLICATION_SCHEME_OPTION_SEQ_GENERATOR", sequenceName = "APP_SCHEME_OPT_SEQ",
        allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "APPLICATION_SCHEME_OPTION_SEQ_GENERATOR")
    private long appSchemeOptId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "SCHEME_OPTION_ID")
    private SchemeOptionDBO schemeOption;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "APPLICATION_ID")
    private ApplicationDBO application;
    
    @Column(name = "FIRST_YR_OF_ROTATION")
    private long firstYearOfRotation;

    public ApplicationSchemeOptionDBO() {
    }

    public Long getJpaVersionNumber() {
        return this.jpaVersionNumber;
    }

    public void setJpaVersionNumber(Long jpaVersionNumber) {
        this.jpaVersionNumber = jpaVersionNumber;
    }

    public long getAppSchemeOptId() {
        return appSchemeOptId;
    }

    public void setAppSchemeOptId(long appSchemeOptId) {
        this.appSchemeOptId = appSchemeOptId;
    }

    public SchemeOptionDBO getSchemeOption() {
        return schemeOption;
    }

    public void setSchemeOption(SchemeOptionDBO schemeOption) {
        this.schemeOption = schemeOption;
    }

    public ApplicationDBO getApplication() {
        return application;
    }

    public void setApplication(ApplicationDBO application) {
        this.application = application;
    }

    /**
	 * @return the firstYearOfRotation
	 */
	public long getFirstYearOfRotation() {
		return firstYearOfRotation;
	}

	/**
	 * @param firstYearOfRotation the firstYearOfRotation to set
	 */
	public void setFirstYearOfRotation(long firstYearOfRotation) {
		this.firstYearOfRotation = firstYearOfRotation;
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

    public String toString() {
        return "ApplicationSchemeOptionDBO [baseTable=" + baseTable + ", application=" + application
            + ", schemeOption=" + schemeOption + "]";
    }

}