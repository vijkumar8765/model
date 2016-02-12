package uk.gov.scotland.afrc.applications.model.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Version;

import uk.gov.scotland.afrc.applications.model.base.BaseTable;
import uk.gov.scotland.afrc.applications.model.base.BaseTableAware;
import uk.gov.scotland.afrc.applications.model.base.BaseTableListener;

@Entity
@EntityListeners(BaseTableListener.class)
@Table(name = "DOC_SUB_TYPE_EVDNCE_REQT_TYPE")
@javax.persistence.Cacheable
public class DocSubTypeEvidenceReqTypeDBO implements Serializable, BaseTableAware {
    private static final long serialVersionUID = 1L;

    @Column(name = "JPA_VERSION_NUMBER")
    @Version
    private Long jpaVersionNumber;

    @Embedded
    private BaseTable baseTable;

    @Id
    private long code;

    @ManyToOne
    @JoinColumn(name = "DOCUMENT_SUB_TYPE_CODE")
    private DocumentSubTypeDBO documentSubType;

    @ManyToOne
    @JoinColumn(name="EVDNCE_REQUIREMENT_TYPE_CODE")
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

    public long getCode() {
        return code;
    }

    public void setCode(long code) {
        this.code = code;
    }

    public DocumentSubTypeDBO getDocumentSubType() {
        return documentSubType;
    }

    public void setDocumentSubType(DocumentSubTypeDBO documentSubType) {
        this.documentSubType = documentSubType;
    }

    public EvidenceRequirementTypeDBO getEvidenceRequirementType() {
        return evidenceRequirementType;
    }

    public void setEvidenceRequirementType(EvidenceRequirementTypeDBO evidenceRequirementType) {
        this.evidenceRequirementType = evidenceRequirementType;
    }

}
