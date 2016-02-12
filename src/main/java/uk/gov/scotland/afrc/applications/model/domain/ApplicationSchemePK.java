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
 * The primary key class for the APPLICATION_SCHEME database table.
 * 
 */
@Embeddable
public class ApplicationSchemePK implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "APPLICATION_ID")
    private long applicationId;

    @Column(name = "SCHEME_ID")
    private long schemeId;

    public ApplicationSchemePK() {
    }

    public long getApplicationId() {
        return this.applicationId;
    }

    public void setApplicationId(long applicationId) {
        this.applicationId = applicationId;
    }

    public long getSchemeId() {
        return this.schemeId;
    }

    public void setSchemeId(long schemeId) {
        this.schemeId = schemeId;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ApplicationSchemePK)) {
            return false;
        }
        ApplicationSchemePK castOther = (ApplicationSchemePK) other;
        return (this.applicationId == castOther.applicationId) && (this.schemeId == castOther.schemeId);
    }

    public int hashCode() {
        final int prime = 31;
        int hash = 17;
        hash = hash * prime + ((int) (this.applicationId ^ (this.applicationId >>> 32)));
        hash = hash * prime + ((int) (this.schemeId ^ (this.schemeId >>> 32)));

        return hash;
    }
}