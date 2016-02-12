package uk.gov.scotland.afrc.applications.model.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;


/**
 * The persistent class for the CAPITAL_TYPE database table.
 * 
 */
@Entity
@Table(name="CAPITAL_TYPE")
@javax.persistence.Cacheable
@NamedQuery(name="CapitalTypeDBO.findAll", query="SELECT c FROM CapitalTypeDBO c")
public class CapitalTypeDBO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private long code;

	private String description;

	@Column(name="JPA_VERSION_NUMBER")
	@Version
	private Long jpaVersionNumber;

	@Column(name="LAST_UPDATED_BY")
	private Long lastUpdatedBy;

	@Temporal(TemporalType.DATE)
	@Column(name="LAST_UPDATED_DATE")
	private Date lastUpdatedDate;

	private String name;

	//bi-directional many-to-one association to CapitalItemTypeDBO
	@OneToMany(mappedBy="capitalTypeDBO")
	private List<CapitalItemTypeDBO> capitalItemTypeDBOs;

	public CapitalTypeDBO() {
	}

	public long getCode() {
		return this.code;
	}

	public void setCode(long code) {
		this.code = code;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Long getJpaVersionNumber() {
		return this.jpaVersionNumber;
	}

	public void setJpaVersionNumber(Long jpaVersionNumber) {
		this.jpaVersionNumber = jpaVersionNumber;
	}

	public Long getLastUpdatedBy() {
		return this.lastUpdatedBy;
	}

	public void setLastUpdatedBy(Long lastUpdatedBy) {
		this.lastUpdatedBy = lastUpdatedBy;
	}

	public Date getLastUpdatedDate() {
		return this.lastUpdatedDate;
	}

	public void setLastUpdatedDate(Date lastUpdatedDate) {
		this.lastUpdatedDate = lastUpdatedDate;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<CapitalItemTypeDBO> getCapitalItemTypes() {
		return this.capitalItemTypeDBOs;
	}

	public void setCapitalItemTypes(List<CapitalItemTypeDBO> capitalItemTypeDBOs) {
		this.capitalItemTypeDBOs = capitalItemTypeDBOs;
	}

	public CapitalItemTypeDBO addCapitalItemType(CapitalItemTypeDBO capitalItemTypeDBO) {
		getCapitalItemTypes().add(capitalItemTypeDBO);
		capitalItemTypeDBO.setCapitalType(this);

		return capitalItemTypeDBO;
	}

	public CapitalItemTypeDBO removeCapitalItemType(CapitalItemTypeDBO capitalItemTypeDBO) {
		getCapitalItemTypes().remove(capitalItemTypeDBO);
		capitalItemTypeDBO.setCapitalType(null);

		return capitalItemTypeDBO;
	}

}