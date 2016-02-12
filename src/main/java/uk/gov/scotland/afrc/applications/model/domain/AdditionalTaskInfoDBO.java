/*
 * Project : AFRC Futures
 * Copyright (C) 2013 Scottish Government AFRC Programme
 * AFRC PROPRIETARY/CONFIDENTIAL
 */
package uk.gov.scotland.afrc.applications.model.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * The persistent class for the ADDITIONAL_TASK_INFO database table.
 * 
 */
@Entity
@Table(name = "ADDITIONAL_TASK_INFO")
@NamedQueries(
    value = { @NamedQuery(
        name = "AdditionalTaskInfo.findByTaskTypeBrnAndBusinessKey",
        query = "SELECT a FROM AdditionalTaskInfoDBO a JOIN a.taskMetadata t WHERE a.taskType = :taskType and a.brn = :brn and t.businessKey = :businessKey and t.businessValue = :businessValue") })
public class AdditionalTaskInfoDBO implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    private long workItemId;

    private int escalated;

    @Temporal(TemporalType.TIMESTAMP)
    private Date escalatedDate;

    @Column(name = "SUSPEND_TYPE")
    private long suspendType;

    private boolean suspendActive;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "SUSPENDSTARTDATE")
    private Date suspendStartDate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "SUSPENDENDDATE")
    private Date suspendEndDate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "TASK_DUE_DATE")
    private Date taskDueDate;

    @Column(name = "TASKTYPE")
    private long taskType;

    @Column(name = "QA_FORCED")
    private boolean qaForced;

    @Column(name = "ORIGINAL_TASK_ID")
    private long originalTaskId;

    @Column(name = "BRN")
    private Long brn;

    @Column(name = "EXTERNAL_INSTANCE_ID")
    private Integer externalInstanceId;

    @Column(name = "ABORTED")
    private Boolean aborted;

    @Column(name = "TASK_MODE")
    private String taskMode;

    @Column(name = "LOCATION_CODE", columnDefinition = "CHAR(9)")
    private String locationCode;

    @Column(name = "BUSINESS_NAME")
    private String businessName;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "TASK_DEADLINE_DATE")
    private Date taskDeadlineDate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "PROCESS_DEADLINE_DATE")
    private Date processDeadlineDate;

    @Column(name = "IS_PROCESS_DEADLINE_FIXED")
    private Boolean processDeadlineFixed;

    @OneToMany(mappedBy = "additionalTaskInfo", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<AdditionalTaskInfoMetadataDBO> taskMetadata;

    public AdditionalTaskInfoDBO() {
    }

    public long getWorkItemId() {
        return this.workItemId;
    }

    public long getSuspendType() {
        return suspendType;
    }

    public void setSuspendType(long suspendType) {
        this.suspendType = suspendType;
    }

    public void setWorkItemId(long workItemId) {
        this.workItemId = workItemId;
    }

    public int getEscalated() {
        return this.escalated;
    }

    public void setEscalated(int escalated) {
        this.escalated = escalated;
    }

    public Date getEscalatedDate() {
        return this.escalatedDate;
    }

    public void setEscalatedDate(Date escalatedDate) {
        this.escalatedDate = escalatedDate;
    }

    public boolean getSuspendActive() {
        return this.suspendActive;
    }

    public void setSuspendActive(boolean suspendActive) {
        this.suspendActive = suspendActive;
    }

    public Date getSuspendStartDate() {
        return this.suspendStartDate;
    }

    public void setSuspendStartDate(Date suspendStartDate) {
        this.suspendStartDate = suspendStartDate;
    }

    public Date getSuspendEndDate() {
        return this.suspendEndDate;
    }

    public void setSuspendEndDate(Date suspendEndDate) {
        this.suspendEndDate = suspendEndDate;
    }

    public long getTaskType() {
        return taskType;
    }

    public void setTaskType(long taskType) {
        this.taskType = taskType;
    }

    public long getOriginalTaskId() {
        return originalTaskId;
    }

    public void setOriginalTaskId(long originalTaskId) {
        this.originalTaskId = originalTaskId;
    }

    public boolean isQAForced() {
        return qaForced;
    }

    public void setQAForced(boolean qaForced) {
        this.qaForced = qaForced;
    }

    public Long getBrn() {
        return brn;
    }

    public void setBrn(Long brn) {
        this.brn = brn;
    }

    public Integer getExternalInstanceId() {
        return externalInstanceId;
    }

    public void setExternalInstanceId(Integer externalInstanceId) {
        this.externalInstanceId = externalInstanceId;
    }

    public Boolean getAborted() {
        return aborted;
    }

    public void setAborted(Boolean aborted) {
        this.aborted = aborted;
    }

    public Date getTaskDueDate() {
        return taskDueDate;
    }

    public void setTaskDueDate(Date taskDueDate) {
        this.taskDueDate = taskDueDate;
    }

    public boolean isQaForced() {
        return qaForced;
    }

    public void setQaForced(boolean qaForced) {
        this.qaForced = qaForced;
    }

    public Date getTaskDeadlineDate() {
        return taskDeadlineDate;
    }

    public void setTaskDeadlineDate(Date taskDeadlineDate) {
        this.taskDeadlineDate = taskDeadlineDate;
    }

    public Date getProcessDeadlineDate() {
        return processDeadlineDate;
    }

    public void setProcessDeadlineDate(Date processDeadlineDate) {
        this.processDeadlineDate = processDeadlineDate;
    }

    public Boolean getProcessDeadlineFixed() {
        return processDeadlineFixed;
    }

    public void setProcessDeadlineFixed(Boolean processDeadlineFixed) {
        this.processDeadlineFixed = processDeadlineFixed;
    }

    public String getTaskMode() {
        return taskMode;
    }

    public void setTaskMode(String taskMode) {
        this.taskMode = taskMode;
    }

    public String getLocationCode() {
        return locationCode;
    }

    public void setLocationCode(String locationCode) {
        this.locationCode = locationCode;
    }

    /**
     * @return the businessName
     */
    public String getBusinessName() {
        return businessName;
    }

    /**
     * @param businessName the businessName to set
     */
    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }

    public List<AdditionalTaskInfoMetadataDBO> getTaskMetadata() {
        return taskMetadata;
    }

    public void setTaskMetadata(List<AdditionalTaskInfoMetadataDBO> taskMetadata) {
        this.taskMetadata = taskMetadata;
    }

}
