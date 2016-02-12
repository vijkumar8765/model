package uk.gov.scotland.afrc.applications.model.domain;

import java.io.Serializable;

import javax.persistence.*;

import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the APP_QUESTION_CHOICE_FACTR database table.
 * 
 */
@Entity
@Table(name="APP_QUESTION_CHOICE_FACTR")
@NamedQuery(name="ApplicationQuestionChoiceFactrDBO.findAll", query="SELECT a FROM ApplicationQuestionChoiceFactrDBO a")
public class ApplicationQuestionChoiceFactrDBO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="APP_QUESTION_CHOICE_FACTR_ID")
	private long appQuestionChoiceFactrId;


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
	
	//bi-directional many-to-one association to AppQuestionChoiceType
    @ManyToOne
    @JoinColumn(name="APP_QUESTION_CHOICE_CODE", referencedColumnName="CODE")
    private ApplicationQuestionChoiceTypeDBO appQuestionChoiceType;
    
  //bi-directional many-to-one association to AppQuestionType
    @ManyToOne (fetch=FetchType.EAGER)
    @JoinColumn(name="APP_QUESTN_CHOICE_FACTR_CODE", referencedColumnName="CODE")
    private ApplicationQuestionChoiceFactrTypeDBO applicationQuestionChoiceFactrType;

	public ApplicationQuestionChoiceFactrDBO() {
	}

	public long getAppQuestionChoiceFactrId() {
		return this.appQuestionChoiceFactrId;
	}

	public void setAppQuestionChoiceFactrId(long appQuestionChoiceFactrId) {
		this.appQuestionChoiceFactrId = appQuestionChoiceFactrId;
	}

	public ApplicationQuestionChoiceTypeDBO getAppQuestionChoiceCode() {
		return this.appQuestionChoiceType;
	}

	public void setAppQuestionChoiceCode(ApplicationQuestionChoiceTypeDBO appQuestionChoiceType) {
		this.appQuestionChoiceType = appQuestionChoiceType;
	}

	public ApplicationQuestionChoiceFactrTypeDBO getAppQuestnChoiceFactrCode() {
		return this.applicationQuestionChoiceFactrType;
	}

	public void setAppQuestnChoiceFactrCode(ApplicationQuestionChoiceFactrTypeDBO applicationQuestionChoiceFactrType) {
		this.applicationQuestionChoiceFactrType = applicationQuestionChoiceFactrType;
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

}