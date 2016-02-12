/*
 * Project : AFRC Futures
 * Copyright (C) 2013 Scottish Government AFRC Programme
 * AFRC PROPRIETARY/CONFIDENTIAL
 */
package uk.gov.scotland.afrc.applications.model.domain;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import uk.gov.scotland.afrc.applications.model.base.BaseTable;
import uk.gov.scotland.afrc.applications.model.base.BaseTableAware;
import uk.gov.scotland.afrc.applications.model.base.BaseTableListener;

/**
 * @author d607693
 *
 */
@Entity
@Table(name = "LOCATION")
@EntityListeners(BaseTableListener.class)
@NamedQueries(
    value = {
				@NamedQuery(name = "CustomerLocation.retrieveByLocationCode",
				query = "SELECT d FROM CustomerLocationDBO d WHERE trim(d.locationCode) =:locationCode") ,
				
            @NamedQuery(
                name = "CustomerLocation.retrieveByLocationAndGrazing",
                query = "SELECT d FROM CustomerLocationDBO d , LocationCommonGrazingDBO l WHERE d.locationId = l.locationIdCommonGrazing and d.locationId=:locationId"),
				
				@NamedQuery(name = "CustomerLocation.retrieveByLocationId",
                query = "SELECT d FROM CustomerLocationDBO d WHERE trim(d.locationId) =:locationId")
   
		})
public class CustomerLocationDBO implements Serializable, BaseTableAware {

	private static final long serialVersionUID = 1L;

	@Embedded
    private BaseTable baseTable;

    @Id
    @Column(name = "LOCATION_ID")
    private long locationId;

    @Column(name = "LOCATION_CODE", length = 9)
    private String locationCode;

    @Column(name = "LOCATION_NAME", length = 100)
    private String locationName;

    @Column(name = "CONTACT_POINT_ID")
    private long contactPointId;
    
    @Column(name = "TOT_SHEEP_EQUIVALENT_CG")
    private BigDecimal totSheepEquivalentCg;
    
    @Column(name = "AREA_CG")
    private BigDecimal areaCg;
    
   // bi-directional many-to-one association
   /* @OneToMany(mappedBy = "locationCroft", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<LocationCommonGrazingDBO> locationCommonGrazing;*/
    
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

    public long getLocationId() {
        return locationId;
    }

    public void setLocationId(long locationId) {
        this.locationId = locationId;
    }

    public String getLocationCode() {
        return locationCode;
    }

    public void setLocationCode(String locationCode) {
        this.locationCode = locationCode;
    }

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }
    
    public void setContactPointId(long contactPointId) {
		this.contactPointId = contactPointId;
	}
    
    public long getContactPointId() {
		return contactPointId;
	}
    
    public void setTotSheepEquivalentCg(BigDecimal totSheepEquivalentCg) {
		this.totSheepEquivalentCg = totSheepEquivalentCg;
	}
    
    public BigDecimal getTotSheepEquivalentCg() {
		return totSheepEquivalentCg;
	}
    
    public void setAreaCg(BigDecimal areaCg) {
		this.areaCg = areaCg;
	}
    
    public BigDecimal getAreaCg() {
		return areaCg;
	}

}
