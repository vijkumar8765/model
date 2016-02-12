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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

import uk.gov.scotland.afrc.applications.model.base.BaseTable;
import uk.gov.scotland.afrc.applications.model.base.BaseTableAware;
import uk.gov.scotland.afrc.applications.model.base.BaseTableListener;

/**
 * The persistent class for the SCHEME database table.
 * 
 */
@Entity
@Table(name = "SCHEME")
@EntityListeners(BaseTableListener.class)
@NamedQueries({
        @NamedQuery(name = "SchemeDBO.findByApplicationId", query = "SELECT DISTINCT s.schemeId, s.schemeName FROM "
            + " AppValidationErrDBO a," + " SchemeDBO s " + " WHERE a.applicationId =:applicationId"
            + " AND a.schemeId = s.schemeId" + " ORDER BY s.schemeName"),
        @NamedQuery(name = "SchemeDBO.findByName", query = "SELECT s FROM SchemeDBO s WHERE s.schemeName = :schemeName"),
        @NamedQuery(name = "SchemeDBO.findById", query = "SELECT s FROM SchemeDBO s WHERE s.schemeId = :schemeId"),
		@NamedQuery(name = "SchemeDBO.findAll", query = "SELECT s FROM SchemeDBO s")		})
public class SchemeDBO implements Serializable, BaseTableAware {
    private static final long serialVersionUID = 1L;

    @Column(name = "JPA_VERSION_NUMBER")
    @Version
    private Long jpaVersionNumber;

    @Embedded
    private BaseTable baseTable;

    @Id
    @Column(name = "SCHEME_ID")
    private long schemeId;

    @Temporal(TemporalType.DATE)
    @Column(name = "END_DATE")
    private Date endDate;

    // @Column(name = "IS_BUDGET_ONLY_FLAG")
    // private Long isBudgetOnly;

    @Column(name = "IS_CONTRACT_NEEDED")
    private Long isContractNeeded;

    @Column(name = "IS_LND_DATA_NEEDED")
    private Long isLandDataNeeded;

    @Column(name = "MAX_AREA")
    private Long maximumArea;

    @Column(name = "MIN_AREA")
    private Long minimumArea;

    @Column(name = "MIN_PAYMENT")
    private Long minimumPayment;

    @Column(name = "PILLAR_ID")
    private Long pillarId;

    @Column(name = "SCHEME_NAME", length = 20)
    private String schemeName;

    @Column(name = "DESCRIPTION")
    private String schemeDescription;

    @Temporal(TemporalType.DATE)
    @Column(name = "START_DATE")
    private Date startDate;

    @OneToMany(mappedBy = "scheme", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<SchemeOptionDBO> schemeOptions;

    @OneToMany(mappedBy="scheme", cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
    private List<AppValidationErrDBO> appValidationErr;
    
    @ManyToOne
    @JoinColumn(name="EVDNCE_REQT_TYPE_CODE")
    private EvidenceRequirementTypeDBO evidenceRequirementType;
    
    public SchemeDBO() {
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

    public long getSchemeId() {
        return this.schemeId;
    }

    public void setSchemeId(long schemeId) {
        this.schemeId = schemeId;
    }

    public Date getEndDate() {
        return this.endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    // public Long getIsBudgetOnly() {
    // return this.isBudgetOnly;
    // }
    //
    // public void setIsBudgetOnly(Long isBudgetOnly) {
    // this.isBudgetOnly = isBudgetOnly;
    // }

    public Long getIsContractNeeded() {
        return this.isContractNeeded;
    }

    public void setIsContractNeeded(Long isContractNeeded) {
        this.isContractNeeded = isContractNeeded;
    }

    public Long getIsLandDataNeeded() {
        return this.isLandDataNeeded;
    }

    public void setIsLandDataNeeded(Long isLandDataNeeded) {
        this.isLandDataNeeded = isLandDataNeeded;
    }

    public Long getMaximumArea() {
        return this.maximumArea;
    }

    public void setMaximumArea(Long maximumArea) {
        this.maximumArea = maximumArea;
    }

    public Long getMinimumArea() {
        return this.minimumArea;
    }

    public void setMinimumArea(Long minimumArea) {
        this.minimumArea = minimumArea;
    }

    public Long getMinimumPayment() {
        return this.minimumPayment;
    }

    public void setMinimumPayment(Long minimumPayment) {
        this.minimumPayment = minimumPayment;
    }

    public Long getPillarId() {
        return this.pillarId;
    }

    public void setPillarId(Long pillarId) {
        this.pillarId = pillarId;
    }

    public String getSchemeName() {
        return this.schemeName;
    }

    public void setSchemeName(String schemeName) {
        this.schemeName = schemeName;
    }

    public Date getStartDate() {
        return this.startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public List<SchemeOptionDBO> getSchemeOptions() {
        return schemeOptions;
    }

    public void setSchemeOptions(List<SchemeOptionDBO> schemeOptions) {
        this.schemeOptions = schemeOptions;
    }

    public String getSchemeDescription() {
        return schemeDescription;
    }

    public void setSchemeDescription(String schemeDescription) {
        this.schemeDescription = schemeDescription;
    }

    public EvidenceRequirementTypeDBO getEvidenceRequirementType() {
        return evidenceRequirementType;
    }

    public void setEvidenceRequirementType(EvidenceRequirementTypeDBO evidenceRequirementType) {
        this.evidenceRequirementType = evidenceRequirementType;
    }
    public List<AppValidationErrDBO> getAppValidationErr() {
		return appValidationErr;
	}

	public void setAppValidationErr(List<AppValidationErrDBO> appValidationErr) {
		this.appValidationErr = appValidationErr;
	}
}