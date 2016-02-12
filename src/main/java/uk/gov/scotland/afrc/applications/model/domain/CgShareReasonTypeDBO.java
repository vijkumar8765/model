/**
 * 
 */
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
import javax.persistence.Version;

import org.apache.openjpa.persistence.jdbc.Unique;

import uk.gov.scotland.afrc.applications.model.base.BaseTable;
import uk.gov.scotland.afrc.applications.model.base.BaseTableListener;


/**
 * The persistent class for the CG_SHARE_REASON_TYPE database table.
 * 
 */
@Entity
@Table(name = "CG_SHARE_ADJT_REASON_TYPE")
@EntityListeners(BaseTableListener.class)
@NamedQueries({ @NamedQuery(name = "CgShareReasonType.getAllCgShareReason",
    query = "SELECT c FROM CgShareReasonTypeDBO c ") })
public class CgShareReasonTypeDBO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8200818873941805403L;
	
	@Id
	@Column(name = "CODE")
	private long code;
	
	@Column(name = "NAME")
	@Unique
	private String name;
	
	@Column(name = "DESCRIPTION")
	private String description;
	
	@Column(name = "JPA_VERSION_NUMBER")
	@Version
	private long jpaVersionNumber;
	
	@Embedded
	private BaseTable baseTable;

	@Column(name = "IS_PENALTY_FLAG")
	private long isPenaltyFlag;
	
	@Column(name = "ATCU_APPLICABLE_FLAG")
	private long atcuApplicableFlag;

	@Column(name = "BUSINESS_PRIORITY")
	private long bussinessPriority;

	@Column(name = "END_DATE")
	private Date endDate;

	@Column(name = "DEFAULT_CHOICE")
	private long defaultChoice;

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

	public long getJpaVersionNumber() {
		return jpaVersionNumber;
	}

	public void setJpaVersionNumber(long jpaVersionNumber) {
		this.jpaVersionNumber = jpaVersionNumber;
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

	public long getIsPenaltyFlag() {
		return isPenaltyFlag;
	}

	public void setIsPenaltyFlag(long isPenaltyFlag) {
		this.isPenaltyFlag = isPenaltyFlag;
	}

	public long getAtcuApplicableFlag() {
		return atcuApplicableFlag;
	}

	public void setAtcuApplicableFlag(long atcuApplicableFlag) {
		this.atcuApplicableFlag = atcuApplicableFlag;
	}

	public long getBussinessPriority() {
		return bussinessPriority;
	}

	public void setBussinessPriority(long bussinessPriority) {
		this.bussinessPriority = bussinessPriority;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public long getDefaultChoice() {
		return defaultChoice;
	}

	public void setDefaultChoice(long defaultChoice) {
		this.defaultChoice = defaultChoice;
	}
	
	

	
	

}
