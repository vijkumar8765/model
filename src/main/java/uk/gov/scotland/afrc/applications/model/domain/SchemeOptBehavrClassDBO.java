package uk.gov.scotland.afrc.applications.model.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

import uk.gov.scotland.afrc.applications.model.base.BaseTable;
import uk.gov.scotland.afrc.applications.model.base.BaseTableAware;

/**
 * The persistent class for the SCHEME_OPT_BEHAVR_CLASS database table.
 * 
 */
@Entity
@Table(name = "SCHEME_OPT_BEHAVR_CLASS")
@NamedQuery(name = "SchemeOptBehavrClassDBO.findAll", query = "SELECT s FROM SchemeOptBehavrClassDBO s")
public class SchemeOptBehavrClassDBO implements Serializable, BaseTableAware {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "SCHEME_OPT_BEHAVR_CLASS_ID")
    private long schemeOptBehavrClassId;

    @Temporal(TemporalType.DATE)
    @Column(name = "END_DATE")
    private Date endDate;

    @Column(name = "JPA_VERSION_NUMBER")
    @Version
    private long jpaVersionNumber;

    @Embedded
    private BaseTable baseTable;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "SCHEME_OPTION_ID")
    private SchemeOptionDBO schemeOption;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "SCHEME_OPT_BEHAVR_CLASS_CODE")
    private SchemeOptBehavrClassTypeDBO schemeOptBehavrClassType;

    public SchemeOptBehavrClassDBO() {
    }

    public long getSchemeOptBehavrClassId() {
        return this.schemeOptBehavrClassId;
    }

    public void setSchemeOptBehavrClassId(long schemeOptBehavrClassId) {
        this.schemeOptBehavrClassId = schemeOptBehavrClassId;
    }

    public Date getEndDate() {
        return this.endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
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

    public long getJpaVersionNumber() {
        return this.jpaVersionNumber;
    }

    public void setJpaVersionNumber(long jpaVersionNumber) {
        this.jpaVersionNumber = jpaVersionNumber;
    }

   
    public SchemeOptionDBO getSchemeOption() {
        return schemeOption;
    }

    public void setSchemeOption(SchemeOptionDBO schemeOption) {
        this.schemeOption = schemeOption;
    }

    public SchemeOptBehavrClassTypeDBO getSchemeOptBehavrClassType() {
        return schemeOptBehavrClassType;
    }

    public void setSchemeOptBehavrClassType(SchemeOptBehavrClassTypeDBO schemeOptBehavrClassType) {
        this.schemeOptBehavrClassType = schemeOptBehavrClassType;
    }

}