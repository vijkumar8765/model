package uk.gov.scotland.afrc.applications.model.dto;

public class ErrorCountDTO {
	
	private Long totalOutstanding;
	private Long totalSuppressed;
	private Long filteredOutstanding;
	private Long filteredSuppressed;
	private Long filteredSuppressedForSuppressionType;
	
	/**
	 * @return the totalOutstanding
	 */
	public Long getTotalOutstanding() {
		return totalOutstanding;
	}
	/**
	 * @param totalOutstanding the totalOutstanding to set
	 */
	public void setTotalOutstanding(Long totalOutstanding) {
		this.totalOutstanding = totalOutstanding;
	}
	/**
	 * @return the totalSuppressed
	 */
	public Long getTotalSuppressed() {
		return totalSuppressed;
	}
	/**
	 * @param totalSuppressed the totalSuppressed to set
	 */
	public void setTotalSuppressed(Long totalSuppressed) {
		this.totalSuppressed = totalSuppressed;
	}
	/**
	 * @return the filteredOutstanding
	 */
	public Long getFilteredOutstanding() {
		return filteredOutstanding;
	}
	/**
	 * @param filteredOutstanding the filteredOutstanding to set
	 */
	public void setFilteredOutstanding(Long filteredOutstanding) {
		this.filteredOutstanding = filteredOutstanding;
	}
	/**
	 * @return the filteredSuppressed
	 */
	public Long getFilteredSuppressed() {
		return filteredSuppressed;
	}
	/**
	 * @param filteredSuppressed the filteredSuppressed to set
	 */
	public void setFilteredSuppressed(Long filteredSuppressed) {
		this.filteredSuppressed = filteredSuppressed;
	}
	/**
	 * @return the filteredSuppressed
	 */
	public Long getFilteredSuppressedForSuppressionType() {
		return filteredSuppressedForSuppressionType;
	}
	/**
	 * @param filteredSuppressed the filteredSuppressed to set
	 */
	public void setFilteredSuppressedForSuppressionType(Long filteredSuppressedForSuppressionType) {
		this.filteredSuppressedForSuppressionType = filteredSuppressedForSuppressionType;
	}	
}
