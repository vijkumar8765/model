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
 * The persistent class for the APP_QUESTION__CHOICE_TYPE database table.
 * 
 */
@Entity
@Table(name = "APP_QUESTION_CHOICE_TYPE")
@javax.persistence.Cacheable
@EntityListeners(BaseTableListener.class)
public class ApplicationQuestionChoiceTypeDBO implements Serializable, BaseTableAware {

    private static final long serialVersionUID = 1L;

    @Column(name = "JPA_VERSION_NUMBER")
    @Version
    private Long jpaVersionNumber;

    @Embedded
    private BaseTable baseTable;

    @Id
    private Long code;

    @Column(name = "APP_QUESTION_TYPE_CODE")
    private Long questionTypeCode;

    @Column(name = "CHOICE_TEXT")
    private String choiceText;

    @Column(name = "NEXT_QUESTION_SET")
    private Long nextQuestionSet;

    @Column(name = "IS_REJECTION_FLAG")
    private boolean rejectionFlag;

    @Column(name = "FURTHER_INFO")
    private String furtherInfo;

    @Column(name = "BUSINESS_PRIORITY")
    private Long businessPriority;

    @Temporal(TemporalType.DATE)
    @Column(name = "END_DATE")
    private Date endDate;

    @Column(name = "DEFAULT_CHOICE")
    private Long defaultChoice;

    @Column(name = "CHNGE_SELECTION_EFFECT_TEXT")
    private String changeSelectionEffectText;

    @OneToMany(fetch = FetchType.EAGER)
    @OrderBy("businessPriority ASC")
    @JoinColumn(name = "QUESTION_SET", referencedColumnName = "NEXT_QUESTION_SET")
    private List<ApplicationQuestionTypeDBO> nextQuestions;

    // bi-directional many-to-one association to AppQuestionChoiceFactr
    @OneToMany(mappedBy = "appQuestionChoiceType", fetch = FetchType.EAGER)
    private List<ApplicationQuestionChoiceFactrDBO> appQuestionChoiceFactrs;

    @ManyToOne
    @JoinColumn(name = "EVDNCE_REQT_TYPE_CODE")
    private EvidenceRequirementTypeDBO evidenceRequirementType;

    public ApplicationQuestionChoiceTypeDBO() {
    }

    public BaseTable getBaseTable() {
        if (baseTable == null) {
            baseTable = new BaseTable();
        }

        return baseTable;
    }

    public Long getJpaVersionNumber() {
        return this.jpaVersionNumber;
    }

    public void setBaseTable(BaseTable baseTable) {
        this.baseTable = baseTable;
    }

    public void setJpaVersionNumber(Long jpaVersionNumber) {
        this.jpaVersionNumber = jpaVersionNumber;
    }

    public Long getCode() {
        return code;
    }

    public void setCode(Long code) {
        this.code = code;
    }

    public Long getQuestionTypeCode() {
        return questionTypeCode;
    }

    public void setQuestionTypeCode(Long questionTypeCode) {
        this.questionTypeCode = questionTypeCode;
    }

    public String getChoiceText() {
        return choiceText;
    }

    public void setChoiceText(String choiceText) {
        this.choiceText = choiceText;
    }

    public Long getNextQuestionSet() {
        return nextQuestionSet;
    }

    public void setNextQuestionSet(Long nextQuestionSet) {
        this.nextQuestionSet = nextQuestionSet;
    }

    public boolean isRejectionFlag() {
        return rejectionFlag;
    }

    public void setRejectionFlag(boolean rejectionFlag) {
        this.rejectionFlag = rejectionFlag;
    }

    public String getFurtherInfo() {
        return furtherInfo;
    }

    public void setFurtherInfo(String furtherInfo) {
        this.furtherInfo = furtherInfo;
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

    public Long getDefaultChoice() {
        return defaultChoice;
    }

    public void setDefaultChoice(Long defaultChoice) {
        this.defaultChoice = defaultChoice;
    }

    public String getChangeSelectionEffectText() {
        return changeSelectionEffectText;
    }

    public void setChangeSelectionEffectText(String changeSelectionEffectText) {
        this.changeSelectionEffectText = changeSelectionEffectText;
    }

    public List<ApplicationQuestionTypeDBO> getNextQuestions() {
        return nextQuestions;
    }

    public void setNextQuestions(List<ApplicationQuestionTypeDBO> nextQuestions) {
        this.nextQuestions = nextQuestions;
    }

    public List<ApplicationQuestionChoiceFactrDBO> getAppQuestionChoiceFactrs() {
        return appQuestionChoiceFactrs;
    }

    public void setAppQuestionChoiceFactrs(List<ApplicationQuestionChoiceFactrDBO> appQuestionChoiceFactrs) {
        this.appQuestionChoiceFactrs = appQuestionChoiceFactrs;
    }

    public EvidenceRequirementTypeDBO getEvidenceRequirementType() {
        return evidenceRequirementType;
    }

    public void setEvidenceRequirementType(EvidenceRequirementTypeDBO evidenceRequirementType) {
        this.evidenceRequirementType = evidenceRequirementType;
    }

    public String toString() {
        return "ApplicationQuestionChoiceTypeDBO [baseTable=" + baseTable + ", code=" + code + ", questionTypeCode="
            + questionTypeCode + ", choiceText=" + choiceText + ", nextQuestionSet=" + nextQuestionSet
            + ", isRejectionFlag=" + rejectionFlag + ", furtherInfo=" + furtherInfo + ", businessPriority="
            + businessPriority + ", endDate=" + endDate + ", defaultChoice=" + defaultChoice + "]";
    }

}
