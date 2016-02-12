package uk.gov.scotland.afrc.applications.model.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;

import uk.gov.scotland.afrc.applications.model.base.BaseTable;
import uk.gov.scotland.afrc.applications.model.base.BaseTableAware;
import uk.gov.scotland.afrc.applications.model.base.BaseTableListener;


@Entity
@Table(name = "OPERATIONAL_CUSTOMER")
@EntityListeners(BaseTableListener.class)
public class OperationalCustomerDBO implements Serializable, BaseTableAware{

	/**
	*
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "OP_CUST_ID")
	private Long opCustId;
	@Column(name = "DECLARED_NO_COI")
	private int declaredNoCoi;
	@Column(name = "END_DATE")
	private Date endDate;
	@Version
	@Column(name="JPA_VERSION_NUMBER")
	private Long jpaVersionNumber;
	@Column(name = "NO_COI_DECLARATION_DATE")
	private Date noCoiDeclarationDate;
	@Column(name = "ORGANISATION_OFFICE_TYPE_CODE")
	private Long organisationOfficeTypeCode;
	@Column(name = "ORGANISATION_TYPE_CODE")
	private Long organisationTypeCode;
		
	@Embedded
    private BaseTable baseTable;
	
	@Override
	public BaseTable getBaseTable() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setBaseTable(BaseTable baseTable) {
		// TODO Auto-generated method stub
		
	}

	public Long getOpCustId() {
		return opCustId;
	}

	public void setOpCustId(Long opCustId) {
		this.opCustId = opCustId;
	}

	public int getDeclaredNoCoi() {
		return declaredNoCoi;
	}

	public void setDeclaredNoCoi(int declaredNoCoi) {
		this.declaredNoCoi = declaredNoCoi;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Long getJpaVersionNumber() {
		return jpaVersionNumber;
	}

	public void setJpaVersionNumber(Long jpaVersionNumber) {
		this.jpaVersionNumber = jpaVersionNumber;
	}

	public Date getNoCoiDeclarationDate() {
		return noCoiDeclarationDate;
	}

	public void setNoCoiDeclarationDate(Date noCoiDeclarationDate) {
		this.noCoiDeclarationDate = noCoiDeclarationDate;
	}

	public Long getOrganisationOfficeTypeCode() {
		return organisationOfficeTypeCode;
	}

	public void setOrganisationOfficeTypeCode(Long organisationOfficeTypeCode) {
		this.organisationOfficeTypeCode = organisationOfficeTypeCode;
	}

	public Long getOrganisationTypeCode() {
		return organisationTypeCode;
	}

	public void setOrganisationTypeCode(Long organisationTypeCode) {
		this.organisationTypeCode = organisationTypeCode;
	}

	
	
	
}
