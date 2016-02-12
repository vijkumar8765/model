package uk.gov.scotland.afrc.applications.model.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import uk.gov.scotland.afrc.applications.model.base.BaseTable;
import uk.gov.scotland.afrc.applications.model.base.BaseTableListener;

/**
 * The persistent class for the CLAIM database table.
 * 
 */
@Entity
@Table(name = "V_LMO_CONTRACT_DETAILS")
@EntityListeners(BaseTableListener.class)
@NamedQueries(value = { @NamedQuery(name = "LMOContractDetailsDBO.findByBrn",
    query = "SELECT c FROM LMOContractDetailsDBO c where c.managedBrn=:brn") })
public class LMOContractDetailsDBO implements Serializable {
    private static final long serialVersionUID = 1L;

    @Embedded
    private BaseTable baseTable;

    @Column(name = "MANAGED_BRN")
    private long managedBrn;

    @Column(name = "SCHEDULE_ITEM_ID")
    private long scheduleItemId;

    @Column(name = "CONTRACT_ID")
    private long contractId;

    @Column(name = "APPLICATION_ID")
    private long applicationId;

    @Column(name = "LPIS_LND_PRCL_ID")
    private long lpisLandParcelId;

    @Id
    @Column(name = "SCHEME_OPT_ID")
    private long schemeOptId;

    @Column(name = "END_DATE")
    private Date endDate;

    @Column(name = "PRO_UNITS")
    private BigDecimal proUnits;

    public long getManagedBrn() {
        return managedBrn;
    }

    public void setManagedBrn(long managedBrn) {
        this.managedBrn = managedBrn;
    }

    public long getScheduleItemId() {
        return scheduleItemId;
    }

    public void setScheduleItemId(long scheduleItemId) {
        this.scheduleItemId = scheduleItemId;
    }

    public long getContractId() {
        return contractId;
    }

    public void setContractId(long contractId) {
        this.contractId = contractId;
    }

    public long getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(long applicationId) {
        this.applicationId = applicationId;
    }

    public long getLpisLandParcelId() {
        return lpisLandParcelId;
    }

    public void setLpisLandParcelId(long lpisLandParcelId) {
        this.lpisLandParcelId = lpisLandParcelId;
    }

    public long getSchemeOptId() {
        return schemeOptId;
    }

    public void setSchemeOptId(long schemeOptId) {
        this.schemeOptId = schemeOptId;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public BigDecimal getProUnits() {
        return proUnits;
    }

    public void setProUnits(BigDecimal proUnits) {
        this.proUnits = proUnits;
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