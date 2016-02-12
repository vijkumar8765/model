package uk.gov.scotland.afrc.applications.model.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import uk.gov.scotland.afrc.applications.model.base.BaseTable;
import uk.gov.scotland.afrc.applications.model.base.BaseTableAware;
import uk.gov.scotland.afrc.applications.model.base.BaseTableListener;

@Entity
@Table(name = "ASSESSMENT_TYPE")
@EntityListeners(BaseTableListener.class)
@NamedQueries(value = { @NamedQuery(name = "AssessmentTypeDBO.findByAssessmentTypeName",
    query = "SELECT s FROM AssessmentTypeDBO s WHERE upper(s.name) = upper(:name)") })
public class AssessmentTypeDBO implements Serializable, BaseTableAware {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "CODE")
    private Long code;
    @Column(name = "DESCRIPTION", length = 100)
    private String description;
    @Column(name = "NAME", length = 20)
    private String name;
    @Column(name = "SCHEME_ID")
    private Long schemeId;
    @Column(name = "END_DATE")
    private Date endDate;
    @Column(name = "BUSINESS_PRIORITY")
    private Long businessPriority;
    @Column(name = "DEFAULT_CHOICE")
    private Boolean defaultChoice;

    @Embedded
    private BaseTable baseTable;

    @Override
    public BaseTable getBaseTable() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void setBaseTable(BaseTable baseTable) {
        // TODO Auto-generated method stub

    }

    public Long getCode() {
        return code;
    }

    public void setCode(Long code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getSchemeId() {
        return schemeId;
    }

    public void setSchemeId(Long schemeId) {
        this.schemeId = schemeId;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Long getBusinessPriority() {
        return businessPriority;
    }

    public void setBusinessPriority(Long businessPriority) {
        this.businessPriority = businessPriority;
    }

    public Boolean getDefaultChoice() {
        return defaultChoice;
    }

    public void setDefaultChoice(Boolean defaultChoice) {
        this.defaultChoice = defaultChoice;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        AssessmentTypeDBO other = (AssessmentTypeDBO) obj;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        return true;
    }

}
