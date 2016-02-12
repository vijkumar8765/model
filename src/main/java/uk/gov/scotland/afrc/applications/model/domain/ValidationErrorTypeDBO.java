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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

import uk.gov.scotland.afrc.applications.model.base.BaseTable;
import uk.gov.scotland.afrc.applications.model.base.BaseTableAware;
import uk.gov.scotland.afrc.applications.model.base.BaseTableListener;

@Entity
@Table(name = "VALIDATION_ERR_TYPE")
@EntityListeners(BaseTableListener.class)
@NamedQueries(value = { 
		@NamedQuery(name = "ValidationErrorTypeDBO.getAll", 
					query = "SELECT vet FROM ValidationErrorTypeDBO vet ORDER BY vet.description")
})
public class ValidationErrorTypeDBO implements Serializable, BaseTableAware {
	
    private static final long serialVersionUID = 1L;

    @Column(name = "JPA_VERSION_NUMBER")
    @Version
    private Long jpaVersionNumber;

    @Embedded
    private BaseTable baseTable;

    @Id
    private long code;

    @Column(name = "BUSINESS_PRIORITY")
    private Long businessPriority;

    @Column(name = "DEFAULT_CHOICE")
    private boolean defaultChoice;

    @Column(name = "DESCRIPTION")
    private String description;

    @Temporal(TemporalType.DATE)
    @Column(name = "END_DATE")
    private Date endDate;

    @Column(name = "NAME")
    private String name;

    public BaseTable getBaseTable() {
        if (baseTable == null) {
            baseTable = new BaseTable();
        }
        return baseTable;
    }

    public void setBaseTable(BaseTable baseTable) {
        this.baseTable = baseTable;
    }

    public Long getJpaVersionNumber() {
        return jpaVersionNumber;
    }

    public void setJpaVersionNumber(Long jpaVersionNumber) {
        this.jpaVersionNumber = jpaVersionNumber;
    }

    public long getCode() {
        return code;
    }

    public void setCode(long code) {
        this.code = code;
    }

    public Long getBusinessPriority() {
        return businessPriority;
    }

    public void setBusinessPriority(Long businessPriority) {
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

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
		ValidationErrorTypeDBO other = (ValidationErrorTypeDBO) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	public String toString() {
        return "ValidationErrorTypeDBO [jpaVersionNumber=" + jpaVersionNumber + ", baseTable=" + baseTable + ", code="
            + code + ", businessPriority=" + businessPriority + ", defaultChoice=" + defaultChoice + ", description="
            + description + ", endDate=" + endDate + ", name=" + name + "]";
    }

}
