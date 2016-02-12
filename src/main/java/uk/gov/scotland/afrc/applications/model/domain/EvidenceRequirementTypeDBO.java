package uk.gov.scotland.afrc.applications.model.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

import uk.gov.scotland.afrc.applications.model.base.BaseTable;
import uk.gov.scotland.afrc.applications.model.base.BaseTableAware;
import uk.gov.scotland.afrc.applications.model.base.BaseTableListener;

@Entity
@EntityListeners(BaseTableListener.class)
@Table(name = "EVDNCE_REQUIREMENT_TYPE")
@javax.persistence.Cacheable
public class EvidenceRequirementTypeDBO implements Serializable, BaseTableAware {
    private static final long serialVersionUID = 1L;

    @Column(name = "JPA_VERSION_NUMBER")
    @Version
    private Long jpaVersionNumber;

    @Embedded
    private BaseTable baseTable;

    @Id
    private long code;

    @Column(name = "BUSINESS_PRIORITY")
    private long businessPriority;

    @Column(name = "DEFAULT_CHOICE")
    private boolean defaultChoice;

    @Column(name = "DESCRIPTION", length = 100)
    private String description;

    @Column(name = "DISPLAY_POST_TEXT")
    private String displayPostText;

    @Column(name = "DISPLAY_PRE_TEXT")
    private String displayPreText;

    // @Lob()
    // @Column(name = "DISPLAY_TEXT")
    // private String displayText;

    @Temporal(TemporalType.DATE)
    @Column(name = "END_DATE")
    private Date endDate;

    @Column(name = "LATE_CHECK_INDICATOR")
    private boolean lateCheckIndicator;

    @Column(name = "NAME", length = 20)
    private String name;

    @OneToMany(mappedBy="evidenceRequirementType")
    private Set<DocSubTypeEvidenceReqTypeDBO> docSubTypeEvidenceReqTypes;
    
    public Long getJpaVersionNumber() {
        return jpaVersionNumber;
    }

    public void setJpaVersionNumber(Long jpaVersionNumber) {
        this.jpaVersionNumber = jpaVersionNumber;
    }

    @Override
    public BaseTable getBaseTable() {
        if (baseTable == null) {
            baseTable = new BaseTable();
        }

        return baseTable;
    }

    @Override
    public void setBaseTable(BaseTable baseTable) {
        this.baseTable = baseTable;
    }

    public long getCode() {
        return code;
    }

    public void setCode(long code) {
        this.code = code;
    }

    public long getBusinessPriority() {
        return businessPriority;
    }

    public void setBusinessPriority(long businessPriority) {
        this.businessPriority = businessPriority;
    }

    public boolean isDefaultChoice() {
        return defaultChoice;
    }

    public void setDefaultChoice(boolean defaultChoice) {
        this.defaultChoice = defaultChoice;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDisplayPostText() {
        return displayPostText;
    }

    public void setDisplayPostText(String displayPostText) {
        this.displayPostText = displayPostText;
    }

    public String getDisplayPreText() {
        return displayPreText;
    }

    public void setDisplayPreText(String displayPreText) {
        this.displayPreText = displayPreText;
    }

    // public String getDisplayText() {
    // return displayText;
    // }
    //
    // public void setDisplayText(String displayText) {
    // this.displayText = displayText;
    // }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public boolean isLateCheckIndicator() {
        return lateCheckIndicator;
    }

    public void setLateCheckIndicator(boolean lateCheckIndicator) {
        this.lateCheckIndicator = lateCheckIndicator;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<DocSubTypeEvidenceReqTypeDBO> getDocSubTypeEvidenceReqTypes() {
        return docSubTypeEvidenceReqTypes;
    }

    public void setDocSubTypeEvidenceReqTypes(Set<DocSubTypeEvidenceReqTypeDBO> docSubTypeEvidenceReqTypes) {
        this.docSubTypeEvidenceReqTypes = docSubTypeEvidenceReqTypes;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) (code ^ (code >>> 32));
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        EvidenceRequirementTypeDBO other = (EvidenceRequirementTypeDBO) obj;
        if (code != other.code) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "EvidenceRequirementType [baseTable=" + baseTable + ", code=" + code + ", businessPriority="
            + businessPriority + ", defaultChoice=" + defaultChoice + ", description=" + description
            + ", displayPostText=" + displayPostText + ", displayPreText=" + displayPreText + ", " + ", endDate="
            + endDate + ", lateCheckIndicator=" + lateCheckIndicator + ", name=" + name
            + "]";
    }
}
