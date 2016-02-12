package uk.gov.scotland.afrc.applications.model.dto;

import java.util.Date;



public class SIACSErrorsDTO {
	private static final long serialVersionUID = 1L;
	private String schemeName;
	private String validationTypeName;
	private Long lpisLandParcelId;
	private Long contractId;
	private String errorDescription;
	private Date errorRunDatetime;
	private boolean errorStatus;
	private Long lpisLandParcelIdScheme;
	private String suppressionCmntText;
	private String prclId;
	
	public SIACSErrorsDTO() {
		super();
	}
	public SIACSErrorsDTO(String schemeName, String description,
			Long lpisLndPrclId,String prclId,String name,
			Date errorCreationDate, boolean passFlag, String suppressionCmntText) {
		super();
		this.schemeName = schemeName;
		this.errorDescription = description;
		this.lpisLandParcelId = lpisLndPrclId;
		this.prclId = prclId;
		this.validationTypeName = name;		
		this.errorRunDatetime = errorCreationDate;
		this.errorStatus = passFlag;
		this.suppressionCmntText = suppressionCmntText;

		}
	public SIACSErrorsDTO(Long contractId,Long lpisLndPrclId) {
		super();
		this.contractId = contractId;
		this.lpisLandParcelIdScheme=lpisLndPrclId;
		}

	public String getSchemeName() {
		return schemeName;
	}

	public void setSchemeName(String schemeName) {
		this.schemeName = schemeName;
	}

	public String getValidationTypeName() {
		return validationTypeName;
	}

	public void setValidationTypeName(String validationTypeName) {
		this.validationTypeName = validationTypeName;
	}

	public Long getLpisLandParcelId() {
		return lpisLandParcelId;
	}

	public void setLpisLandParcelId(Long lpisLandParcelId) {
		this.lpisLandParcelId = lpisLandParcelId;
	}

	
	public String getPrclId() {
		return prclId;
	}
	public void setPrclId(String prclId) {
		this.prclId = prclId;
	}
	public Long getContractId() {
		return contractId;
	}

	public void setContractId(Long contractId) {
		this.contractId = contractId;
	}

	public String getErrorDescription() {
		return errorDescription;
	}

	public void setErrorDescription(String errorDescription) {
		this.errorDescription = errorDescription;
	}

	public Date getErrorRunDatetime() {
		return errorRunDatetime;
	}

	public void setErrorRunDatetime(Date errorRunDatetime) {
		this.errorRunDatetime = errorRunDatetime;
	}

	public boolean isErrorStatus() {
		return errorStatus;
	}

	public void setErrorStatus(boolean errorStatus) {
		this.errorStatus = errorStatus;
	}
	public Long getLpisLandParcelIdScheme() {
		return lpisLandParcelIdScheme;
	}

	public void setLpisLandParcelIdScheme(Long lpisLandParcelIdScheme) {
		this.lpisLandParcelIdScheme = lpisLandParcelIdScheme;
	}

	public String getSuppressionCmntText() {
		return suppressionCmntText;
	}

	public void setSuppressionCmntText(String suppressionCmntText) {
		this.suppressionCmntText = suppressionCmntText;
	}
	
	
	

}
