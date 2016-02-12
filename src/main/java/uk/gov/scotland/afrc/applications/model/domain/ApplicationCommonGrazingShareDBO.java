package uk.gov.scotland.afrc.applications.model.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

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

/**
 * The persistent class for the APP_CG_SHARE database table.
 * 
 */
@Entity
@Table(name = "APP_CG_SHARE")
@EntityListeners(BaseTableListener.class)
@NamedQueries(
    value = {
            @NamedQuery(name = "AppCgShareBDO.findByAppCG",
                query = "SELECT a FROM ApplicationCommonGrazingShareDBO a WHERE a.applicationCommonGrazing = :appCg"),
            @NamedQuery(
                name = "AppCgShareBDO.getActiveSharesByAppCG",
                query = "SELECT a FROM ApplicationCommonGrazingShareDBO a WHERE a.applicationCommonGrazing = :appCg AND a.isRemovedFlag = FALSE"),
            @NamedQuery(
                name = "AppCgShareBDO.getShareByCGAndCroft",
                query = "SELECT a FROM ApplicationCommonGrazingShareDBO a WHERE a.applicationCommonGrazing = :appCg AND a.appCgCroftId = :appCgCroftId"),
            @NamedQuery(
                name = "AppCgShareBDO.getShareByCGAndCroftAndName",
                query = "SELECT a FROM ApplicationCommonGrazingShareDBO a WHERE a.applicationCommonGrazing = :appCg AND a.appCgCroftId = :appCgCroftId AND a.shareCroftName = :shareName"),
            @NamedQuery(
                name = "AppCgShareBDO.getShareByCGAndCroftName",
                query = "SELECT a FROM ApplicationCommonGrazingShareDBO a WHERE a.applicationCommonGrazing = :appCg AND a.shareCroftName = :shareName") })
public class ApplicationCommonGrazingShareDBO implements Serializable, BaseTableAware {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "APP_CG_SHARE_ID")
    @SequenceGenerator(name = "APP_CG_SHARE_SEQ_GENERATOR", sequenceName = "APP_CG_SHARE_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "APP_CG_SHARE_SEQ_GENERATOR")
    private long appCgShareId;

    @Column(name = "APP_CG_CROFT_ID")
    private Long appCgCroftId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "LND_USE_ACTIVITY_TYPE_CODE")
    private LandUseActivityTypeDBO landUseActivityTypeDBO;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "APP_CG_ID", nullable = false)
    private ApplicationCommonGrazingDBO applicationCommonGrazing;

    @OneToMany(mappedBy = "applicationCommonGrazingShare", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<CgShareLndUseAreaDBO> cgShareLndUseAreaDBO;

    @Column(name = "APP_CROFT_SHARE_AREA")
    private BigDecimal appCroftShareArea;

    @Column(name = "APP_TOT_SHEEP_EQUIVALENT")
    private BigDecimal appTotSheepEquivalent;

    @Column(name = "IS_ADDED_FLAG")
    private boolean isAddedFlag;

    @Column(name = "IS_CONFIRMED_FLAG")
    private boolean isConfirmedFlag;

    @Column(name = "IS_REMOVED_FLAG")
    private boolean isRemovedFlag;

    @Column(name = "IS_SHAREHOLDER_FLAG")
    private boolean isShareholderFlag;

    @Column(name = "IS_VERIFIED_FLAG")
    private boolean isVerifiedFlag;

    @Column(name = "USE_LND_PART_ORGANIC_FLAG")
    private Boolean partialOrganicFlag;

    @Column(name = "SHARE_CROFT_NAME")
    private String shareCroftName;

    @Column(name = "JPA_VERSION_NUMBER")
    @Version
    private Long jpaVersionNumber;

    @Embedded
    private BaseTable baseTable;

    @OneToMany(mappedBy = "commonGrazingShare", cascade = { CascadeType.ALL }, fetch = FetchType.LAZY)
    private Set<AppValidationErrDBO> validationErrors;

    public Set<AppValidationErrDBO> getValidationErrors() {
        return validationErrors;
    }

    public void setValidationErrors(Set<AppValidationErrDBO> validationErrors) {
        this.validationErrors = validationErrors;
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

    public ApplicationCommonGrazingShareDBO() {
    }

    public long getAppCgShareId() {
        return this.appCgShareId;
    }

    public void setAppCgShareId(long appCgShareId) {
        this.appCgShareId = appCgShareId;
    }

    public Long getAppCgCroftId() {
        return this.appCgCroftId;
    }

    public void setAppCgCroftId(Long appCgCroftId) {
        this.appCgCroftId = appCgCroftId;
    }

    public BigDecimal getAppCroftShareArea() {
        return this.appCroftShareArea;
    }

    public void setAppCroftShareArea(BigDecimal appCroftShareArea) {
        this.appCroftShareArea = appCroftShareArea;
    }

    public BigDecimal getAppTotSheepEquivalent() {
        return this.appTotSheepEquivalent;
    }

    public void setAppTotSheepEquivalent(BigDecimal appTotSheepEquivalent) {
        this.appTotSheepEquivalent = appTotSheepEquivalent;
    }

    public boolean isAddedFlag() {
        return this.isAddedFlag;
    }

    public void setIsAddedFlag(boolean isAddedFlag) {
        this.isAddedFlag = isAddedFlag;
    }

    public boolean isConfirmedFlag() {
        return this.isConfirmedFlag;
    }

    public void setIsConfirmedFlag(boolean isConfirmedFlag) {
        this.isConfirmedFlag = isConfirmedFlag;
    }

    public boolean isRemovedFlag() {
        return this.isRemovedFlag;
    }

    public void setIsRemovedFlag(boolean isRemovedFlag) {
        this.isRemovedFlag = isRemovedFlag;
    }

    public boolean isShareholderFlag() {
        return this.isShareholderFlag;
    }

    public void setIsShareholderFlag(boolean isShareholderFlag) {
        this.isShareholderFlag = isShareholderFlag;
    }

    public boolean isVerifiedFlag() {
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

    public String getShareCroftName() {
        return this.shareCroftName;
    }

    public void setShareCroftName(String shareCroftName) {
        this.shareCroftName = shareCroftName;
    }

    public ApplicationCommonGrazingDBO getApplicationCommonGrazing() {
        return applicationCommonGrazing;
    }

    public void setApplicationCommonGrazing(ApplicationCommonGrazingDBO applicationCommonGrazing) {
        this.applicationCommonGrazing = applicationCommonGrazing;
    }

    public void setConfirmedFlag(boolean isConfirmedFlag) {
        this.isConfirmedFlag = isConfirmedFlag;
    }

    public List<CgShareLndUseAreaDBO> getCgShareLndUseAreaDBO() {
        return cgShareLndUseAreaDBO;
    }

    public void setCgShareLndUseAreaDBO(List<CgShareLndUseAreaDBO> cgShareLndUseAreaDBO) {
        this.cgShareLndUseAreaDBO = cgShareLndUseAreaDBO;
    }

    public LandUseActivityTypeDBO getLandUseActivityTypeDBO() {
        return landUseActivityTypeDBO;
    }

    public void setLandUseActivityTypeDBO(LandUseActivityTypeDBO landUseActivityTypeDBO) {
        this.landUseActivityTypeDBO = landUseActivityTypeDBO;
    }

    public Boolean getPartialOrganicFlag() {
        return partialOrganicFlag;
    }

    public void setPartialOrganicFlag(Boolean partialOrganicFlag) {
        this.partialOrganicFlag = partialOrganicFlag;
    }
}