package uk.gov.scotland.afrc.applications.model.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;


/**
 * ***************************************************************************************************************
 * This is a READ ONLY DBO Object to LPIS for the LPIS_FEATURE database table.
 * This DBO should only be used to read data from LPIS_FEATURE synonym/table
 * DO NOT USE IT TO MODIFY ANYTHING IN THE DATABASE
 * ***************************************************************************************************************
 */
@Entity
@Table(name="LPIS_FEATURE")
@NamedQueries({
        @NamedQuery(name = "LpisFeatureDBO.findAll", query = "SELECT l FROM LpisFeatureDBO l"),
        @NamedQuery(name = "LpisFeatureDBO.findBylpisLandPrclId",
            query = "SELECT l FROM LpisFeatureDBO l where l.lpisLndPrclId  = :lpisLndPrclId"),
        @NamedQuery(name = "LpisFeatureDBO.findBylpisLandPrclIdAndType",
            query = "SELECT l FROM LpisFeatureDBO l, FeatureTypeDBO t WHERE l.lpisLndPrclId = :lpisLndPrclId AND l.featureTypeCode = t.code AND t.lndUseTypeCode = :landUseType"),
        @NamedQuery(
            name = "LpisFeatureDBO.sumBylpisLandPrclIdAndType",
            query = "SELECT SUM(l.digitisedArea) FROM LpisFeatureDBO l, FeatureTypeDBO t WHERE l.lpisLndPrclId = :lpisLndPrclId AND l.featureTypeCode = t.code AND t.lndUseTypeCode = :landUseType"),
        @NamedQuery(
            name = "LpisFeatureDBO.sumBylpisLandPrclIdAndLocationId",
            query = "SELECT SUM(l.digitisedArea) FROM LpisFeatureDBO l, LpisLandParcelDBO t WHERE l.lpisLndPrclId = t.lpisLndPrclId AND t.locationId = :locationId"),
        @NamedQuery(
            name = "LpisFeatureDBO.findByLocationIdAndType",
            query = "SELECT lf FROM LpisFeatureDBO lf, LpisLandParcelDBO lp, FeatureTypeDBO ft  WHERE lf.lpisLndPrclId = lp.lpisLndPrclId AND lp.locationId = :locationId AND lf.featureTypeCode = ft.code AND ft.lndUseTypeCode = :landUseType"),
        @NamedQuery(
            name = "LpisFeatureDBO.findLUTypeBylpisLandPrclId",
            query = "SELECT DISTINCT t.lndUseTypeCode FROM FeatureTypeDBO t, LpisFeatureDBO l WHERE l.lpisLndPrclId = :lpisLndPrclId AND l.featureTypeCode = t.code"),
        @NamedQuery(
            name = "LpisFeatureDBO.findLUTypeByLocationId",
            query = "SELECT DISTINCT ft.lndUseTypeCode FROM FeatureTypeDBO ft, LpisFeatureDBO lf, LpisLandParcelDBO lp WHERE lp.locationId = :locationId AND lp.lpisLndPrclId = lf.lpisLndPrclId AND lf.featureTypeCode = ft.code")
 })
public class LpisFeatureDBO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
    @Column(name = "LPIS_FEAT_ID", insertable = false, updatable = false)
	private long lpisFeatId;

    @Column(name = "DIGITISED_AREA", insertable = false, updatable = false)
	private BigDecimal digitisedArea;

	@Temporal(TemporalType.DATE)
    @Column(name = "END_DATE", insertable = false, updatable = false)
	private Date endDate;

    @Column(name = "FEAT_ID", insertable = false, updatable = false)
	private String featId;

    @Column(name = "FEAT_VER", insertable = false, updatable = false)
    private Long featVer;

    @Column(name = "FEATURE_TYPE_CODE", insertable = false, updatable = false)
    private Long featureTypeCode;

	private Object geometry;

    @Column(name = "IS_UNIFORM", insertable = false, updatable = false)
	private String isUniform;

    @Column(name = "JPA_VERSION_NUMBER", insertable = false, updatable = false)
	@Version
    private Long jpaVersionNumber;

    @Column(name = "LAST_UPDATED_BY", insertable = false, updatable = false)
    private Long lastUpdatedBy;

    @Temporal(TemporalType.DATE)
    @Column(name = "LAST_UPDATED_DATE", insertable = false, updatable = false)
	private Date lastUpdatedDate;

	private String lineage;

    @Column(name = "LPIS_LND_PRCL_ID", insertable = false, updatable = false)
    private Long lpisLndPrclId;

    @Column(name = "PERCENTAGE_INELIGIBLE", insertable = false, updatable = false)
	private BigDecimal percentageIneligible;

    @Column(name = "REVIEWED_BY", insertable = false, updatable = false)
	private String reviewedBy;

	@Temporal(TemporalType.DATE)
    @Column(name = "REVIEWED_DATE", insertable = false, updatable = false)
	private Date reviewedDate;

	@Temporal(TemporalType.DATE)
    @Column(name = "START_DATE", insertable = false, updatable = false)
	private Date startDate;

    @ManyToOne(fetch=FetchType.LAZY, cascade=CascadeType.MERGE)
	@JoinColumn(name="FEATURE_TYPE_CODE")
    private FeatureTypeDBO featureType;	
    
	@ManyToOne(fetch=FetchType.LAZY, cascade=CascadeType.MERGE)
	@JoinColumn(name="LPIS_LND_PRCL_ID")
	private LpisLandParcelDBO lpislandParcel;

	public LpisFeatureDBO() {
	}

	public long getLpisFeatId() {
		return this.lpisFeatId;
	}

	public void setLpisFeatId(long lpisFeatId) {
		this.lpisFeatId = lpisFeatId;
	}

	public BigDecimal getDigitisedArea() {
		return this.digitisedArea;
	}

	public void setDigitisedArea(BigDecimal digitisedArea) {
		this.digitisedArea = digitisedArea;
	}

	public Date getEndDate() {
		return this.endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getFeatId() {
		return this.featId;
	}

	public void setFeatId(String featId) {
		this.featId = featId;
	}

    public Long getFeatVer() {
		return this.featVer;
	}

    public void setFeatVer(Long featVer) {
		this.featVer = featVer;
	}

    public Long getFeatureTypeCode() {
		return this.featureTypeCode;
	}

    public void setFeatureTypeCode(Long featureTypeCode) {
		this.featureTypeCode = featureTypeCode;
	}

	public Object getGeometry() {
		return this.geometry;
	}

	public void setGeometry(Object geometry) {
		this.geometry = geometry;
	}

	public String getIsUniform() {
		return this.isUniform;
	}

	public void setIsUniform(String isUniform) {
		this.isUniform = isUniform;
	}

    public Long getJpaVersionNumber() {
		return this.jpaVersionNumber;
	}

    public void setJpaVersionNumber(Long jpaVersionNumber) {
		this.jpaVersionNumber = jpaVersionNumber;
	}

    public Long getLastUpdatedBy() {
		return this.lastUpdatedBy;
	}

    public void setLastUpdatedBy(Long lastUpdatedBy) {
		this.lastUpdatedBy = lastUpdatedBy;
	}

	public Date getLastUpdatedDate() {
		return this.lastUpdatedDate;
	}

	public void setLastUpdatedDate(Date lastUpdatedDate) {
		this.lastUpdatedDate = lastUpdatedDate;
	}

	public String getLineage() {
		return this.lineage;
	}

	public void setLineage(String lineage) {
		this.lineage = lineage;
	}

    public Long getLpisLndPrclId() {
		return this.lpisLndPrclId;
	}

    public void setLpisLndPrclId(Long lpisLndPrclId) {
		this.lpisLndPrclId = lpisLndPrclId;
	}

	public BigDecimal getPercentageIneligible() {
		return this.percentageIneligible;
	}

	public void setPercentageIneligible(BigDecimal percentageIneligible) {
		this.percentageIneligible = percentageIneligible;
	}

	public String getReviewedBy() {
		return this.reviewedBy;
	}

	public void setReviewedBy(String reviewedBy) {
		this.reviewedBy = reviewedBy;
	}

	public Date getReviewedDate() {
		return this.reviewedDate;
	}

	public void setReviewedDate(Date reviewedDate) {
		this.reviewedDate = reviewedDate;
	}

	public Date getStartDate() {
		return this.startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public FeatureTypeDBO getFeatureType() {
		return featureType;
	}

	public void setFeatureType(FeatureTypeDBO featureType) {
		this.featureType = featureType;
	}

	public LpisLandParcelDBO getLpislandParcel() {
		return lpislandParcel;
	}

	public void setLpislandParcel(LpisLandParcelDBO lpislandParcel) {
		this.lpislandParcel = lpislandParcel;
	}
	
	

}