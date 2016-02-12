package uk.gov.scotland.afrc.applications.model.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Version;

import uk.gov.scotland.afrc.applications.model.base.BaseTable;
import uk.gov.scotland.afrc.applications.model.base.BaseTableAware;
import uk.gov.scotland.afrc.applications.model.base.BaseTableListener;

/**
 * The persistent class for the SCHEDULE_ITEM database table.
 * 
 */

// TODO reinstate in ScheduleItemDBO.findByContractId once IM team provide start date AND si.startDate = :startDate
@Entity
@Table(name = "SCHEDULE_ITEM")
@EntityListeners(BaseTableListener.class)
@NamedQueries(
    value = {
            @NamedQuery(name = "ScheduleItem.findAll", query = "SELECT s FROM ScheduleItemDBO s"),
            @NamedQuery(name = "ScheduleItemDBO.findByApplicationId",
                query = "SELECT s FROM ScheduleItemDBO s where s.application.applicationId = :applicationId"),
            @NamedQuery(name = "ScheduleItemDBO.findByDistictSchemeOptIdByApplicationId",
                query = "SELECT distinct s.schemeOptId FROM ScheduleItemDBO s where s.application.applicationId = :applicationId"),
            @NamedQuery(name = "ScheduleItemDBO.findByAppLndPrclId",
                query = "SELECT s FROM ScheduleItemDBO s where s.appLndParcel.appLndPrclId = :appLndPrclId"),
            @NamedQuery(
                name = "ScheduleItemDBO.findByApplicationIdAndScheduleItemId",
                query = "SELECT s FROM ScheduleItemDBO s where s.application.applicationId = :applicationId and s.scheduleItemId = :scheduleItemId"),
            @NamedQuery(
                name = "ScheduleItemDBO.findByContractId",
                query = "SELECT si FROM ScheduleItemDBO si, ContractDBO c, SchemeOptionDBO so, SchemeDBO sc, AnnualRecurrentItemDBO ari WHERE c.managedBrn =:managedBrn AND c.contractId =:contractId AND c.contractId = si.contractId AND si.schemeOptId = so.schemeOptionId AND ari.scheduleItem.scheduleItemId = si.scheduleItemId AND sc.schemeId = so.schemeId AND ari.startDate = :startDate"),
            @NamedQuery(
                name = "ScheduleItemDBO.findByContractIdAndEndDate",
                query = "SELECT si FROM ScheduleItemDBO si, AnnualRecurrentItemDBO ari, ContractDBO c, SchemeOptionDBO so, SchemeDBO sc WHERE c.managedBrn =:managedBrn AND c.contractId =:contractId AND c.contractId = si.contractId AND ari.endDate >= :endDate AND si.schemeOptId = so.schemeOptionId AND sc.schemeId = so.schemeId AND si.scheduleItemId = ari.scheduleItemId"),
            @NamedQuery(
                name = "ScheduleItemDBO.findByContractIdAndEndDateAfter",
                query = "SELECT si FROM ScheduleItemDBO si, ContractDBO c, SchemeOptionDBO so, SchemeDBO sc, AnnualRecurrentItemDBO ari WHERE c.managedBrn =:managedBrn AND c.contractId =:contractId AND c.contractId = si.contractId AND si.schemeOptId = so.schemeOptionId AND ari.scheduleItem.scheduleItemId = si.scheduleItemId AND sc.schemeId = so.schemeId AND ari.endDate >= :endDate"),
            @NamedQuery(
                name = "ScheduleItemDBO.findScheduleItemsByApplicationIdAndAppLndPrclId",
                query = "SELECT s FROM ScheduleItemDBO s where s.application.applicationId = :applicationId and s.appLndParcel.appLndPrclId = :appLndPrclId"),
            @NamedQuery(
                    name = "ScheduleItemDBO.findScheduleItemsByApplicationIdAndSchemeOptionId",
                query = "SELECT s FROM ScheduleItemDBO s where s.application.applicationId = :applicationId and s.schemeOption.schemeOptionId = :schemeOptionId"),
            @NamedQuery(name = "ScheduleItemDBO.findScheduleItemsByLPISLandParcelId",
                query = "SELECT s FROM ScheduleItemDBO s where s.lpisLndPrclId = :lpisLndPrclId")
    })
@NamedQuery(name = "ScheduleItemDBO.findAll", query = "SELECT s FROM ScheduleItemDBO s")
public class ScheduleItemDBO implements Serializable, BaseTableAware {
    private static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name = "SCHEDULE_ITEM_SEQ_GENERATOR", sequenceName = "SCHEDULE_ITEM_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SCHEDULE_ITEM_SEQ_GENERATOR")
    @Column(name = "SCHEDULE_ITEM_ID")
    private long scheduleItemId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "APPLICATION_ID")
    private ApplicationDBO application;

    @Column(name = "JPA_VERSION_NUMBER")
    @Version
    private long jpaVersionNumber;

    @Column(name = "LPIS_LND_PRCL_ID")
    private long lpisLndPrclId;

    @Column(name = "SCHEME_OPT_ID")
    private long schemeOptId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "SCHEME_OPT_ID")
    private SchemeOptionDBO schemeOption;

    @Column(name = "CONTRACT_ID")
    private Long contractId;

    // bi-directional many-to-one association to ContractDBO
    @ManyToOne
    @JoinColumn(name = "CONTRACT_ID")
    private ContractDBO contract;

    // bi-directional many-to-one association to ScheduleItem
    @ManyToOne
    @JoinColumn(name = "APP_LND_PRCL_ID")
    private AppLndPrclDBO appLndParcel;

    // bi-directional many-to-one association to AnnualRecurrentItem
    @OneToMany(mappedBy = "scheduleItem", cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE },
        fetch = FetchType.EAGER)
    private List<AnnualRecurrentItemDBO> annualRecurrentItems;

    // bi-directional many-to-one association to CapitalItem
    @OneToMany(mappedBy = "scheduleItem", cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE },
        fetch = FetchType.EAGER)
    private List<CapitalItemDBO> capitalItems;

    @Column(name = "APP_LND_PRCL_ID")
    private Long appLndPrclId;

    public Long getAppLndPrclId() {
        return appLndPrclId;
    }

    public void setAppLndPrclId(Long appLndPrclId) {
        this.appLndPrclId = appLndPrclId;
    }

    @Embedded
    private BaseTable baseTable;

    public ScheduleItemDBO() {
    }

    public ApplicationDBO getApplication() {
        return application;
    }

    public void setApplication(ApplicationDBO application) {
        this.application = application;
    }

    public long getScheduleItemId() {
        return this.scheduleItemId;
    }

    public void setScheduleItemId(long scheduleItemId) {
        this.scheduleItemId = scheduleItemId;
    }

    public long getJpaVersionNumber() {
        return this.jpaVersionNumber;
    }

    public void setJpaVersionNumber(long jpaVersionNumber) {
        this.jpaVersionNumber = jpaVersionNumber;
    }

    public long getLpisLndPrclId() {
        return this.lpisLndPrclId;
    }

    public void setLpisLndPrclId(long lpisLndPrclId) {
        this.lpisLndPrclId = lpisLndPrclId;
    }

    // public Date getStartDate() {
    // return this.startDate;
    // }
    //
    // public void setStartDate(Date startDate) {
    // this.startDate = startDate;
    // }

    public SchemeOptionDBO getSchemeOption() {
        return schemeOption;
    }

    public void setSchemeOption(SchemeOptionDBO schemeOption) {
        this.schemeOption = schemeOption;
    }

    public ContractDBO getContract() {
        return this.contract;
    }

    public void setContract(ContractDBO contract) {
        this.contract = contract;
    }

    public Long getContractId() {
        return contractId;
    }

    public void setContractId(Long contractId) {
        this.contractId = contractId;
    }

    public List<AnnualRecurrentItemDBO> getAnnualRecurrentItems() {
        return this.annualRecurrentItems;
    }

    public void setAnnualRecurrentItems(List<AnnualRecurrentItemDBO> annualRecurrentItems) {
        this.annualRecurrentItems = annualRecurrentItems;
    }

    public AnnualRecurrentItemDBO addAnnualRecurrentItem(AnnualRecurrentItemDBO annualRecurrentItem) {
        getAnnualRecurrentItems().add(annualRecurrentItem);
        annualRecurrentItem.setScheduleItem(this);

        return annualRecurrentItem;
    }

    public AnnualRecurrentItemDBO removeAnnualRecurrentItem(AnnualRecurrentItemDBO annualRecurrentItem) {
        getAnnualRecurrentItems().remove(annualRecurrentItem);
        annualRecurrentItem.setScheduleItem(null);

        return annualRecurrentItem;
    }

    public List<CapitalItemDBO> getCapitalItems() {
        return this.capitalItems;
    }

    public void setCapitalItems(List<CapitalItemDBO> capitalItems) {
        this.capitalItems = capitalItems;
    }

    public CapitalItemDBO addCapitalItem(CapitalItemDBO capitalItem) {
        getCapitalItems().add(capitalItem);
        capitalItem.setScheduleItem(this);

        return capitalItem;
    }

    public CapitalItemDBO removeCapitalItem(CapitalItemDBO capitalItem) {
        getCapitalItems().remove(capitalItem);
        capitalItem.setScheduleItem(null);

        return capitalItem;
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

    public long getSchemeOptId() {
        return schemeOptId;
    }

    public void setSchemeOptId(long schemeOptId) {
        this.schemeOptId = schemeOptId;
    }

    public AppLndPrclDBO getAppLndParcel() {
        return appLndParcel;
    }

    public void setAppLndParcel(AppLndPrclDBO appLndParcel) {
        this.appLndParcel = appLndParcel;
    }

}