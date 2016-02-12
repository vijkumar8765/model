package uk.gov.scotland.afrc.applications.model.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import uk.gov.scotland.afrc.applications.model.base.BaseTable;
import uk.gov.scotland.afrc.applications.model.base.BaseTableAware;
import uk.gov.scotland.afrc.applications.model.base.BaseTableListener;


/**
 * The persistent class for the APP_SUSPENSION_REASON database table.
 * 
 */
@Entity
@Table(name="APP_SUSPENSION_REASON_TYPE")
@EntityListeners(BaseTableListener.class)

@NamedQueries(
	    value = {
	    		@NamedQuery(name="AppSuspensionReasonDBO.findAll", query="SELECT a FROM AppSuspensionReasonDBO a"),
	            @NamedQuery(name = "AppSuspensionReasonDBO.findByCode", query = "SELECT a FROM AppSuspensionReasonDBO a where a.code=:code") })
public class AppSuspensionReasonDBO implements Serializable, BaseTableAware {
	private static final long serialVersionUID = 1L;

	@Id
	private Long code;
	
	private String name;
	
	private String description;
	
	@Column(name="JPA_VERSION_NUMBER")
	private Long jpaVersionNumber;

	@Temporal(TemporalType.DATE)
	@Column(name="LAST_UPDATED_DATE")
	private Date lastUpdatedDate;

	@Column(name="LAST_UPDATED_BY")
	private Long lastUpdatedBy;

	@Temporal(TemporalType.DATE)
	@Column(name="END_DATE")
	private Date endDate;

	@Column(name="DEFAULT_CHOICE")
	private Long defaultChoice;

	@Column(name="BUSINESS_PRIORITY")
	private Long businessPriority;

	public AppSuspensionReasonDBO() {
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


	public Long getJpaVersionNumber() {
		return jpaVersionNumber;
	}


	public void setJpaVersionNumber(Long jpaVersionNumber) {
		this.jpaVersionNumber = jpaVersionNumber;
	}


	public Date getLastUpdatedDate() {
		return lastUpdatedDate;
	}


	public void setLastUpdatedDate(Date lastUpdatedDate) {
		this.lastUpdatedDate = lastUpdatedDate;
	}


	public Long getLastUpdatedBy() {
		return lastUpdatedBy;
	}


	public void setLastUpdatedBy(Long lastUpdatedBy) {
		this.lastUpdatedBy = lastUpdatedBy;
	}


	public Date getEndDate() {
		return endDate;
	}


	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}


	public Long getDefaultChoice() {
		return defaultChoice;
	}


	public void setDefaultChoice(Long defaultChoice) {
		this.defaultChoice = defaultChoice;
	}


	public Long getBusinessPriority() {
		return businessPriority;
	}


	public void setBusinessPriority(Long businessPriority) {
		this.businessPriority = businessPriority;
	}


	@Override
	public BaseTable getBaseTable() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setBaseTable(BaseTable baseTable) {
		// TODO Auto-generated method stub
		
	}

}