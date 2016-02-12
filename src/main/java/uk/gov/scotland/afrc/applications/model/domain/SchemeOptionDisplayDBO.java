package uk.gov.scotland.afrc.applications.model.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import uk.gov.scotland.afrc.applications.model.base.BaseTable;
import uk.gov.scotland.afrc.applications.model.base.BaseTableAware;

/**
 * The persistent class for the SCHEME_OPTION_DISPLAY database table.
 * 
 */
@Entity
@Table(name = "SCHEME_OPTION_DISPLAY")
@NamedQuery(name = "SchemeOptionDisplayDBO.findAll", query = "SELECT s FROM SchemeOptionDisplayDBO s")
public class SchemeOptionDisplayDBO implements Serializable, BaseTableAware {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "SCHEME_OPTION_DISPLAY_ID")
    private long schemeOptionDisplayId;

    @Column(name = "JPA_VERSION_NUMBER")
    private long jpaVersionNumber;

    @Embedded
    private BaseTable baseTable;

    @Column(name = "OPT_DESCRIPTION_NARRATIVE")
    private String optDescriptionNarrative;

    @Column(name = "PAYMENT_RATE_DISPLAY_TEXT")
    private String paymentRateDisplayText;

    @OneToOne
    @Column(name = "SCHEME_OPTION_ID")
    private SchemeOptionDBO schemeOption;

    @Column(name = "UNIT_OF_MEAS_DISPLAY_TXT")
    private String unitOfMeasDisplayTxt;

    public SchemeOptionDisplayDBO() {
    }

    public long getSchemeOptionDisplayId() {
        return this.schemeOptionDisplayId;
    }

    public void setSchemeOptionDisplayId(long schemeOptionDisplayId) {
        this.schemeOptionDisplayId = schemeOptionDisplayId;
    }

    public long getJpaVersionNumber() {
        return this.jpaVersionNumber;
    }

    public void setJpaVersionNumber(long jpaVersionNumber) {
        this.jpaVersionNumber = jpaVersionNumber;
    }

    public String getOptDescriptionNarrative() {
        return this.optDescriptionNarrative;
    }

    public void setOptDescriptionNarrative(String optDescriptionNarrative) {
        this.optDescriptionNarrative = optDescriptionNarrative;
    }

    public String getPaymentRateDisplayText() {
        return this.paymentRateDisplayText;
    }

    public void setPaymentRateDisplayText(String paymentRateDisplayText) {
        this.paymentRateDisplayText = paymentRateDisplayText;
    }

    public SchemeOptionDBO getSchemeOption() {
        return schemeOption;
    }

    public void setSchemeOption(SchemeOptionDBO schemeOption) {
        this.schemeOption = schemeOption;
    }

    public String getUnitOfMeasDisplayTxt() {
        return this.unitOfMeasDisplayTxt;
    }

    public void setUnitOfMeasDisplayTxt(String unitOfMeasDisplayTxt) {
        this.unitOfMeasDisplayTxt = unitOfMeasDisplayTxt;
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