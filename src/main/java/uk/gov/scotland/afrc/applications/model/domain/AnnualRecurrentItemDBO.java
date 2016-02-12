package uk.gov.scotland.afrc.applications.model.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

import uk.gov.scotland.afrc.applications.model.base.BaseTable;
import uk.gov.scotland.afrc.applications.model.base.BaseTableAware;
import uk.gov.scotland.afrc.applications.model.base.BaseTableListener;

/**
 * The persistent class for the ANNUAL_RECURRENT_ITEM database table.
 * 
 */
@Entity
@Table(name = "ANNUAL_RECURRENT_ITEM")
@EntityListeners(BaseTableListener.class)
@NamedQueries(value = {
        @NamedQuery(name = "AnnualRecurrentItem.findAll", query = "SELECT a FROM AnnualRecurrentItemDBO a"),
        @NamedQuery(name = "AnnualRecurrentItem.findByScheduleItem",
            query = "SELECT a FROM AnnualRecurrentItemDBO a WHERE a.scheduleItem.scheduleItemId =:scheduleItemId"),
        @NamedQuery(name = "AnnualRecurrentItem.findDistinctMapLetterByScheduleItem",
            query = "SELECT distinct upper(a.mapLetter) FROM AnnualRecurrentItemDBO a WHERE a.scheduleItem.scheduleItemId =:scheduleItemId")})
public class AnnualRecurrentItemDBO implements Serializable,BaseTableAware {
    private static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name = "ANNUAL_RECURRENT_ITEM_SEQ_GENERATOR", sequenceName = "ANNUAL_RECURRENT_ITEM_SEQ",
        allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ANNUAL_RECURRENT_ITEM_SEQ_GENERATOR")
    @Column(name = "ANNUAL_RECURRENT_ITEM_ID")
    private long annualRecurrentItemId;

    @Column(name = "FIRST_YR_OF_CLAIM")
    private long firstYrOfClaim;

    @Column(name = "JPA_VERSION_NUMBER")
    @Version
    private Long jpaVersionNumber;

    @Column(name = "MAP_LETTER")
    private String mapLetter;

    @Column(name = "PRO_UNITS")
    private BigDecimal proUnits;

    @Column(name = "SCHEDULE_ITEM_ID")
    private long scheduleItemId;

    // bi-directional many-to-one association to ScheduleItem
    @ManyToOne
    @JoinColumn(name = "SCHEDULE_ITEM_ID")
    private ScheduleItemDBO scheduleItem;
    
    // bi-directional many-to-one association to CapitalItem
    @OneToMany(mappedBy = "annualRecurrentItem", cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE },
        fetch = FetchType.EAGER)
    private List<AnnualRecurrentRotationYrDBO> annualRecurrentRotationYr;
    
    @Temporal( TemporalType.DATE)
    @Column(name="START_DATE")
    private Date startDate;
    
    @Temporal( TemporalType.DATE)
    @Column(name="END_DATE")
    private Date endDate;    

    @Embedded
    private BaseTable baseTable;

    public AnnualRecurrentItemDBO() {
    }
    
    public void setScheduleItemId(long scheduleItemId) {
        this.scheduleItemId = scheduleItemId;
    }

    public long getScheduleItemId() {
        return scheduleItemId;
    }


    public long getAnnualRecurrentItemId() {
        return this.annualRecurrentItemId;
    }

    public void setAnnualRecurrentItemId(long annualRecurrentItemId) {
        this.annualRecurrentItemId = annualRecurrentItemId;
    }

    public long getFirstYrOfClaim() {
        return this.firstYrOfClaim;
    }

    public void setFirstYrOfClaim(long firstYrOfClaim) {
        this.firstYrOfClaim = firstYrOfClaim;
    }

    public Long getJpaVersionNumber() {
        return this.jpaVersionNumber;
    }

    public void setJpaVersionNumber(Long jpaVersionNumber) {
        this.jpaVersionNumber = jpaVersionNumber;
    }

    public String getMapLetter() {
        return this.mapLetter;
    }

    public void setMapLetter(String mapLetter) {
        this.mapLetter = mapLetter;
    }

    public BigDecimal getProUnits() {
		return proUnits;
	}

	public void setProUnits(BigDecimal proUnits) {
		this.proUnits = proUnits;
	}

	public ScheduleItemDBO getScheduleItem() {
        return this.scheduleItem;
    }

    public void setScheduleItem(ScheduleItemDBO scheduleItem) {
        this.scheduleItem = scheduleItem;
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

    public List<AnnualRecurrentRotationYrDBO> getAnnualRecurrentRotationYr() {
        return annualRecurrentRotationYr;
    }

    public void setAnnualRecurrentRotationYr(List<AnnualRecurrentRotationYrDBO> annualRecurrentRotationYr) {
        this.annualRecurrentRotationYr = annualRecurrentRotationYr;
    }
    
    public AnnualRecurrentRotationYrDBO addAnnualRecurrentRotationYr(AnnualRecurrentRotationYrDBO annualRecurrentRotationYr) {
        getAnnualRecurrentRotationYr().add(annualRecurrentRotationYr);
        annualRecurrentRotationYr.setAnnualRecurrentItem(this);
        return annualRecurrentRotationYr;
    }

    public AnnualRecurrentRotationYrDBO removeAnnualRecurrentItem(AnnualRecurrentRotationYrDBO annualRecurrentRotationYr) {
    	 getAnnualRecurrentRotationYr().remove(annualRecurrentRotationYr);
    	 annualRecurrentRotationYr.setAnnualRecurrentItem(this);
         return annualRecurrentRotationYr;
    }
    
    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
}