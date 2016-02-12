package uk.gov.scotland.afrc.applications.model.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Version;

import uk.gov.scotland.afrc.applications.model.base.BaseTable;
import uk.gov.scotland.afrc.applications.model.base.BaseTableAware;
import uk.gov.scotland.afrc.applications.model.base.BaseTableListener;

@Entity
@Table(name = "COLLABORATING_DIRECT_CUSTOMER")
@EntityListeners(BaseTableListener.class)
@NamedQueries(value = {
        @NamedQuery(name = "CollaboratingDirectCustomer.deleteAllByApplicationId",
            query = "DELETE FROM CollaboratingDirectCustomerDBO d WHERE d.applicationId = :applicationId"),
        @NamedQuery(name = "CollaboratingDirectCustomer.findAllByApplicationId",
            query = "SELECT d FROM CollaboratingDirectCustomerDBO d WHERE d.applicationId = :applicationId") })
public class CollaboratingDirectCustomerDBO implements Serializable, BaseTableAware {
    @Column(name = "JPA_VERSION_NUMBER")
    @Version
    private Long jpaVersionNumber;

    @Embedded
    private BaseTable baseTable;

    @Id
    @Column(name = "COLLABORATING_BRN_ID")
    @SequenceGenerator(name = "COLLABORATING_DIRECT_CUSTOMER_SEQ_GENERATOR",
        sequenceName = "COLLABORATING_DIRECT_CUST_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "COLLABORATING_DIRECT_CUSTOMER_SEQ_GENERATOR")
    private Long collaboratingBrnId;

    @Column(name = "BRN")
    private Long brn;

    @Column(name = "APPLICATION_ID")
    private Long applicationId;

    @Column(name = "BRN_REF")
    private String brnReference;

    public Long getJpaVersionNumber() {
        return jpaVersionNumber;
    }

    public void setJpaVersionNumber(Long jpaVersionNumber) {
        this.jpaVersionNumber = jpaVersionNumber;
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

    public Long getCollaboratingBrnId() {
        return collaboratingBrnId;
    }

    public void setCollaboratingBrnId(Long collaboratingBrnId) {
        this.collaboratingBrnId = collaboratingBrnId;
    }

    public Long getBrn() {
        return brn;
    }

    public void setBrn(Long brn) {
        this.brn = brn;
    }

    public Long getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(Long applicationId) {
        this.applicationId = applicationId;
    }

    public String getBrnReference() {
        return brnReference;
    }

    public void setBrnReference(String brnReference) {
        this.brnReference = brnReference;
    }

}
