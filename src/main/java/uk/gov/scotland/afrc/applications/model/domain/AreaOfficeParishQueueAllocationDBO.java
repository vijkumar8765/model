package uk.gov.scotland.afrc.applications.model.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import uk.gov.scotland.afrc.applications.model.base.BaseTable;

@Entity
@Table(name = "AREA_OFF_PARISH_Q_ALLOCATION")
@EntityListeners(BaseTable.class)
@NamedQueries({
	@NamedQuery(name = "AreaOfficeParishQueueAllocationDBO.findAllocationQueueIdByParishTypeCode", 
	query = "SELECT area.allocationQueueId FROM AreaOfficeParishQueueAllocationDBO area WHERE area.parishTypeCode = :parishTypeCode")
})
public class AreaOfficeParishQueueAllocationDBO implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "PARISH_TYPE_CODE")
	private Long parishTypeCode;

	@Column(name = "AREA_OFFICE_TYPE_CODE")
	private Long areaOfficeTypeCode;

	@Column(name = "ALLOCATED_QUEUE_ID")
	private Long allocationQueueId;
	
	public Long getParishTypeCode() {
		return parishTypeCode;
	}

	public void setParishTypeCode(Long parishTypeCode) {
		this.parishTypeCode = parishTypeCode;
	}

	public Long getAreaOfficeTypeCode() {
		return areaOfficeTypeCode;
	}

	public void setAreaOfficeTypeCode(Long areaOfficeTypeCode) {
		this.areaOfficeTypeCode = areaOfficeTypeCode;
	}

	public Long getAllocationQueueId() {
		return allocationQueueId;
	}

	public void setAllocationQueueId(Long allocationQueueId) {
		this.allocationQueueId = allocationQueueId;
	}

}
