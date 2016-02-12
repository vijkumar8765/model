package uk.gov.scotland.afrc.applications.model.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the APP_QUES_CHOICE_FACTR_TYPE database table.
 * 
 */
@Entity
@Table(name="APP_QUES_CHOICE_FACTR_TYPE")
@javax.persistence.Cacheable
@NamedQuery(name="ApplicationQuestionChoiceFactrTypeDBO.findAll", query="SELECT a FROM ApplicationQuestionChoiceFactrTypeDBO a")
public class ApplicationQuestionChoiceFactrTypeDBO implements Serializable {
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
	private BigDecimal jpaVersionNumber;

	@Column(name="LAST_UPDATED_BY")
	private BigDecimal lastUpdatedBy;

	@Temporal(TemporalType.DATE)
	@Column(name="LAST_UPDATED_DATE")
	private Date lastUpdatedDate;

	private String name;

	public ApplicationQuestionChoiceFactrTypeDBO() {
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

	public BigDecimal getJpaVersionNumber() {
		return this.jpaVersionNumber;
	}

	public void setJpaVersionNumber(BigDecimal jpaVersionNumber) {
		this.jpaVersionNumber = jpaVersionNumber;
	}

	public BigDecimal getLastUpdatedBy() {
		return this.lastUpdatedBy;
	}

	public void setLastUpdatedBy(BigDecimal lastUpdatedBy) {
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

}