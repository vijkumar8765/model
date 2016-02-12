/*
 * Project : AFRC Futures
 * Copyright (C) 2013 Scottish Government AFRC Programme
 * AFRC PROPRIETARY/CONFIDENTIAL
 */
package uk.gov.scotland.afrc.applications.model.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ADDL_TASK_OR_PROC_INFO_KEY")
public class AdditionalTaskInfoMetadataDBO implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "ID")
    private long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "WORK_ITEM_ID", nullable = false)
    private AdditionalTaskInfoDBO additionalTaskInfo;
    
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "EXTERNAL_INSTANCE_ID", nullable = false)
    private AdditionalProcessInfoDBO additionalProcessInfo;

	@Column(name = "KEY_NAME")
    private String businessKey;

    @Column(name = "KEY_VALUE")
    private String businessValue;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public AdditionalTaskInfoDBO getAdditionalTaskInfo() {
        return additionalTaskInfo;
    }

    public void setAdditionalTaskInfo(AdditionalTaskInfoDBO additionalTaskInfo) {
        this.additionalTaskInfo = additionalTaskInfo;
    }

    public String getBusinessKey() {
        return businessKey;
    }

    public void setBusinessKey(String businessKey) {
        this.businessKey = businessKey;
    }

    public String getBusinessValue() {
        return businessValue;
    }

    public void setBusinessValue(String businessValue) {
        this.businessValue = businessValue;
    }

    public AdditionalProcessInfoDBO getAdditionalProcessInfo() {
		return additionalProcessInfo;
	}

	public void setAdditionalProcessInfo(
			AdditionalProcessInfoDBO additionalProcessInfo) {
		this.additionalProcessInfo = additionalProcessInfo;
	}
	
	
}
