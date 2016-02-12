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
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

import uk.gov.scotland.afrc.applications.model.base.BaseTable;
import uk.gov.scotland.afrc.applications.model.base.BaseTableListener;


/**
 * The persistent class for the ELIGIBLE_CAPITAL_ITEM_TYPE database table.
 * 
 */
@Entity
@Table(name="ELIGIBLE_CAPITAL_ITEM_TYPE")
@javax.persistence.Cacheable
@EntityListeners(BaseTableListener.class)
@NamedQuery(name="EligibleCapitalItemTypeDBO.findEligibleCapitalItemTypesBySchemeOptionId", query="SELECT e FROM EligibleCapitalItemTypeDBO e where e.schemeOptionId = :schemeOptionId")
public class EligibleCapitalItemTypeDBO implements Serializable, uk.gov.scotland.afrc.applications.model.base.BaseTableAware  {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ELIG_CAPITAL_ITEM_TYPE_ID")
	private long eligCapitalItemTypeId;

	@Column(name="JPA_VERSION_NUMBER")
	@Version
	private Long jpaVersionNumber;

	@Column(name="LAST_UPDATED_BY")
	private Long lastUpdatedBy;

	@Temporal(TemporalType.DATE)
	@Column(name="LAST_UPDATED_DATE")
	private Date lastUpdatedDate;

	@Column(name="SCHEME_OPTION_ID")
	private long schemeOptionId;

	//bi-directional many-to-one association to CapitalItemTypeDBO
	@ManyToOne
	@JoinColumn(name="CAPITAL_ITEM_TYPE_CODE")
	private CapitalItemTypeDBO capitalItemTypeDBO;
	
	@Embedded
	private BaseTable baseTable;

	public EligibleCapitalItemTypeDBO() {
	}

	public long getEligCapitalItemTypeId() {
		return this.eligCapitalItemTypeId;
	}

	public void setEligCapitalItemTypeId(long eligCapitalItemTypeId) {
		this.eligCapitalItemTypeId = eligCapitalItemTypeId;
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

	public long getSchemeOptionId() {
		return this.schemeOptionId;
	}

	public void setSchemeOptionId(long schemeOptionId) {
		this.schemeOptionId = schemeOptionId;
	}

	public CapitalItemTypeDBO getCapitalItemType() {
		return this.capitalItemTypeDBO;
	}

	public void setCapitalItemType(CapitalItemTypeDBO capitalItemTypeDBO) {
		this.capitalItemTypeDBO = capitalItemTypeDBO;
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

}