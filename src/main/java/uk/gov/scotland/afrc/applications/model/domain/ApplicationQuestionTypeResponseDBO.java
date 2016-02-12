package uk.gov.scotland.afrc.applications.model.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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

/**
 * The persistent class for the APP_QUESTION_TYPE_RESPONSE database table.
 * 
 */
@Entity
@Table(name = "APP_QUESTION_TYPE_RESPONSE")
@EntityListeners(BaseTableListener.class)
@NamedQueries(
    value = { @NamedQuery(
        name = "ApplicationQuestionTypeResponseDBO.findByApplicationIdAndQuestionTypeCode",
        query = "SELECT d FROM ApplicationQuestionTypeResponseDBO d WHERE d.applicationId = :applicationId AND d.appQuestionTypeCode = :questionTypeCode "),
        @NamedQuery(
                name = "ApplicationQuestionTypeResponseDBO.findByApplicationId",
                query = "SELECT d FROM ApplicationQuestionTypeResponseDBO d WHERE d.applicationId = :applicationId "),
        @NamedQuery(
                name = "ApplicationQuestionTypeResponseDBO.findByApplicationIdAndQuestionTypeCodeAndAssessmentElementId",
                query = "SELECT d FROM ApplicationQuestionTypeResponseDBO d WHERE d.applicationId = :applicationId AND d.appQuestionTypeCode = :questionTypeCode "
                    + "AND d.assessmentElementId = :assessmentElementId "),
            @NamedQuery(
                name = "ApplicationQuestionTypeResponseDBO.findByApplicationIdAndQuestionTypeCodeAndAssessmentElementIds",
                query = "SELECT d FROM ApplicationQuestionTypeResponseDBO d WHERE d.applicationId = :applicationId AND d.appQuestionTypeCode = :questionTypeCode "
                    + "AND d.assessmentElementId in :assessmentElementIds "), })
public class ApplicationQuestionTypeResponseDBO implements Serializable, BaseTableAware {

    private static final long serialVersionUID = 1L;

    @Column(name = "JPA_VERSION_NUMBER")
    @Version
    private Long jpaVersionNumber;

    @Embedded
    private BaseTable baseTable;

    @Id
    @Column(name = "APP_QUESTION_TYPE_RESPONSE_ID")
    @SequenceGenerator(name = "QUESTION_RESPONCE_SEQ_GENERATOR", sequenceName = "QUESTION_RESPONCE_SEQ",
        allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "QUESTION_RESPONCE_SEQ_GENERATOR")
    private long appQuestionTypeResponseId;

    @Column(name = "APPLICATION_ID")
    private Long applicationId;

    @Column(name = "APP_QUESTION_CHOICE_TYPE_CODE")
    private Long appQuestionChoiceTypeCode;

    @Column(name = "APP_QUESTION_TYPE_CODE")
    private Long appQuestionTypeCode;

    // @Column(name = "LPIS_LND_PRCL_ID")
    // private Long lpisLndPrclId;

    @Column(name = "RESPONSE_TEXT")
    private String responseText;

    @Column(name = "RESPONSE_NUMBER")
    private BigDecimal responseNumber;

    @Temporal(TemporalType.DATE)
    @Column(name = "RESPONSE_DATE")
    private Date responseDate;
    
  //bi-directional many-to-one association to AppQuestionChoiceType
    @ManyToOne
    @JoinColumn(name="APP_QUESTION_CHOICE_TYPE_CODE")
    private ApplicationQuestionChoiceTypeDBO appQuestionChoiceType;

    //bi-directional many-to-one association to AppQuestionType
    @ManyToOne
    @JoinColumn(name="APP_QUESTION_TYPE_CODE")
    private ApplicationQuestionTypeDBO appQuestionType;

    @Column(name = "ASSESSMENT_ELEMENT_ID")
    private Long assessmentElementId;
    
    public ApplicationQuestionTypeResponseDBO() {
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

    public long getAppQuestionTypeResponseId() {
        return appQuestionTypeResponseId;
    }

    public void setAppQuestionTypeResponseId(long appQuestionTypeResponseId) {
        this.appQuestionTypeResponseId = appQuestionTypeResponseId;
    }

    public Long getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(Long applicationId) {
        this.applicationId = applicationId;
    }

    public Long getAppQuestionChoiceTypeCode() {
        return appQuestionChoiceTypeCode;
    }

    public void setAppQuestionChoiceTypeCode(Long appQuestionChoiceTypeCode) {
        this.appQuestionChoiceTypeCode = appQuestionChoiceTypeCode;
    }

    public Long getAppQuestionTypeCode() {
        return appQuestionTypeCode;
    }

    public void setAppQuestionTypeCode(Long appQuestionTypeCode) {
        this.appQuestionTypeCode = appQuestionTypeCode;
    }

    // public Long getLpisLndPrclId() {
    // return lpisLndPrclId;
    // }
    //
    // public void setLpisLndPrclId(Long lpisLndPrclId) {
    // this.lpisLndPrclId = lpisLndPrclId;
    // }

    public String getResponseText() {
        return responseText;
    }

    public void setResponseText(String responseText) {
        this.responseText = responseText;
    }

    public BigDecimal getResponseNumber() {
        return responseNumber;
    }

    public void setResponseNumber(BigDecimal responseNumber) {
        this.responseNumber = responseNumber;
    }

    public Date getResponseDate() {
        return responseDate;
    }

    public void setResponseDate(Date responseDate) {
        this.responseDate = responseDate;
    }

    // public String toString() {
    // return "ApplicationQuestionTypeResponseDBO [jpaVersionNumber=" + jpaVersionNumber + ", baseTable=" + baseTable
    // + ", appQuestionTypeResponseId=" + appQuestionTypeResponseId + ", applicationId=" + applicationId
    // + ", appQuestionChoiceTypeCode=" + appQuestionChoiceTypeCode + ", appQuestionTypeCode="
    // + appQuestionTypeCode + ", lpisLndPrclId=" + lpisLndPrclId + ", responseText=" + responseText
    // + ", responseNumber=" + responseNumber + ", responseDate=" + responseDate + "]";
    // }

    public ApplicationQuestionChoiceTypeDBO getAppQuestionChoiceType() {
        return appQuestionChoiceType;
    }

    public void setAppQuestionChoiceType(ApplicationQuestionChoiceTypeDBO appQuestionChoiceType) {
        this.appQuestionChoiceType = appQuestionChoiceType;
    }

    public ApplicationQuestionTypeDBO getAppQuestionType() {
        return appQuestionType;
    }

    public void setAppQuestionType(ApplicationQuestionTypeDBO appQuestionType) {
        this.appQuestionType = appQuestionType;
    }

    public Long getAssessmentElementId() {
        return assessmentElementId;
    }

    public void setAssessmentElementId(Long assessmentElementId) {
        this.assessmentElementId = assessmentElementId;
    }

    public String toString() {
        return "ApplicationQuestionTypeResponseDBO [jpaVersionNumber=" + jpaVersionNumber + ", baseTable=" + baseTable
            + ", appQuestionTypeResponseId=" + appQuestionTypeResponseId + ", applicationId=" + applicationId
            + ", appQuestionChoiceTypeCode=" + appQuestionChoiceTypeCode + ", appQuestionTypeCode="
            + appQuestionTypeCode + ", responseText=" + responseText
            + ", responseNumber=" + responseNumber + ", responseDate=" + responseDate + "]";
    }

}
