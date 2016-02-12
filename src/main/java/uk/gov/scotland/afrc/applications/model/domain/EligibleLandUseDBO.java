/*
 * Project : AFRC Futures
 * Copyright (C) 2013 Scottish Government AFRC Programme
 * AFRC PROPRIETARY/CONFIDENTIAL
 */
package uk.gov.scotland.afrc.applications.model.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import uk.gov.scotland.afrc.applications.model.base.BaseTable;
import uk.gov.scotland.afrc.applications.model.base.BaseTableAware;
import uk.gov.scotland.afrc.applications.model.base.BaseTableListener;

/**
 * The persistent class for the ELIGIBLE_LAND_USE database table.
 * 
 */
@Entity
@Table(name="ELIGIBLE_LAND_USE")
@NamedQuery(name = "EligibleLandUseDBO.findBPSEligibilityByIdLUT",
    query = "SELECT e FROM EligibleLandUseDBO e WHERE e.landUseTypeId = :landUseTypeId AND e.schemeOption.scheme.schemeName = 'BPS' ")
@EntityListeners(BaseTableListener.class)
public class EligibleLandUseDBO implements Serializable, BaseTableAware {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ELIGIBLE_LAND_USE_IDENTIFIER")
	private long eligibleLandUseId;

    @Embedded
    private BaseTable baseTable;

    @Column(name = "LND_USE_TYPE_CODE")
    @ManyToOne
    private LandUseTypeDBO landUseType;

    @Column(name = "LND_USE_TYPE_CODE")
    private Long landUseTypeId;

    @OneToOne
    @Column(name = "SCHEME_OPTION_ID")
    private SchemeOptionDBO schemeOption;

	public long getEligibleLandUseId() {
		return eligibleLandUseId;
	}

	public SchemeOptionDBO getSchemeOption() {
		return schemeOption;
	}

	public void setSchemeOption(SchemeOptionDBO schemeOption) {
		this.schemeOption = schemeOption;
	}

	public void setEligibleLandUseId(long eligibleLandUseId) {
		this.eligibleLandUseId = eligibleLandUseId;
	}

	public LandUseTypeDBO  getLandUseType() {
		return landUseType;
	}

	public void setLandUseType(LandUseTypeDBO landUseType) {
		this.landUseType = landUseType;
	}

    public Long getLandUseTypeId() {
        return landUseTypeId;
    }

    public void setLandUseTypeId(Long landUseTypeId) {
        this.landUseTypeId = landUseTypeId;
    }

    public EligibleLandUseDBO() {
	}

    public BaseTable getBaseTable() {
        if (baseTable == null) {
            baseTable = new BaseTable();
        }

        return baseTable;
    }

    public void setBaseTable(BaseTable baseTable) {
        this.baseTable = baseTable;
    }
    
    
}