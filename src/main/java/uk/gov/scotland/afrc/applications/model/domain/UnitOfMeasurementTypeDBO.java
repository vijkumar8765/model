package uk.gov.scotland.afrc.applications.model.domain;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import uk.gov.scotland.afrc.applications.model.base.BaseTable;
import uk.gov.scotland.afrc.applications.model.base.BaseTableListener;


/**
 * The persistent class for the UNIT_OF_MEASUREMENT_TYPE database table.
 * 
 */
@Entity
@Table(name="UNIT_OF_MEASUREMENT_TYPE")
@javax.persistence.Cacheable
@EntityListeners(BaseTableListener.class)
@NamedQuery(name="UnitOfMeasurementTypeDBO.findAll", query="SELECT u FROM UnitOfMeasurementTypeDBO u order by u.description")
public class UnitOfMeasurementTypeDBO implements Serializable,  uk.gov.scotland.afrc.applications.model.base.BaseTableAware {
	private static final long serialVersionUID = 1L;

	@Id
    @Column(name = "CODE")
	private long code;

	@Column(name="DESCRIPTION")
	private String description;

	@Column(name="JPA_VERSION_NUMBER")
	private BigDecimal jpaVersionNumber;
	
	@Column(name="NAME")
	private String name;

	@Embedded
    private BaseTable baseTable;
	
	public UnitOfMeasurementTypeDBO() {
	}

	public long getCode() {
		return this.code;
	}

	public void setCode(long code) {
		this.code = code;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public BigDecimal getJpaVersionNumber() {
		return this.jpaVersionNumber;
	}

	public void setJpaVersionNumber(BigDecimal jpaVersionNumber) {
		this.jpaVersionNumber = jpaVersionNumber;
	}

	
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
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