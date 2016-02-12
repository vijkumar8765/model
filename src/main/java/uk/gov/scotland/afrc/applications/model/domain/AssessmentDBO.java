package uk.gov.scotland.afrc.applications.model.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

import uk.gov.scotland.afrc.applications.model.base.BaseTable;
import uk.gov.scotland.afrc.applications.model.base.BaseTableAware;
import uk.gov.scotland.afrc.applications.model.base.BaseTableListener;

@Entity
@Table(name = "ASSESSMENT")
@EntityListeners(BaseTableListener.class)
@NamedQueries(
    value = {
            @NamedQuery(
                name = "AssessmentDBO.findByApplicationIdAndAssessmentTypeCode",
                query = "SELECT s FROM AssessmentDBO s WHERE s.applicationId = :applicationId and s.assessmentTypeCode = :assessmentTypeCode"),
            @NamedQuery(
                name = "AssessmentDBO.findByApplicationIdAndAssessmentTypeCodes",
                query = "SELECT s FROM AssessmentDBO s WHERE s.applicationId = :applicationId and s.assessmentTypeCode in (:assessmentTypeCodeList)"),
            @NamedQuery(name = "AssessmentDBO.findByApplicationId",
                query = "SELECT s FROM AssessmentDBO s WHERE s.applicationId = :applicationId order by s.assessmentTypeCode"),
            @NamedQuery(name = "AssessmentDBO.findAssessmentCounts",
                query = "SELECT count(s.applicationId), p.approvalOutcomeTypeCode FROM AssessmentDBO s,ApprovalDBO p WHERE s.assessmentId = p.assessmentId and s.applicationId = :applicationId group by p.approvalOutcomeTypeCode") })
public class AssessmentDBO implements Serializable, BaseTableAware {
    /**
     * 
     */
    private static final long serialVersionUID = -8124967795705559944L;

    @Version
    @Column(name = "JPA_VERSION_NUMBER")
    private Long jpaVersionNumber;
    @Id
    @Column(name = "ASSESSMENT_ID")
    @SequenceGenerator(name = "ASSESSMENT_SEQ_GENERATOR", sequenceName = "ASSESSMENT_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ASSESSMENT_SEQ_GENERATOR")
    private Long assessmentId;
    @Column(name = "APPLICATION_ID")
    private Long applicationId;
    @Column(name = "OP_CUST_ID")
    private Long opCustID;
    @Column(name = "ASSESSMENT_TYPE_CODE")
    private Long assessmentTypeCode;
    @Temporal(TemporalType.DATE)
    @Column(name = "ASSESSMENT_DATE")
    private Date assessmentDate;
    @Embedded
    private BaseTable baseTable;
    
    @Column(name = "ASSESSMENT_STS_CODE")
    private boolean required;
    
    @OneToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE },fetch = FetchType.EAGER)
    @JoinColumn(name="ASSESSMENT_ID", referencedColumnName="ASSESSMENT_ID")
    private List<AssessmentElementDBO> assessmentEntitlements;

    @OneToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="ASSESSMENT_ID", referencedColumnName="ASSESSMENT_ID")
    private ApprovalDBO approval;
    
    public AssessmentDBO() {

    }

    public Long getAssessmentId() {
        return assessmentId;
    }

    public void setAssessmentId(Long assessmentId) {
        this.assessmentId = assessmentId;
    }

    public Long getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(Long applicationId) {
        this.applicationId = applicationId;
    }

    public Long getOpCustID() {
        return opCustID;
    }

    public void setOpCustID(Long opCustID) {
        this.opCustID = opCustID;
    }

    public Long getAssessmentTypeCode() {
        return assessmentTypeCode;
    }

    public void setAssessmentTypeCode(Long assessmentTypeCode) {
        this.assessmentTypeCode = assessmentTypeCode;
    }

    public Date getAssessmentDate() {
        return assessmentDate;
    }

    public void setAssessmentDate(Date assessmentDate) {
        this.assessmentDate = assessmentDate;
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

    public boolean isRequired() {
        return required;
    }

    public void setRequired(boolean required) {
        this.required = required;
    }

    public ApprovalDBO getApproval() {
        return approval;
    }

    public void setApproval(ApprovalDBO approval) {
        this.approval = approval;
    }

    public List<AssessmentElementDBO> getAssessmentEntitlements() {
        return assessmentEntitlements;
    }

    public void setAssessmentEntitlements(List<AssessmentElementDBO> assessmentEntitlements) {
        this.assessmentEntitlements = assessmentEntitlements;
    }
  
}
