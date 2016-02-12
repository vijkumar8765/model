package uk.gov.scotland.afrc.applications.model.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Version;

import uk.gov.scotland.afrc.applications.model.base.BaseTable;
import uk.gov.scotland.afrc.applications.model.base.BaseTableAware;
import uk.gov.scotland.afrc.applications.model.base.BaseTableListener;

/**
 * The persistent class for the APP_COMMON_GRAZING database table.
 * 
 */
@Entity
@Table(name = "APP_COMMON_GRAZING")
@EntityListeners(BaseTableListener.class)
@NamedQueries(
    value = {
            @NamedQuery(name = "ApplicationCommonGrazing.findByApplicationId",
                query = "SELECT a FROM ApplicationCommonGrazingDBO a WHERE a.applicationId = :applicationId"),
            @NamedQuery(
                name = "ApplicationCommonGrazing.getByAppIdAndLocationId",
                query = "SELECT a FROM ApplicationCommonGrazingDBO a, LocationCommonGrazingDBO l WHERE a.applicationId = :appId AND a.locationIdCg = :locationId"),
            @NamedQuery(name = "ApplicationCommonGrazing.findByLocationId",
                query = "SELECT a FROM ApplicationCommonGrazingDBO a WHERE a.locationIdCg = :locationId") })
public class ApplicationCommonGrazingDBO implements Serializable, BaseTableAware {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "APP_CG_ID")
    @SequenceGenerator(name = "APP_CG_SEQ_GENERATOR", sequenceName = "APP_CG_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "APP_CG_SEQ_GENERATOR")
    private long appCgId;

    @Column(name = "LOCATION_CG_TSE")
    private BigDecimal appSheepEquivalent;

    @Column(name = "APPLICATION_ID")
    private Long applicationId;

    @Column(name = "BPS_ELIGIBLE_AREA")
    private BigDecimal bpsEligibleArea;

    @Column(name = "GROSS_AREA")
    private BigDecimal grossArea;

    @Column(name = "IS_ADDED_FLAG")
    private boolean isAddedFlag;

    @Column(name = "IS_REMOVED_FLAG")
    private boolean isRemovedFlag;

    @Column(name = "IS_VERIFIED_FLAG")
    private boolean isVerifiedFlag;

    @Column(name = "JPA_VERSION_NUMBER")
    @Version
    private Long jpaVersionNumber;

    @Column(name = "LFA_CLASS_FLAG")
    private boolean lfaClassFlag;

    @Column(name = "LOCATION_ID_CG")
    private Long locationIdCg;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "LOCATION_ID_CG")
    private CustomerLocationDBO locationCg;

    @OneToMany(mappedBy = "applicationCommonGrazing", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @OrderBy("shareCroftName")
    private List<ApplicationCommonGrazingShareDBO> appCgShares;

    public void setAddedFlag(boolean isAddedFlag) {
        this.isAddedFlag = isAddedFlag;
    }

    public void setRemovedFlag(boolean isRemovedFlag) {
        this.isRemovedFlag = isRemovedFlag;
    }

    public void setVerifiedFlag(boolean isVerifiedFlag) {
        this.isVerifiedFlag = isVerifiedFlag;
    }

    public List<ApplicationCommonGrazingShareDBO> getAppCgShares() {
        return appCgShares;
    }

    public void setAppCgShares(List<ApplicationCommonGrazingShareDBO> appCgShares) {
        this.appCgShares = appCgShares;
    }

    @Embedded
    private BaseTable baseTable;

    public BaseTable getBaseTable() {
        if (baseTable == null) {
            baseTable = new BaseTable();
        }

        return baseTable;
    }

    public void setBaseTable(BaseTable baseTable) {
        this.baseTable = baseTable;
    }

    public ApplicationCommonGrazingDBO() {
    }

    public long getAppCgId() {
        return this.appCgId;
    }

    public void setAppCgId(long appCgId) {
        this.appCgId = appCgId;
    }

    public BigDecimal getAppSheepEquivalent() {
        return this.appSheepEquivalent;
    }

    public void setAppSheepEquivalent(BigDecimal appSheepEquivalent) {
        this.appSheepEquivalent = appSheepEquivalent;
    }

    public Long getApplicationId() {
        return this.applicationId;
    }

    public void setApplicationId(Long applicationId) {
        this.applicationId = applicationId;
    }

    public BigDecimal getBpsEligibleArea() {
        if (null == this.bpsEligibleArea) {
            setBpsEligibleArea(BigDecimal.ZERO);
        }
        return this.bpsEligibleArea;
    }

    public void setBpsEligibleArea(BigDecimal bpsEligibleArea) {
        this.bpsEligibleArea = bpsEligibleArea;
    }

    public BigDecimal getGrossArea() {
        if (null == this.grossArea) {
            setGrossArea(BigDecimal.ZERO);
        }
        return this.grossArea;
    }

    public void setGrossArea(BigDecimal grossArea) {
        this.grossArea = grossArea;
    }

    public boolean getIsAddedFlag() {
        return this.isAddedFlag;
    }

    public void setIsAddedFlag(boolean isAddedFlag) {
        this.isAddedFlag = isAddedFlag;
    }

    public boolean getIsRemovedFlag() {
        return this.isRemovedFlag;
    }

    public void setIsRemovedFlag(boolean isRemovedFlag) {
        this.isRemovedFlag = isRemovedFlag;
    }

    public boolean getIsVerifiedFlag() {
        return this.isVerifiedFlag;
    }

    public void setIsVerifiedFlag(boolean isVerifiedFlag) {
        this.isVerifiedFlag = isVerifiedFlag;
    }

    public Long getJpaVersionNumber() {
        return this.jpaVersionNumber;
    }

    public void setJpaVersionNumber(Long jpaVersionNumber) {
        this.jpaVersionNumber = jpaVersionNumber;
    }

    public boolean isLfaClassFlag() {
        return lfaClassFlag;
    }

    public void setLfaClassFlag(boolean lfaClassFlag) {
        this.lfaClassFlag = lfaClassFlag;
    }

    public Long getLocationIdCg() {
        return locationIdCg;
    }

    public void setLocationIdCg(Long locationIdCg) {
        this.locationIdCg = locationIdCg;
    }
}