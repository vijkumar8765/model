package uk.gov.scotland.afrc.applications.model.domain;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * The persistent class for the REVALIDATION_QUEUE database table.
 * 
 */
@Entity
@Table(name = "REVALIDATION_QUEUE")
@NamedQuery(name = "findPendingRevalidationEvents", query = "SELECT r FROM RevalidationQueueDBO r")
public class RevalidationQueueDBO implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name = "REVALIDATION_QUEUE_GENERATOR", sequenceName = "REVALIDATION_QUEUE_SEQ",
        allocationSize = 1,
        initialValue = 100)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "REVALIDATION_QUEUE_GENERATOR")
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

    public RevalidationQueueDBO() {
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