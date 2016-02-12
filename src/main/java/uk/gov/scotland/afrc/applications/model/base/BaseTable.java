/*
 * Project : AFRC Futures
 * Copyright (C) 2013 Scottish Government AFRC Programme
 * AFRC PROPRIETARY/CONFIDENTIAL
 */
package uk.gov.scotland.afrc.applications.model.base;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Embeddable
public class BaseTable implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "LAST_UPDATED_BY")
    private Long lastUpdatedBy;

	
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "LAST_UPDATED_DATE")
    private Date lastUpdatedDate;

    /*public void updateForWrite() {
        FuturesContextHeader contextHeader = FuturesContext.get();

        Long userId = contextHeader.getUserPK();

        if (userId != null) {
            lastUpdatedBy = userId;
        }

        lastUpdatedDate = new Date();
    }*/

    public Long getLastUpdatedBy() {
        return lastUpdatedBy;
    }

    public void setLastUpdatedBy(Long lastUpdatedBy) {
        this.lastUpdatedBy = lastUpdatedBy;
    }

    public Date getLastUpdatedDate() {
        return lastUpdatedDate;
    }

    public void setLastUpdatedDate(Date lastUpdatedDate) {
        this.lastUpdatedDate = lastUpdatedDate;
    }

    public String toString() {
        return "BaseTable(" + super.toString() + ") [lastUpdatedBy=" + lastUpdatedBy + ", lastUpdatedDate="
            + lastUpdatedDate;
    }
}
