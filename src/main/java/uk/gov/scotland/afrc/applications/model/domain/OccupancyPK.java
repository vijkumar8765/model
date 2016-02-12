/*
 * Project : AFRC Futures
 * Copyright (C) 2013 Scottish Government AFRC Programme
 * AFRC PROPRIETARY/CONFIDENTIAL
 */
package uk.gov.scotland.afrc.applications.model.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * The primary key class for the OCCUPANCY database table.
 * 
 */
@Embeddable
public class OccupancyPK implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name = "BRN")
    private long brn;

    @Column(name = "LOCATION_ID")
    private long locationId;

    public OccupancyPK() {
    }

    public long getBrn() {
        return brn;
    }

    public void setBrn(long brn) {
        this.brn = brn;
    }

    public long getLocationId() {
        return locationId;
    }

    public void setLocationId(long locationId) {
        this.locationId = locationId;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) (brn ^ (brn >>> 32));
        result = prime * result + (int) (locationId ^ (locationId >>> 32));
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        OccupancyPK other = (OccupancyPK) obj;
        if (brn != other.brn)
            return false;
        if (locationId != other.locationId)
            return false;
        return true;
    }

}