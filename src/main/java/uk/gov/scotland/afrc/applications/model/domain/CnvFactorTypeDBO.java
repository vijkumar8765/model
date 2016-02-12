package uk.gov.scotland.afrc.applications.model.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import uk.gov.scotland.afrc.applications.model.base.BaseTable;
import uk.gov.scotland.afrc.applications.model.base.BaseTableAware;
import uk.gov.scotland.afrc.applications.model.base.BaseTableListener;


/**
 * The persistent class for the CNV_FACTOR_TYPE database table.
 * 
 */
@Entity
@Table(name="CNV_FACTOR_TYPE")
@javax.persistence.Cacheable
@EntityListeners(BaseTableListener.class)
@NamedQuery(name = "CnvFactorTypeDBO.findAll", query = "SELECT c FROM CnvFactorTypeDBO c")
public class CnvFactorTypeDBO implements Serializable, BaseTableAware {
	private static final long serialVersionUID = 1L;

	@Id
    @Column(name = "CODE")
	private long code;

    @Embedded
    private BaseTable baseTable;

	@Column(name="ACTUAL_CNV_FACTOR")
	private BigDecimal actualCnvFactor;

    @Column(name = "DESCRIPTION")
	private String description;

	@Column(name="JPA_VERSION_NUMBER")
    private Long jpaVersionNumber;

	@Column(name="LAST_UPDATED_BY")
    private Long lastUpdatedBy;

	@Temporal(TemporalType.DATE)
	@Column(name="LAST_UPDATED_DATE")
	private Date lastUpdatedDate;

    @Column(name = "NAME")
	private String name;

	public CnvFactorTypeDBO() {
	}

    @Override
    public BaseTable getBaseTable() {
        if (baseTable == null) {
            baseTable = new BaseTable();
        }

        return baseTable;
    }

    @Override
    public void setBaseTable(BaseTable baseTable) {
        this.baseTable = baseTable;
    }

	public long getCode() {
		return this.code;
	}

	public void setCode(long code) {
		this.code = code;
	}

	public BigDecimal getActualCnvFactor() {
		return this.actualCnvFactor;
	}

	public void setActualCnvFactor(BigDecimal actualCnvFactor) {
		this.actualCnvFactor = actualCnvFactor;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

    public Long getJpaVersionNumber() {
		return this.jpaVersionNumber;
	}

    public void setJpaVersionNumber(Long jpaVersionNumber) {
		this.jpaVersionNumber = jpaVersionNumber;
	}

    public Long getLastUpdatedBy() {
		return this.lastUpdatedBy;
	}

    public void setLastUpdatedBy(Long lastUpdatedBy) {
		this.lastUpdatedBy = lastUpdatedBy;
	}

	public Date getLastUpdatedDate() {
		return this.lastUpdatedDate;
	}

	public void setLastUpdatedDate(Date lastUpdatedDate) {
		this.lastUpdatedDate = lastUpdatedDate;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

}