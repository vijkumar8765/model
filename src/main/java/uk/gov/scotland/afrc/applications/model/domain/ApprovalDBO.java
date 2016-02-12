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
@Table(name = "APPRVL")
@EntityListeners(BaseTableListener.class)
@NamedQueries(value = {
		@NamedQuery(name = "ApprovalDBO.findByAssessmentIdAndOutcomeType", query = "SELECT s FROM ApprovalDBO s WHERE s.assessmentId = :assessmentId and s.approvalOutcomeTypeCode = :approvalOutcomeTypeCode"),
		@NamedQuery(name = "ApprovalDBO.findByApprovalId", query = "SELECT s FROM ApprovalDBO s WHERE s.approvalId = :approvalId "),
		@NamedQuery(name = "ApprovalDBO.findByAssessmentId", query = "SELECT s FROM ApprovalDBO s WHERE s.assessmentId = :assessmentId")
		})
public class ApprovalDBO implements Serializable, BaseTableAware {
	/**
	 * 
	 */
	private static final long serialVersionUID = -20425493177501276L;


	/**
	 * 
	 */
	@Version
	@Column(name = "JPA_VERSION_NUMBER")
	private Long jpaVersionNumber;
	
	
	@Id
	@Column(name = "APPRVL_ID")
	@SequenceGenerator(name = "APPRVL_SEQ_GENERATOR", sequenceName = "APPRVL_SEQ", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "APPRVL_SEQ_GENERATOR")
	private Long approvalId;

	@Column(name = "SUPPORTING_DOCUMENT_ID")
	private Long supportingDocumentId;
	@Column(name = "APPRVL_OUTCOME_TYPE_CODE")
	private Long approvalOutcomeTypeCode;
	@Column(name = "OP_CUST_ID")
	private Long opCustId;
	@Column(name = "ASSESSMENT_ID")
	private Long assessmentId;
	@Column(name = "APPROVED_FLAG")
	private int approvedFlag;
	@Column(name = "REASON")
	private String reason;
	@Temporal(TemporalType.DATE)
	@Column(name = "APPRVL_DATE")
	private Date approvalDate;
	@Temporal(TemporalType.DATE)
	@Column(name = "LAST_UPDATED_DATE")
	private Date lastUpdatedDate;
	@Column(name = "LAST_UPDATED_BY")
	private long lastUpdatedBy;
	@Column(name="APPRVL_CHNGE_REASON_TYPE_CODE")
	private Long apprvlChngeReasonTypeCode;
	
	@Embedded
	private BaseTable baseTable;

	public Long getApprovalId() {
		return approvalId;
	}

	public void setApprovalId(Long approvalId) {
		this.approvalId = approvalId;
	}

	public Long getSupportingDocumentId() {
		return supportingDocumentId;
	}

	public void setSupportingDocumentId(Long supportingDocumentId) {
		this.supportingDocumentId = supportingDocumentId;
	}

	public Long getApprovalOutcomeTypeCode() {
		return approvalOutcomeTypeCode;
	}

	public void setApprovalOutcomeTypeCode(Long approvalOutcomeTypeCode) {
		this.approvalOutcomeTypeCode = approvalOutcomeTypeCode;
	}

	public Long getOpCustId() {
		return opCustId;
	}

	public void setOpCustId(Long opCustId) {
		this.opCustId = opCustId;
	}

	public Long getAssessmentId() {
		return assessmentId;
	}

	public void setAssessmentId(Long assessmentId) {
		this.assessmentId = assessmentId;
	}

	public int getApprovedFlag() {
		return approvedFlag;
	}

	public void setApprovedFlag(int approvedFlag) {
		this.approvedFlag = approvedFlag;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public Date getApprovalDate() {
		return approvalDate;
	}

	public void setApprovalDate(Date approvalDate) {
		this.approvalDate = approvalDate;
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

    public Long getApprvlChngeReasonTypeCode() {
		return this.apprvlChngeReasonTypeCode;
	}

	public void setApprvlChngeReasonTypeCode(Long apprvlChngeReasonTypeCode) {
		this.apprvlChngeReasonTypeCode = apprvlChngeReasonTypeCode;
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
