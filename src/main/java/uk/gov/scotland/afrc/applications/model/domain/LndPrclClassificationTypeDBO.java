package uk.gov.scotland.afrc.applications.model.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;


/**
 * ***************************************************************************************************************
 * This is a READ ONLY DBO Object to LPIS for the LND_PRCL_CLASSIFICATION_TYPE database table.
 * This DBO should only be used to read data from LND_PRCL_CLASSIFICATION_TYPE synonym/table
 * DO NOT USE IT TO MODIFY ANYTHING IN THE DATABASE
 * ***************************************************************************************************************
 */
@Entity
@Table(name="LND_PRCL_CLASSIFICATION_TYPE")
@javax.persistence.Cacheable
@NamedQuery(name="LndPrclClassificationTypeDBO.findAll", query="SELECT l FROM LndPrclClassificationTypeDBO l")
public class LndPrclClassificationTypeDBO implements Serializable {
	private static final long serialVersionUID = 1L;

    @Column(name = "CODE", insertable = false, updatable = false)
	@Id
	private long code;

    @Column(name = "BUSINESS_PRIORITY", insertable = false, updatable = false)
	private BigDecimal businessPriority;

    @Column(name = "DEFAULT_CHOICE", insertable = false, updatable = false)
    private long defaultChoice;

	private String description;

	@Temporal(TemporalType.DATE)
    @Column(name = "END_DATE", insertable = false, updatable = false)
	private Date endDate;

    @Column(name = "JPA_VERSION_NUMBER", insertable = false, updatable = false)
	@Version
    private long jpaVersionNumber;

    @Column(name = "LAST_UPDATED_BY", insertable = false, updatable = false)
    private long lastUpdatedBy;

    @Temporal(TemporalType.DATE)
    @Column(name = "LAST_UPDATED_DATE", insertable = false, updatable = false)
    private Date lastUpdatedDate;

    @Column(name = "NAME", insertable = false, updatable = false)
	private String name;

	@Temporal(TemporalType.DATE)
    @Column(name = "START_DATE", insertable = false, updatable = false)
	private Date startDate;

	public LndPrclClassificationTypeDBO() {
	}

	public long getCode() {
		return this.code;
	}

	public void setCode(long code) {
		this.code = code;
	}

	public BigDecimal getBusinessPriority() {
		return this.businessPriority;
	}

	public void setBusinessPriority(BigDecimal businessPriority) {
		this.businessPriority = businessPriority;
	}

    public long getDefaultChoice() {
		return this.defaultChoice;
	}

    public void setDefaultChoice(long defaultChoice) {
		this.defaultChoice = defaultChoice;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getEndDate() {
		return this.endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

    public long getJpaVersionNumber() {
		return this.jpaVersionNumber;
	}

    public void setJpaVersionNumber(long jpaVersionNumber) {
		this.jpaVersionNumber = jpaVersionNumber;
	}

    public long getLastUpdatedBy() {
        return this.lastUpdatedBy;
    }

    public void setLastUpdatedBy(long lastUpdatedBy) {
        this.lastUpdatedBy = lastUpdatedBy;
    }

    public Date getLastUpdatedDate() {
        return this.lastUpdatedDate;
    }

    public void setLastUpdatedDate(Date lastUpdatedDate) {
        this.lastUpdatedDate = lastUpdatedDate;
    }

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getStartDate() {
		return this.startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

}