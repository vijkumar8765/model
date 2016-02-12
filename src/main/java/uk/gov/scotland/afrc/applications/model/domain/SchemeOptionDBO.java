/*
 * Project : AFRC Futures
 * Copyright (C) 2013 Scottish Government AFRC Programme
 * AFRC PROPRIETARY/CONFIDENTIAL
 */
package uk.gov.scotland.afrc.applications.model.domain;

import java.io.Serializable;
import java.util.List;

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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.Version;

import uk.gov.scotland.afrc.applications.model.base.BaseTable;
import uk.gov.scotland.afrc.applications.model.base.BaseTableAware;
import uk.gov.scotland.afrc.applications.model.base.BaseTableListener;

/**
 * The persistent class for the SCHEME_OPTION database table.
 * 
 */
@Entity
@Table(name = "SCHEME_OPTION")
@EntityListeners(BaseTableListener.class)
@NamedQuery(name = "SchemeOptionDBO.findAll", query = "SELECT s FROM SchemeOptionDBO s")
@NamedQueries(value = {
        @NamedQuery(name = "SchemeOptionDBO.findAll", query = "SELECT s FROM SchemeOptionDBO s"),
            @NamedQuery(
                name = "SchemeOptionDBO.getConversionFactor",
                query = "SELECT c.actualCnvFactor FROM CnvFactorTypeDBO c, SchemeOptionDBO s WHERE s.cnvTypeCode = c.code AND s.schemeOptionId = :schemeOptionId AND s.unitOfmeasureType IS NOT NULL"),
        @NamedQuery(name = "SchemeOptionDBO.findByScheme",
            query = "SELECT s FROM SchemeOptionDBO s where s.scheme.schemeId = :schemeId order by s.schemeOptionCode, s.schemeOptionDescription") })
public class SchemeOptionDBO implements Serializable, BaseTableAware {
    private static final long serialVersionUID = 1L;

    @Column(name = "JPA_VERSION_NUMBER")
    @Version
    private Long jpaVersionNumber;

    @Embedded
    private BaseTable baseTable;

    @Id
    @Column(name = "SCHEME_OPT_ID")
    private long schemeOptionId;

    @Column(name = "SCHEME_OPTION_CODE")
    private String schemeOptionCode;

    @Column(name = "SCHEME_ID")
    private long schemeId;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "SCHEME_ID", nullable = false)
    private SchemeDBO scheme;

    @Column(name = "SCHEME_OPTION_DESCRIPTION")
    private String schemeOptionDescription;

    @Column(name = "UNIT_OF_MEASUREMENT_CODE")
    private Long unitOfMeasureId;

    @Column(name = "CNV_FACTOR_TYPE_CODE")
    private Long cnvTypeCode;

    @Column(name = "SCHEME_OPTION_TYPE_CODE")
    private Long schemeOptionTypeCode;

    @ManyToOne(fetch = FetchType.EAGER)    
    @JoinColumn(name = "SCHEME_OPTION_TYPE_CODE")
    private SchemeOptionTypeDBO schemeOptionType;

    @ManyToOne(fetch = FetchType.EAGER)    
    @JoinColumn(name = "OPT_PERIOD_CODE")
    private OptPeriodTypeDBO optionPeriod;

    @OneToMany(mappedBy = "schemeOption")
    private List<EligibleLandUseDBO> eligibleLandUse;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "OPT_GROUP_CODE")
    private OptionGroupDBO optionGroup;

    // bi-directional many-to-one association to SchemeOptionDBO
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "PARENT_SCHEME_OPTION_ID")
    private SchemeOptionDBO schemeOption;

    @Column(name = "IS_CONTRACT_NEEDED")
    private Long isContractNeeded;

    // bi-directional many-to-one association to SchemeOptionDBO
    @OneToMany(mappedBy = "schemeOption")
    private List<SchemeOptionDBO> schemeOptions;

    // bi-directional many-to-one association to ApplicationSchemeDBO
    @OneToMany(mappedBy = "schemeOption")
    private List<ApplicationSchemeOptionDBO> applicationSchemeOptions;

    @ManyToOne
    @JoinColumn(name = "UNIT_OF_MEASUREMENT_CODE")
    private UnitOfMeasurementTypeDBO unitOfmeasureType;

    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name = "CNV_FACTOR_TYPE_CODE")
    private CnvFactorTypeDBO cnvType;
    
    @OneToOne(mappedBy= "schemeOption",  fetch = FetchType.EAGER)
    private SchemeOptionDisplayDBO schemeOptionDisplay;
  
    @OneToMany(mappedBy = "schemeOption", fetch=FetchType.EAGER)
    private List<SchemeOptBehavrClassDBO> schemeOptBehavrClasses;

    @ManyToOne
    @JoinColumn(name="EVDNCE_REQT_TYPE_CODE")
    private EvidenceRequirementTypeDBO evidenceRequirementType;
    
    @Transient
    private Double paymentRate=null;
    
    public Double getPaymentRate() {
		return paymentRate;
	}

	public void setPaymentRate(Double paymentRate) {
		this.paymentRate = paymentRate;
	}
    
    public SchemeOptionDBO() {
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

    public long getSchemeOptionId() {
        return this.schemeOptionId;
    }

    public void setSchemeOptionId(long schemeOptionId) {
        this.schemeOptionId = schemeOptionId;
    }

    public Long getIsContractNeeded() {
        return this.isContractNeeded;
    }

    public void setIsContractNeeded(Long isContractNeeded) {
        this.isContractNeeded = isContractNeeded;
    }

 	public SchemeOptionTypeDBO getSchemeOptionType() {
		return schemeOptionType;
	}

	public void setSchemeOptionType(SchemeOptionTypeDBO schemeOptionType) {
		this.schemeOptionType = schemeOptionType;
	}

	public Long getJpaVersionNumber() {
        return this.jpaVersionNumber;
    }

    public Long getSchemeOptionTypeCode() {
		return schemeOptionTypeCode;
	}

	public void setSchemeOptionTypeCode(Long schemeOptionTypeCode) {
		this.schemeOptionTypeCode = schemeOptionTypeCode;
	}

	public void setJpaVersionNumber(Long jpaVersionNumber) {
        this.jpaVersionNumber = jpaVersionNumber;
    }

    public OptionGroupDBO getOptionGroup() {
        return optionGroup;
    }

    public void setOptionGroup(OptionGroupDBO optionGroup) {
        this.optionGroup = optionGroup;
    }

    /**
	 * @return the optionPeriod
	 */
	public OptPeriodTypeDBO getOptionPeriod() 
	{
		return optionPeriod;
	}
	
	/**
	 * @param optionPeriod the optionPeriod to set
	 */
	public void setOptionPeriod(OptPeriodTypeDBO optionPeriod) 
	{
		this.optionPeriod = optionPeriod;
	}

    public SchemeDBO getScheme() {
        return this.scheme;
    }

    public void setScheme(SchemeDBO scheme) {
        this.scheme = scheme;
    }

    public String getSchemeOptionCode() {
        return this.schemeOptionCode;
    }

    public void setSchemeOptionCode(String schemeOptionCode) {
        this.schemeOptionCode = schemeOptionCode;
    }

    public String getSchemeOptionDescription() {
        return this.schemeOptionDescription;
    }

    public void setSchemeOptionDescription(String schemeOptionDescription) {
        this.schemeOptionDescription = schemeOptionDescription;
    }

    public Long getUnitOfMeasureId() {
        return this.unitOfMeasureId;
    }

    public void setUnitOfMeasureId(Long unitOfMeasureId) {
        this.unitOfMeasureId = unitOfMeasureId;
    }

    public Long getCnvTypeCode() {
        return cnvTypeCode;
    }

    public void setCnvTypeCode(Long cnvTypeCode) {
        this.cnvTypeCode = cnvTypeCode;
    }

    public SchemeOptionDBO getSchemeOption() {
        return this.schemeOption;
    }

    public void setSchemeOption(SchemeOptionDBO schemeOption) {
        this.schemeOption = schemeOption;
    }

    public List<SchemeOptionDBO> getSchemeOptions() {
        return this.schemeOptions;
    }

    public void setSchemeOptions(List<SchemeOptionDBO> schemeOptions) {
        this.schemeOptions = schemeOptions;
    }

    public SchemeOptionDBO addSchemeOption(SchemeOptionDBO schemeOption) {
        getSchemeOptions().add(schemeOption);
        schemeOption.setSchemeOption(this);

        return schemeOption;
    }

    public SchemeOptionDBO removeSchemeOption(SchemeOptionDBO schemeOption) {
        getSchemeOptions().remove(schemeOption);
        schemeOption.setSchemeOption(null);

        return schemeOption;
    }

    public List<ApplicationSchemeOptionDBO> getApplicationSchemeOptions() {
        return applicationSchemeOptions;
    }

    public void setApplicationSchemeOptions(List<ApplicationSchemeOptionDBO> applicationSchemeOptions) {
        this.applicationSchemeOptions = applicationSchemeOptions;
    }

    public UnitOfMeasurementTypeDBO getUnitOfmeasureType() {
        return unitOfmeasureType;
    }

    public void setUnitOfmeasureType(UnitOfMeasurementTypeDBO unitOfmeasureType) {
        this.unitOfmeasureType = unitOfmeasureType;
    }

    public long getSchemeId() {
        return schemeId;
    }

    public void setSchemeId(long schemeId) {
        this.schemeId = schemeId;
    }

    public List<EligibleLandUseDBO> getEligibleLandUse() {
        return eligibleLandUse;
    }

    public void setEligibleLandUse(List<EligibleLandUseDBO> eligibleLandUse) {
        this.eligibleLandUse = eligibleLandUse;
    }

    public CnvFactorTypeDBO getCnvType() {
        return cnvType;
    }

    public void setCnvType(CnvFactorTypeDBO cnvType) {
        this.cnvType = cnvType;
    }

	public SchemeOptionDisplayDBO getSchemeOptionDisplay() {
		return schemeOptionDisplay;
	}

	public void setSchemeOptionDisplay(SchemeOptionDisplayDBO schemeOptionDisplay) {
		this.schemeOptionDisplay = schemeOptionDisplay;
	}

	public List<SchemeOptBehavrClassDBO> getSchemeOptBehavrClasses() {
		return schemeOptBehavrClasses;
	}

	public void setSchemeOptBehavrClasses(List<SchemeOptBehavrClassDBO> schemeOptBehavrClasses) {
		this.schemeOptBehavrClasses = schemeOptBehavrClasses;
	}

    public EvidenceRequirementTypeDBO getEvidenceRequirementType() {
        return evidenceRequirementType;
    }

    public void setEvidenceRequirementType(EvidenceRequirementTypeDBO evidenceRequirementType) {
        this.evidenceRequirementType = evidenceRequirementType;
    }

}