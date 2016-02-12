package uk.gov.scotland.afrc.applications.model.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import uk.gov.scotland.afrc.applications.model.base.BaseTable;
import uk.gov.scotland.afrc.applications.model.base.BaseTableAware;
import uk.gov.scotland.afrc.applications.model.base.BaseTableListener;


/**
 * The persistent class for the DOCUMENT_SUB_CATG_TYPE database table.
 * 
 */
@Entity
@Table(name="DOCUMENT_SUB_CATG_TYPE_VIEW")
@EntityListeners(BaseTableListener.class)
@NamedQuery(name="DocSubCategoryType.findAll", query="SELECT c FROM DocSubCategoryType c")
public class DocSubCategoryType implements Serializable,BaseTableAware {
	private static final long serialVersionUID = 1L;
	
	@Embedded
    private BaseTable baseTable;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long code;

	@Column(name="BUSINESS_PRIORITY")
	private long businessPriority;

	@Column(name="DEFAULT_CHOICE")
	private int defaultChoice;

	@Column(name="DESCRIPTION", length=100)
	private String description;

	@Temporal(TemporalType.DATE)
	@Column(name="END_DATE")
	private Date endDate;

	@Column(name="JPA_VERSION_NUMBER")
	private long jpaVersionNumber;

	@Column(name="LAST_UPDATED_BY")
	private long lastUpdatedBy;

	@Temporal(TemporalType.DATE)
	@Column(name="LAST_UPDATED_DATE")
	private Date lastUpdatedDate;

	@Column(name="LEVEL0")
	private long level;

	@Column(name="NAME", length=20)
	private String name;
	
	@Column(name="PARENT_CODE")
	private int parentCode;

	public DocSubCategoryType() {
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

	public int getDefaultChoice() {
		return this.defaultChoice;
	}

	public void setDefaultChoice(int defaultChoice) {
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

	public long getLastUpdatedBy() {
		return this.lastUpdatedBy;
	}

	public void setLastUpdatedBy(long lastUpdatedBy) {
		this.lastUpdatedBy = lastUpdatedBy;
	}

	public Date getLastUpdatedDate() {
		return this.lastUpdatedDate;
	}

	public void setLastUpdatedDate(Date lastUpdatedDate) {
		this.lastUpdatedDate = lastUpdatedDate;
	}

	public long getLevel() {
		return this.level;
	}

	public void setLevel(long level) {
		this.level = level;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * @return the parentCode
	 */
	public int getParentCode() {
		return parentCode;
	}

	/**
	 * @param parentCode the parentCode to set
	 */
	public void setParentCode(int parentCode) {
		this.parentCode = parentCode;
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

}