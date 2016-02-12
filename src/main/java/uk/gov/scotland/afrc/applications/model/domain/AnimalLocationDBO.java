/*
 * Project : AFRC Futures
 * Copyright (C) 2013 Scottish Government AFRC Programme
 * AFRC PROPRIETARY/CONFIDENTIAL
 */
package uk.gov.scotland.afrc.applications.model.domain;

import java.io.Serializable;

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
import javax.persistence.Version;

import uk.gov.scotland.afrc.applications.model.base.BaseTable;
import uk.gov.scotland.afrc.applications.model.base.BaseTableAware;
import uk.gov.scotland.afrc.applications.model.base.BaseTableListener;

@Entity
@Table(name = "ANIMAL_LOCATION_DECLARATION")
@EntityListeners(BaseTableListener.class)
@NamedQueries(value = { @NamedQuery(name = "AnimalLocationDBO.animalLocationList",
    query = "SELECT a FROM AnimalLocationDBO a where a.applicationId = :applicationId") })
public class AnimalLocationDBO implements Serializable, BaseTableAware {

	private static final long serialVersionUID = 1L;

	@Column(name = "JPA_VERSION_NUMBER")
    @Version
    private Long jpaVersionNumber;

    @Embedded
    private BaseTable baseTable;

    @Id
    @Column(name = "ANIMAL_LOCN_DECLARATION_ID")
    @SequenceGenerator(name = "ANIMAL_LOC_DECLARATION_SEQ_GENERATOR", sequenceName = "ANIMAL_LOC_DECLARATION_SEQ",
        allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ANIMAL_LOC_DECLARATION_SEQ_GENERATOR")
    private long animalLocationDeclarationId;
    
    @Column(name = "APPLICATION_ID")
    private long applicationId;

    @Column(name = "LOCATION_ID")
    private long locationId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "LOCATION_ID")
    private CustomerLocationDBO customerLocation;

    public CustomerLocationDBO getCustomerLocation() {
        return customerLocation;
    }

    public void setCustomerLocation(CustomerLocationDBO customerLocation) {
        this.customerLocation = customerLocation;
    }

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

    public long getAnimalLocationDeclarationId() {
        return animalLocationDeclarationId;
    }

    public void setAnimalLocationDeclarationId(long animalLocationDeclarationId) {
        this.animalLocationDeclarationId = animalLocationDeclarationId;
    }

    public long getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(long applicationId) {
        this.applicationId = applicationId;
    }

    public long getLocationId() {
        return locationId;
    }

    public void setLocationId(long locationId) {
        this.locationId = locationId;
    }

    public String toString() {
        return "AnimalLocationDBO [baseTable=" + baseTable + ", animalLocationDeclarationId="
            + animalLocationDeclarationId + ", applicationId=" + applicationId + ", locationId=" + locationId
            + ", customerLocation=" + customerLocation + "]";
    }

    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) (applicationId ^ (applicationId >>> 32));
        result = prime * result + (int) (locationId ^ (locationId >>> 32));
        return result;
    }

    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (!(obj instanceof AnimalLocationDBO))
            return false;
        AnimalLocationDBO other = (AnimalLocationDBO) obj;
        if (applicationId != other.applicationId)
            return false;
        if (locationId != other.locationId)
            return false;
        return true;
    }

}
