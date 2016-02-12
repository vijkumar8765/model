package uk.gov.scotland.afrc.applications.model.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Version;

import uk.gov.scotland.afrc.applications.model.base.BaseTable;
import uk.gov.scotland.afrc.applications.model.base.BaseTableAware;
import uk.gov.scotland.afrc.applications.model.base.BaseTableListener;

/**
 * The persistent class for the CONTRACT database table.
 * 
 */

// TODO reimplement startdate check according to adviec by IM team AND si.startDate = :startDate
@Entity
@Table(name = "CONTRACT")
@EntityListeners(BaseTableListener.class)
@NamedQueries(
    value = {
            @NamedQuery(
                name = "ContractDBO.findContractsByBrn",
                query = "SELECT c FROM ContractDBO c, ScheduleItemDBO si, SchemeDBO s, SchemeOptionDBO so, AnnualRecurrentItemDBO ari WHERE c.managedBrn = :brn AND c = si.contract AND si.schemeOptId = so.schemeOptionId AND so.schemeId = s.schemeId AND ari.scheduleItem.scheduleItemId = si.scheduleItemId AND s.schemeName = :scheme AND ari.startDate = :startDate"),
            @NamedQuery(
                name = "ContractDBO.findContractsByBrnAndEndDateLaterThan",
                query = "SELECT c FROM ContractDBO c, ScheduleItemDBO si, SchemeDBO s, SchemeOptionDBO so, AnnualRecurrentItemDBO ari WHERE c.managedBrn = :brn AND c = si.contract AND si.schemeOptId = so.schemeOptionId AND so.schemeId = s.schemeId AND ari.scheduleItem.scheduleItemId = si.scheduleItemId AND s.schemeName = :scheme AND ari.endDate >= :endDate"),
            @NamedQuery(
                name = "ContractDBO.findContractsBetweenDates",
                query = "SELECT c FROM ContractDBO c, ScheduleItemDBO si, SchemeDBO s, SchemeOptionDBO so, AnnualRecurrentItemDBO ari WHERE c.managedBrn = :brn AND c = si.contract AND si.schemeOptId = so.schemeOptionId AND so.schemeId = s.schemeId AND ari.scheduleItem.scheduleItemId = si.scheduleItemId AND s.schemeName = :scheme AND ari.startDate <= :startDate and ari.endDate  >= :endDate"),
            @NamedQuery(
                name = "ContractDBO.findContractsByYear",
                query = "SELECT c FROM ContractDBO c, ScheduleItemDBO si, SchemeDBO s, SchemeOptionDBO so, AnnualRecurrentItemDBO ari WHERE c.managedBrn = :brn AND c = si.contract AND si.schemeOptId = so.schemeOptionId AND so.schemeId = s.schemeId AND ari.scheduleItem.scheduleItemId = si.scheduleItemId AND s.schemeName = :scheme AND ari.endDate >= :startDate and ari.endDate  <= :endDate"), })
public class ContractDBO implements Serializable, BaseTableAware {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "CONTRACT_ID")
    private long contractId;

    @Column(name = "CONTRACT_REF_NUM")
    private String contractRefNum;

    @Column(name = "COST_CLA")
    private BigDecimal costCla;

    @Column(name = "COST_INCURRED")
    private BigDecimal costIncurred;

    @Column(name = "JPA_VERSION_NUMBER")
    @Version
    private long jpaVersionNumber;

    @Column(name = "MANAGED_BRN")
    private long managedBrn;

    // bi-directional many-to-one association to ScheduleItemDBO
    @OneToMany(mappedBy = "contract")
    private List<ScheduleItemDBO> scheduleItems;

    @Embedded
    private BaseTable baseTable;

    public ContractDBO() {
    }

    public long getContractId() {
        return this.contractId;
    }

    public void setContractId(long contractId) {
        this.contractId = contractId;
    }

    public String getContractRefNum() {
        return this.contractRefNum;
    }

    public void setContractRefNum(String contractRefNum) {
        this.contractRefNum = contractRefNum;
    }

    public BigDecimal getCostCla() {
        return this.costCla;
    }

    public void setCostCla(BigDecimal costCla) {
        this.costCla = costCla;
    }

    public BigDecimal getCostIncurred() {
        return this.costIncurred;
    }

    public void setCostIncurred(BigDecimal costIncurred) {
        this.costIncurred = costIncurred;
    }

    public long getJpaVersionNumber() {
        return this.jpaVersionNumber;
    }

    public void setJpaVersionNumber(long jpaVersionNumber) {
        this.jpaVersionNumber = jpaVersionNumber;
    }

    public long getManagedBrn() {
        return this.managedBrn;
    }

    public void setManagedBrn(long managedBrn) {
        this.managedBrn = managedBrn;
    }

    public List<ScheduleItemDBO> getScheduleItems() {
        return this.scheduleItems;
    }

    public void setScheduleItems(List<ScheduleItemDBO> scheduleItems) {
        this.scheduleItems = scheduleItems;
    }

    public ScheduleItemDBO addScheduleItem(ScheduleItemDBO scheduleItem) {
        getScheduleItems().add(scheduleItem);
        scheduleItem.setContract(this);

        return scheduleItem;
    }

    public ScheduleItemDBO removeScheduleItem(ScheduleItemDBO scheduleItem) {
        getScheduleItems().remove(scheduleItem);
        scheduleItem.setContract(null);

        return scheduleItem;
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