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
 * The primary key class for the APPLICATION_SCHEME_OPTION database table.
 * 
 */
@Embeddable
public class ApplicationSchemeOptionPK implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "APPLICATION_ID")
    private long applicationId;

    @Column(name = "SCHEME_OPT_ID")
    private long schemeOptionId;

    public ApplicationSchemeOptionPK() {
    }

    public long getApplicationId() {
        return this.applicationId;
    }

    public void setApplicationId(long applicationId) {
        this.applicationId = applicationId;
    }

    public long getSchemeOptionId() {
        return this.schemeOptionId;
    }

    public void setSchemeOptionId(long schemeOptionId) {
        this.schemeOptionId = schemeOptionId;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ApplicationSchemeOptionPK)) {
            return false;
        }
        ApplicationSchemeOptionPK castOther = (ApplicationSchemeOptionPK) other;
        return (this.applicationId == castOther.applicationId) && (this.schemeOptionId == castOther.schemeOptionId);
    }

    public int hashCode() {
        final int prime = 31;
        int hash = 17;
        hash = hash * prime + ((int) (this.applicationId ^ (this.applicationId >>> 32)));
        hash = hash * prime + ((int) (this.schemeOptionId ^ (this.schemeOptionId >>> 32)));

        return hash;
    }
}