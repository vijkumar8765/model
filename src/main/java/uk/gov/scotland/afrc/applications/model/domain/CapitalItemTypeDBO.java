package uk.gov.scotland.afrc.applications.model.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Version;

import uk.gov.scotland.afrc.applications.model.base.BaseTable;


/**
 * The persistent class for the CAPITAL_ITEM_TYPE database table.
 * 
 */
@Entity
@Table(name="CAPITAL_ITEM_TYPE")
@javax.persistence.Cacheable
@NamedQuery(name="CapitalItemTypeDBO.findAll", query="SELECT c FROM CapitalItemTypeDBO c")
public class CapitalItemTypeDBO implements Serializable, uk.gov.scotland.afrc.applications.model.base.BaseTableAware  {
	private static final long serialVersionUID = 1L;

	@Id
	private long code;

	@Column(name="CAPITAL_ITEM_TYPE_NAME")
	private String capitalItemTypeName;

	@Column(name="DESCRIPTION")
	private String description;

	@Column(name="JPA_VERSION_NUMBER")
	@Version
	private Long jpaVersionNumber;

	@Column(name="MAX_AREA")
	private Long maxArea;

    // @Column(name="MAX_PAYMENT")
    // private Long maxPayment;

    // @Column(name="MAX_RATE")
    // private Long maxRate;

	@Column(name="MIN_AREA")
	private Long minArea;

    // @Column(name="MIN_PAYMENT")
    // private Long minPayment;

//	@Column(name="OPT_PERIOD_CODE")
//	private Long optPeriodCode;

    // @Column(name="PAYMENT_PCT")
    // private Long paymentPct;

    // private Long rate;

	@Column(name="SCHEME_ID")
	private Long schemeId;

	@Column(name="UNIT_OF_MEASUREMENT_CODE")
	private Long unitOfMeasurementCode;

	//bi-directional many-to-one association to CapitalTypeDBO
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="CAPITAL_TYPE_CODE")
	private CapitalTypeDBO capitalTypeDBO;

	//bi-directional many-to-one association to EligibleCapitalItemTypeDBO
	@OneToMany(mappedBy="capitalItemTypeDBO")
	private List<EligibleCapitalItemTypeDBO> eligibleCapitalItemTypeDBOs;
	
	//bi-directional many-to-one association to CapitalTypeDBO
    @OneToMany(mappedBy="capitalItemTypeDBO")
    private List<CapitalItemDBO> capitalItemDBOs;
	
	@ManyToOne
	@JoinColumn(name = "UNIT_OF_MEASUREMENT_CODE")
	private UnitOfMeasurementTypeDBO unitOfmeasureType;
	
	@ManyToOne
	@JoinColumn(name = "OPT_PERIOD_CODE")
	private OptPeriodTypeDBO optPeriodCode;
	
	@Embedded
	private BaseTable baseTable;

    @ManyToOne
    @JoinColumn(name="EVDNCE_REQT_TYPE_CODE")
    private EvidenceRequirementTypeDBO evidenceRequirementType;
	
	public CapitalItemTypeDBO() {
	}

	public long getCode() {
		return this.code;
	}

	public void setCode(long code) {
		this.code = code;
	}

	public String getCapitalItemTypeName() {
		return this.capitalItemTypeName;
	}

	public void setCapitalItemTypeName(String capitalItemTypeName) {
		this.capitalItemTypeName = capitalItemTypeName;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Long getJpaVersionNumber() {
		return this.jpaVersionNumber;
	}

	public void setJpaVersionNumber(Long jpaVersionNumber) {
		this.jpaVersionNumber = jpaVersionNumber;
	}

	
	public Long getMaxArea() {
		return this.maxArea;
	}

	public void setMaxArea(Long maxArea) {
		this.maxArea = maxArea;
	}

    // public Long getMaxPayment() {
    // return this.maxPayment;
    // }
    //
    // public void setMaxPayment(Long maxPayment) {
    // this.maxPayment = maxPayment;
    // }

    // public Long getMaxRate() {
    // return this.maxRate;
    // }
    //
    // public void setMaxRate(Long maxRate) {
    // this.maxRate = maxRate;
    // }

	public Long getMinArea() {
		return this.minArea;
	}

	public void setMinArea(Long minArea) {
		this.minArea = minArea;
	}

    // public Long getMinPayment() {
    // return this.minPayment;
    // }
    //
    // public void setMinPayment(Long minPayment) {
    // this.minPayment = minPayment;
    // }

	public OptPeriodTypeDBO getOptPeriodCode() {
		return this.optPeriodCode;
	}

	public void setOptPeriodCode(OptPeriodTypeDBO optPeriodCode) {
		this.optPeriodCode = optPeriodCode;
	}

    // public Long getPaymentPct() {
    // return this.paymentPct;
    // }
    //
    // public void setPaymentPct(Long paymentPct) {
    // this.paymentPct = paymentPct;
    // }

    // public Long getRate() {
    // return this.rate;
    // }
    //
    // public void setRate(Long rate) {
    // this.rate = rate;
    // }

	public Long getSchemeId() {
		return this.schemeId;
	}

	public void setSchemeId(Long schemeId) {
		this.schemeId = schemeId;
	}

	public Long getUnitOfMeasurementCode() {
		return this.unitOfMeasurementCode;
	}

	public void setUnitOfMeasurementCode(Long unitOfMeasurementCode) {
		this.unitOfMeasurementCode = unitOfMeasurementCode;
	}

	public CapitalTypeDBO getCapitalType() {
		return this.capitalTypeDBO;
	}

	public void setCapitalType(CapitalTypeDBO capitalTypeDBO) {
		this.capitalTypeDBO = capitalTypeDBO;
	}

	public List<EligibleCapitalItemTypeDBO> getEligibleCapitalItemTypes() {
		return this.eligibleCapitalItemTypeDBOs;
	}

	public void setEligibleCapitalItemTypes(List<EligibleCapitalItemTypeDBO> eligibleCapitalItemTypeDBOs) {
		this.eligibleCapitalItemTypeDBOs = eligibleCapitalItemTypeDBOs;
	}

	public EligibleCapitalItemTypeDBO addEligibleCapitalItemType(EligibleCapitalItemTypeDBO eligibleCapitalItemTypeDBO) {
		getEligibleCapitalItemTypes().add(eligibleCapitalItemTypeDBO);
		eligibleCapitalItemTypeDBO.setCapitalItemType(this);

		return eligibleCapitalItemTypeDBO;
	}

	public EligibleCapitalItemTypeDBO removeEligibleCapitalItemType(EligibleCapitalItemTypeDBO eligibleCapitalItemTypeDBO) {
		getEligibleCapitalItemTypes().remove(eligibleCapitalItemTypeDBO);
		eligibleCapitalItemTypeDBO.setCapitalItemType(null);

		return eligibleCapitalItemTypeDBO;
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


	public UnitOfMeasurementTypeDBO getUnitOfmeasureType() {
		return unitOfmeasureType;
	}

	public void setUnitOfmeasureType(UnitOfMeasurementTypeDBO unitOfmeasureType) {
		this.unitOfmeasureType = unitOfmeasureType;
	}
	
	public List<CapitalItemDBO> getCapitalItemDBOs() {
        return capitalItemDBOs;
    }

    public void setCapitalItemDBOs(List<CapitalItemDBO> capitalItemDBOs) {
        this.capitalItemDBOs = capitalItemDBOs;
    }

    public EvidenceRequirementTypeDBO getEvidenceRequirementType() {
        return evidenceRequirementType;
    }

    public void setEvidenceRequirementType(EvidenceRequirementTypeDBO evidenceRequirementType) {
        this.evidenceRequirementType = evidenceRequirementType;
    }

}