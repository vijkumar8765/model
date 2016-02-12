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
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Version;

import uk.gov.scotland.afrc.applications.model.base.BaseTable;
import uk.gov.scotland.afrc.applications.model.base.BaseTableAware;
import uk.gov.scotland.afrc.applications.model.base.BaseTableListener;
import uk.gov.scotland.afrc.applications.model.base.LandUseClaimAware;

@Entity
@Table(name = "CG_SHARE_CLAIM")
@EntityListeners(BaseTableListener.class)
@NamedQueries({ @NamedQuery(
    name = "CgShareClaim.findBySchemeAndApplicationId",
            query = "SELECT cgs FROM CgShareClaimDBO cgs where cgs.schemeId = :schemeId and cgs.cgShareLndUseArea.applicationCommonGrazingShare.isConfirmedFlag = :isConfirmed and cgs.cgShareLndUseArea.applicationCommonGrazingShare.applicationCommonGrazing.applicationId = :applicationId"),
        @NamedQuery(name = "CgShareClaimDBO.removeByCGLandUseArea",
            query = "DELETE FROM CgShareClaimDBO cgsc where cgsc.cgShareLndUseArea = :cgShareLandUseArea"),

})
public class CgShareClaimDBO implements Serializable, BaseTableAware, LandUseClaimAware {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "CG_SHARE_CLAIM_ID")
    @SequenceGenerator(name = "CG_SHARE_CLAIM_SEQ_GENERATOR", sequenceName = "CG_SHARE_CLAIM_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CG_SHARE_CLAIM_SEQ_GENERATOR")
    private long cgShareClaimId;

    @Column(name = "JPA_VERSION_NUMBER")
    @Version
    private Long jpaVersionNumber;

    @Embedded
    private BaseTable baseTable;

    @ManyToOne
    @JoinColumn(name = "CG_SHARE_LND_USE_AREA_ID")
    private CgShareLndUseAreaDBO cgShareLndUseArea;

    @Column(name = "CLAIMED_AREA")
    private BigDecimal claimedArea;

    @Column(name = "SCHEME_ID")
    private Long schemeId;

    public long getCgShareClaimId() {
        return cgShareClaimId;
    }

    public void setCgShareClaimId(long cgShareClaimId) {
        this.cgShareClaimId = cgShareClaimId;
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

    public CgShareLndUseAreaDBO getCgShareLndUseArea() {
        return cgShareLndUseArea;
    }

    public void setCgShareLndUseArea(CgShareLndUseAreaDBO cgShareLndUseArea) {
        this.cgShareLndUseArea = cgShareLndUseArea;
    }

    public BigDecimal getClaimedArea() {
        return claimedArea;
    }

    public void setClaimedArea(BigDecimal claimedArea) {
        this.claimedArea = claimedArea;
    }

    public Long getSchemeId() {
        return schemeId;
    }

    public void setSchemeId(Long schemeId) {
        this.schemeId = schemeId;
    }

    public String toString() {
        return "CgShareClaimDBO [cgShareClaimId=" + cgShareClaimId + ", baseTable=" + baseTable
            + ", cgShareLndUseArea=" + cgShareLndUseArea + ", claimedArea=" + claimedArea + ", schemeId=" + schemeId
            + "]";
    }

    @Override
    public LandUseTypeDBO getLandUseType() {
        return getCgShareLndUseArea().getLandUseType();
    }

    @Override
    public BigDecimal getLandUseAreaAmount() {
        return getCgShareLndUseArea().getAreaAmount();
    }

    @Override
    public Long getLandUseAreaPK() {
        return getCgShareLndUseArea().getCgShareLndUseAreaId();
    }
}
