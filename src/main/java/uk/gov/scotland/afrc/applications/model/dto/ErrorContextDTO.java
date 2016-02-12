package uk.gov.scotland.afrc.applications.model.dto;


public class ErrorContextDTO {
    private Long landUseAreaId;
    private Long animalClaimId;
    private Long schemeId;
    private Long schemeOptionId;
    private Long appLandParcelId;
    private Long lpisLandParcelId;
    private Long appCgShareId;
    private Long locationCgId;
    private Long appQuestionTypeCode;
    private Long claimId;
    private Long assessmentId;
    
	public ErrorContextDTO() {
		super();
	}

	public ErrorContextDTO(Long landUseAreaId, Long animalClaimId,
			Long schemeId, Long schemeOptionId, Long appLandParcelId, 
			Long lpisLandParcelId, Long appCgShareId, Long locationCgId,
			Long appQuestionTypeCode,Long claimId, Long assessmentId) {
		super();
		this.landUseAreaId = landUseAreaId;
		this.animalClaimId = animalClaimId;
		this.schemeId = schemeId;
		this.schemeOptionId = schemeOptionId;
		this.appLandParcelId = appLandParcelId;
		this.lpisLandParcelId = lpisLandParcelId;
		this.appCgShareId = appCgShareId;
		this.locationCgId = locationCgId;
		this.appQuestionTypeCode = appQuestionTypeCode;
		this.claimId=claimId;
		this.assessmentId = assessmentId;
	}

	public Long getLandUseAreaId() {
		return landUseAreaId;
	}

	public void setLandUseAreaId(Long landUseAreaId) {
		this.landUseAreaId = landUseAreaId;
	}

	public Long getAnimalClaimId() {
		return animalClaimId;
	}

	public void setAnimalClaimId(Long animalClaimId) {
		this.animalClaimId = animalClaimId;
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

	public Long getAppLandParcelId() {
		return appLandParcelId;
	}

	public void setAppLandParcelId(Long appLandParcelId) {
		this.appLandParcelId = appLandParcelId;
	}

	public Long getLpisLandParcelId() {
		return lpisLandParcelId;
	}

	public void setLpisLandParcelId(Long lpisLandParcelId) {
		this.lpisLandParcelId = lpisLandParcelId;
	}

	public Long getLocationCgId() {
		return locationCgId;
	}

	public void setLocationCgId(Long locationCgId) {
		this.locationCgId = locationCgId;
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

    public Long getClaimId() {
        return claimId;
    }

    public void setClaimId(Long claimId) {
        this.claimId = claimId;
    }

    public Long getAssessmentId() {
        return assessmentId;
    }

    public void setAssessmentId(Long assessmentId) {
        this.assessmentId = assessmentId;
    }
    
}
