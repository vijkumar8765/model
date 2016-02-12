package uk.gov.scotland.afrc.applications.model.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

import uk.gov.scotland.afrc.applications.model.base.BaseTable;
import uk.gov.scotland.afrc.applications.model.base.BaseTableListener;


/**
 * The persistent class for the CAPITAL_ITEM database table.
 * 
 */
@Entity
@Table(name="CAPITAL_ITEM")
@EntityListeners(BaseTableListener.class)
@NamedQuery(name="CapitalItemDBO.findAll", query="SELECT c FROM CapitalItemDBO c")

@NamedQueries(value = { @NamedQuery(name="CapitalItemDBO.findAll", query="SELECT c FROM CapitalItemDBO c"),
                        @NamedQuery(name="CapitalItem.findByScheduleItem", query="SELECT C FROM CapitalItemDBO c where c.scheduleItem = :scheduleItem")})
public class CapitalItemDBO  implements Serializable, uk.gov.scotland.afrc.applications.model.base.BaseTableAware {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="CAPITAL_ITEM_ID")
	@SequenceGenerator(name = "CAPITAL_ITEM_SEQ_GENERATOR", sequenceName = "CAPITAL_ITEM_SEQ",
    allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CAPITAL_ITEM_SEQ_GENERATOR")
	private long capitalItemId;   

	@Temporal(TemporalType.DATE)
	@Column(name="END_DATE")
	private Date endDate;

	@Column(name="JPA_VERSION_NUMBER")
	@Version
	private Long jpaVersionNumber;

	@Column(name="MAP_LETTER")
	private String mapLetter;

	@Column(name="RATE")
	private BigDecimal rate;

	@Temporal(TemporalType.DATE)
	@Column(name="START_DATE")
	private Date startDate;

	@Column(name="UNITS_UNDERTAKEN")
	private BigDecimal unitsUndertaken;

	@Column(name="YR_OF_CLAIM")
    private long yrOfClaim;
	
	@Column(name="UNIT_OF_MEASUREMENT_CODE")
	private Long unitOfMeasurementCode;
	
	@Column(name="DESCRIPTION")
	private String description;
	
	//bi-directional many-to-one association to CapitalItemTypeDBO
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="CAPITAL_ITEM_TYPE_CODE")
	private CapitalItemTypeDBO capitalItemTypeDBO;

	//bi-directional many-to-one association to ScheduleItem
	@ManyToOne
	@JoinColumn(name="SCHEDULE_ITEM_ID")
	private ScheduleItemDBO scheduleItem;
	
	@Embedded
	private BaseTable baseTable;

	public CapitalItemDBO() {
	}

	public long getCapitalItemId() {
		return this.capitalItemId;
	}

	public void setCapitalItemId(long capitalItemId) {
		this.capitalItemId = capitalItemId;
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

	public String getMapLetter() {
		return this.mapLetter;
	}

	public void setMapLetter(String mapLetter) {
		this.mapLetter = mapLetter;
	}

	public BigDecimal getRate() {
		return this.rate;
	}

	public void setRate(BigDecimal rate) {
		this.rate = rate;
	}

	public Date getStartDate() {
		return this.startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public BigDecimal getUnitsUndertaken() {
		return this.unitsUndertaken;
	}

	public void setUnitsUndertaken(BigDecimal unitsUndertaken) {
		this.unitsUndertaken = unitsUndertaken;
	}

    public long getYrOfClaim() {
		return this.yrOfClaim;
	}

    public void setYrOfClaim(long yrOfClaim) {
		this.yrOfClaim = yrOfClaim;
	}

	public CapitalItemTypeDBO getCapitalItemType() {
		return this.capitalItemTypeDBO;
	}

	public void setCapitalItemType(CapitalItemTypeDBO capitalItemTypeDBO) {
		this.capitalItemTypeDBO = capitalItemTypeDBO;
	}

	public ScheduleItemDBO getScheduleItem() {
		return this.scheduleItem;
	}

	public void setScheduleItem(ScheduleItemDBO scheduleItem) {
		this.scheduleItem = scheduleItem;
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

	public Long getUnitOfMeasurementCode() {
		return unitOfMeasurementCode;
	}

	public void setUnitOfMeasurementCode(Long unitOfMeasurementCode) {
		this.unitOfMeasurementCode = unitOfMeasurementCode;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public CapitalItemTypeDBO getCapitalItemTypeDBO() {
		return capitalItemTypeDBO;
	}

	public void setCapitalItemTypeDBO(CapitalItemTypeDBO capitalItemTypeDBO) {
		this.capitalItemTypeDBO = capitalItemTypeDBO;
	}

   
}