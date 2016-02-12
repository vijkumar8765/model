package uk.gov.scotland.afrc.applications.model.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Version;

import uk.gov.scotland.afrc.applications.model.base.BaseTable;
import uk.gov.scotland.afrc.applications.model.base.BaseTableAware;
import uk.gov.scotland.afrc.applications.model.base.BaseTableListener;

// This object is created for DELETE purpose only.
// If it is needed, feel free to extend it and add other fields, base table and a sequence.

@Entity
@Table(name = "APP_ENTITLEMENT_CATG")
@EntityListeners(BaseTableListener.class)
@NamedQueries(value = { @NamedQuery(name = "AppEntitlementCatgDBO.deleteByApplicationId",
    query = "DELETE FROM AppEntitlementCatgDBO d WHERE d.applicationId = :applicationId"),
    @NamedQuery(name = "AppEntitlementCatgDBO.findByApplicationId",
    	query = "select d FROM AppEntitlementCatgDBO d WHERE d.applicationId = :applicationId"),
    @NamedQuery(name = "AppEntitlementCatgDBO.findByBrnAndApplicationTypeCode",
    	query = "select d FROM AppEntitlementCatgDBO d, ApplicationDBO e WHERE d.brn = :brn and d.applicationId = e.applicationId and e.applicationTypeCode = :applicationTypeCode")})
public class AppEntitlementCatgDBO implements Serializable, BaseTableAware {

    private static final long serialVersionUID = 1L;

	@Id
	@Column(name="APP_ENTITLEMENT_CATG_ID", length=38)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "APP_ENTITLEMENT_CATG_GEN")
	@SequenceGenerator(name = "APP_ENTITLEMENT_CATG_GEN", sequenceName = "APP_ENTITLEMENT_CATG_SEQ", allocationSize=1)
    private long appEntitlementCatgId;

    @Column(name = "APPLICATION_ID")
    private Long applicationId;
    
    @Column(name = "BRN")
    private long brn;
    
    @Column(name = "CURRENT_STATUS_TYPE_CODE")
    private long currentStatusTypeCode;
    
    @Column(name = "ENTITLEMENT_CATG_ID")
    private long entitlementCatgId;
    
	@Column(name = "JPA_VERSION_NUMBER")
    @Version
    private Long jpaVersionNumber;

    @Embedded
    private BaseTable baseTable;

    public long getAppEntitlementCatgId() {
        return appEntitlementCatgId;
    }

    public void setAppEntitlementCatgId(long appEntitlementCatgId) {
        this.appEntitlementCatgId = appEntitlementCatgId;
    }

    public Long getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(Long applicationId) {
        this.applicationId = applicationId;
    }

    public Long getJpaVersionNumber() {
        return jpaVersionNumber;
    }

    public void setJpaVersionNumber(Long jpaVersionNumber) {
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
    
    public long getBrn() {
		return brn;
	}

	public void setBrn(long brn) {
		this.brn = brn;
	}

	public long getCurrentStatusTypeCode() {
		return currentStatusTypeCode;
	}

	public void setCurrentStatusTypeCode(long currentStatusTypeCode) {
		this.currentStatusTypeCode = currentStatusTypeCode;
	}

	public long getEntitlementCatgId() {
		return entitlementCatgId;
	}

	public void setEntitlementCatgId(long entitlementCatgId) {
		this.entitlementCatgId = entitlementCatgId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ (int) (appEntitlementCatgId ^ (appEntitlementCatgId >>> 32));
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
		AppEntitlementCatgDBO other = (AppEntitlementCatgDBO) obj;
		if (appEntitlementCatgId != other.appEntitlementCatgId)
			return false;
		return true;
	}
}
