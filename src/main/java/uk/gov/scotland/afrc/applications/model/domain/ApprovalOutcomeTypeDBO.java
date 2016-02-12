package uk.gov.scotland.afrc.applications.model.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

import uk.gov.scotland.afrc.applications.model.base.BaseTable;
import uk.gov.scotland.afrc.applications.model.base.BaseTableAware;
import uk.gov.scotland.afrc.applications.model.base.BaseTableListener;

@Entity
@Table(name = "APPRVL_OUTCOME_TYPE")
@EntityListeners(BaseTableListener.class)
@NamedQueries(value = {
		@NamedQuery(name = "ApprovalOutcomeTypeDBO.findCodeByName", query = "SELECT s.code FROM ApprovalOutcomeTypeDBO s WHERE s.name = :name"),
		@NamedQuery(name = "ApprovalOutcomeTypeDBO.findApprovalOutcomeTypes", query = "SELECT s FROM ApprovalOutcomeTypeDBO s")
})
public class ApprovalOutcomeTypeDBO implements Serializable, BaseTableAware{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8124967795705559944L;
	
		
	@Version
	@Column(name = "JPA_VERSION_NUMBER")
	private Long jpaVersionNumber;
	@Id
	@Column(name = "CODE")
	@SequenceGenerator(name = "APPROVAL_OUTCOME_SEQ_GENERATOR", sequenceName = "APPROVAL_OUTCOME_SEQ")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "APPROVAL_OUTCOME_SEQ_GENERATOR")
	private Long code;
	@Column(name = "NAME")
	private String name;
	@Column(name = "DESCRIPTION")
	private String  description;
	@Column(name = "BUSINESS_PRIORITY")
	private Long businessPriority;
	@Column(name = "END_DATE")
	private Date endDate;
	@Column(name = "DEFAULT_CHOICE")
	private int defaultChoice;
	@Temporal(TemporalType.DATE)
	@Column(name = "LAST_UPDATED_DATE")
	private Date lastUpdatedDate;
	@Column(name = "LAST_UPDATED_BY")
	private long lastUpdatedBy;
	
	@Embedded
	private BaseTable baseTable;

	
	
	public Long getCode() {
		return code;
	}

	public void setCode(Long code) {
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

	public Long getBusinessPriority() {
		return businessPriority;
	}

	public void setBusinessPriority(Long businessPriority) {
		this.businessPriority = businessPriority;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public int getDefaultChoice() {
		return defaultChoice;
	}

	public void setDefaultChoice(int defaultChoice) {
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Long getJpaVersionNumber() {
		return jpaVersionNumber;
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
}