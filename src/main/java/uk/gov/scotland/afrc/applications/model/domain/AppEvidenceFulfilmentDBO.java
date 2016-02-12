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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Version;

import uk.gov.scotland.afrc.applications.model.base.BaseTable;
import uk.gov.scotland.afrc.applications.model.base.BaseTableAware;
import uk.gov.scotland.afrc.applications.model.base.BaseTableListener;

@Entity
@EntityListeners(BaseTableListener.class)
@NamedQueries(value = { @NamedQuery(name = "AppEvidenceFulfilmentDBO.findByApplicationId",
    query = "SELECT d FROM AppEvidenceFulfilmentDBO d WHERE d.applicationId = :applicationId") })
@Table(name = "APP_EVDNCE_FULFILMENT")
public class AppEvidenceFulfilmentDBO implements Serializable, BaseTableAware {
    private static final long serialVersionUID = 1L;

    @Column(name = "JPA_VERSION_NUMBER")
    @Version
    private Long jpaVersionNumber;

    @Embedded
    private BaseTable baseTable;

    @Id
    @Column(name = "APP_EVDNCE_FULFILMENT_ID")
    @SequenceGenerator(name = "APP_EVDNCE_FULFILMENT_SEQ_GENERATOR", sequenceName = "APP_EVDNCE_FULFILMENT_SEQ",
        allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "APP_EVDNCE_FULFILMENT_SEQ_GENERATOR")
    private long appEvdnceFulfilmentId;

    @Column(name = "APP_EVDNCE_FULFILMENT_CMT", length = 100)
    private String appEvdnceFulfilmentCmt;

    @Column(name = "APPLICATION_ID")
    private long applicationId;

    @Column(name = "EVDNCE_FULFILMENT_TYPE_CODE")
    private Long evidenceFulfilmentTypeCode;

    @ManyToOne
    @JoinColumn(name = "EVDNCE_REQT_TYPE_CODE")
    private EvidenceRequirementTypeDBO evidenceRequirementType;

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

    public long getAppEvdnceFulfilmentId() {
        return appEvdnceFulfilmentId;
    }

    public void setAppEvdnceFulfilmentId(long appEvdnceFulfilmentId) {
        this.appEvdnceFulfilmentId = appEvdnceFulfilmentId;
    }

    public String getAppEvdnceFulfilmentCmt() {
        return appEvdnceFulfilmentCmt;
    }

    public void setAppEvdnceFulfilmentCmt(String appEvdnceFulfilmentCmt) {
        this.appEvdnceFulfilmentCmt = appEvdnceFulfilmentCmt;
    }

    public long getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(long applicationId) {
        this.applicationId = applicationId;
    }
    
    public Long getEvidenceFulfilmentTypeCode() {
        return evidenceFulfilmentTypeCode;
    }

    public void setEvidenceFulfilmentTypeCode(Long evidenceFulfilmentTypeCode) {
        this.evidenceFulfilmentTypeCode = evidenceFulfilmentTypeCode;
    }

    public EvidenceRequirementTypeDBO getEvidenceRequirementType() {
        return evidenceRequirementType;
    }

    public void setEvidenceRequirementType(EvidenceRequirementTypeDBO evidenceRequirementType) {
        this.evidenceRequirementType = evidenceRequirementType;
    }

    public String toString() {
        return "AppEvidenceFulfilment [baseTable=" + baseTable + ", appEvdnceFulfilmentId=" + appEvdnceFulfilmentId
            + ", appEvdnceFulfilmentCmt=" + appEvdnceFulfilmentCmt + ", applicationId=" + applicationId
            + ", evidenceFulfilmentTypeCode=" + evidenceFulfilmentTypeCode + ", evidenceRequirementType="
            + evidenceRequirementType + "]";
    }
}
