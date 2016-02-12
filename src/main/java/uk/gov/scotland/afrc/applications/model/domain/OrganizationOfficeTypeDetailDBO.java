package uk.gov.scotland.afrc.applications.model.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import uk.gov.scotland.afrc.applications.model.base.BaseTable;
import uk.gov.scotland.afrc.applications.model.base.BaseTableAware;
import uk.gov.scotland.afrc.applications.model.base.BaseTableListener;

@Entity
@Table(name = "ORG_OFFICE_TYPE_DETAIL")
@EntityListeners(BaseTableListener.class)
public class OrganizationOfficeTypeDetailDBO implements Serializable, BaseTableAware {
	private static final long serialVersionUID = -2964121963787349715L;

	@Id
	@Column(name = "ORGANISATION_OFFICE_TYPE_CODE")
	private long organizationOfficeTypeCode;

	@OneToOne
	@Column(name = "CONTACT_POINT_ID")
	private ContactDetailDBO contactDetail;

	@Embedded
	private BaseTable baseTable;

	public long getOrganizationOfficeTypeCode() {
		return organizationOfficeTypeCode;
	}

	public void setOrganizationOfficeTypeCode(long organizationOfficeTypeCode) {
		this.organizationOfficeTypeCode = organizationOfficeTypeCode;
	}

	public ContactDetailDBO getContactDetail() {
		return contactDetail;
	}

	public void setContactDetail(ContactDetailDBO contactDetail) {
		this.contactDetail = contactDetail;
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
}
