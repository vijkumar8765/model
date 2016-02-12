package uk.gov.scotland.afrc.applications.model.domain;

import java.io.Serializable;
import java.util.Date;

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
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.persistence.Version;

import uk.gov.scotland.afrc.applications.model.base.BaseTable;
import uk.gov.scotland.afrc.applications.model.base.BaseTableAware;
import uk.gov.scotland.afrc.applications.model.base.BaseTableListener;

@Entity
@EntityListeners(BaseTableListener.class)
@NamedQueries(value = { @NamedQuery(name = "DataChangeEventDBO.findPendingDataChangeEvents",
    query = "SELECT d FROM DataChangeEventDBO d") })
@Table(name = "Data_Change_Event")
public class DataChangeEventDBO implements Serializable, BaseTableAware {

    private static final long serialVersionUID = -57581494106200410L;

    @Column(name = "JPA_VERSION_NUMBER")
    @Version
    private Long jpaVersionNumber;

    @Id
    @Column(name = "DATA_CHANGE_EVENT_ID")
    @SequenceGenerator(name = "DATA_CHANGE_EVENT_SEQ_GENERATOR", sequenceName = "DATA_CHANGE_EVENT_SEQ",
        allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "DATA_CHANGE_EVENT_SEQ_GENERATOR")
    private long dataChangeEventId;

    @Temporal(TemporalType.DATE)
    @Column(name = "EVENT_DATE")
    private Date eventDate;

    @Column(name = "DM_BATCH_REF")
    private String dmBatchRef;

    @Column(name = "SOURCE")
    private String source;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "EVENT_TYPE")
    private DataChangeEventTypeDBO dataChangeEventType;

    @Column(name = "BRN")
    private String brn;

    @Column(name = "CONTRACT_ID")
    private long contractId;

    @Column(name = "LPIS_LND_PRCL_ID")
    private long lpisLndPrclId;

    @Column(name = "LOCATION_ID")
    private long locationId;

    @Column(name = "OBJECT_ID")
    private long objectId;

    @Temporal(TemporalType.DATE)
    @Column(name = "PDU_IS_PROCESSED_DATE")
    private Date pduIsProcessedDate;

    @Temporal(TemporalType.DATE)
    @Column(name = "FME_IS_PROCESSED_DATE")
    private Date fmeIsProcessedDate;

    @Column(name = "PRCL_ID")
    private String prclId;

    @Embedded
    private BaseTable baseTable;

    @Transient
    private boolean processingSuccessful;

    @Transient
    private boolean appCommonGrazingUpdated;

    @Transient
    private boolean appLandParcelUpdated;

    @Transient
    private DataChangeEventDBO expiredEvent;

    @Column(name = "EVENT_TYPE")
    private long eventType;

    public long getEventType() {
        return eventType;
    }

    public void setEventType(long eventType) {
        this.eventType = eventType;
    }

    @Column(name = "EFFECTIVE_DATE")
    private Date effectiveDate;

    public Date getEffectiveDate() {
        return effectiveDate;
    }

    public void setEffectiveDate(Date effectiveDate) {
        this.effectiveDate = effectiveDate;
    }

    public DataChangeEventDBO() {
        this.processingSuccessful = true;
    }

    public long getDataChangeEventId() {
        return dataChangeEventId;
    }

    public void setDataChangeEventId(long dataChangeEventId) {
        this.dataChangeEventId = dataChangeEventId;
    }

    public long getLpisLndPrclId() {
        return lpisLndPrclId;
    }

    public void setLpisLndPrclId(long lpisLndPrclId) {
        this.lpisLndPrclId = lpisLndPrclId;
    }

    public Date getEventDate() {
        return eventDate;
    }

    public void setEventDate(Date eventDate) {
        this.eventDate = eventDate;
    }

    public String getDmBatchRef() {
        return dmBatchRef;
    }

    public void setDmBatchRef(String dmBatchRef) {
        this.dmBatchRef = dmBatchRef;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public DataChangeEventTypeDBO getDataChangeEventType() {
        return dataChangeEventType;
    }

    public void setDataChangeEventType(DataChangeEventTypeDBO dataChangeEventType) {
        this.dataChangeEventType = dataChangeEventType;
    }

    public String getBrn() {
        return brn;
    }

    public void setBrn(String brn) {
        this.brn = brn;
    }

    public long getContractId() {
        return contractId;
    }

    public void setContractId(long contractId) {
        this.contractId = contractId;
    }

    public long getLocationId() {
        return locationId;
    }

    public void setLocationId(long locationId) {
        this.locationId = locationId;
    }

    public boolean isProcessingSuccessful() {
        return processingSuccessful;
    }

    public void setProcessingSuccessful(boolean processingSuccessful) {
        this.processingSuccessful = processingSuccessful;
    }

    public boolean isAppCommonGrazingUpdated() {
        return appCommonGrazingUpdated;
    }

    public void setAppCommonGrazingUpdated(boolean appCommonGrazingUpdated) {
        this.appCommonGrazingUpdated = appCommonGrazingUpdated;
    }

    public boolean isAppLandParcelUpdated() {
        return appLandParcelUpdated;
    }

    public void setAppLandParcelUpdated(boolean appLandParcelUpdated) {
        this.appLandParcelUpdated = appLandParcelUpdated;
    }

    public Long getJpaVersionNumber() {
        return jpaVersionNumber;
    }

    public void setJpaVersionNumber(Long jpaVersionNumber) {
        this.jpaVersionNumber = jpaVersionNumber;
    }

    public long getObjectId() {
        return objectId;
    }

    public void setObjectId(long objectId) {
        this.objectId = objectId;
    }

    public Date getPduIsProcessedDate() {
        return pduIsProcessedDate;
    }

    public void setPduIsProcessedDate(Date pduIsProcessedDate) {
        this.pduIsProcessedDate = pduIsProcessedDate;
    }

    public Date getFmeIsProcessedDate() {
        return fmeIsProcessedDate;
    }

    public void setFmeIsProcessedDate(Date fmeIsProcessedDate) {
        this.fmeIsProcessedDate = fmeIsProcessedDate;
    }

    public String getPrclId() {
        return prclId;
    }

    public void setPrclId(String prclId) {
        this.prclId = prclId;
    }

    public DataChangeEventDBO getExpiredEvent() {
        return expiredEvent;
    }

    public void setExpiredEvent(DataChangeEventDBO expiredEvent) {
        this.expiredEvent = expiredEvent;
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

}
