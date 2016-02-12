package uk.gov.scotland.afrc.applications.model.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;


/**
 * The persistent class for the AREA_OFFICE_TYPE database table.
 * 
 */
@Entity
@Table(name="AREA_OFFICE_TYPE")
@javax.persistence.Cacheable
@NamedQueries(value = {
@NamedQuery(name="AreaOfficeTypeDBO.findAll", query="SELECT a FROM AreaOfficeTypeDBO a"),
@NamedQuery(name="AreaOfficeTypeDBO.findAreaOfficeByAOCode", query="SELECT a FROM AreaOfficeTypeDBO a where a.code = :code")
})
public class AreaOfficeTypeDBO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="CODE")	
	private long code;
	
	@Column(name="NAME")	
	private String name;
	
	@Column(name="DESCRIPTION")
	private String description;
	
	@Column(name="BUSINESS_PRIORITY")
	private long businessPriority;
	
	@Column(name="END_DATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date endDate;
	
	@Column(name="DEFAULT_CHOICE")
	private long defaultChoice;
	
	@Column(name="LAST_UPDATED_DATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date lastUpdatedDate;
	
	@Column(name="LAST_UPDATED_BY")
	private long lastUpdatedBy;	
	
	@Column(name = "JPA_VERSION_NUMBER")
	@Version
	private Long jpaVersionNumber;
	
	@Column(name="ORG_OFFICE_TYPE_CODE")	
	private long orgOfficeTypeCode;

	public AreaOfficeTypeDBO() {
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

	public long getBusinessPriority() {
		return businessPriority;
	}

	public void setBusinessPriority(long businessPriority) {
		this.businessPriority = businessPriority;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public long getDefaultChoice() {
		return defaultChoice;
	}

	public void setDefaultChoice(long defaultChoice) {
		this.defaultChoice = defaultChoice;
	}

	public Date getLastUpdatedDate() {
		return lastUpdatedDate;
	}

	public void setLastUpdatedDate(Date lastUpdatedDate) {
		this.lastUpdatedDate = lastUpdatedDate;
	}

	public long getLastUpdatedBy() {
		return lastUpdatedBy;
	}

	public void setLastUpdatedBy(long lastUpdatedBy) {
		this.lastUpdatedBy = lastUpdatedBy;
	}

	public long getOrgOfficeTypeCode() {
		return orgOfficeTypeCode;
	}

	public void setOrgOfficeTypeCode(long orgOfficeTypeCode) {
		this.orgOfficeTypeCode = orgOfficeTypeCode;
	}

	public Long getJpaVersionNumber() {
		return jpaVersionNumber;
	}

	public void setJpaVersionNumber(Long jpaVersionNumber) {
		this.jpaVersionNumber = jpaVersionNumber;
	}

}
