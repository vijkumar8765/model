package uk.gov.scotland.afrc.applications.model.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import uk.gov.scotland.afrc.applications.model.base.BaseTable;
import uk.gov.scotland.afrc.applications.model.base.BaseTableAware;

/**
 * The persistent class for the OCCUPANCY database table.
 * 
 */
@Entity
@Table(name = "OCCUPANCY")
@NamedQueries({
		@NamedQuery(name = "OccupancyDBO.findAll", query = "SELECT o FROM OccupancyDBO o"),
		@NamedQuery(name = "OccupancyDBO.findByLocationId", query = "SELECT o FROM OccupancyDBO o where o.pk.locationId = :locationId"),
		@NamedQuery(name = "OccupancyDBO.findByBrnAndLocationId", query = "SELECT o FROM OccupancyDBO o WHERE o.pk.locationId = :locationId AND o.pk.brn = :brn "),
		@NamedQuery(name = "OccupancyDBO.findMainLocationCodeForBrn", query = "SELECT location.locationCode FROM OccupancyDBO o, LocationDBO location WHERE o.mainLocationFlag = 1 AND o.pk.brn = :brn "
    			+ " AND  o.pk.locationId = location.locationId") })
public class OccupancyDBO implements Serializable, BaseTableAware {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private OccupancyPK pk;

	@Embedded
	private BaseTable baseTable;

	@Column(name = "CONTACT_POINT_ID")
	private long contactPointId;

	@Column(name = "JPA_VERSION_NUMBER")
	private long jpaVersionNumber;

	@Column(name = "LAST_UPDATED_BY")
	private long lastUpdatedBy;

	@Temporal(TemporalType.DATE)
	@Column(name = "LAST_UPDATED_DATE")
	private Date lastUpdatedDate;

	@Column(name = "MAIN_LOCATION_FLAG")
	private long mainLocationFlag;

	@Temporal(TemporalType.DATE)
	@Column(name = "OCCUPANCY_END_DATE")
	private Date occupancyEndDate;

	@Temporal(TemporalType.DATE)
	@Column(name = "OCCUPANCY_START_DATE")
	private Date occupancyStartDate;

	@Column(name = "OWNED_AREA_HECTARE")
	private BigDecimal ownedAreaHectare;

	@Column(name = "PREVIOUS_OCCUPIER")
	private String previousOccupier;

	@Column(name = "TENANTED_AREA_HECTARE")
	private BigDecimal tenantedAreaHectare;

	@Column(name = "TOTAL_AREA_HECTARE")
	private BigDecimal totalAreaHectare;

	public OccupancyDBO() {
	}

	public long getContactPointId() {
		return this.contactPointId;
	}

	public void setContactPointId(long contactPointId) {
		this.contactPointId = contactPointId;
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

	public long getMainLocationFlag() {
		return this.mainLocationFlag;
	}

	public void setMainLocationFlag(long mainLocationFlag) {
		this.mainLocationFlag = mainLocationFlag;
	}

	public Date getOccupancyEndDate() {
		return this.occupancyEndDate;
	}

	public void setOccupancyEndDate(Date occupancyEndDate) {
		this.occupancyEndDate = occupancyEndDate;
	}

	public Date getOccupancyStartDate() {
		return this.occupancyStartDate;
	}

	public void setOccupancyStartDate(Date occupancyStartDate) {
		this.occupancyStartDate = occupancyStartDate;
	}

	public BigDecimal getOwnedAreaHectare() {
		return this.ownedAreaHectare;
	}

	public void setOwnedAreaHectare(BigDecimal ownedAreaHectare) {
		this.ownedAreaHectare = ownedAreaHectare;
	}

	public String getPreviousOccupier() {
		return this.previousOccupier;
	}

	public void setPreviousOccupier(String previousOccupier) {
		this.previousOccupier = previousOccupier;
	}

	public BigDecimal getTenantedAreaHectare() {
		return this.tenantedAreaHectare;
	}

	public void setTenantedAreaHectare(BigDecimal tenantedAreaHectare) {
		this.tenantedAreaHectare = tenantedAreaHectare;
	}

	public BigDecimal getTotalAreaHectare() {
		return this.totalAreaHectare;
	}

	public void setTotalAreaHectare(BigDecimal totalAreaHectare) {
		this.totalAreaHectare = totalAreaHectare;
	}

	public BaseTable getBaseTable() {
		return baseTable;
	}

	public void setBaseTable(BaseTable baseTable) {
		this.baseTable = baseTable;
	}

	public OccupancyPK getPk() {
		return pk;
	}

	public void setPk(OccupancyPK pk) {
		this.pk = pk;
	}

	public long getBrn() {
		return this.getPk().getBrn();
	}

	public void setBrn(long brn) {
		this.getPk().setBrn(brn);
	}

	public long getLocationId() {
		return this.getPk().getLocationId();
	}

	public void setLocationId(long locationId) {
		this.getPk().setLocationId(locationId);
	}

}