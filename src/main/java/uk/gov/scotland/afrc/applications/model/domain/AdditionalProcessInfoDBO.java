package uk.gov.scotland.afrc.applications.model.domain;

import java.io.Serializable;

import javax.persistence.*;

import java.sql.Timestamp;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the ADDITIONAL_PROCESS_INFO database table.
 * 
 */
@Entity
@Table(name="ADDITIONAL_PROCESS_INFO")
@NamedQueries(
	    value = { 
	    	@NamedQuery(
	        name = "AdditionalProcessInfoDBO.findByBrn",
	        query = "SELECT a FROM AdditionalProcessInfoDBO a JOIN a.addlTaskOrProcInfoKeys t WHERE a.brn = :brn" ),
	        @NamedQuery(
	    	        name = "AdditionalProcessInfoDBO.findByProcessAndAppId",
	    	        query = "SELECT a FROM AdditionalProcessInfoDBO a JOIN a.addlTaskOrProcInfoKeys t WHERE "
	    	        		+ " a.bpmnProcessId=:bpmnProcessId and t.businessKey =:businessKey and t.businessValue=:businessValue" ),
			@NamedQuery(
			        name = "AdditionalProcessInfoDBO.findByBrnAndAppId",
			        query = "SELECT a FROM AdditionalProcessInfoDBO a JOIN a.addlTaskOrProcInfoKeys t WHERE a.brn = :brn"
			        		+ " and t.businessKey = :businessKey and t.businessValue = :businessValue" )        		
	    })


public class AdditionalProcessInfoDBO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="EXTERNAL_INSTANCE_ID")
	private Long externalInstanceId;

	@Column(name="BPMN_PROCESS_ID")
	private String bpmnProcessId;

	@Column(name="BRN")
	private Long brn;

	@Column(name="COUNTRY_CODE")
	private BigDecimal countryCode;

	@Column(name="CREATION_DATE")
	private Timestamp creationDate;

	@Column(name="DIRECT_CUSTOMER_NAME")
	private String directCustomerName;

	@Column(name="POSTCODE")
	private String postcode;

	@OneToMany(mappedBy="additionalProcessInfo")
	private List<AdditionalTaskInfoMetadataDBO> addlTaskOrProcInfoKeys;

	public AdditionalProcessInfoDBO() {
	}

	public Long getExternalInstanceId() {
		return this.externalInstanceId;
	}

	public void setExternalInstanceId(Long externalInstanceId) {
		this.externalInstanceId = externalInstanceId;
	}

	public String getBpmnProcessId() {
		return this.bpmnProcessId;
	}

	public void setBpmnProcessId(String bpmnProcessId) {
		this.bpmnProcessId = bpmnProcessId;
	}

	public Long getBrn() {
		return this.brn;
	}

	public void setBrn(Long brn) {
		this.brn = brn;
	}

	public BigDecimal getCountryCode() {
		return this.countryCode;
	}

	public void setCountryCode(BigDecimal countryCode) {
		this.countryCode = countryCode;
	}

	public Timestamp getCreationDate() {
		return this.creationDate;
	}

	public void setCreationDate(Timestamp creationDate) {
		this.creationDate = creationDate;
	}

	public String getDirectCustomerName() {
		return this.directCustomerName;
	}

	public void setDirectCustomerName(String directCustomerName) {
		this.directCustomerName = directCustomerName;
	}

	public String getPostcode() {
		return this.postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	public List<AdditionalTaskInfoMetadataDBO> getAddlTaskOrProcInfoKeys() {
		return this.addlTaskOrProcInfoKeys;
	}

	public void setAddlTaskOrProcInfoKeys(List<AdditionalTaskInfoMetadataDBO> addlTaskOrProcInfoKeys) {
		this.addlTaskOrProcInfoKeys = addlTaskOrProcInfoKeys;
	}
	
}