/*
 * Project : AFRC Futures
 * Copyright (C) 2013 Scottish Government AFRC Programme
 * AFRC PROPRIETARY/CONFIDENTIAL
 */
package uk.gov.scotland.afrc.applications.model.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import javax.persistence.Table;

import uk.gov.scotland.afrc.applications.model.base.BaseTable;
import uk.gov.scotland.afrc.applications.model.base.BaseTableListener;

/**
 * @author d608864
 *
 */
@Entity
@Table(name = "OPT_PERIOD_TYPE")
@javax.persistence.Cacheable
@EntityListeners(BaseTableListener.class)
public class OptPeriodTypeDBO
{

    @Embedded
    private BaseTable baseTable;

    @Id
    @Column(name = "CODE")
    private long code;

    @Column(name = "NAME")
    private String name;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "DURATION")
    private long duration;

    @Column(name = "MAX_OFFSET")
    private long maxOffset;
    
    @Column(name = "OFFSET")
    private long offset;

    
	/**
	 * @return the baseTable
	 */
	public BaseTable getBaseTable() 
	{
       
		// Check if baseTbale is null. If so, define.
		if (baseTable == null) 
        {
            baseTable = new BaseTable();
        }
		
        return baseTable;
	}

	
	/**
	 * @param baseTable the baseTable to set
	 */
	public void setBaseTable(BaseTable baseTable) 
	{
		this.baseTable = baseTable;
	}

	
	/**
	 * @return the code
	 */
	public long getCode()
	{
		return code;
	}

	
	/**
	 * @param code the code to set
	 */
	public void setCode(long code) 
	{
		this.code = code;
	}

	
	/**
	 * @return the name
	 */
	public String getName()
	{
		return name;
	}

	
	/**
	 * @param name the name to set
	 */
	public void setName(String name) 
	{
		this.name = name;
	}
	

	/**
	 * @return the description
	 */
	public String getDescription() 
	{
		return description;
	}

	
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description)
	{
		this.description = description;
	}
	

	/**
	 * @return the duration
	 */
	public long getDuration()
	{
		return duration;
	}

	
	/**
	 * @param duration the duration to set
	 */
	public void setDuration(long duration) 
	{
		this.duration = duration;
	}

	
	/**
	 * @return the maxOffset
	 */
	public long getMaxOffset() 
	{
		return maxOffset;
	}

	
	/**
	 * @param maxOffset the maxOffset to set
	 */
	public void setMaxOffset(long maxOffset) 
	{
		this.maxOffset = maxOffset;
	}
	

	/**
	 * @return the offset
	 */
	public long getOffset() 
	{
		return offset;
	}

	
	/**
	 * @param offset the offset to set
	 */
	public void setOffset(long offset) 
	{
		this.offset = offset;
	}
    

}

