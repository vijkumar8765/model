package uk.gov.scotland.afrc.applications.model.domain;

import java.io.Serializable;
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
 * This is a READ ONLY DBO Object to LPIS for the FEATURE_TYPE database table.
 * This DBO should only be used to read data from FEATURE_TYPE synonym/table
 * DO NOT USE IT TO MODIFY ANYTHING IN THE DATABASE
 * ***************************************************************************************************************
 */
@Entity
@Table(name="FEATURE_TYPE")
@javax.persistence.Cacheable
@NamedQuery(name="FeatureTypeDBO.findAll", query="SELECT f FROM FeatureTypeDBO f")
public class FeatureTypeDBO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
    @Column(name = "CODE", insertable = false, updatable = false)
	private long code;

    @Column(name = "BUSINESS_PRIORITY", insertable = false, updatable = false)
    private Long businessPriority;

    @Column(name = "DEFAULT_CHOICE", insertable = false, updatable = false)
    private Long defaultChoice;

    @Column(name = "DESCRIPTION", insertable = false, updatable = false)
	private String description;

	@Temporal(TemporalType.DATE)
    @Column(name = "END_DATE", insertable = false, updatable = false)
	private Date endDate;

    @Column(name = "JPA_VERSION_NUMBER", insertable = false, updatable = false)
	@Version
    private Long jpaVersionNumber;

    @Column(name = "LAST_UPDATED_BY", insertable = false, updatable = false)
    private Long lastUpdatedBy;

    @Temporal(TemporalType.DATE)
    @Column(name = "LAST_UPDATED_DATE", insertable = false, updatable = false)
    private Date lastUpdatedDate;

    @Column(name = "LND_USE_TYPE_CODE", insertable = false, updatable = false)
    private Long lndUseTypeCode;

    @Column(name = "LPIS_CATG_CODE", insertable = false, updatable = false)
    private Long lpisCatgCode;

    @Column(name = "NAME", insertable = false, updatable = false)
	private String name;

	@Temporal(TemporalType.DATE)
    @Column(name = "START_DATE", insertable = false, updatable = false)
	private Date startDate;

	public FeatureTypeDBO() {
	}

	public long getCode() {
		return this.code;
	}

	public void setCode(long code) {
		this.code = code;
	}

    public Long getBusinessPriority() {
		return this.businessPriority;
	}

    public void setBusinessPriority(Long businessPriority) {
		this.businessPriority = businessPriority;
	}

    public Long getDefaultChoice() {
		return this.defaultChoice;
	}

    public void setDefaultChoice(Long defaultChoice) {
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

    public Long getJpaVersionNumber() {
		return this.jpaVersionNumber;
	}

    public void setJpaVersionNumber(Long jpaVersionNumber) {
		this.jpaVersionNumber = jpaVersionNumber;
	}

    public Long getLastUpdatedBy() {
        return this.lastUpdatedBy;
    }

    public void setLastUpdatedBy(Long lastUpdatedBy) {
        this.lastUpdatedBy = lastUpdatedBy;
    }

    public Date getLastUpdatedDate() {
        return this.lastUpdatedDate;
    }

    public void setLastUpdatedDate(Date lastUpdatedDate) {
        this.lastUpdatedDate = lastUpdatedDate;
    }

    public Long getLndUseTypeCode() {
		return this.lndUseTypeCode;
	}

    public void setLndUseTypeCode(Long lndUseTypeCode) {
		this.lndUseTypeCode = lndUseTypeCode;
	}

    public Long getLpisCatgCode() {
		return this.lpisCatgCode;
	}

    public void setLpisCatgCode(Long lpisCatgCode) {
		this.lpisCatgCode = lpisCatgCode;
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