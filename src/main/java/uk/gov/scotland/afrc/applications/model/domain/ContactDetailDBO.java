package uk.gov.scotland.afrc.applications.model.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import javax.persistence.Table;

import uk.gov.scotland.afrc.applications.model.base.BaseTable;
import uk.gov.scotland.afrc.applications.model.base.BaseTableAware;
import uk.gov.scotland.afrc.applications.model.base.BaseTableListener;

@Entity
@Table(name = "CONTACT_DETAIL")
@EntityListeners(BaseTableListener.class)
public class ContactDetailDBO implements Serializable, BaseTableAware {

	private static final long serialVersionUID = -2175080865714471565L;
	@Id
	@Column(name = "CONTACT_POINT_ID")
	private long contactPointId;
	@Column(name = "ADDRESS_LINE1")
	private String addressLine1;
	@Column(name = "ADDRESS_LINE2")
	private String addressLine2;
	@Column(name = "ADDRESS_LINE3")
	private String addressLine3;
	@Column(name = "ADDRESS_LINE5")
	private String addressLine5;
	@Column(name = "EMAIL_ADDRESS")
	private String emailAddress;
	@Column(name = "POSTCODE")
	private String postCode;
	@Column(name = "POST_TOWN")
	private String postTown;

	@Embedded
	private BaseTable baseTable;

	public long getContactPointId() {
		return contactPointId;
	}

	public void setContactPointId(long contactPointId) {
		this.contactPointId = contactPointId;
	}

	public String getAddressLine1() {
		return addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public String getAddressLine2() {
		return addressLine2;
	}

	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	public String getAddressLine3() {
		return addressLine3;
	}

	public void setAddressLine3(String addressLine3) {
		this.addressLine3 = addressLine3;
	}

	public String getAddressLine5() {
		return addressLine5;
	}

	public void setAddressLine5(String addressLine5) {
		this.addressLine5 = addressLine5;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getPostCode() {
		return postCode;
	}

	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}

	public String getPostTown() {
		return postTown;
	}

	public void setPostTown(String postTown) {
		this.postTown = postTown;
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
