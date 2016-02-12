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
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Version;

import uk.gov.scotland.afrc.applications.model.base.BaseTable;
import uk.gov.scotland.afrc.applications.model.base.BaseTableAware;
import uk.gov.scotland.afrc.applications.model.base.BaseTableListener;
import uk.gov.scotland.afrc.applications.model.base.LandUseAreaAware;

@Entity
@Table(name = "CG_SHARE_LND_USE_AREA")
@EntityListeners(BaseTableListener.class)
@NamedQueries(
    value = {
            @NamedQuery(
                name = "CgShareLndUseArea.findByApplicationId",
                query = "SELECT a FROM CgShareLndUseAreaDBO a WHERE a.applicationCommonGrazingShare.applicationCommonGrazing.applicationId = :applicationId AND a.applicationCommonGrazingShare.isConfirmedFlag = :isConfirmed"),
            @NamedQuery(name = "CgShareLndUseArea.findByAppCGShareId",
                query = "SELECT a FROM CgShareLndUseAreaDBO a WHERE a.appCGShareId = :appCGShareId") })
public class CgShareLndUseAreaDBO implements Serializable, BaseTableAware, LandUseAreaAware {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "CG_SHARE_LND_USE_AREA_ID")
    @SequenceGenerator(name = "CG_SHARE_LND_USE_AREA_SEQ_GENERATOR", sequenceName = "CG_SHARE_LND_USE_AREA_SEQ",
        allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CG_SHARE_LND_USE_AREA_SEQ_GENERATOR")
    private long cgShareLndUseAreaId;

    @Column(name = "JPA_VERSION_NUMBER")
    @Version
    private Long jpaVersionNumber;

    @Embedded
    private BaseTable baseTable;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "APP_CG_SHARE_ID", nullable = false)
    private ApplicationCommonGrazingShareDBO applicationCommonGrazingShare;

    @Column(name = "APP_CG_SHARE_ID")
    private Long appCGShareId;

    @Column(name = "AREA_AMT")
    private BigDecimal areaAmt;

    @Column(name = "LFA_CLASS_FLAG")
    private boolean lfaClassFlag;

    @Column(name = "LND_USE_TYPE_CODE")
    private Long lndUseTypeCode;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "LND_USE_TYPE_CODE")
    private LandUseTypeDBO landUseType;

    @Column(name = "PAYMENT_REGION_ID")
    private Long paymentRegionId;

    @Column(name = "APPLICATION_ID")
    private long applicationId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "APPLICATION_ID")
    private ApplicationDBO application;

    @OneToMany(mappedBy = "cgShareLndUseArea", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<CgShareClaimDBO> cgShareClaims;

    public long getCgShareLndUseAreaId() {
        return cgShareLndUseAreaId;
    }

    public void setCgShareLndUseAreaId(long cgShareLndUseAreaId) {
        this.cgShareLndUseAreaId = cgShareLndUseAreaId;
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

    public BigDecimal getAreaAmt() {
        return areaAmt;
    }

    public void setAreaAmt(BigDecimal areaAmt) {
        this.areaAmt = areaAmt;
    }

    public boolean isLfaClassFlag() {
        return lfaClassFlag;
    }

    public void setLfaClassFlag(boolean lfaClassFlag) {
        this.lfaClassFlag = lfaClassFlag;
    }

    public Long getLndUseTypeCode() {
        return lndUseTypeCode;
    }

    public void setLndUseTypeCode(Long lndUseTypeCode) {
        this.lndUseTypeCode = lndUseTypeCode;
    }

    public Long getPaymentRegionId() {
        return paymentRegionId;
    }

    public void setPaymentRegionId(Long paymentRegionId) {
        this.paymentRegionId = paymentRegionId;
    }

    public List<CgShareClaimDBO> getCgShareClaims() {
        return cgShareClaims;
    }

    public void setCgShareClaims(List<CgShareClaimDBO> cgShareClaims) {
        this.cgShareClaims = cgShareClaims;
    }

    public String toString() {
        return "CgShareLndUseAreaDBO [cgShareLndUseAreaId=" + cgShareLndUseAreaId + ", baseTable=" + baseTable
            + ", appCgShareId=" + applicationCommonGrazingShare + ", areaAmt=" + areaAmt + ", lfaClassFlag="
            + lfaClassFlag + ", lndUseTypeCode=" + lndUseTypeCode + ", paymentRegionId=" + paymentRegionId
            + ", cgShareClaims=" + cgShareClaims + "]";
    }

    public ApplicationCommonGrazingShareDBO getApplicationCommonGrazingShare() {
        return applicationCommonGrazingShare;
    }

    public void setApplicationCommonGrazingShare(ApplicationCommonGrazingShareDBO applicationCommonGrazingShare) {
        this.applicationCommonGrazingShare = applicationCommonGrazingShare;
    }

    public Long getAppCGShareId() {
        return appCGShareId;
    }

    public void setAppCGShareId(Long appCGShareId) {
        this.appCGShareId = appCGShareId;
    }

    public boolean isLfa() {
        return getApplicationCommonGrazingShare().getApplicationCommonGrazing().isLfaClassFlag();
    }

    public BigDecimal getAreaAmount() {
        return getAreaAmt();
    }

    public LandUseTypeDBO getLandUseType() {
        return landUseType;
    }

    public void setLandUseType(LandUseTypeDBO landUseType) {
        this.landUseType = landUseType;
    }

    public long getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(long applicationId) {
        this.applicationId = applicationId;
    }

    public ApplicationDBO getApplication() {
        return application;
    }

    public void setApplication(ApplicationDBO application) {
        this.application = application;
    }
}
