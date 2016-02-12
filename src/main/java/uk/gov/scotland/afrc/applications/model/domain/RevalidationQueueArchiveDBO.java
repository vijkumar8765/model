package uk.gov.scotland.afrc.applications.model.domain;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "REVALIDATION_QUEUE_ARCHIVE")
public class RevalidationQueueArchiveDBO {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "REVALIDATION_QUEUE_ID")
    private long revalidationQueueId;

    @Column(name = "APPLICATION_ID")
    private long applicationId;

    @Column(name = "BRN")
    private long brn;

    @Column(name = "DATA_CHANGE_EVENT_ID")
    private long dataChangeEventId;

    @Column(name = "LOCATION_ID")
    private long locationId;

    @Column(name = "LPIS_LND_PRCL_ID")
    private long lpisLndPrclId;

    @Column(name = "QUEUE_DATE")
    private Timestamp queueDate;

    @Column(name = "RULESET")
    private String ruleset;

    public RevalidationQueueArchiveDBO() {
    }

    public long getRevalidationQueueId() {
        return this.revalidationQueueId;
    }

    public void setRevalidationQueueId(long revalidationQueueId) {
        this.revalidationQueueId = revalidationQueueId;
    }

    public long getApplicationId() {
        return this.applicationId;
    }

    public void setApplicationId(long applicationId) {
        this.applicationId = applicationId;
    }

    public long getBrn() {
        return this.brn;
    }

    public void setBrn(long brn) {
        this.brn = brn;
    }

    public long getDataChangeEventId() {
        return this.dataChangeEventId;
    }

    public void setDataChangeEventId(long dataChangeEventId) {
        this.dataChangeEventId = dataChangeEventId;
    }

    public long getLocationId() {
        return this.locationId;
    }

    public void setLocationId(long locationId) {
        this.locationId = locationId;
    }

    public long getLpisLndPrclId() {
        return this.lpisLndPrclId;
    }

    public void setLpisLndPrclId(long lpisLndPrclId) {
        this.lpisLndPrclId = lpisLndPrclId;
    }

    public Timestamp getQueueDate() {
        return this.queueDate;
    }

    public void setQueueDate(Timestamp queueDate) {
        this.queueDate = queueDate;
    }

    public String getRuleset() {
        return this.ruleset;
    }

    public void setRuleset(String ruleset) {
        this.ruleset = ruleset;
    }
}
