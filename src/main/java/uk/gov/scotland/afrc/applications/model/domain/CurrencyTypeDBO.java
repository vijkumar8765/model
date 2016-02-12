package uk.gov.scotland.afrc.applications.model.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

import uk.gov.scotland.afrc.applications.model.base.BaseTable;
import uk.gov.scotland.afrc.applications.model.base.BaseTableAware;
import uk.gov.scotland.afrc.applications.model.base.BaseTableListener;


/**
 * The persistent class for the CURRENCY_TYPE database table.
 * 
 */
@Entity
@Table(name="CURRENCY_TYPE")
@javax.persistence.Cacheable
@EntityListeners(BaseTableListener.class)
@NamedQuery(name="CurrencyTypeDBO.findAll", query="SELECT c FROM CurrencyTypeDBO c")
public class CurrencyTypeDBO implements Serializable , BaseTableAware{
	private static final long serialVersionUID = 1L;

    @Embedded
    private BaseTable baseTable;
    
	@Id
	@Column(name="CODE")
	private Long code;

	@Column(name="BUSINESS_PRIORITY")
	private Long businessPriority;

	@Column(name="DEFAULT_CHOICE")
	private Long defaultChoice;

	@Column(name="DESCRIPTION")
	private String description;

	@Temporal(TemporalType.DATE)
	@Column(name="END_DATE")
	private Date endDate;

	@Column(name="JPA_VERSION_NUMBER")
	@Version
	private Long jpaVersionNumber;

	@Column(name="NAME")
	private String name;

	public CurrencyTypeDBO() {
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
		return this.code;
	}

	public void setCode(Long code) {
		this.code = code;
	}

	public Long getBusinessPriority() {
		return this.businessPriority;
	}

	public void setBusinessPriority(Long businessPriority) {
		this.businessPriority = businessPriority;
	}

	public Long getDefaultChoice() {
		return this.defaultChoice;
	}

	public void setDefaultChoice(Long defaultChoice) {
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

	public Long getJpaVersionNumber() {
		return this.jpaVersionNumber;
	}

	public void setJpaVersionNumber(Long jpaVersionNumber) {
		this.jpaVersionNumber = jpaVersionNumber;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public boolean isSterling(){
		return getDescription()!=null?getDescription().toUpperCase().startsWith("STER"):null;
	}
	
	public boolean isEuro(){
		return getDescription()!=null?getDescription().toUpperCase().startsWith("EUR"):null;
	}
}