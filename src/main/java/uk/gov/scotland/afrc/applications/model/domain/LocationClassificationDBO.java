package uk.gov.scotland.afrc.applications.model.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Version;

import uk.gov.scotland.afrc.applications.model.base.BaseTable;
import uk.gov.scotland.afrc.applications.model.base.BaseTableListener;

/**
 * The persistent class for the CURRENCY_TYPE database table.
 * 
 */
@Entity
@Table(name="LOCATION_CLASSIFICATION")
@EntityListeners(BaseTableListener.class)
@NamedQueries({
	@NamedQuery(name="LocationClassificationDBO.getByLocationId", 
				query="SELECT c FROM LocationClassificationDBO c where c.locationId = :locationId"),
	@NamedQuery(name="LocationClassificationDBO.findLFAType", 
				query="SELECT c FROM LocationClassificationDBO c where c.locationId = :locationId AND c.locationClassTypeCode IN (SELECT d.code FROM LocationClassificationTypeDBO d WHERE d.name IN :typeList)")
})
public class LocationClassificationDBO implements Serializable {
	private static final long serialVersionUID = 1L;

    @Embedded
    private BaseTable baseTable;
    
	@Id
	@Column(name="LOCN_CLASS_ID")
	private Long locationClassId;

	@Column(name="LOCATION_ID")
	private Long locationId;

	@Column(name="LOCN_CLASS_TYPE_CODE")
	private Long locationClassTypeCode;

	@Column(name="LOCN_CLASS_AREA")
	private Long locationClassArea;

	@Column(name="JPA_VERSION_NUMBER")
	@Version
	private Long jpaVersionNumber;

	public LocationClassificationDBO() {
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
    
    public Long getLocationClassId() {
		return locationClassId;
	}
    
    public void setLocationClassId(Long locationClassId) {
		this.locationClassId = locationClassId;
	}
    
    public Long getLocationId() {
		return locationId;
	}
    
    public void setLocationId(Long locationId) {
		this.locationId = locationId;
	}
    
    public Long getLocationClassTypeCode() {
		return locationClassTypeCode;
	}
    
    public void setLocationClassTypeCode(Long locationClassTypeCode) {
		this.locationClassTypeCode = locationClassTypeCode;
	}
    
    public Long getLocationClassArea() {
		return locationClassArea;
	}
    
    public void setLocationClassArea(Long locationClassArea) {
		this.locationClassArea = locationClassArea;
	}
}
