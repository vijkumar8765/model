package uk.gov.scotland.afrc.applications.model.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

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
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

import uk.gov.scotland.afrc.applications.model.base.BaseTable;
import uk.gov.scotland.afrc.applications.model.base.BaseTableAware;
import uk.gov.scotland.afrc.applications.model.base.BaseTableListener;

/**
 * The persistent class for the LOCATION_COMMON_GRAZING database table.
 * 
 */
@Entity
@Table(name = "LOCATION_COMMON_GRAZING")
@EntityListeners(BaseTableListener.class)
@NamedQueries(
    value = {
            @NamedQuery(name = "LocationCommonGrazingDBO.findAll", query = "SELECT l FROM LocationCommonGrazingDBO l"),
            @NamedQuery(name = "LocationCommonGrazingDBO.findByLocationIdCroft",
                query = "SELECT l FROM LocationCommonGrazingDBO l where l.locationIdCroft = :locationIdCroft"),
            @NamedQuery(
                name = "LocationCommonGrazingDBO.findByLocationIdCommonGrazing",
                query = "SELECT l FROM LocationCommonGrazingDBO l where l.locationIdCommonGrazing = :locationIdCommonGrazing"),
            @NamedQuery(
                name = "LocationCommonGrazingDBO.findByLocationId",
                query = "SELECT l FROM LocationCommonGrazingDBO l where l.locationIdCommonGrazing = :locationIdCommonGrazing"),
            @NamedQuery(
                name = "LocationCommonGrazingDBO.findByLocationCommonGrazingId",
                query = "SELECT l FROM LocationCommonGrazingDBO l where l.locationCommonGrazingId = :locationCommonGrazingId"),
            @NamedQuery(
                name = "LocationCommonGrazingDBO.findByCGAndCroftAndName",
                query = "SELECT l FROM LocationCommonGrazingDBO l WHERE l.locationIdCommonGrazing = :locationIdCommonGrazing AND l.locationIdCroft = :locationIdCroft AND l.shareCroftName = :shareName"),
            @NamedQuery(
                name = "LocationCommonGrazingDBO.findByCGandCroft",
                query = "SELECT l FROM LocationCommonGrazingDBO l where l.locationIdCommonGrazing = :locationIdCommonGrazing and l.locationIdCroft = :locationIdCroft"),
            @NamedQuery(
                name = "LocationCommonGrazingDBO.retrieveCommonGrzingsByLocation",
                query = "SELECT distinct l.locationCg FROM LocationCommonGrazingDBO l  WHERE l.locationCroft.locationCode=:locationCode or l.locationCg.locationCode=:locationCode " ),
            @NamedQuery(
                name = "LocationCommonGrazingDBO.findByCGAndCroftName",
                query = "SELECT l FROM LocationCommonGrazingDBO l where l.locationIdCommonGrazing = :locationIdCommonGrazing AND l.shareCroftName = :shareName"),
            @NamedQuery(
                name = "LocationCommonGrazingDBO.getCommonGrazingsByBRN",
                query = "SELECT distinct l.locationCg FROM LocationCommonGrazingDBO l, OccupancyDBO oc  WHERE "
                    + " oc.pk.brn =:brn and (l.locationCroft.locationId=oc.pk.locationId or l.locationCg.locationId=oc.pk.locationId)")
            })
public class LocationCommonGrazingDBO implements Serializable, BaseTableAware {
    private static final long serialVersionUID = 1L;


    @Id
    @SequenceGenerator(name = "LOCATION_COMMON_GRAZING__SEQ_GENERATOR", sequenceName = "LOCATION_COMMON_GRAZING_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "LOCATION_COMMON_GRAZING__SEQ_GENERATOR")
    @Column(name = "LOCATION_COMMON_GRAZING_ID")
    private long locationCommonGrazingId;

    @Column(name = "JPA_VERSION_NUMBER")
    @Version
    private long jpaVersionNumber;  

    @Column(name = "LOCATION_ID_CG")
    private long locationIdCommonGrazing;

    @Column(name = "LOCATION_ID_CROFT")
    private Long locationIdCroft;

    // bi-directional many-to-one association
    @ManyToOne
    @JoinColumn(name = "LOCATION_ID_CROFT")
    private CustomerLocationDBO locationCroft;
    
    @OneToOne
    @JoinColumn(name = "LOCATION_ID_CG")
    private CustomerLocationDBO locationCg;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "LOCATION_ID", referencedColumnName = "LOCATION_ID_CROFT")
    private List<OccupancyDBO> occupancies;

    @Column(name = "SHARE_CROFT_NAME")
    private String shareCroftName;

    @Column(name = "TOT_SHEEP_EQUIVALENT")
    private BigDecimal totSheepEquivalent;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "EFFECTIVE_DATE")
    private Date effectiveDate;
    
    // @Column(name = "REASON_CODE")
    // private long reasonCode;
    //
    // @Column(name = "COMMENTS")
    // private String comments;
    //
    // @Column(name = "CROFT_NAME_EDITABLE_FLAG")
    // private boolean croftNameEditable;
    
    
    @Embedded
    private BaseTable baseTable;

    public LocationCommonGrazingDBO() {
    }

    public long getLocationCommonGrazingId() {
        return this.locationCommonGrazingId;
    }

    public void setLocationCommonGrazingId(long locationCommonGrazingId) {
        this.locationCommonGrazingId = locationCommonGrazingId;
    }

    public long getJpaVersionNumber() {
        return this.jpaVersionNumber;
    }

    public void setJpaVersionNumber(long jpaVersionNumber) {
        this.jpaVersionNumber = jpaVersionNumber;
    }


    public long getLocationIdCommonGrazing() {
        return this.locationIdCommonGrazing;
    }

    public void setLocationIdCommonGrazing(long locationIdCommonGrazing) {
        this.locationIdCommonGrazing = locationIdCommonGrazing;
    }

    public Long getLocationIdCroft() {
        return this.locationIdCroft;
    }

    public void setLocationIdCroft(Long locationIdCroft) {
        this.locationIdCroft = locationIdCroft;
    }

    public String getShareCroftName() {
        return this.shareCroftName;
    }

    public void setShareCroftName(String shareCroftName) {
        this.shareCroftName = shareCroftName;
    }

    public BigDecimal getTotSheepEquivalent() {
        return this.totSheepEquivalent;
    }

    public void setTotSheepEquivalent(BigDecimal totSheepEquivalent) {
        this.totSheepEquivalent = totSheepEquivalent;
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

    public CustomerLocationDBO getLocationCroft() {
        return locationCroft;
    }

    public void setLocationCroft(CustomerLocationDBO locationCroft) {
        this.locationCroft = locationCroft;
    }

    public List<OccupancyDBO> getOccupancies() {
        return occupancies;
    }

    public void setOccupancies(List<OccupancyDBO> occupancies) {
        this.occupancies = occupancies;
    }

    public Date getEffectiveDate() {
        return effectiveDate;
    }

    public void setEffectiveDate(Date effectiveDate) {
        this.effectiveDate = effectiveDate;
    }

    public CustomerLocationDBO getLocationCg() {
        return locationCg;
    }

    public void setLocationCg(CustomerLocationDBO locationCg) {
        this.locationCg = locationCg;
    }

    // public long getReasonCode() {
    // return reasonCode;
    // }
    //
    // public void setReasonCode(long reasonCode) {
    // this.reasonCode = reasonCode;
    // }
    //
    // public String getComments() {
    // return comments;
    // }
    //
    // public void setComments(String comments) {
    // this.comments = comments;
    // }
    //
    // public boolean isCroftNameEditable() {
    // return croftNameEditable;
    // }
    //
    // public void setCroftNameEditable(boolean croftNameEditable) {
    // this.croftNameEditable = croftNameEditable;
    // }

}
