package uk.gov.scotland.afrc.applications.model.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

import uk.gov.scotland.afrc.applications.model.base.BaseTable;
import uk.gov.scotland.afrc.applications.model.base.BaseTableAware;
import uk.gov.scotland.afrc.applications.model.base.BaseTableListener;

@Entity
@Table(name = "VALIDATION_TYPE")
@javax.persistence.Cacheable
@EntityListeners(BaseTableListener.class)
@NamedQueries(value = { @NamedQuery(name = "ValidationTypeDBO.findByName",
    query = "SELECT v FROM ValidationTypeDBO v WHERE v.name = :name"),
    @NamedQuery(name = "ValidationTypeDBO.findValidationTypesByCategoryName",
    query = "SELECT v FROM ValidationTypeDBO v WHERE v.validationTypeCatg.name = :categoryName "
    		+ " AND v.name IN :validationTypeNames"),
    @NamedQuery(name = "ValidationTypeDBO.findByApplicationId",
    query = "SELECT DISTINCT v.code, v.description FROM "
    		+ " AppValidationErrDBO a,"
    		+ " ValidationTypeDBO v "
    		+ " WHERE a.applicationId =:applicationId"
    		+ " AND a.validationType.code = v.code"
    		+ " ORDER BY v.description"),
    @NamedQuery(name = "ValidationTypeDBO.findByCodeList",
    query = "SELECT v.code, v FROM ValidationTypeDBO v WHERE v.code IN :codeList"),
    @NamedQuery(name = "ValidationTypeDBO.findByCode",
    query = "SELECT v FROM ValidationTypeDBO v WHERE v.code =:code")})
public class ValidationTypeDBO implements Serializable, BaseTableAware {

    private static final long serialVersionUID = 1L;

    @Column(name = "JPA_VERSION_NUMBER")
    @Version
    private Long jpaVersionNumber;

    @Embedded
    private BaseTable baseTable;

    @Id
    @Column(name = "CODE")
    private Long code;

    @Column(name = "APP_SECT_TYPE_CODE")
    private Long appSectTypeCode;

    @Column(name = "BUSINESS_PRIORITY")
    private Long businessPriority;

    @Column(name = "CAN_SUPPRESS_FLAG")
    private boolean canSuppressFlag;

    @Column(name = "DEFAULT_CHOICE")
    private boolean defaultChoice;

    @Column(name = "DESCRIPTION")
    private String description;

    @Temporal(TemporalType.DATE)
    @Column(name = "END_DATE")
    private Date endDate;

    @Column(name = "IS_TIGHT_FLAG")
    private boolean isTightFlag;

    @Column(name = "MUST_JUSTIFY_FLAG")
    private boolean mustJustifyFlag;

    @Column(name = "NAME")
    private String name;

   /* @Column(name = "PAGE")
    private String page;*/

    @ManyToOne
    @JoinColumn(name = "VALIDATION_ERR_TYPE_CODE")
    private ValidationErrorTypeDBO validationErrorType;

    @ManyToOne
    @JoinColumn(name = "VALIDATION_TYPE_CATEGORY_CODE")
    private ValidationTypeCatgDBO validationTypeCatg;

    @ManyToOne
    @JoinColumn(name = "VALIDATION_TYPE_CLASS_CODE")
    private ValidationTypeClassDBO validationTypeClass;
    
    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "VALIDATION_TYPE_CODE", referencedColumnName = "CODE")
    private List<ValidationJustificationTypeDBO> validationJustificationTypes;

    public BaseTable getBaseTable() {
        if (baseTable == null) {
            baseTable = new BaseTable();
        }
        return baseTable;
    }

    public void setBaseTable(BaseTable baseTable) {
        this.baseTable = baseTable;
    }

    public Long getJpaVersionNumber() {
        return jpaVersionNumber;
    }

    public void setJpaVersionNumber(Long jpaVersionNumber) {
        this.jpaVersionNumber = jpaVersionNumber;
    }

    public long getCode() {
        return code;
    }

    public void setCode(long code) {
        this.code = code;
    }

    public Long getAppSectTypeCode() {
        return appSectTypeCode;
    }

    public void setAppSectTypeCode(Long appSectTypeCode) {
        this.appSectTypeCode = appSectTypeCode;
    }

    public Long getBusinessPriority() {
        return businessPriority;
    }

    public void setBusinessPriority(Long businessPriority) {
        this.businessPriority = businessPriority;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public boolean isTightFlag() {
        return isTightFlag;
    }

    public void setTightFlag(boolean isTightFlag) {
        this.isTightFlag = isTightFlag;
    }

    public boolean isCanSuppressFlag() {
        return canSuppressFlag;
    }

    public void setCanSuppressFlag(boolean canSuppressFlag) {
        this.canSuppressFlag = canSuppressFlag;
    }

    public boolean isDefaultChoice() {
        return defaultChoice;
    }

    public void setDefaultChoice(boolean defaultChoice) {
        this.defaultChoice = defaultChoice;
    }

    public boolean isMustJustifyFlag() {
        return mustJustifyFlag;
    }

    public void setMustJustifyFlag(boolean mustJustifyFlag) {
        this.mustJustifyFlag = mustJustifyFlag;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

   /* public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }
*/
    public ValidationTypeCatgDBO getValidationTypeCatg() {
        return validationTypeCatg;
    }

    public void setValidationTypeCatg(ValidationTypeCatgDBO validationTypeCatg) {
        this.validationTypeCatg = validationTypeCatg;
    }

    public ValidationErrorTypeDBO getValidationErrorType() {
        return validationErrorType;
    }

    public void setValidationErrorType(ValidationErrorTypeDBO validationErrorType) {
        this.validationErrorType = validationErrorType;
    }
    
    public ValidationTypeClassDBO getValidationTypeClass() {
        return validationTypeClass;
    }

    public void setValidationTypeClass(ValidationTypeClassDBO validationTypeClass) {
        this.validationTypeClass = validationTypeClass;
    }
    
    public List<ValidationJustificationTypeDBO> getValidationJustificationTypes() {
        return validationJustificationTypes;
    }

    public void setValidationJustificationTypes(List<ValidationJustificationTypeDBO> validationJustificationTypes) {
        this.validationJustificationTypes = validationJustificationTypes;
    }

    
    
   

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ValidationTypeDBO other = (ValidationTypeDBO) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	public String toString() {
        return "ValidationTypeDBO [baseTable=" + baseTable + ", code=" + code + ", appSectTypeCode=" + appSectTypeCode
            + ", businessPriority=" + businessPriority + ", canSuppressFlag=" + canSuppressFlag + ", defaultChoice="
            + defaultChoice + ", description=" + description + ", endDate=" + endDate + ", isTightFlag=" + isTightFlag
            + ", mustJustifyFlag=" + mustJustifyFlag + ", name=" + name  + ", validationTypeCatg="
            + validationTypeCatg + ", validationJustificationTypes=" + validationJustificationTypes + "]";
    }

}
