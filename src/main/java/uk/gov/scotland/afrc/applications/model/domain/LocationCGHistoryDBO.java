package uk.gov.scotland.afrc.applications.model.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import uk.gov.scotland.afrc.applications.model.base.BaseTable;
import uk.gov.scotland.afrc.applications.model.base.BaseTableListener;

@Entity
@Table(name = "LOCATION_HISTORY")
@EntityListeners(BaseTableListener.class)
@NamedQuery(name = "LocationCGHistory.findByLocationCgId", query = "SELECT c FROM LocationCGHistoryDBO c")
public class LocationCGHistoryDBO implements Serializable, uk.gov.scotland.afrc.applications.model.base.BaseTableAware {

    private static final long serialVersionUID = 1L;

    @Embedded
    private BaseTable baseTable;

    @Id
    @Column(name = "LOCATION_CG_HISTORY_ID")
    @SequenceGenerator(name = "LOCATION_CG_HISTORY_SEQ_GENERATOR", sequenceName = "LOCATION_CG_HISTORY_SEQ",
        allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "LOCATION_CG_HISTORY_SEQ_GENERATOR")
    private long locationCGHistoryId;

    @Column(name = "JPA_VERSION_NUMBER")
    private BigDecimal jpaVersionNumber;

    @Column(name = "LOCATION_ID", nullable = false)
    private long locationId;

    @Column(name = "LOCATION_CODE")
    private String locationCode;

    @Column(name = "LOCATION_NAME")
    private String locationName;

    @Column(name = "GROSS_CG_AREA")
    private BigDecimal grossCGArea;

    @Column(name = "GROSS_INELIGIBLE_AREA")
    private BigDecimal grossIneligibleArea;

    @Column(name = "GROSS_BPS_ELIGIBLE_AREA")
    private BigDecimal grossBPSEligibleArea;

    @Column(name = "TOTAL_SHEEP_EQUIVALENT")
    private long totSheepEquivalent;

    @Column(name = "LAST_UPDATED_BY_NAME")
    private String changedBy;

    @Column(name = "EFFECTIVE_DATE")
    private Date effectiveDate;

    public BigDecimal getJpaVersionNumber() {
        return jpaVersionNumber;
    }

    public void setJpaVersionNumber(BigDecimal jpaVersionNumber) {
        this.jpaVersionNumber = jpaVersionNumber;
    }

    public long getLocationId() {
        return locationId;
    }

    public void setLocationId(long locationId) {
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

    public BigDecimal getGrossCGArea() {
        return grossCGArea;
    }

    public void setGrossCGArea(BigDecimal grossCGArea) {
        this.grossCGArea = grossCGArea;
    }

    public BigDecimal getGrossIneligibleArea() {
        return grossIneligibleArea;
    }

    public void setGrossIneligibleArea(BigDecimal grossIneligibleArea) {
        this.grossIneligibleArea = grossIneligibleArea;
    }

    public BigDecimal getGrossBPSEligibleArea() {
        return grossBPSEligibleArea;
    }

    public void setGrossBPSEligibleArea(BigDecimal grossBPSEligibleArea) {
        this.grossBPSEligibleArea = grossBPSEligibleArea;
    }

    public long getTotSheepEquivalent() {
        return totSheepEquivalent;
    }

    public void setTotSheepEquivalent(long totSheepEquivalent) {
        this.totSheepEquivalent = totSheepEquivalent;
    }

    public String getChangedBy() {
        return changedBy;
    }

    public void setChangedBy(String changedBy) {
        this.changedBy = changedBy;
    }

    public Date getEffectiveDate() {
        return effectiveDate;
    }

    public void setEffectiveDate(Date effectiveDate) {
        this.effectiveDate = effectiveDate;
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
