/**
 * 
 */
package uk.gov.scotland.afrc.applications.model.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

import uk.gov.scotland.afrc.applications.model.base.BaseTable;
import uk.gov.scotland.afrc.applications.model.base.BaseTableAware;
import uk.gov.scotland.afrc.applications.model.base.BaseTableListener;

/**
 * @author d609094
 * 
 */
@Entity
@Table(name = "ASSOC_APP_VALIDATION_RESULT")
@EntityListeners(BaseTableListener.class)
@NamedQueries(value = { 
        @NamedQuery(name = "RelatedApplicationsDBO.findRelatedApplicationsByCrossErrorID", 
        		query = "SELECT r FROM "
                + " RelatedApplicationsDBO r " 
        		+ " WHERE r.appValidationErrId =:appValidationErrorId"
                + " ORDER BY r.applicationId")})
					//SELECT r.* FROM          
					//assoc_app_validation_result r
					//WHERE r.APP_VALIDATION_ERR_ID =2095
					//ORDER BY r.APPLICATION_ID;
public class RelatedApplicationsDBO implements Serializable, BaseTableAware {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Embedded
	private BaseTable baseTable;

	@Temporal(TemporalType.DATE)
	@Column(name = "LAST_UPDATED_DATE")
	private Date lastUpdatedDate;

	@Column(name = "LAST_UPDATED_BY")
	private long lastUpdatedUser;

	@Column(name = "JPA_VERSION_NUMBER")
	@Version
	private Long jpaVersionNumber;

	@Id
	@Column(name = "ASSOC_APP_VAL_RESULT_ID")
	@SequenceGenerator(name = "RELATED_APPLICATIONS_SEQ_GENERATOR", sequenceName = "ASSOC_APP_VAL_RESULT_SEQ", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "RELATED_APPLICATIONS_SEQ_GENERATOR")
	private long AssocAppValResultId;

	@Column(name = "APPLICATION_ID")
	private Long applicationId;

	@Column(name = "APP_VALIDATION_RESULT_ID")
	private Long AppValidationResultId;

	@Column(name = "APP_VALIDATION_ERR_ID")
	private Long appValidationErrId;
    
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "APP_VALIDATION_ERR_ID")
    private AppValidationErrDBO appValidationErr;
	
	
	public BaseTable getBaseTable() {
		if (baseTable == null) {
			baseTable = new BaseTable();
		}

		return baseTable;
	}

	public void setBaseTable(BaseTable baseTable) {
		this.baseTable = baseTable;
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

	public Long getJpaVersionNumber() {
		return jpaVersionNumber;
	}

	public void setJpaVersionNumber(Long jpaVersionNumber) {
		this.jpaVersionNumber = jpaVersionNumber;
	}

	public long getAssocAppValResultId() {
		return AssocAppValResultId;
	}

	public void setAssocAppValResultId(long assocAppValResultId) {
		AssocAppValResultId = assocAppValResultId;
	}

	public Long getApplicationId() {
		return applicationId;
	}

	public void setApplicationId(Long applicationId) {
		this.applicationId = applicationId;
	}

	public Long getAppValidationResultId() {
		return AppValidationResultId;
	}

	public void setAppValidationResultId(Long appValidationResultId) {
		AppValidationResultId = appValidationResultId;
	}

	public Long getAppValidationErrId() {
		return appValidationErrId;
	}

	public void setAppValidationErrId(Long appValidationErrId) {
		this.appValidationErrId = appValidationErrId;
	}
	
	public AppValidationErrDBO getAppValidationErr() {
		return this.appValidationErr;
	}

	public void setAppValidationErr(AppValidationErrDBO appValidationErr) {
		this.appValidationErr = appValidationErr;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ (int) (applicationId ^ (applicationId >>> 32));
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
		RelatedApplicationsDBO other = (RelatedApplicationsDBO) obj;
		if (applicationId != other.applicationId)
			return false;
		return true;
	}

	public String toString() {
        return "RelatedApplicationsDBO [baseTable=" + baseTable + ", AssocAppValResultId=" + AssocAppValResultId + 
        		", applicationId=" + applicationId + ", AppValidationResultId=" + AppValidationResultId + 
        		", appValidationErrId=" + appValidationErrId + "]";
    }
}
