package uk.gov.scotland.afrc.applications.model.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

// This object is created for read purpose only.
// If it is needed, feel free to extend it and add other fields, base table and a sequence.

@Entity
@Table(name = "APP_ENTITLEMENT_CATG_STS_TYPE")
@javax.persistence.Cacheable
@NamedQueries(value = { @NamedQuery(name = "AppEntitlementCatgStsType.findByName", query = "Select d FROM AppEntitlementCatgStsTypeDBO d WHERE d.name = :name") })
public class AppEntitlementCatgStsTypeDBO implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(length = 38)
	private long code;

	@Column(nullable = false, length = 20)
	private String name;

	public long getCode() {
		return code;
	}

	public void setCode(long code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
