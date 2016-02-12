package uk.gov.scotland.afrc.applications.model.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;


/**
 * ***************************************************************************************************************
 * This is a READ ONLY DBO Object to LPIS for the LND_PRCL_CLASSIFICATION database table.
 * This DBO should only be used to read data from LND_PRCL_CLASSIFICATION synonym/table
 * DO NOT USE IT TO MODIFY ANYTHING IN THE DATABASE
 * ***************************************************************************************************************
 */
@Entity
@Table(name="LND_PRCL_CLASSIFICATION")
@NamedQuery(
    name = "LndPrclClassificationDBO.findByIdAndType",
    query = "SELECT l FROM LndPrclClassificationDBO l, LndPrclClassificationTypeDBO t WHERE l.lpisLndPrclId = :lpisLndPrclId AND l.endDate IS NULL AND l.prclClassCode = t.code AND t.name IN :typeList")
public class LndPrclClassificationDBO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
    @Column(name = "LND_PRCL_CLASS_ID", insertable = false, updatable = false)
	private long lndPrclClassId;

	@Temporal(TemporalType.DATE)
    @Column(name = "END_DATE", insertable = false, updatable = false)
	private Date endDate;

    @Column(name = "JPA_VERSION_NUMBER", insertable = false, updatable = false)
	@Version
    private long jpaVersionNumber;

    @Column(name = "LAST_UPDATED_BY", insertable = false, updatable = false)
    private long lastUpdatedBy;

    @Temporal(TemporalType.DATE)
    @Column(name = "LAST_UPDATED_DATE", insertable = false, updatable = false)
    private Date lastUpdatedDate;

    @Column(name = "LPIS_LND_PRCL_ID", insertable = false, updatable = false)
    private long lpisLndPrclId;

    @Column(name = "PRCL_CLASS_CODE", insertable = false, updatable = false)
    private long prclClassCode;

	@Temporal(TemporalType.DATE)
    @Column(name = "START_DATE", insertable = false, updatable = false)
	private Date startDate;

    @Column(name = "START_REASON", insertable = false, updatable = false)
	private String startReason;

	public LndPrclClassificationDBO() {
	}

	public long getLndPrclClassId() {
		return this.lndPrclClassId;
	}

	public void setLndPrclClassId(long lndPrclClassId) {
		this.lndPrclClassId = lndPrclClassId;
	}

	public Date getEndDate() {
		return this.endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

    public long getJpaVersionNumber() {
		return this.jpaVersionNumber;
	}

    public void setJpaVersionNumber(long jpaVersionNumber) {
		this.jpaVersionNumber = jpaVersionNumber;
	}

    public long getLastUpdatedBy() {
        return this.lastUpdatedBy;
    }

    public void setLastUpdatedBy(long lastUpdatedBy) {
        this.lastUpdatedBy = lastUpdatedBy;
    }

    public Date getLastUpdatedDate() {
        return this.lastUpdatedDate;
    }

    public void setLastUpdatedDate(Date lastUpdatedDate) {
        this.lastUpdatedDate = lastUpdatedDate;
    }

    public long getLpisLndPrclId() {
		return this.lpisLndPrclId;
	}

    public void setLpisLndPrclId(long lpisLndPrclId) {
		this.lpisLndPrclId = lpisLndPrclId;
	}

    public long getPrclClassCode() {
		return this.prclClassCode;
	}

    public void setPrclClassCode(long prclClassCode) {
		this.prclClassCode = prclClassCode;
	}

	public Date getStartDate() {
		return this.startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public String getStartReason() {
		return this.startReason;
	}

	public void setStartReason(String startReason) {
		this.startReason = startReason;
	}

}