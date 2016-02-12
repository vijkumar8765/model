package uk.gov.scotland.afrc.applications.model.dto;

import uk.gov.scotland.afrc.applications.model.domain.AppValidationErrDBO;

public class ValidationErrorAndSecDTO {
	private AppValidationErrDBO error;
	
	private String page;
	public AppValidationErrDBO getError() {
		return error;
	}
	public void setError(AppValidationErrDBO error) {
		this.error = error;
	}
	public String getPage() {
		return page;
	}
	public void setPage(String page) {
		this.page = page;
	}
	public ValidationErrorAndSecDTO(AppValidationErrDBO error, String page) {
		super();
		this.error = error;
		this.page = page;
	}

}
