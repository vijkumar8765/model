package uk.gov.scotland.afrc.applications.model.domain;

import uk.gov.scotland.afrc.applications.model.base.BaseTable;
import uk.gov.scotland.afrc.applications.model.base.BaseTableAware;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by d608947 on 17/11/2014.
 */
@Entity
@Table(name="PAYMENT_REGION")
public class PaymentRegionDBO implements Serializable, BaseTableAware {

    @Embedded
    private BaseTable baseTable;

    @Id
    @Column(name="PAYMENT_REGION_ID")
    private long paymentRegionId;

    @Column(name="NAME", nullable = false)
    private String name;

    @Column(name="DESCRIPTION")
    private String description;

    @Column(name="JPA_VERSION_NUMBER")
    private long jpaVersionNumber;

    public long getJpaVersionNumber() {
        return jpaVersionNumber;
    }

    public void setJpaVersionNumber(long jpaVersionNumber) {
        this.jpaVersionNumber = jpaVersionNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getPaymentRegionId() {
        return paymentRegionId;
    }

    public void setPaymentRegionId(long paymentRegionId) {
        this.paymentRegionId = paymentRegionId;
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
