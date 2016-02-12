package uk.gov.scotland.afrc.applications.model.dto;

public class AdjustmentDTO {
	
	private Long adjustmentId;
	private Long applicationId;
	private Long claimId;
	private String comment;
	private Long fieldId;
	private Long landUseAreaId;
	private Long liveStockId;
	private String newValue;
	private String previousValue;
	private String reason;
		
	public AdjustmentDTO() {
		super();
	}
	
	public AdjustmentDTO(Long adjustmentId, Long applicationId, Long claimId,
			String comment, Long fieldId, Long landUseAreaId, Long liveStockId,
			String newValue, String previousValue, String reason) {
		super();
		this.adjustmentId = adjustmentId;
		this.applicationId = applicationId;
		this.claimId = claimId;
		this.comment = comment;
		this.fieldId = fieldId;
		this.landUseAreaId = landUseAreaId;
		this.liveStockId = liveStockId;
		this.newValue = newValue;
		this.previousValue = previousValue;
		this.reason = reason;
	}

	public Long getAdjustmentId() {
		return adjustmentId;
	}

	public void setAdjustmentId(Long adjustmentId) {
		this.adjustmentId = adjustmentId;
	}

	public Long getApplicationId() {
		return applicationId;
	}

	public void setApplicationId(Long applicationId) {
		this.applicationId = applicationId;
	}

	public Long getClaimId() {
		return claimId;
	}

	public void setClaimId(Long claimId) {
		this.claimId = claimId;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Long getFieldId() {
		return fieldId;
	}

	public void setFieldId(Long fieldId) {
		this.fieldId = fieldId;
	}

	public Long getLandUseAreaId() {
		return landUseAreaId;
	}

	public void setLandUseAreaId(Long landUseAreaId) {
		this.landUseAreaId = landUseAreaId;
	}

	public Long getLiveStockId() {
		return liveStockId;
	}

	public void setLiveStockId(Long liveStockId) {
		this.liveStockId = liveStockId;
	}

	public String getNewValue() {
		return newValue;
	}

	public void setNewValue(String newValue) {
		this.newValue = newValue;
	}

	public String getPreviousValue() {
		return previousValue;
	}

	public void setPreviousValue(String previousValue) {
		this.previousValue = previousValue;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}	

}
