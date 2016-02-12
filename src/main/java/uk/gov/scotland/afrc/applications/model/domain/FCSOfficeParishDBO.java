package uk.gov.scotland.afrc.applications.model.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import uk.gov.scotland.afrc.applications.model.base.BaseTable;
import uk.gov.scotland.afrc.applications.model.base.BaseTableAware;
import uk.gov.scotland.afrc.applications.model.base.BaseTableListener;

@Entity
@Table(name = "FCS_OFFICE_PARISH")
@EntityListeners(BaseTableListener.class)
public class FCSOfficeParishDBO implements Serializable, BaseTableAware {
	private static final long serialVersionUID = -5402775030353233209L;

	@Id
	@Column(name = "PARISH_TYPE_CODE")
	private long parishTypeCode;

	@OneToOne
	@Column(name = "FCS_OFFICE_TYPE_CODE")
	private AreaOfficeTypeDBO areaOfficeType;

	public long getParishTypeCode() {
		return parishTypeCode;
	}

	public void setParishTypeCode(long parishTypeCode) {
		this.parishTypeCode = parishTypeCode;
	}

	public AreaOfficeTypeDBO getAreaOfficeType() {
        return areaOfficeType;
    }

    public void setAreaOfficeType(AreaOfficeTypeDBO areaOfficeType) {
        this.areaOfficeType = areaOfficeType;
    }

    @Embedded
	private BaseTable baseTable;

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
