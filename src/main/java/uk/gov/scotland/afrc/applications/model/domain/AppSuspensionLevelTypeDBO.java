/*
 * Project : AFRC Futures
 * Copyright (C) 2013 Scottish Government AFRC Programme
 * AFRC PROPRIETARY/CONFIDENTIAL
 */
package uk.gov.scotland.afrc.applications.model.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

import uk.gov.scotland.afrc.applications.model.base.BaseTable;
import uk.gov.scotland.afrc.applications.model.base.BaseTableAware;
import uk.gov.scotland.afrc.applications.model.base.BaseTableListener;

/**
 *  
 * @author d609030
 *
 */

/**
 * The persistent class for the APP_SUSPENSION database table.
 * 
 */
@Entity
@Table(name = "APP_SUSPENSION_LEVEL_TYPE")
@EntityListeners(BaseTableListener.class)
@NamedQueries(
    value = {
    		@NamedQuery(name = "AppSuspensionLevelTypeDBO.findAll", query = "SELECT s FROM AppSuspensionLevelTypeDBO s"),
    		@NamedQuery(name = "AppSuspensionLevelTypeDBO.findByCode", query = "SELECT s FROM AppSuspensionLevelTypeDBO s where s.appSuspensionLevelTypeCode=:code") })
public class AppSuspensionLevelTypeDBO implements Serializable, BaseTableAware {
	
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "CODE")
    private Long appSuspensionLevelTypeCode;

    @Column(name = "NAME")
    private String appSuspensionLevelTypeName;

    @Column(name = "DESCRIPTION")
    private String desc;

    @Column(name = "JPA_VERSION_NUMBER")
    @Version
    private Long jpaVersionNumber;

    @Column(name = "LAST_UPDATED_BY")
    private Long lastUpdatedBy;

    @Temporal(TemporalType.DATE)
    @Column(name = "LAST_UPDATED_DATE")
    private Date lastUpdatedDate;

    @Temporal(TemporalType.DATE)
    @Column(name = "END_DATE")
    private Date endDate;

    public AppSuspensionLevelTypeDBO() {
    }

	public Long getAppSuspensionLevelTypeCode() {
		return appSuspensionLevelTypeCode;
	}



	public void setAppSuspensionLevelTypeCode(Long appSuspensionLevelTypeCode) {
		this.appSuspensionLevelTypeCode = appSuspensionLevelTypeCode;
	}



	public String getAppSuspensionLevelTypeName() {
		return appSuspensionLevelTypeName;
	}



	public void setAppSuspensionLevelTypeName(String appSuspensionLevelTypeName) {
		this.appSuspensionLevelTypeName = appSuspensionLevelTypeName;
	}



	public String getDesc() {
		return desc;
	}



	public void setDesc(String desc) {
		this.desc = desc;
	}



	public Long getJpaVersionNumber() {
		return jpaVersionNumber;
	}



	public void setJpaVersionNumber(Long jpaVersionNumber) {
		this.jpaVersionNumber = jpaVersionNumber;
	}



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



	public Date getEndDate() {
		return endDate;
	}



	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}



	@Override
	public BaseTable getBaseTable() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setBaseTable(BaseTable baseTable) {
		// TODO Auto-generated method stub
		
	}



    

}