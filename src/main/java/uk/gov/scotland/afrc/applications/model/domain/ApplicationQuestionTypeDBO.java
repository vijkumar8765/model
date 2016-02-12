package uk.gov.scotland.afrc.applications.model.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

import uk.gov.scotland.afrc.applications.model.base.BaseTable;
import uk.gov.scotland.afrc.applications.model.base.BaseTableAware;
import uk.gov.scotland.afrc.applications.model.base.BaseTableListener;

/**
 * The persistent class for the APP_QUESTION_TYPE database table.
 * 
 */
@Entity
@Table(name = "APP_QUESTION_TYPE")
@javax.persistence.Cacheable
@EntityListeners(BaseTableListener.class)
@NamedQueries(value = {
        @NamedQuery(name = "ApplicationQuestionType.findByApplicationCode",
            query = "SELECT d FROM ApplicationQuestionTypeDBO d WHERE d.applicationTypeCode = :applicationTypeCode "
                + "AND d.questionSetName = :questionSetName " + "AND d.startDate <= :applicableYear "
                + "AND (d.endDate IS NULL OR d.endDate >= :applicableYear) " + "AND d.questionSet IS NULL "
                + "AND d.schemeOptionId IS NULL " + "AND d.entitlementCatgId IS NULL " + "AND d.schemeId IS NULL "
                + "AND d.livestockCatgTypeCode IS NULL " + "AND d.assessmentTypeCode IS NULL "
                + "ORDER BY d.businessPriority"),
        @NamedQuery(name = "ApplicationQuestionType.findByQuestionCode",
            query = "SELECT d FROM ApplicationQuestionTypeDBO d WHERE d.code = :qCode"),
        @NamedQuery(name = "ApplicationQuestionType.findByApplicationCodeAndYear",
            query = "SELECT d FROM ApplicationQuestionTypeDBO d WHERE d.applicationTypeCode = :applicationTypeCode "
                + "AND d.startDate <= :applicableYear " + "AND (d.endDate IS NULL OR d.endDate >= :applicableYear) "
                + "AND d.questionSet IS NULL " + "ORDER BY d.businessPriority"),
        @NamedQuery(name = "ApplicationQuestionType.findAllByApplicationCode",
            query = "SELECT d FROM ApplicationQuestionTypeDBO d WHERE d.applicationTypeCode = :applicationTypeCode "
                + "AND d.questionSetName = :questionSetName " + "AND d.startDate <= :applicableYear "
                + "AND (d.endDate IS NULL OR d.endDate >= :applicableYear) " + "AND d.questionSet IS NULL "
                + "ORDER BY d.businessPriority"), 
        @NamedQuery(name = "ApplicationQuestionType.findByAssessmentTypeCode",
            query = "SELECT d FROM ApplicationQuestionTypeDBO d WHERE d.assessmentTypeCode = :assessmentTypeCode "
                + " AND d.questionSet IS NULL ORDER BY d.businessPriority") })
public class ApplicationQuestionTypeDBO implements Serializable, BaseTableAware {

    private static final long serialVersionUID = 1L;

    @Column(name = "JPA_VERSION_NUMBER")
    @Version
    private Long jpaVersionNumber;

    @Embedded
    private BaseTable baseTable;

    @Id
    private long code;

    @Column(name = "SCHEME_OPTION_ID")
    private Long schemeOptionId;

    @Column(name = "APPLICATION_TYPE_CODE")
    private Long applicationTypeCode;

    @Column(name = "ENTITLEMENT_CATG_ID")
    private Long entitlementCatgId;

    @Column(name = "ANSWER_TYPE_CODE")
    private Long answerTypeCode;

    @Column(name = "SCHEME_ID")
    private Long schemeId;

    @Column(name = "LIVESTOCK_CATG_TYPE_CODE")
    private Long livestockCatgTypeCode;

    @Column(name = "ASSESSMENT_TYPE_CODE")
    private Long assessmentTypeCode;

    @Column(name = "QUESTION_TEXT")
    private String questionText;

    @Temporal(TemporalType.DATE)
    @Column(name = "START_DATE")
    private Date startDate;

    // @Column(name = "IS_MANDATORY")
    // private boolean mandatory;

    @Column(name = "QUESTION_SET")
    private Long questionSet;

    @Column(name = "QUESTION_SET_NAME", length = 20)
    private String questionSetName;

    @Column(name = "BUSINESS_PRIORITY")
    private Long businessPriority;

    @Temporal(TemporalType.DATE)
    @Column(name = "END_DATE")
    private Date endDate;

    @Column(name = "DEFAULT_CHOICE")
    private Long defaultChoice;

    @Column(name = "MIN_ANSWER_NUMBER")
    private Long minAnswerNumber;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "QUESTION_MANDATORY_TYPE_CODE", referencedColumnName = "CODE")
    private QuestionMandatoryTypeDBO questionMandatoryTypeCode;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "APP_QUESTION_TYPE_CODE", referencedColumnName = "CODE")
    @OrderBy("businessPriority, choiceText ASC")
    private List<ApplicationQuestionChoiceTypeDBO> choices;

    @ManyToOne
    @JoinColumn(name = "EVDNCE_REQT_TYPE_CODE")
    private EvidenceRequirementTypeDBO evidenceRequirementType;
    
    public ApplicationQuestionTypeDBO() {
    }

    public long getCode() {
        return this.code;
    }

    public void setCode(long code) {
        this.code = code;
    }

    public Long getAnswerTypeCode() {
        return this.answerTypeCode;
    }

    public void setAnswerTypeCode(Long answerTypeCode) {
        this.answerTypeCode = answerTypeCode;
    }

    public Long getApplicationTypeCode() {
        return this.applicationTypeCode;
    }

    public void setApplicationTypeCode(Long applicationTypeCode) {
        this.applicationTypeCode = applicationTypeCode;
    }

    public Long getAssessmentTypeCode() {
        return this.assessmentTypeCode;
    }

    public void setAssessmentTypeCode(Long assessmentTypeCode) {
        this.assessmentTypeCode = assessmentTypeCode;
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

    public Long getMinAnswerNumber() {
        return minAnswerNumber;
    }

    public void setMinAnswerNumber(Long minAnswerNumber) {
        this.minAnswerNumber = minAnswerNumber;
    }

    public QuestionMandatoryTypeDBO getQuestionMandatoryTypeCode() {
        return questionMandatoryTypeCode;
    }

    public void setQuestionMandatoryTypeCode(QuestionMandatoryTypeDBO questionMandatoryTypeCode) {
        this.questionMandatoryTypeCode = questionMandatoryTypeCode;
    }

    public Date getEndDate() {
        return this.endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Long getEntitlementCatgId() {
        return this.entitlementCatgId;
    }

    public void setEntitlementCatgId(Long entitlementCatgId) {
        this.entitlementCatgId = entitlementCatgId;
    }

    public Long getJpaVersionNumber() {
        return this.jpaVersionNumber;
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

    public Long getLivestockCatgTypeCode() {
        return this.livestockCatgTypeCode;
    }

    public void setLivestockCatgTypeCode(Long livestockCatgTypeCode) {
        this.livestockCatgTypeCode = livestockCatgTypeCode;
    }

    // public boolean isMandatory() {
    // return mandatory;
    // }
    //
    // public void setMandatory(boolean mandatory) {
    // this.mandatory = mandatory;
    // }

    public Long getQuestionSet() {
        return this.questionSet;
    }

    public void setQuestionSet(Long questionSet) {
        this.questionSet = questionSet;
    }

    public String getQuestionSetName() {
        return this.questionSetName;
    }

    public void setQuestionSetName(String questionSetName) {
        this.questionSetName = questionSetName;
    }

    public String getQuestionText() {
        return this.questionText;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    public Long getSchemeId() {
        return this.schemeId;
    }

    public void setSchemeId(Long schemeId) {
        this.schemeId = schemeId;
    }

    public Long getSchemeOptionId() {
        return this.schemeOptionId;
    }

    public void setSchemeOptionId(Long schemeOptionId) {
        this.schemeOptionId = schemeOptionId;
    }

    public Date getStartDate() {
        return this.startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public List<ApplicationQuestionChoiceTypeDBO> getChoices() {
        return choices;
    }

    public void setChoices(List<ApplicationQuestionChoiceTypeDBO> choices) {
        this.choices = choices;
    }

    public EvidenceRequirementTypeDBO getEvidenceRequirementType() {
        return evidenceRequirementType;
    }

    public void setEvidenceRequirementType(EvidenceRequirementTypeDBO evidenceRequirementType) {
        this.evidenceRequirementType = evidenceRequirementType;
    }

    // public String toString() {
    // return "ApplicationQuestionTypeDBO [baseTable=" + baseTable + ", code=" + code + ", answerTypeCode="
    // + answerTypeCode + ", applicationTypeCode=" + applicationTypeCode + ", assessmentTypeCode="
    // + assessmentTypeCode + ", businessPriority=" + businessPriority + ", defaultChoice=" + defaultChoice
    // + ", endDate=" + endDate + ", entitlementCatgId=" + entitlementCatgId + ", mandatory=" + mandatory
    // + ", livestockCatgTypeCode=" + livestockCatgTypeCode + ", questionSet=" + questionSet
    // + ", questionSetName=" + questionSetName + ", questionText=" + questionText + ", schemeId=" + schemeId
    // + ", schemeOptionId=" + schemeOptionId + ", startDate=" + startDate + "]";
    // }

    public String toString() {
        return "ApplicationQuestionTypeDBO [baseTable=" + baseTable + ", code=" + code + ", answerTypeCode="
            + answerTypeCode + ", applicationTypeCode=" + applicationTypeCode + ", assessmentTypeCode="
            + assessmentTypeCode + ", businessPriority=" + businessPriority + ", defaultChoice=" + defaultChoice
            + ", endDate=" + endDate + ", entitlementCatgId=" + entitlementCatgId + ", livestockCatgTypeCode="
            + livestockCatgTypeCode + ", questionSet=" + questionSet + ", questionSetName=" + questionSetName
            + ", questionText=" + questionText + ", schemeId=" + schemeId + ", schemeOptionId=" + schemeOptionId
            + ", startDate=" + startDate + "]";
    }

}
