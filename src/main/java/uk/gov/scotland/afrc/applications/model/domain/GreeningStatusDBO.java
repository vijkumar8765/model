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
 * The persistent class for the GREENING_STATUS database table.
 * 
 */
@Entity
@Table(name = "GREENING_STATUS")
@EntityListeners(BaseTableListener.class)
@NamedQueries(value = { @NamedQuery(name = "GreeningStatusDBO.findByApplicationId",
    query = "SELECT g FROM GreeningStatusDBO g WHERE g.applicationId = :appId"),
    @NamedQuery(name = "GreeningStatusDBO.deleteByApplicationId",
    query = "DELETE FROM GreeningStatusDBO d WHERE d.applicationId = :appId"),})
public class GreeningStatusDBO implements Serializable, BaseTableAware {
    private static final Long serialVersionUID = 1L;

    @Embedded
    private BaseTable baseTable;

    @Column(name = "GREENING_STS_ID")
    @SequenceGenerator(name = "GREENING_STATUS_SEQ_GENERATOR", sequenceName = "GREENING_STATUS_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "GREENING_STATUS_SEQ_GENERATOR")
    private Long greeningStatusId;

    @Id
    @Column(name = "APPLICATION_ID")
    private Long applicationId;

    @Column(name = "GREENING_STS")
    private String greeningStatus;

    @Column(name = "GREENING_STS_REASON")
    private String greeningStatusReason;

    @Column(name = "ARABLE_AREA")
    private BigDecimal arableArea;

    @Column(name = "EFA_STS")
    private String efaStatus;

    @Column(name = "EFA_STS_REASON")
    private String efaStatusReason;

    @Column(name = "EFA_AREA_REQ")
    private BigDecimal efaAreaRequired;

    @Column(name = "CROP_DIVERSFCTN_REQT")
    private String cropDiversReq;

    @Column(name = "CROP_DIVERSFCTN_STS")
    private String cropDiversStatus;

    @Column(name = "CROP_DIVERSFCTN_STS_REASON")
    private String cropDiversStatusReason;

    @Column(name = "PRI_CROP_AREA")
    private BigDecimal primaryCropArea;

    @Column(name = "PRI_CROP_PERCENTAGE")
    private BigDecimal primaryCropPercentage;

    @Column(name = "PRI_CROP_CODE")
    @ManyToOne
    private CropFamilyTypeDBO primaryCropFamilyType;
    
    @Column(name = "SEC_CROP_CODE")
    @ManyToOne
    private CropFamilyTypeDBO secondaryCropFamilyType;

    @Column(name = "SEC_CROP_AREA")
    private BigDecimal secondaryCropArea;

    @Column(name = "SEC_CROP_PERCENTAGE")
    private BigDecimal secondaryCropPercentage;

    @Column(name = "OTH_CROP_AREA")
    private BigDecimal otherCropArea;

    @Column(name = "OTH_CROP_PERCENTAGE")
    private BigDecimal otherCropAreaPercentage;

    @Column(name = "JPA_VERSION_NUMBER")
    @Version
    private Long jpaVersionNumber;

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

    /**
     * @return the greeningStatusId
     */
    public Long getGreeningStatusId() {
        return greeningStatusId;
    }

    /**
     * @param greeningStatusId
     *            the greeningStatusId to set
     */
    public void setGreeningStatusId(Long greeningStatusId) {
        this.greeningStatusId = greeningStatusId;
    }

    /**
     * @return the applicationId
     */
    public Long getApplicationId() {
        return applicationId;
    }

    /**
     * @param applicationId
     *            the applicationId to set
     */
    public void setApplicationId(Long applicationId) {
        this.applicationId = applicationId;
    }

    /**
     * @return the greeningStatus
     */
    public String getGreeningStatus() {
        return greeningStatus;
    }

    /**
     * @param greeningStatus
     *            the greeningStatus to set
     */
    public void setGreeningStatus(String greeningStatus) {
        this.greeningStatus = greeningStatus;
    }

    /**
     * @return the greeningStatusReason
     */
    public String getGreeningStatusReason() {
        return greeningStatusReason;
    }

    /**
     * @param greeningStatusReason
     *            the greeningStatusReason to set
     */
    public void setGreeningStatusReason(String greeningStatusReason) {
        this.greeningStatusReason = greeningStatusReason;
    }

    /**
     * @return the arableArea
     */
    public BigDecimal getArableArea() {
        return arableArea;
    }

    /**
     * @param arableArea
     *            the arableArea to set
     */
    public void setArableArea(BigDecimal arableArea) {
        this.arableArea = arableArea;
    }

    /**
     * @return the efaStatus
     */
    public String getEfaStatus() {
        return efaStatus;
    }

    /**
     * @param efaStatus
     *            the efaStatus to set
     */
    public void setEfaStatus(String efaStatus) {
        this.efaStatus = efaStatus;
    }

    /**
     * @return the efaStatusReason
     */
    public String getEfaStatusReason() {
        return efaStatusReason;
    }

    /**
     * @param efaStatusReason
     *            the efaStatusReason to set
     */
    public void setEfaStatusReason(String efaStatusReason) {
        this.efaStatusReason = efaStatusReason;
    }

    /**
     * @return the efaAreaRequired
     */
    public BigDecimal getEfaAreaRequired() {
        return efaAreaRequired;
    }

    /**
     * @param efaAreaRequired
     *            the efaAreaRequired to set
     */
    public void setEfaAreaRequired(BigDecimal efaAreaRequired) {
        this.efaAreaRequired = efaAreaRequired;
    }

    /**
     * @return the cropDiversReq
     */
    public String getCropDiversReq() {
        return cropDiversReq;
    }

    /**
     * @param cropDiversReq
     *            the cropDiversReq to set
     */
    public void setCropDiversReq(String cropDiversReq) {
        this.cropDiversReq = cropDiversReq;
    }

    /**
     * @return the cropDiversStatus
     */
    public String getCropDiversStatus() {
        return cropDiversStatus;
    }

    /**
     * @param cropDiversStatus
     *            the cropDiversStatus to set
     */
    public void setCropDiversStatus(String cropDiversStatus) {
        this.cropDiversStatus = cropDiversStatus;
    }

    /**
     * @return the cropDiversStatusReason
     */
    public String getCropDiversStatusReason() {
        return cropDiversStatusReason;
    }

    /**
     * @param cropDiversStatusReason
     *            the cropDiversStatusReason to set
     */
    public void setCropDiversStatusReason(String cropDiversStatusReason) {
        this.cropDiversStatusReason = cropDiversStatusReason;
    }

    /**
     * @return the primaryCropArea
     */
    public BigDecimal getPrimaryCropArea() {
        return primaryCropArea;
    }

    /**
     * @param primaryCropArea
     *            the primaryCropArea to set
     */
    public void setPrimaryCropArea(BigDecimal primaryCropArea) {
        this.primaryCropArea = primaryCropArea;
    }

    /**
     * @return the primaryCropPercentage
     */
    public BigDecimal getPrimaryCropPercentage() {
        return primaryCropPercentage;
    }

    /**
     * @param primaryCropPercentage
     *            the primaryCropPercentage to set
     */
    public void setPrimaryCropPercentage(BigDecimal primaryCropPercentage) {
        this.primaryCropPercentage = primaryCropPercentage;
    }

    /**
     * @return the secondaryCropArea
     */
    public BigDecimal getSecondaryCropArea() {
        return secondaryCropArea;
    }

    /**
     * @param secondaryCropArea
     *            the secondaryCropArea to set
     */
    public void setSecondaryCropArea(BigDecimal secondaryCropArea) {
        this.secondaryCropArea = secondaryCropArea;
    }

    /**
     * @return the secondaryCropPercentage
     */
    public BigDecimal getSecondaryCropPercentage() {
        return secondaryCropPercentage;
    }

    /**
     * @param secondaryCropPercentage
     *            the secondaryCropPercentage to set
     */
    public void setSecondaryCropPercentage(BigDecimal secondaryCropPercentage) {
        this.secondaryCropPercentage = secondaryCropPercentage;
    }

    /**
     * @return the otherCropArea
     */
    public BigDecimal getOtherCropArea() {
        return otherCropArea;
    }

    /**
     * @param otherCropArea
     *            the otherCropArea to set
     */
    public void setOtherCropArea(BigDecimal otherCropArea) {
        this.otherCropArea = otherCropArea;
    }

    /**
     * @return the otherCropAreaPercentage
     */
    public BigDecimal getOtherCropAreaPercentage() {
        return otherCropAreaPercentage;
    }

    /**
     * @param otherCropAreaPercentage
     *            the otherCropAreaPercentage to set
     */
    public void setOtherCropAreaPercentage(BigDecimal otherCropAreaPercentage) {
        this.otherCropAreaPercentage = otherCropAreaPercentage;
    }

    /**
     * @return the jpaVersionNumber
     */
    public Long getJpaVersionNumber() {
        return jpaVersionNumber;
    }

    /**
     * @param jpaVersionNumber the jpaVersionNumber to set
     */
    public void setJpaVersionNumber(Long jpaVersionNumber) {
        this.jpaVersionNumber = jpaVersionNumber;
    }

	/**
	 * @return
	 */
	public CropFamilyTypeDBO getPrimaryCropFamilyType() {
		return primaryCropFamilyType;
	}

	/**
	 * @param primaryCropFamilyType
	 */
	public void setPrimaryCropFamilyType(CropFamilyTypeDBO primaryCropFamilyType) {
		this.primaryCropFamilyType = primaryCropFamilyType;
	}

	/**
	 * @return
	 */
	public CropFamilyTypeDBO getSecondaryCropFamilyType() {
		return secondaryCropFamilyType;
	}

	public void setSecondaryCropFamilyType(CropFamilyTypeDBO secondaryCropFamilyType) {
		this.secondaryCropFamilyType = secondaryCropFamilyType;
	}
}
