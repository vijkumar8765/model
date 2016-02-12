package uk.gov.scotland.afrc.applications.model.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Version;

import uk.gov.scotland.afrc.applications.model.base.BaseTable;


/**
 * The persistent class for the ANNUAL_RECURRENT_ROTATION_YR database table.
 * 
 */
@Entity
@Table(name="ANNUAL_RECURRENT_ROTATION_YR")
@NamedQuery(name="AnnualRecurrentRotationYrDBO.findAll", query="SELECT a FROM AnnualRecurrentRotationYrDBO a")
public class AnnualRecurrentRotationYrDBO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="AR_ROTATION_YR_ID")
	@SequenceGenerator(name = "ANN_RECURR_ROTATION_YR_SEQ_GENERATOR", sequenceName = "ANN_RECURR_ROTATION_YR_SEQ",
	        allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ANN_RECURR_ROTATION_YR_SEQ_GENERATOR")
	private long arRotationYrId;

	@Column(name="ANNUAL_RECURRENT_ITEM_ID")
	private long annualRecurrentItemId;

	@Column(name="JPA_VERSION_NUMBER")
	@Version
	private Long jpaVersionNumber;

	
	@Column(name="ROTATION_YR")
	private long rotationYr;

	@Column(name="YEAR1_FLAG")
	private long year1Flag;

	@Embedded
    private BaseTable baseTable;
	public AnnualRecurrentRotationYrDBO() {
	}

	// bi-directional many-to-one association to ScheduleItem
    @ManyToOne
    @JoinColumn(name = "ANNUAL_RECURRENT_ITEM_ID")
    private AnnualRecurrentItemDBO annualRecurrentItem;
    
	public long getArRotationYrId() {
		return this.arRotationYrId;
	}

	public void setArRotationYrId(long arRotationYrId) {
		this.arRotationYrId = arRotationYrId;
	}

	public long getAnnualRecurrentItemId() {
		return this.annualRecurrentItemId;
	}

	public void setAnnualRecurrentItemId(long annualRecurrentItemId) {
		this.annualRecurrentItemId = annualRecurrentItemId;
	}

	public Long getJpaVersionNumber() {
		return this.jpaVersionNumber;
	}

	public void setJpaVersionNumber(Long jpaVersionNumber) {
		this.jpaVersionNumber = jpaVersionNumber;
	}


	public long getRotationYr() {
		return this.rotationYr;
	}

	public void setRotationYr(long rotationYr) {
		this.rotationYr = rotationYr;
	}

	public long getYear1Flag() {
		return this.year1Flag;
	}

	public void setYear1Flag(long year1Flag) {
		this.year1Flag = year1Flag;
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
    
    public AnnualRecurrentItemDBO getAnnualRecurrentItem() {
        return annualRecurrentItem;
    }

    public void setAnnualRecurrentItem(AnnualRecurrentItemDBO annualRecurrentItem) {
        this.annualRecurrentItem = annualRecurrentItem;
    }
	
}