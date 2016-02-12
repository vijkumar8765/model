package uk.gov.scotland.afrc.applications.model.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import uk.gov.scotland.afrc.applications.model.base.BaseTable;
import uk.gov.scotland.afrc.applications.model.base.BaseTableAware;
import uk.gov.scotland.afrc.applications.model.base.BaseTableListener;


@Entity
@Table(name = "ENTITLEMENT_CATG")
@EntityListeners(BaseTableListener.class)
@NamedQueries(
	    value = {
	            @NamedQuery(
	                name = "EntitlementCatg.findCategoriesByApplicationTypeAndRoute",
	                query = "SELECT d FROM EntitlementCatgDBO d WHERE d.applicationTypeCode = :applicationTypeCode AND d.entitlementRoute.code = :routeTypeCode ORDER BY d.businessPriority"),
                @NamedQuery(
    	                name = "EntitlementCatg.findByDescription",
    	                query = "SELECT d FROM EntitlementCatgDBO d WHERE d.description = :description")})
public class EntitlementCatgDBO implements Serializable, BaseTableAware {

	private static final long serialVersionUID = 1L;

    @Embedded
    private BaseTable baseTable;
	
	@Basic
	@Column(name="ALWAYS_MANUALLY_ASSESS_FLAG", length=1)
	private Boolean alwaysManuallyAssessFlag;

	@Basic
	@Column(name="BUSINESS_PRIORITY", length=10)
	private Long businessPriority;

	@Basic
	@Column(name="DEFAULT_CHOICE", length=1)
	private Boolean defaultChoice;

	@Basic
	@Column(nullable=false, length=100)
	private String description;

	@Basic
	@Column(name="END_DATE", columnDefinition="DATE")
	private Date endDate;

	@Id
	@Column(name="ENTITLEMENT_CATG_ID", length=38)
	private long entitlementCatgId;

	@ManyToOne(fetch=FetchType.LAZY, cascade=CascadeType.MERGE)
	@JoinColumn(name="ENTITLEMENT_ROUTE_CODE", nullable=false)
	private EntitlementRouteDBO entitlementRoute;

	@Basic
	@Column(nullable=false, length=20)
	private String name;

	@Column(name = "APPLICATION_TYPE_CODE")
    private Long applicationTypeCode;

	public EntitlementCatgDBO() {
	}

	public EntitlementCatgDBO(long entitlementCatgId) {
		this.entitlementCatgId = entitlementCatgId;
	}

	public Long getApplicationTypeCode() {
		return applicationTypeCode;
	}

	public void setApplicationTypeCode(Long applicationTypeCode) {
		this.applicationTypeCode = applicationTypeCode;
	}

	public Boolean isAlwaysManuallyAssessFlag() {
		return alwaysManuallyAssessFlag;
	}

	public void setAlwaysManuallyAssessFlag(Boolean alwaysManuallyAssessFlag) {
		this.alwaysManuallyAssessFlag = alwaysManuallyAssessFlag;
	}

	public Long getBusinessPriority() {
		return businessPriority;
	}

	public void setBusinessPriority(Long businessPriority) {
		this.businessPriority = businessPriority;
	}

	public Boolean isDefaultChoice() {
		return defaultChoice;
	}

	public void setDefaultChoice(Boolean defaultChoice) {
		this.defaultChoice = defaultChoice;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public long getEntitlementCatgId() {
		return entitlementCatgId;
	}

	public void setEntitlementCatgId(long entitlementCatgId) {
		this.entitlementCatgId = entitlementCatgId;
	}

	public EntitlementRouteDBO getEntitlementRoute() {
		return entitlementRoute;
	}

	public void setEntitlementRoute(EntitlementRouteDBO entitlementRoute) {
		this.entitlementRoute = entitlementRoute;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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