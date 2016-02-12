package uk.gov.scotland.afrc.applications.model.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Version;

import uk.gov.scotland.afrc.applications.model.base.BaseTable;
import uk.gov.scotland.afrc.applications.model.base.BaseTableAware;
import uk.gov.scotland.afrc.applications.model.base.BaseTableListener;

@Entity
@Table(name = "ASSESSMENT_ELEMENT")
@EntityListeners(BaseTableListener.class)
public class AssessmentElementDBO implements Serializable, BaseTableAware{

    /**
     * 
     */
    private static final long serialVersionUID = -8912150929721002340L;
    
    @Id
    @Column(name="ASSESSMENT_ELEMENT_ID")
    @SequenceGenerator(name = "ASSESSMENT_ELEMENT_SEQ_GENERATOR", sequenceName = "ASSESSMENT_ELEMENT_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ASSESSMENT_ELEMENT_SEQ_GENERATOR")
    private Long assessmentElementId;
    
    @Column(name = "ASSESSMENT_ID")
    private Long assessmentId;
    
    @ManyToOne
    @JoinColumn(name = "APP_LND_PRCL_ID")
    private AppLndPrclDBO appLandParcel;
    
    @Version
    @Column(name="JPA_VERSION_NUMBER")
    private Long jpaVersionNumber;
    
    @Column(name = "APP_QUESTION_TYPE_CODE")
    private Long appQuestionTypeCode;
    
    @Embedded
    private BaseTable baseTable;
    
    public Long getAssessmentElementId() {
        return assessmentElementId;
    }

    public void setAssessmentElementId(Long assessmentElementId) {
        this.assessmentElementId = assessmentElementId;
    }

    public Long getAssessmentId() {
        return assessmentId;
    }

    public void setAssessmentId(Long assessmentId) {
        this.assessmentId = assessmentId;
    }

    public AppLndPrclDBO getAppLandParcel() {
        return appLandParcel;
    }

    public void setAppLandParcel(AppLndPrclDBO appLandParcel) {
        this.appLandParcel = appLandParcel;
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

    public Long getAppQuestionTypeCode() {
        return appQuestionTypeCode;
    }

    public void setAppQuestionTypeCode(Long appQuestionTypeCode) {
        this.appQuestionTypeCode = appQuestionTypeCode;
    }
    
}
