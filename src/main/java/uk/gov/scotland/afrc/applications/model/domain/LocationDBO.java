package uk.gov.scotland.afrc.applications.model.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;

import uk.gov.scotland.afrc.applications.model.base.BaseTable;
import uk.gov.scotland.afrc.applications.model.base.BaseTableAware;
import uk.gov.scotland.afrc.applications.model.base.BaseTableListener;

@Entity
@Table(name = "LOCATION")
@EntityListeners(BaseTableListener.class)
public class LocationDBO implements Serializable, BaseTableAware {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Embedded
    private BaseTable baseTable;
    
	@Id
	@Column(name="LOCATION_ID")
	private Long locationId;

	@Column(name="LOCATION_CODE")
	private String locationCode;

	@Column(name="LOCATION_NAME")
	private String locationName;

	@Column(name="JPA_VERSION_NUMBER")
	@Version
	private Long jpaVersionNumber;

	@Column(name="CREATED_DATE")
	private Date createddate;

	@Column(name="ORG_OFFICE_TYPE_CODE")
	private Long orgOfficeTypeCode;

	@Column(name="CONTACT_POINT_ID")
	private Long contactPointId;
	
	@Column(name="TOT_SHEEP_EQUIVALENT_CG")
    private BigDecimal tot_sheep_equivalentCg;

	@Column(name="AREA_CG")
    private BigDecimal areaCg;

	@Column(name="REGULATED_CG_FLAG")
    private BigDecimal regulatedCgFlag;
	
	public Long getLocationId() {
		return locationId;
	}

	public void setLocationId(Long locationId) {
		this.locationId = locationId;
	}

	public String getLocationCode() {
		return locationCode;
	}

	public void setLocationCode(String locationCode) {
		this.locationCode = locationCode;
	}

	public String getLocationName() {
		return locationName;
	}

	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}

	public Long getJpaVersionNumber() {
		return jpaVersionNumber;
	}

	public void setJpaVersionNumber(Long jpaVersionNumber) {
		this.jpaVersionNumber = jpaVersionNumber;
	}

	public Date getCreateddate() {
		return createddate;
	}

	public void setCreateddate(Date createddate) {
		this.createddate = createddate;
	}

	public Long getOrgOfficeTypeCode() {
		return orgOfficeTypeCode;
	}

	public void setOrgOfficeTypeCode(Long orgOfficeTypeCode) {
		this.orgOfficeTypeCode = orgOfficeTypeCode;
	}

	public Long getContactPointId() {
		return contactPointId;
	}

	public void setContactPointId(Long contactPointId) {
		this.contactPointId = contactPointId;
	}

    public BigDecimal getTot_sheep_equivalentCg() {
		return tot_sheep_equivalentCg;
	}

    public void setTot_sheep_equivalentCg(BigDecimal tot_sheep_equivalentCg) {
		this.tot_sheep_equivalentCg = tot_sheep_equivalentCg;
	}

    public BigDecimal getAreaCg() {
		return areaCg;
	}

    public void setAreaCg(BigDecimal areaCg) {
		this.areaCg = areaCg;
	}

    public BigDecimal getRegulatedCgFlag() {
		return regulatedCgFlag;
	}

    public void setRegulatedCgFlag(BigDecimal regulatedCgFlag) {
		this.regulatedCgFlag = regulatedCgFlag;
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
