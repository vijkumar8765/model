package uk.gov.scotland.afrc.applications.model.domain;

import uk.gov.scotland.afrc.applications.model.base.BaseTable;
import uk.gov.scotland.afrc.applications.model.base.BaseTableAware;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by d608947 on 14/11/2014.
 */
@Entity
@Table(name="PAYMENT_RATE_BAND")
public class PaymentRateBandDBO implements Serializable, BaseTableAware {
    private static final long serialVersionUID = 1L;

    @Embedded
    private BaseTable baseTable;

    @Id
    @Column(name="PAYMENT_RATE_BAND_ID")
    private long paymentRateBandId;

    /*@OneToOne
    @JoinColumn(name = "PAYMENT_REGION_ID")
    private PaymentRegionDBO paymentRegion;*/

    @Column(name="JPA_VERSION_NUMBER")
    private long jpaVersionNumber;

    @Column(name="PAYMENT_RATE")
    private BigDecimal paymentRate;

    @Column(name="CAP")
    private BigDecimal cap;

    @Column(name="PAYMENT_PCT")
    private BigDecimal paymentPct;

    @Column(name="BASE_CAP")
    private BigDecimal baseCap;

    public long getJpaVersionNumber() {
        return jpaVersionNumber;
    }

    public void setJpaVersionNumber(long jpaVersionNumber) {
        this.jpaVersionNumber = jpaVersionNumber;
    }

    public long getPaymentRateBandId() {
        return paymentRateBandId;
    }

    public void setPaymentRateBandId(long paymentRateBandId) {
        this.paymentRateBandId = paymentRateBandId;
    }

    /*public PaymentRegionDBO getPaymentRegion() {
        return paymentRegion;
    }

    public void setPaymentRegion(PaymentRegionDBO paymentRegion) {
        this.paymentRegion = paymentRegion;
    }*/

    public BigDecimal getPaymentRate() {
        return paymentRate;
    }

    public void setPaymentRate(BigDecimal paymentRate) {
        this.paymentRate = paymentRate;
    }

    public BigDecimal getCap() {
        return cap;
    }

    public void setCap(BigDecimal cap) {
        this.cap = cap;
    }

    public BigDecimal getPaymentPct() {
        return paymentPct;
    }

    public void setPaymentPct(BigDecimal paymentPct) {
        this.paymentPct = paymentPct;
    }

    public BigDecimal getBaseCap() {
        return baseCap;
    }

    public void setBaseCap(BigDecimal baseCap) {
        this.baseCap = baseCap;
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
