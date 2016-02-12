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
@Table(name = "ADJT_REASON_TYPE")
@EntityListeners(BaseTableListener.class)
@NamedQueries(value = { @NamedQuery(name = "AdjustmentReasonTypeDBO.findByName", 
query = "SELECT l FROM AdjustmentReasonTypeDBO l where l.name = :name") })
public class AdjustmentReasonTypeDBO implements Serializable, BaseTableAware {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "CODE")
	private long code;

	@Column(name = "NAME")
	private String name;

	@Column(name = "DESCRIPTION")
	private String description;

	@Column(name = "JPA_VERSION_NUMBER")
	@Version
	private Long jpaVersionNumber;

	@Column(name = "BUSINESS_PRIORITY")
	private Long buisnessPriority;

	@Temporal(TemporalType.DATE)
	@Column(name = "END_DATE")
	private Date endDate;

	@Column(name = "DEFAULT_CHOICE")
	private int defaultChoice;

	@Temporal(TemporalType.DATE)
	@Column(name = "LAST_UPDATED_DATE")
	private Date lastUpdatedDate;

	@Column(name = "LAST_UPDATED_BY")
	private long lastUpdatedUser;
	
	@Embedded
	private BaseTable baseTable;	

	public long getCode() {
		return code;
	}

	public void setCode(long code) {
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

	public Long getBuisnessPriority() {
		return buisnessPriority;
	}

	public void setBuisnessPriority(Long buisnessPriority) {
		this.buisnessPriority = buisnessPriority;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public int getDefaultChoice() {
		return defaultChoice;
	}

	public void setDefaultChoice(int defaultChoice) {
		this.defaultChoice = defaultChoice;
	}

	public Date getLastUpdatedDate() {
		return lastUpdatedDate;
	}

	public void setLastUpdatedDate(Date lastUpdatedDate) {
		this.lastUpdatedDate = lastUpdatedDate;
	}

	public long getLastUpdatedUser() {
		return lastUpdatedUser;
	}

	public void setLastUpdatedUser(long lastUpdatedUser) {
		this.lastUpdatedUser = lastUpdatedUser;
	}

	public BaseTable getBaseTable() {
		return baseTable;
	}

	public void setBaseTable(BaseTable baseTable) {
		this.baseTable = baseTable;
	}

}
