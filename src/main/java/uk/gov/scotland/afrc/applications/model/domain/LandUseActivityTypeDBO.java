package uk.gov.scotland.afrc.applications.model.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

import uk.gov.scotland.afrc.applications.model.base.BaseTable;
import uk.gov.scotland.afrc.applications.model.base.BaseTableListener;

/**
 * Entity implementation class for Entity: LandUseActivityTypeDBO
 *
 */
@Entity
@Table(name="LND_USE_ACTIVITY_TYPE")
@javax.persistence.Cacheable
@EntityListeners(BaseTableListener.class)
@NamedQueries(
	    value = {
	    		@NamedQuery(name="LandUseActivityTypeDBO.findAll", query="SELECT c FROM LandUseActivityTypeDBO c"),
	    		@NamedQuery(name="LandUseActivityTypeDBO.findByCode", query="SELECT c FROM LandUseActivityTypeDBO c where c.code=:code")})
public class LandUseActivityTypeDBO implements Serializable {
	
	private static final long serialVersionUID = 1L;

    @Embedded
    private BaseTable baseTable;
    
	@Id
	@Column(name="CODE")
	private Long code;

	@Column(name="NAME")
	private String name;

	@Column(name="DESCRIPTION")
	private String description;

	@Column(name="BUSINESS_PRIORITY")
	private Long businessPriority;

	@Temporal(TemporalType.DATE)
	@Column(name="END_DATE")
	private Date endDate;

	@Column(name="JPA_VERSION_NUMBER")
	@Version
	private Long jpaVersionNumber;

	@Column(name="DEFAULT_CHOICE")
	private boolean defaultChoice;
	
    @ManyToOne
    @JoinColumn(name = "EVDNCE_REQT_TYPE_CODE")
    private EvidenceRequirementTypeDBO evidenceRequirementType;	
	
	public LandUseActivityTypeDBO() {
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
    
    public Long getCode() {
		return code;
	}
    
    public void setCode(Long code) {
		this.code = code;
	}
    
    public String getName() {
		return name;
	}
    
    public void setName(String name) {
		this.name = name;
	}
    
    public String getDescription() {
		return description;
	}
    
    public void setDescription(String description) {
		this.description = description;
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
    
    public Long getJpaVersionNumber() {
		return jpaVersionNumber;
	}
    
    public void setJpaVersionNumber(Long jpaVersionNumber) {
		this.jpaVersionNumber = jpaVersionNumber;
	}
    
    public boolean isDefaultChoice() {
		return defaultChoice;
	}
    
    public void setDefaultChoice(boolean defaultChoice) {
		this.defaultChoice = defaultChoice;
	}
    
    public EvidenceRequirementTypeDBO getEvidenceRequirementType() {
        return evidenceRequirementType;
    }

    public void setEvidenceRequirementType(EvidenceRequirementTypeDBO evidenceRequirementType) {
        this.evidenceRequirementType = evidenceRequirementType;
    }
   
}
