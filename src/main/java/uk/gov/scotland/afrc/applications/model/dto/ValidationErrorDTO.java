package uk.gov.scotland.afrc.applications.model.dto;

import java.util.Date;

public class ValidationErrorDTO {
	private Long appValidationErrId;
	private Long applicationId;
	private Date dateRaised;
	private Long errorCategory;
	private String errorDescription;
	private Long errorTypeCode;
	private String errorName;
	private Boolean errorSuppressible;
	private Long jpaVersion;
	private Long landUsePrcl;
	private Long landUse;
	private Long appCgShareId;
	private Long lastUpdateBy;
	private Date lastUpdateDate;
	private Long scheme;
	private String justificationText;
	private Long schemeOption;
	private Long section;
	private Long validationJustificationType;
	private Long validationSuppressionType;
	private Long questionTypeCode;
	private Date validationRunDatetime;
	private String suppressionCmntText;


	public ValidationErrorDTO(Long appValidationErrId, Long applicationId, Date dateRaised,
		Long errorCategory, String errorDescription, Long errorTypeCode, String errorName,
		Boolean errorSuppressible, Long jpaVersion, Long landUsePrcl,
		Long landUse, Long appCgShareId, Long lastUpdateBy, Date lastUpdateDate, Long scheme,
		String justificationText, Long schemeOption, Long section,
		Long validationJustificationType, Long validationSuppressionType, Date validationRunDatetime,
		Long questionTypeCode, String suppressionCmntText) {
		super();
		this.appValidationErrId = appValidationErrId;
		this.applicationId = applicationId;
		this.dateRaised = dateRaised;
		this.errorCategory = errorCategory;
		this.errorDescription = errorDescription;
		this.errorTypeCode = errorTypeCode;
		this.errorName = errorName;
		this.errorSuppressible = errorSuppressible;
		this.jpaVersion = jpaVersion;
		this.landUsePrcl = landUsePrcl;
		this.landUse = landUse;
		this.appCgShareId = appCgShareId;
		this.lastUpdateBy = lastUpdateBy;
		this.lastUpdateDate = lastUpdateDate;
		this.scheme = scheme;
		this.justificationText = justificationText;
		this.schemeOption = schemeOption;
		this.section = section;
		this.validationJustificationType = validationJustificationType;
		this.validationSuppressionType = validationSuppressionType;
		this.validationRunDatetime = validationRunDatetime;
		this.questionTypeCode = questionTypeCode;
		this.suppressionCmntText = suppressionCmntText;
	}
	
	public Long getAppValidationErrId() {
		return appValidationErrId;
	}
	
	public void setAppValidationErrId(Long appValidationErrId) {
		this.appValidationErrId = appValidationErrId;
	}

	public Long getApplicationId() {
		return applicationId;
	}

	public void setApplicationId(Long applicationId) {
		this.applicationId = applicationId;
	}

	public Long getErrorCategory() {
		return errorCategory;
	}

	public void setErrorCategory(Long errorCategory) {
		this.errorCategory = errorCategory;
	}

	public String getErrorDescription() {
		return errorDescription;
	}

	public void setErrorDescription(String errorDescription) {
		this.errorDescription = errorDescription;
	}

	public Long getErrorTypeCode() {
		return errorTypeCode;
	}

	public void setErrorTypeCode(Long errorTypeCode) {
		this.errorTypeCode = errorTypeCode;
	}

	public String getErrorName() {
		return errorName;
	}

	public void setErrorName(String errorName) {
		this.errorName = errorName;
	}

	public Boolean getErrorSuppressible() {
		return errorSuppressible;
	}

	public void setErrorSuppressible(Boolean errorSuppressible) {
		this.errorSuppressible = errorSuppressible;
	}

	public Long getJpaVersion() {
		return jpaVersion;
	}

	public void setJpaVersion(Long jpaVersion) {
		this.jpaVersion = jpaVersion;
	}

	public Long getLandUsePrcl() {
		return landUsePrcl;
	}

	public void setLandUsePrcl(Long landUsePrcl) {
		this.landUsePrcl = landUsePrcl;
	}

	public Long getLandUse() {
		return landUse;
	}

	public void setLandUse(Long landUse) {

		this.landUse = landUse;
	}

	public Date getDateRaised() {
		return dateRaised;
	}

	public void setDateRaised(Date dateRaised) {
		this.dateRaised = dateRaised;
	}

	public Long getLastUpdateBy() {
		return lastUpdateBy;
	}

	public void setLastUpdateBy(Long lastUpdateBy) {
		this.lastUpdateBy = lastUpdateBy;
	}

	public Date getLastUpdateDate() {
		return lastUpdateDate;
	}

	public void setLastUpdateDate(Date lastUpdateDate) {
		this.lastUpdateDate = lastUpdateDate;
	}

	public Long getScheme() {
		return scheme;
	}

	public void setScheme(Long scheme) {
		this.scheme = scheme;
	}

	public String getJustificationText() {
		return justificationText;
	}

	public void setJustificationText(String justificationText) {
		this.justificationText = justificationText;
	}

	public Long getSchemeOption() {
		return schemeOption;
	}

	public void setSchemeOption(Long schemeOption) {
		this.schemeOption = schemeOption;
	}

	public Long getSection() {
		return section;
	}

	public void setSection(Long section) {
		this.section = section;
	}

	public Long getValidationJustificationType() {
		return validationJustificationType;
	}

	public void setValidationJustificationType(Long validationJustificationType) {
		this.validationJustificationType = validationJustificationType;
	}

	public Long getValidationSuppressionType() {
		return validationSuppressionType;
	}
	
	public void setValidationSuppressionType(Long validationSuppressionType) {
		this.validationSuppressionType = validationSuppressionType;
	}

	public Date getValidationRunDatetime() {
		return validationRunDatetime;
	}

	public void setValidationRunDatetime(Date validationRunDatetime) {
		this.validationRunDatetime = validationRunDatetime;
	}

	public Long getQuestionTypeCode() {
		return questionTypeCode;
	}

	public void setQuestionTypeCode(Long questionTypeCode) {
		this.questionTypeCode = questionTypeCode;
	}

	public String getSuppressionCmntText() {
		return suppressionCmntText;
	}

	public void setSuppressionCmntText(String suppressionCmntText) {
		this.suppressionCmntText = suppressionCmntText;
	}

	public Long getAppCgShareId() {
		return appCgShareId;
	}

	public void setAppCgShareId(Long appCgShareId) {
		this.appCgShareId = appCgShareId;
	}

	@Override
	public String toString() {
		return "ValidationErrorDTO [appValidationErrId=" + appValidationErrId
				+ ", errorCategory=" + errorCategory + ", errorDescription="
				+ errorDescription + ", errorName=" + errorName
				+ ", errorSuppressible=" + errorSuppressible + ", jpaVersion="
				+ jpaVersion + ", landUsePrcl=" + landUsePrcl + ", landUse="
				+ landUse + ", appCgShareId=" + appCgShareId + ", lastUpdateBy=" + lastUpdateBy
				+ ", lastUpdateDate=" + lastUpdateDate + ", scheme=" + scheme
				+ ", schemeOption=" + schemeOption + ", section=" + section
				+ ", validationJustificationType="
				+ validationJustificationType + ", validationSuppressionType="
				+ validationSuppressionType + ", validationRunDatetime="
				+ validationRunDatetime + "]";
	}

}
