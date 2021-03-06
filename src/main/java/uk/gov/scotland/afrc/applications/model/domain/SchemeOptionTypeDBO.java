package uk.gov.scotland.afrc.applications.model.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import uk.gov.scotland.afrc.applications.model.base.BaseTable;
import uk.gov.scotland.afrc.applications.model.base.BaseTableAware;


/**
 * The persistent class for the SCHEME_OPTION_TYPE database table.
 * 
 */
@Entity
@Table(name="SCHEME_OPTION_TYPE")
@javax.persistence.Cacheable
@NamedQuery(name="SchemeOptionTypeDBO.findAll", query="SELECT s FROM SchemeOptionTypeDBO s")
public class SchemeOptionTypeDBO implements Serializable, BaseTableAware  {
	private static final long serialVersionUID = 1L;

	@Id
	private long code;

	@Column(name="BUSINESS_PRIORITY")
	private BigDecimal businessPriority;

	@Column(name="DEFAULT_CHOICE")
	private BigDecimal defaultChoice;

	private String description;

	@Temporal(TemporalType.DATE)
	@Column(name="END_DATE")
	private Date endDate;

	@Column(name="JPA_VERSION_NUMBER")
	private long jpaVersionNumber;

	@Embedded
	private BaseTable baseTable;
	
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

	private String name;

	public SchemeOptionTypeDBO() {
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

	public BigDecimal getDefaultChoice() {
		return this.defaultChoice;
	}

	public void setDefaultChoice(BigDecimal defaultChoice) {
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


	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}



}