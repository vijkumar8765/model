package uk.gov.scotland.afrc.applications.model.domain;

import java.io.Serializable;
import java.math.BigDecimal;

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
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import uk.gov.scotland.afrc.applications.model.base.BaseTable;
import uk.gov.scotland.afrc.applications.model.base.BaseTableAware;
import uk.gov.scotland.afrc.applications.model.base.BaseTableListener;
import uk.gov.scotland.afrc.applications.model.base.LandUseClaimAware;

/**
 * The persistent class for the LAND_USE_CLAIM database table.
 * 
 */
@Entity
@Table(name = "LAND_USE_CLAIM")
@EntityListeners(BaseTableListener.class)
@NamedQueries({
        @NamedQuery(name = "LandUseClaim.findByLandUseAreaAndScheme",
            query = "SELECT luc FROM LandUseClaimDBO luc where luc.landUseArea = :landUseArea and luc.scheme = :scheme"),
        @NamedQuery(name = "LandUseClaim.removeByLandUseArea",
            query = "DELETE FROM LandUseClaimDBO luc where luc.landUseArea = :landUseArea"),
        @NamedQuery(name = "LandUseClaim.removeByLandUseAreaAndScheme",
            query = "DELETE FROM LandUseClaimDBO luc where luc.landUseArea = :landUseArea and luc.scheme = :scheme"),
        @NamedQuery(
            name = "LandUseClaim.findBySchemeAndApplicationId",
            query = "SELECT luc FROM LandUseClaimDBO luc where luc.scheme.schemeId = :schemeId and luc.landUseArea.applicationId = :applicationId and luc.landUseArea.applicationLandParcel.isConfirmedFlag = :isConfirmed"),
        @NamedQuery(
            name = "LandUseClaim.findByLandUseAreaId",
            query = "SELECT luc FROM LandUseClaimDBO luc where luc.landUseArea.lndUseAreaId = :lndUseAreaId")

})
public class LandUseClaimDBO implements Serializable, BaseTableAware, LandUseClaimAware {

    private static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name = "LAND_USE_CLAIM_GENERATOR", sequenceName = "LAND_USE_CLAIM_SEQ", allocationSize = 1,
        initialValue = 100)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "LAND_USE_CLAIM_GENERATOR")
    @Column(name = "LND_USE_CLAIM_ID")
    private long landUseClaimIdentifier;

    @Embedded
    private BaseTable baseTable;

    @Column(name = "AREA_AMT")
    private BigDecimal areaAmt;

    @Column(name = "JPA_VERSION_NUMBER")
    private long jpaVersionNumber;

    @ManyToOne
    @JoinColumn(name = "LND_USE_AREA_ID")
    private LandUseAreaDBO landUseArea;

    @OneToOne
    @JoinColumn(name = "SCHEME_ID")
    private SchemeDBO scheme;

    public SchemeDBO getScheme() {
        return scheme;
    }

    public void setScheme(SchemeDBO scheme) {
        this.scheme = scheme;
    }

    public LandUseClaimDBO() {
    }

    public long getLandUseClaimIdentifier() {
        return this.landUseClaimIdentifier;
    }

    public void setLandUseClaimIdentifier(long landUseClaimIdentifier) {
        this.landUseClaimIdentifier = landUseClaimIdentifier;
    }

    public BigDecimal getAreaAmt() {
        return this.areaAmt;
    }

    public void setAreaAmt(BigDecimal areaAmt) {
        this.areaAmt = areaAmt;
    }

    public long getJpaVersionNumber() {
        return this.jpaVersionNumber;
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

    public LandUseAreaDBO getLandUseArea() {
        return landUseArea;
    }

    public void setLandUseArea(LandUseAreaDBO landUseArea) {
        this.landUseArea = landUseArea;
    }

    @Override
    public BigDecimal getClaimedArea() {
        BigDecimal claimedArea = getAreaAmt();
        if (claimedArea == null) {
            claimedArea = BigDecimal.ZERO;
        }
        return claimedArea;
    }

    @Override
    public LandUseTypeDBO getLandUseType() {
        return getLandUseArea().getLandUseType();
    }

    @Override
    public BigDecimal getLandUseAreaAmount() {
        return getLandUseArea().getAreaAmount();
    }

    @Override
    public Long getLandUseAreaPK() {
        return getLandUseArea().getLndUseAreaId();
    }
    
    
}