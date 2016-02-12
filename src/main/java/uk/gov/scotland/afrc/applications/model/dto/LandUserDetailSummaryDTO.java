package uk.gov.scotland.afrc.applications.model.dto;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;

/**
 * This class is not used for persistance
 * This is used to extract the data from native query in result set and used as a DTO.
 * @author d608413
 *
 */
public class LandUserDetailSummaryDTO {

	private Long landUseAreaId;
	private BigDecimal landUseArea;
    private Long landUseTypeCode;
    private String landUseDescription;
    private String name;
    private boolean feature;
    private List<SchemeSummary> schemes=Collections.emptyList();
    
    public List<SchemeSummary> getSchemes() {
		return schemes;
	}

	public void setSchemes(List<SchemeSummary> schemes) {
		this.schemes = schemes;
	}
	public static class SchemeSummary {
    	
    	private boolean associated;
    	private String schemeName;
    	private BigDecimal area;
    	
		public SchemeSummary(String schemeName, boolean associated, 
				BigDecimal area) {
			super();
			this.schemeName = schemeName;
			this.associated = associated;
			this.area = area;
		}
		public boolean isAssociated() {
			return associated;
		}
		public void setAssociated(boolean associated) {
			this.associated = associated;
		}
		public String getSchemeName() {
			return schemeName;
		}
		public void setSchemeName(String schemeName) {
			this.schemeName = schemeName;
		}
		public BigDecimal getArea() {
			return area;
		}
		public void setArea(BigDecimal area) {
			this.area = area;
		}
    	
    }
    
    
    public LandUserDetailSummaryDTO(Long landUseAreaId, BigDecimal landUseArea,
			String schemeName, BigDecimal schemeClaimArea,
			Long landUseTypeCode, String landUseDescription, boolean feature) {
		super();
		this.landUseAreaId = landUseAreaId;
		this.landUseArea = landUseArea;
		this.landUseTypeCode = landUseTypeCode;
		this.landUseDescription = landUseDescription;
		this.feature = feature;
    }	

    public LandUserDetailSummaryDTO() {
	
    }

	public Long getLandUseAreaId() {
		return landUseAreaId;
	}
	
	public void setLandUseAreaId(Long landUseAreaId) {
		this.landUseAreaId = landUseAreaId;
	}
	public BigDecimal getLandUseArea() {
		return landUseArea;
	}
	public void setLandUseArea(BigDecimal landUseArea) {
		this.landUseArea = landUseArea;
	}

	public Long getLandUseTypeCode() {
		return landUseTypeCode;
	}
	public void setLandUseTypeCode(Long landUseTypeCode) {
		this.landUseTypeCode = landUseTypeCode;
	}
	public String getLandUseDescription() {
		return landUseDescription;
	}
	public void setLandUseDescription(String landUseDescription) {
		this.landUseDescription = landUseDescription;
	}
	public boolean isFeature() {
		return feature;
	}
	public void setFeature(boolean feature) {
		this.feature = feature;
	}

	public SchemeSummary getSchemeSummary(String scheme) {
		SchemeSummary result=null;
		
		for(SchemeSummary ss: schemes) {
			if(scheme.equals(ss.getSchemeName())) {
				result=ss;
				break;
			}
		}
		return result;	
	}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
	
	
	

}
