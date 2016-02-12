/*
 * Project : AFRC Futures
 * Copyright (C) 2013 Scottish Government AFRC Programme
 * AFRC PROPRIETARY/CONFIDENTIAL
 */
package uk.gov.scotland.afrc.applications.model.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import javax.persistence.Table;

import uk.gov.scotland.afrc.applications.model.base.BaseTable;
import uk.gov.scotland.afrc.applications.model.base.BaseTableAware;
import uk.gov.scotland.afrc.applications.model.base.BaseTableListener;

/**
 * @author d607693
 *
 */
@Entity
@Table(name = "OPTION_GROUP")
@EntityListeners(BaseTableListener.class)
public class OptionGroupDBO implements Serializable, BaseTableAware {

    private static final long serialVersionUID = 1L;

    @Embedded
    private BaseTable baseTable;

    @Id
    @Column(name = "CODE")
    private long code;

    @Column(name = "NAME")
    private String name;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "PARENT_OPT_GROUP_CODE")
    private long parentOptGroupCode;

    @Column(name = "OPT_LEVEL")
    private long optionLevel;

    @Column(name = "END_DATE")
    private Date endDate;

    public BaseTable getBaseTable() {
        if (baseTable == null) {
            baseTable = new BaseTable();
        }

        return baseTable;
    }

    public void setBaseTable(BaseTable baseTable) {
        this.baseTable = baseTable;
    }

    public long getCode() {
        return code;
    }

    public void setCode(long code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getParentOptGroupCode() {
        return parentOptGroupCode;
    }

    public void setParentOptGroupCode(long parentOptGroupCode) {
        this.parentOptGroupCode = parentOptGroupCode;
    }

    public long getOptionLevel() {
        return optionLevel;
    }

    public void setOptionLevel(long optionLevel) {
        this.optionLevel = optionLevel;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

}
