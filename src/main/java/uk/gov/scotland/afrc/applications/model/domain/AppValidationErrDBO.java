package uk.gov.scotland.afrc.applications.model.domain;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

import uk.gov.scotland.afrc.applications.model.base.BaseTable;
import uk.gov.scotland.afrc.applications.model.base.BaseTableAware;
import uk.gov.scotland.afrc.applications.model.base.BaseTableListener;

@Entity
@Table(name = "APP_VALIDATION_ERR")
@EntityListeners(BaseTableListener.class)
@NamedQueries(
    value = {
            @NamedQuery(name = "AppValidationErr.findByApplicationId",
                query = "SELECT d FROM AppValidationErrDBO d LEFT JOIN d.relatedApplications r WHERE d.applicationId = :applicationId or r.applicationId = :applicationId "
                    + "ORDER BY d.ref1, d.ref2, d.description"),
            @NamedQuery(name = "AppValidationErrDBO.findByApplicationAndValTypeCatName",
                    query = "SELECT a FROM AppValidationErrDBO a " + " LEFT JOIN a.relatedApplications r INNER JOIN a.validationType v "
                        + " INNER JOIN v.validationTypeCatg vc " + " WHERE (a.applicationId = :applicationId or r.applicationId = :applicationId) "
                        + " AND vc.name = :categoryName "),
            @NamedQuery(
                name = "AppValidationErrDBO.findWithSecByApplicationId",
                query = "SELECT new uk.gov.scotland.afrc.applications.model.dto.ValidationErrorAndSecDTO(d,t.sectionPage) FROM AppValidationErrDBO d LEFT JOIN d.relatedApplications r, ApplicationSectionTypeDBO t"
                    + " WHERE (d.applicationId = :applicationId or r.applicationId = :applicationId) and d.validationType.appSectTypeCode=t.code and d.clearedFlag=false "
                    + "ORDER BY d.validationType.businessPriority, d.ref1, d.ref2, d.description"),
            @NamedQuery(name = "AppValidationErrDBO.getAppValidationErrsByIds",
                query = "SELECT d FROM AppValidationErrDBO d LEFT JOIN d.relatedApplications r WHERE d.appValidationErrId in (:errorIds) or r.applicationId in (:errorIds) "),
            @NamedQuery(
                name = "AppValidationErr.findByApplicationIdAndSchemeOptionId",
                query = "SELECT d FROM AppValidationErrDBO d LEFT JOIN d.relatedApplications r WHERE (d.applicationId = :applicationId or r.applicationId = :applicationId) and d.schemeOptionId = :schemeOptionId "
                    + "ORDER BY d.ref1, d.ref2, d.description"),
            @NamedQuery(name = "AppValidationErrDBO.findByApplicationIdAndValidationTypeCode",
                query = "SELECT d FROM AppValidationErrDBO d LEFT JOIN d.relatedApplications r WHERE (d.applicationId = :applicationId or r.applicationId = :applicationId) "
                    + "AND d.validationType.code = :validationTypeCode"),
            @NamedQuery(name = "AppValidationErr.findUnresolvedErrorsByApplicationId",
                query = "SELECT d FROM AppValidationErrDBO d LEFT JOIN d.relatedApplications r WHERE (d.applicationId = :applicationId or r.applicationId = :applicationId) "
                    + "AND d.valJustificationTypeCode IS NULL AND d.clearedFlag = false "),
            @NamedQuery(name = "AppValidationErr.findUnresolvedErrorsCountByApplicationId",
                query = "SELECT count(d) FROM AppValidationErrDBO d LEFT JOIN d.relatedApplications r WHERE (d.applicationId = :applicationId or r.applicationId = :applicationId) "
                    + "AND d.valJustificationTypeCode IS NULL AND d.clearedFlag = false "),
            @NamedQuery(name = "AppValidationErr.findByApplicationAndSectionTypeCode",
                query = "SELECT d FROM AppValidationErrDBO d LEFT JOIN d.relatedApplications r WHERE (d.applicationId = :applicationId or r.applicationId = :applicationId) "
                    + "AND d.validationType.appSectTypeCode = :appSectTypeCode AND d.clearedFlag = false "
                    + "AND d.valJustificationTypeCode IS NULL " + "ORDER BY d.ref1, d.ref2, d.description"),
            @NamedQuery(
                name = "AppValidationErr.findCountByApplicationAndSectionTypeCode",
                query = "SELECT count(d), d.animalClaimId, d.lndUseAreaId, d.schemeId, d.schemeOptionId, d.appLndPrclId, d.appCgShareId FROM AppValidationErrDBO d LEFT JOIN d.relatedApplications r WHERE (d.applicationId = :applicationId or r.applicationId = :applicationId) "
                    + "AND d.validationType.appSectTypeCode = :appSectTypeCode "
                    + "AND d.valJustificationTypeCode IS NULL "
                    + "AND d.clearedFlag=false "
                    + "AND (d.animalClaimId IS NOT NULL "
                    + "OR d.lndUseAreaId IS NOT NULL "
                    + "OR d.schemeId IS NOT NULL "
                    + "OR d.appLndPrclId IS NOT NULL "
                    + "OR d.appCgShareId IS NOT NULL "
                    + "OR d.schemeOptionId IS NOT NULL)"
                    + "GROUP BY d.animalClaimId, d.lndUseAreaId, d.schemeId, d.schemeOptionId, d.appLndPrclId, d.appCgShareId"),
            @NamedQuery(name = "AppValidationErrDBO.getOpenErrorsCount",
                query = "SELECT count(d) FROM AppValidationErrDBO d LEFT JOIN d.relatedApplications r WHERE (d.applicationId = :applicationId or r.applicationId = :applicationId) "
                    + "AND (d.passFlag = false AND d.valJustificationTypeCode IS NULL) "),

            @NamedQuery(name = "AppValidationErrDBO.getOpenErrorsCountByClass",
                query = "SELECT count(d) FROM AppValidationErrDBO d LEFT JOIN d.relatedApplications r INNER JOIN d.validationType v INNER JOIN v.validationTypeClass vc " 
                	+ " WHERE (d.applicationId = :applicationId or r.applicationId = :applicationId) "
                    + " AND (d.passFlag = false AND d.valJustificationTypeCode IS NULL) "
                    + " AND vc.name = :className "),
            @NamedQuery(name = "AppValidationErrDBO.checkJPAVersionNumber",
                query = "SELECT a.jpaVersionNumber FROM AppValidationErrDBO a "
                    + "WHERE a.appValidationErrId = :appValidationErrorId "),
            @NamedQuery(
                name = "AppValidationErrDBO.getJustificationReasons",
                query = "SELECT DISTINCT new uk.gov.scotland.afrc.applications.model.dto.ValidationJustificationDTO(v.code, v.description) FROM AppValidationErrDBO a LEFT JOIN a.relatedApplications r,  "
                    + " ValidationJustificationTypeDBO v "
                    + " WHERE (a.applicationId = :applicationId or r.applicationId = :applicationId) "
                    + "	AND (a.passFlag IS NULL OR a.passFlag = false) "
                    + " AND (a.clearedFlag IS NULL OR a.clearedFlag = false) "
                    + " AND (a.valSuppressionTypeCode = v.code)"
                    + " AND a.validationType.validationTypeClass.code = :validationTypeClass "),        	    	
        	@NamedQuery(
                    	name="AppValidationErrDBO.findSIACSErrorsByApplicationId",
                    	query="SELECT  new uk.gov.scotland.afrc.applications.model.dto.SIACSErrorsDTO (sc.schemeName,ave.description,ave.lpisLndPrclId,alp.prclId,vtc.description,ave.validationRunDatetime,ave.passFlag,ave.suppressionCmntText) "
                    				+ " FROM AppValidationErrDBO ave"
                    				+ " LEFT JOIN ave.relatedApplications r"
        							+ " INNER JOIN ave.validationType vt"
        							+ " INNER JOIN vt.validationTypeCatg vtc"
        							+ " LEFT OUTER JOIN ave.scheme sc"
        							+ " LEFT OUTER JOIN ave.appLndPrcl alp"
        							+ " WHERE (ave.applicationId = :applicationId or r.applicationId = :applicationId)"
        							+ " AND ave.valSuppressionTypeCode=2"
        							+ " AND ave.appLndPrclId=alp.appLndPrclId"
        							+ " ORDER BY ave.passFlag,ave.appLndPrclId"
                    		),
             @NamedQuery(name="AppValidationErrDBO.findNotClearedSIACSErrorsByApplicationId",
                                	query="SELECT  new uk.gov.scotland.afrc.applications.model.dto.SIACSErrorsDTO (sc.schemeName,ave.description,ave.lpisLndPrclId,alp.prclId,vtc.description,ave.validationRunDatetime,ave.passFlag,ave.suppressionCmntText) "
                                				+ " FROM AppValidationErrDBO ave"
                                				+ " LEFT JOIN ave.relatedApplications r"
                    							+ " INNER JOIN ave.validationType vt"
                    							+ " INNER JOIN vt.validationTypeCatg vtc"
                    							+ " LEFT OUTER JOIN ave.scheme sc"
                    							+ " LEFT OUTER JOIN ave.appLndPrcl alp"
                    							+ " WHERE (ave.applicationId = :applicationId or r.applicationId = :applicationId)"
                    							+ " AND ave.valSuppressionTypeCode=2"
                    							+ "	AND (ave.passFlag IS NULL OR ave.passFlag = false) "
                    		                    + " AND (ave.clearedFlag IS NULL OR ave.clearedFlag = false) "
                    							+ " ORDER BY ave.passFlag,ave.appLndPrclId"
                                		),        		
            @NamedQuery(
                         name="AppValidationErrDBO.findContractssByApplicationId",
                         query="SELECT new uk.gov.scotland.afrc.applications.model.dto.SIACSErrorsDTO(si.contractId, ave.lpisLndPrclId) "
                        		+ " FROM AppValidationErrDBO ave"
                        		+ " LEFT JOIN ave.relatedApplications r"
    							+ " INNER JOIN ave.appLndPrcl alp"
                       		 	+ " INNER JOIN alp.scheduleItems si"
                       		 	+ " WHERE (ave.applicationId = :applicationId or r.applicationId = :applicationId)"
                       		 	+ " AND ave.valSuppressionTypeCode=2" 
                   				+ " ORDER BY si.contractId,si.lpisLndPrclId"
                            ),
            
            @NamedQuery(name = "AppValidationErrDBO.getApplicationType", query = "SELECT app.applicationTypeCode FROM AppValidationErrDBO ave,  "
    				+ " ApplicationDBO app "
    				+ " WHERE ave.applicationId = app.applicationId AND"
    				+ " ave.appValidationErrId = :appValidationErrId"
    				),
    		@NamedQuery(name = "AppValidationErrDBO.findByAppLandParcel",
                    query = "SELECT d FROM AppValidationErrDBO d  " + " WHERE d.appLndPrclId = :appLndPrclId"),
            @NamedQuery(name = "AppValidationErrDBO.findLatestSuppressedErrorByApplicationId",
            	query = "SELECT d FROM AppValidationErrDBO d LEFT JOIN d.relatedApplications r " 
            			+ " WHERE (d.applicationId = :applicationId or r.applicationId = :applicationId) "
                		+ " and d.baseTable.lastUpdatedDate = ( select max(a.baseTable.lastUpdatedDate) from AppValidationErrDBO a LEFT JOIN a.relatedApplications r2 "
                		+ " WHERE (a.applicationId = :subApplicationId or r2.applicationId = :subApplicationId) "
                		+ " and a.valSuppressionTypeCode is not null )"),
            @NamedQuery(name = "AppValidationErrDBO.findLatestUpdatedErrorByApplicationId",
        		query = "SELECT d FROM AppValidationErrDBO d LEFT JOIN d.relatedApplications r " 
        				+ " WHERE (d.applicationId = :applicationId or r.applicationId = :applicationId) "
            		+ " and d.baseTable.lastUpdatedDate = ( select max(a.baseTable.lastUpdatedDate) from AppValidationErrDBO a LEFT JOIN a.relatedApplications r2 "
            		+ " WHERE (a.applicationId = :subApplicationId or r2.applicationId = :subApplicationId))" )
                 
    })
public class AppValidationErrDBO implements Serializable, BaseTableAware {

    private static final long serialVersionUID = 1L;

    @Column(name = "JPA_VERSION_NUMBER")
    @Version
    private Long jpaVersionNumber;

    @Embedded
    private BaseTable baseTable;

    @Id
    @Column(name = "APP_VALIDATION_ERR_ID")
    @SequenceGenerator(name = "APP_VALIDATION_ERR_SEQ_GENERATOR", sequenceName = "APP_VALIDATION_ERR_SEQ",
        allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "APP_VALIDATION_ERR_SEQ_GENERATOR")
    private long appValidationErrId;

    @Column(name = "ANIMAL_CLAIM_ID")
    private Long animalClaimId;

    @Column(name = "APPLICATION_ID")
    private Long applicationId;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "JUSTIFICATION_TEXT")
    private String justificationText;

    @Column(name = "LND_USE_AREA_ID")
    private Long lndUseAreaId;

    @Column(name = "APP_LND_PRCL_ID")
    private Long appLndPrclId;

    @Column(name = "PASS_FLAG")
    private boolean passFlag;

    @Column(name = "IS_CLEARED_FLAG")
    private boolean clearedFlag;

    @Column(name = "REF_1")
    private String ref1;

    @Column(name = "REF_2")
    private String ref2;

    @Column(name = "SCHEME_ID")
    private Long schemeId;

    @Column(name = "SCHEME_OPTION_ID")
    private Long schemeOptionId;

    @Column(name = "VAL_JUSTIFICATION_TYPE_CODE")
    private Long valJustificationTypeCode;

    @ManyToOne
    @JoinColumn(name = "VAL_JUSTIFICATION_TYPE_CODE")
    private ValidationJustificationTypeDBO valJustificationType;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "VALIDATION_RUN_DATETIME")
    private Date validationRunDatetime;

    @ManyToOne
    @JoinColumn(name = "VALIDATION_TYPE_CODE")
    private ValidationTypeDBO validationType;

    @Column(name = "SUPPRESSION_CMT_TEXT")
    private String suppressionCmntText;

    @Column(name = "VAL_SUPPRESSION_TYPE_CODE")
    private Long valSuppressionTypeCode;

    @ManyToOne
    @JoinColumn(name = "VAL_SUPPRESSION_TYPE_CODE")
    private ValidationJustificationTypeDBO valSuppressionType;
	
    @ManyToOne
    @JoinColumn(name = "APP_LND_PRCL_ID")
    private AppLndPrclDBO appLndPrcl;

    @ManyToOne
    @JoinColumn(name = "SCHEME_ID")
    private SchemeDBO scheme;
    
    @Column(name = "APP_CG_SHARE_ID")
    private Long appCgShareId;

    @Column(name = "APP_QUESTION_TYPE_CODE")
    private Long appQuestionTypeCode;

    @Column(name = "CLAIM_ID")
    private Long claimId;
    
    @Column(name= "LPIS_LND_PRCL_ID")
    private Long lpisLndPrclId;
  
    @Column(name= "CG_SHARE_LND_USE_AREA_ID")
    private Long locationCgId;
      
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "ERR_CREATION_DATE")
    private Date errorCreationDate;
    
    @Column(name = "ASSESSMENT_ID")
    private Long assessmentId;
    @ManyToOne
    @JoinColumn(name = "APP_CG_SHARE_ID")
    private ApplicationCommonGrazingShareDBO commonGrazingShare;
    
    @OneToMany(mappedBy="appValidationErr", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<RelatedApplicationsDBO> relatedApplications;
    
    public ApplicationCommonGrazingShareDBO getCommonGrazingShare() {
        return commonGrazingShare;
    }

    public void setCommonGrazingShare(ApplicationCommonGrazingShareDBO commonGrazingShare) {
        this.commonGrazingShare = commonGrazingShare;
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

    public long getAppValidationErrId() {
        return appValidationErrId;
    }

    public void setAppValidationErrId(long appValidationErrId) {
        this.appValidationErrId = appValidationErrId;
    }

    public Long getAnimalClaimId() {
        return animalClaimId;
    }

    public void setAnimalClaimId(Long animalClaimId) {
        this.animalClaimId = animalClaimId;
    }

    public Long getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(Long applicationId) {
        this.applicationId = applicationId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getJustificationText() {
        return justificationText;
    }

    public void setJustificationText(String justificationText) {
        this.justificationText = justificationText;
    }

    public Long getLndUseAreaId() {
        return lndUseAreaId;
    }

    public void setLndUseAreaId(Long lndUseAreaId) {
        this.lndUseAreaId = lndUseAreaId;
    }

    public Long getAppLndPrclId() {
        return appLndPrclId;
    }

    public void setAppLndPrclId(Long appLndPrclId) {
        this.appLndPrclId = appLndPrclId;
    }

    public boolean isPassFlag() {
        return passFlag;
    }

    public void setPassFlag(boolean passFlag) {
        this.passFlag = passFlag;
    }

    public String getRef1() {
        return ref1;
    }

    public void setRef1(String ref1) {
        this.ref1 = ref1;
    }

    public String getRef2() {
        return ref2;
    }

    public void setRef2(String ref2) {
        this.ref2 = ref2;
    }

    public Long getSchemeId() {
        return schemeId;
    }

    public void setSchemeId(Long schemeId) {
        this.schemeId = schemeId;
    }

    public Long getSchemeOptionId() {
        return schemeOptionId;
    }

    public void setSchemeOptionId(Long schemeOptionId) {
        this.schemeOptionId = schemeOptionId;
    }

    public Long getValJustificationTypeCode() {
        return valJustificationTypeCode;
    }

    public void setValJustificationTypeCode(Long valJustificationTypeCode) {
        this.valJustificationTypeCode = valJustificationTypeCode;
    }

    public Date getValidationRunDatetime() {
        return validationRunDatetime;
    }

    public void setValidationRunDatetime(Date validationRunDatetime) {
        this.validationRunDatetime = validationRunDatetime;
    }

    public ValidationTypeDBO getValidationType() {
        return validationType;
    }

    public void setValidationType(ValidationTypeDBO validationType) {
        this.validationType = validationType;
    }

    public String getSuppressionCmntText() {
        return suppressionCmntText;
    }

    public void setSuppressionCmntText(String suppressionCmntText) {
        this.suppressionCmntText = suppressionCmntText;
    }

    public ValidationJustificationTypeDBO getValJustificationType() {
        return valJustificationType;
    }

    public void setValJustificationType(ValidationJustificationTypeDBO valJustificationType) {
        this.valJustificationType = valJustificationType;
    }

    public Long getValSuppressionTypeCode() {
        return valSuppressionTypeCode;
    }

    public void setValSuppressionTypeCode(Long valSuppressionTypeCode) {
        this.valSuppressionTypeCode = valSuppressionTypeCode;
    }

    public boolean isClearedFlag() {
        return clearedFlag;
    }

    public void setClearedFlag(boolean clearedFlag) {
        this.clearedFlag = clearedFlag;
    }

    public Long getClaimId() {
        return claimId;
    }

    public void setClaimId(Long claimId) {
        this.claimId = claimId;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((applicationId == null) ? 0 : applicationId.hashCode());
        result = prime * result + ((validationType == null) ? 0 : validationType.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        AppValidationErrDBO other = (AppValidationErrDBO) obj;
        if (this.appValidationErrId == other.appValidationErrId) {
            return true;
        }
        if (applicationId == null) {
            if (other.applicationId != null)
                return false;
        } else if (!applicationId.equals(other.applicationId))
            return false;
        if (validationType == null) {
            if (other.validationType != null)
                return false;
        } else if (!validationType.equals(other.validationType))
            return false;
        return false;
    }

    public String toString() {
        return "AppValidationErrDBO [baseTable=" + baseTable + ", appValidationErrId=" + appValidationErrId
            + ", animalClaimId=" + animalClaimId + ", applicationId=" + applicationId + ", description=" + description
            + ", justificationText=" + justificationText + ", lndUseAreaId=" + lndUseAreaId + ", lpisLndPrclId="
            + appLndPrclId + ", passFlag=" + passFlag + ", ref1=" + ref1 + ", ref2=" + ref2 + ", schemeId=" + schemeId
            + ", schemeOptionId=" + schemeOptionId + ", valJustificationTypeCode=" + valJustificationTypeCode
            + ", validationRunDatetime=" + validationRunDatetime + ", validationType=" + validationType
            + ", valSuppressionTypeCode=" + valSuppressionTypeCode + "]";
    }

    public AppLndPrclDBO getAppLndPrcl() {
        return appLndPrcl;
    }

    public void setAppLndPrcl(AppLndPrclDBO appLndPrcl) {
        this.appLndPrcl = appLndPrcl;
    }

    public Long getAppCgShareId() {
        return appCgShareId;
    }

    public void setAppCgShareId(Long appCgShareId) {
        this.appCgShareId = appCgShareId;
    }

    public Long getAppQuestionTypeCode() {
        return appQuestionTypeCode;
    }

    public void setAppQuestionTypeCode(Long appQuestionTypeCode) {
        this.appQuestionTypeCode = appQuestionTypeCode;
    }

	public SchemeDBO getScheme() {
		return scheme;
	}

	public void setScheme(SchemeDBO scheme) {
		this.scheme = scheme;
	}

	public Long getLpisLndPrclId() {
		return lpisLndPrclId;
	}

	public void setLpisLndPrclId(Long lpisLndPrclId) {
		this.lpisLndPrclId = lpisLndPrclId;
	}

	public Long getLocationCgId() {
		return locationCgId;
	}

	public void setLocationCgId(Long locationCgId) {
		this.locationCgId = locationCgId;
	}

	public Date getErrorCreationDate() {
		return errorCreationDate;
	}

	public void setErrorCreationDate(Date errorCreationDate) {
		this.errorCreationDate = errorCreationDate;
	}

    public Long getAssessmentId() {
        return assessmentId;
    }

    public void setAssessmentId(Long assessmentId) {
        this.assessmentId = assessmentId;
    }

    public ValidationJustificationTypeDBO getValSuppressionType() {
        return valSuppressionType;
    }

    public void setValSuppressionType(ValidationJustificationTypeDBO valSuppressionType) {
        this.valSuppressionType = valSuppressionType;
    }

	public List<RelatedApplicationsDBO> getRelatedApplications() {
		return this.relatedApplications;
	}

	public void setRelatedApplications(List<RelatedApplicationsDBO> relatedApplications) {
		this.relatedApplications = relatedApplications;
	}
}
