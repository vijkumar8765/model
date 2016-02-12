package uk.gov.scotland.afrc.applications.model.dto;

import java.util.Date;

public class FilterDTO {
	
	private Long landPrclId;
	private Long sectionId;
	private Long schemeId;
	private Long errorTypeId;
	private Date fromDate;
	private Date toDate;
	private Long questionTypeCode;
	
	public FilterDTO() {
		super();
	}
	public FilterDTO(Long landPrclId, Long sectionId, Long schemeId,
			Long errorTypeId, Date fromDate, Date toDate ) {
		super();
		this.landPrclId = landPrclId;
		this.sectionId = sectionId;
		this.schemeId = schemeId;
		this.errorTypeId = errorTypeId;
		this.fromDate = fromDate;
		this.toDate = toDate;
		
	}

	public FilterDTO(Long landPrclId, Long sectionId, Long schemeId,
			Long errorTypeId, Date fromDate, Date toDate,Long questionTypeCode ) {
		super();
		this.landPrclId = landPrclId;
		this.sectionId = sectionId;
		this.schemeId = schemeId;
		this.errorTypeId = errorTypeId;
		this.fromDate = fromDate;
		this.toDate = toDate;
		this.questionTypeCode = questionTypeCode;
	}
	/**
	 * @return the landPrclId
	 */
	public Long getLandPrclId() {
		return landPrclId;
	}
	/**
	 * @param landPrclId the landPrclId to set
	 */
	public void setLandPrclId(Long landPrclId) {
		this.landPrclId = landPrclId;
	}
	/**
	 * @return the sectionId
	 */
	public Long getSectionId() {
		return sectionId;
	}
	/**
	 * @param sectionId the sectionId to set
	 */
	public void setSectionId(Long sectionId) {
		this.sectionId = sectionId;
	}
	/**
	 * @return the schemeId
	 */
	public Long getSchemeId() {
		return schemeId;
	}
	/**
	 * @param schemeId the schemeId to set
	 */
	public void setSchemeId(Long schemeId) {
		this.schemeId = schemeId;
	}
	/**
	 * @return the errorTypeId
	 */
	public Long getErrorTypeId() {
		return errorTypeId;
	}
	/**
	 * @param errorTypeId the errorTypeId to set
	 */
	public void setErrorTypeId(Long errorTypeId) {
		this.errorTypeId = errorTypeId;
	}
	/**
	 * @return the fromDate
	 */
	public Date getFromDate() {
		return fromDate;
	}
	/**
	 * @param fromDate the fromDate to set
	 */
	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}
	/**
	 * @return the toDate
	 */
	public Date getToDate() {
		return toDate;
	}
	/**
	 * @param toDate the toDate to set
	 */
	public void setToDate(Date toDate) {
		this.toDate = toDate;
	}

    public Long getQuestionTypeCode() {
        return questionTypeCode;
    }

    public void setQuestionTypeCode(Long questionTypeCode) {
        this.questionTypeCode = questionTypeCode;
    }

}
