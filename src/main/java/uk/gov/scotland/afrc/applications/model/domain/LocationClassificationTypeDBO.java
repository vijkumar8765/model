package uk.gov.scotland.afrc.applications.model.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import uk.gov.scotland.afrc.applications.model.base.BaseTable;


/**
* The persistent class for the LOCATION_CLASSIFICATION_TYPE database table.
* 
*/
@Entity
@Table(name="LOCATION_CLASSIFICATION_TYPE")
@javax.persistence.Cacheable
@NamedQuery(name="LocationClassificationTypeDBO.findAll", query="SELECT l FROM LocationClassificationTypeDBO l")
public class LocationClassificationTypeDBO implements Serializable {

	private static final long serialVersionUID = 1L;

    @Embedded
    private BaseTable baseTable;

	@Id
	@Column(name="CODE")
	private long code;

	@Column(name="NAME")
	private String name;
	
	@Column(name="DESCRIPTION")
	private String description;
	
	@Column(name="BUSINESS_PRIORITY")
	private long businessPriority;

	@Temporal(TemporalType.DATE)
	@Column(name="END_DATE")
	private Date endDate;

	@Column(name="DEFAULT_CHOICE")
	private boolean defaultChoice;

	@Column(name="JPA_VERSION_NUMBER")
	private long jpaVersionNumber;


	public LocationClassificationTypeDBO() {
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
		return this.code;
	}

	public void setCode(long code) {
		this.code = code;
	}

	public long getBusinessPriority() {
		return this.businessPriority;
	}

	public void setBusinessPriority(long businessPriority) {
		this.businessPriority = businessPriority;
	}

	public boolean getDefaultChoice() {
		return this.defaultChoice;
	}

	public void setDefaultChoice(boolean defaultChoice) {
		this.defaultChoice = defaultChoice;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getEndDate() {
		return this.endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public long getJpaVersionNumber() {
		return this.jpaVersionNumber;
	}

	public void setJpaVersionNumber(long jpaVersionNumber) {
		this.jpaVersionNumber = jpaVersionNumber;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
