package uk.gov.scotland.afrc.applications.model.domain;

import java.io.Serializable;
import java.math.BigDecimal;

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
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Version;

import uk.gov.scotland.afrc.applications.model.base.BaseTable;
import uk.gov.scotland.afrc.applications.model.base.BaseTableAware;
import uk.gov.scotland.afrc.applications.model.base.BaseTableListener;

/**
 * The persistent class for the CLAIM database table.
 * 
 */
@Entity
@Table(name = "CLAIM")
@EntityListeners(BaseTableListener.class)
@NamedQueries(
    value = {
            @NamedQuery(
                name = "ClaimDBO.findByApplicationAndParcelId",
                query = "SELECT c FROM ClaimDBO c, AppLndPrclDBO a WHERE c.applicationId = :appId AND c.appLndPrclId = :appLndPrclId order by c.isAddedFlag, c.claimId"),
            @NamedQuery(
                name = "ClaimDBO.findByApplicationAndShareId",
                query = "SELECT c FROM ClaimDBO c, AppLndPrclDBO a WHERE c.applicationId = :appId AND c.appCgShareId = :appCgShareId order by c.isAddedFlag, c.claimId"),
            @NamedQuery(name = "ClaimDBO.findByApplicationId",
                query = "SELECT c FROM ClaimDBO c, AppLndPrclDBO a WHERE c.applicationId = :applicationId"),
            @NamedQuery(
                name = "ClaimDBO.removeByApplicationIdAndAppLndParcelId",
                query = "DELETE FROM ClaimDBO claim where claim.applicationId = :applicationId AND claim.appLndPrclId = :appLndPrclId"),
            @NamedQuery(name = "ClaimDBO.findByApplicationIdAndSchemeId",
                query = "SELECT c, alp, so FROM ClaimDBO c JOIN c.schemeOption so LEFT OUTER JOIN c.appLndPrcl alp "
                    + "WHERE c.schemeOptionId = so.schemeOptionId " + "AND so.schemeId IN :schemeIds "
                    + "AND c.applicationId = :applicationId "),
            @NamedQuery(
                name = "ClaimDBO.findPreviousYearClaimsByLandParcel",
                query = "SELECT c, si, ari FROM ClaimDBO c ,ScheduleItemDBO si, SchemeDBO s, SchemeOptionDBO so, AnnualRecurrentItemDBO ari "
                    + " where si.schemeOptId = so.schemeOptionId AND so.schemeId = s.schemeId "
                    + " AND c.applicationId= si.application.applicationId AND ari.scheduleItem.scheduleItemId = si.scheduleItemId "
                    + " AND c.applicationId=:applicationId AND c.lpisLndPrclId=:lpisLndPrclId AND c.schemeOptionId=so.schemeOptionId "
                    + " AND s.schemeName = :scheme AND ari.endDate >= :endDate"),
            @NamedQuery(
                name = "ClaimDBO.findPreviousYearClaims",
                query = "SELECT c, si, ari FROM ClaimDBO c ,ScheduleItemDBO si, SchemeDBO s, SchemeOptionDBO so, AnnualRecurrentItemDBO ari, ContractDBO con "
                    + " where si.schemeOptId = so.schemeOptionId AND so.schemeId = s.schemeId "
                    + " AND ari.scheduleItem.scheduleItemId = si.scheduleItemId "
                    + " AND c.applicationId=:applicationId AND c.schemeOptionId=so.schemeOptionId "
                    + " AND con.managedBrn=:brn AND con.contractId=si.contractId "
                    + " AND s.schemeName = :scheme AND ari.endDate >= :endDate") })
public class ClaimDBO implements Serializable, BaseTableAware {
    private static final long serialVersionUID = 1L;

    @Embedded
    private BaseTable baseTable;

    @Id
    @Column(name = "CLAIM_ID")
    @SequenceGenerator(name = "CLAIM_SEQ_GENERATOR", sequenceName = "CLAIM_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CLAIM_SEQ_GENERATOR")
    private long claimId;

    @Column(name = "APPLICATION_ID")
    private long applicationId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "SCHEME_OPT_ID")
    private SchemeOptionDBO schemeOption;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "APP_LND_PRCL_ID")
    private AppLndPrclDBO appLndPrcl;

    @Column(name = "SCHEME_OPT_ID")
    private long schemeOptionId;

    @Column(name = "APP_LND_PRCL_ID")
    private Long appLndPrclId;

    @Column(name = "APP_CG_SHARE_ID")
    private Long appCgShareId;

    public AppLndPrclDBO getAppLndPrcl() {
        return appLndPrcl;
    }

    public void setAppLndPrcl(AppLndPrclDBO appLndPrcl) {
        this.appLndPrcl = appLndPrcl;
    }

    public void setAddedFlag(boolean isAddedFlag) {
        this.isAddedFlag = isAddedFlag;
    }

    @Column(name = "RECLAIMED_FLAG", columnDefinition = "DECIMAL(1,0)")
    private boolean claimStatus;

    @Column(name = "IS_ADDED_FLAG", columnDefinition = "DECIMAL(1,0)")
    private boolean isAddedFlag;

    @Column(name = "JPA_VERSION_NUMBER")
    @Version
    private Long jpaVersionNumber;

    @Column(name = "LPIS_LND_PRCL_ID")
    private Long lpisLndPrclId;

    @Column(name = "UNITS_AGREED")
    private BigDecimal unitsAgreed;

    @Column(name = "UNITS_UNDERTAKEN")
    private BigDecimal unitsUndertaken;

    @Column(name = "PRCL_ID")
    private String parcelIdentifier;

    /**
     * @return the parcelIdentifier
     */
    public String getParcelIdentifier() {
        return parcelIdentifier;
    }

    /**
     * @param parcelIdentifier the parcelIdentifier to set
     */
    public void setParcelIdentifier(String parcelIdentifier) {
        this.parcelIdentifier = parcelIdentifier;
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

    public ClaimDBO() {
    }

    public long getClaimId() {
        return this.claimId;
    }

    public void setClaimId(long claimId) {
        this.claimId = claimId;
    }

    public long getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(long applicationId) {
        this.applicationId = applicationId;
    }

    public boolean getClaimStatus() {
        return this.claimStatus;
    }

    public void setClaimStatus(boolean claimStatus) {
        this.claimStatus = claimStatus;
    }

    public boolean getIsAddedFlag() {
        return this.isAddedFlag;
    }

    public void setIsAddedFlag(boolean isAddedFlag) {
        this.isAddedFlag = isAddedFlag;
    }

    public Long getJpaVersionNumber() {
        return this.jpaVersionNumber;
    }

    public void setJpaVersionNumber(Long jpaVersionNumber) {
        this.jpaVersionNumber = jpaVersionNumber;
    }

    public Long getLpisLndPrclId() {
        return this.lpisLndPrclId;
    }

    public void setLpisLndPrclId(Long lpisLndPrclId) {
        this.lpisLndPrclId = lpisLndPrclId;
    }

    public BigDecimal getUnitsAgreed() {
        return unitsAgreed;
    }

    public void setUnitsAgreed(BigDecimal unitsAgreed) {
        this.unitsAgreed = unitsAgreed;
    }

    public BigDecimal getUnitsUndertaken() {
        return unitsUndertaken;
    }

    public void setUnitsUndertaken(BigDecimal unitsUndertaken) {
        this.unitsUndertaken = unitsUndertaken;
    }

    public SchemeOptionDBO getSchemeOption() {
        return schemeOption;
    }

    public void setSchemeOption(SchemeOptionDBO schemeOption) {
        this.schemeOption = schemeOption;
    }

    public long getSchemeOptionId() {
        return schemeOptionId;
    }

    public void setSchemeOptionId(long schemeOptionId) {
        this.schemeOptionId = schemeOptionId;
    }

    public Long getAppLndPrclId() {
        return appLndPrclId;
    }

    public void setAppLndPrclId(Long appLndPrclId) {
        this.appLndPrclId = appLndPrclId;
    }

    public Long getAppCgShareId() {
        return appCgShareId;
    }

    public void setAppCgShareId(Long appCgShareId) {
        this.appCgShareId = appCgShareId;
    }
}