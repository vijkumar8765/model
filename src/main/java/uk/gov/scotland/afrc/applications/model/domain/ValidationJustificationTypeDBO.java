package uk.gov.scotland.afrc.applications.model.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embedded;
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

@Entity
@Table(name = "VALIDATION_JUSTIFICATION_TYPE")
@javax.persistence.Cacheable
@EntityListeners(BaseTableListener.class)
@NamedQueries(
	    value = {
				 @NamedQuery(name = "ValidationJustificationTypeDBO.getAllJustificationReasons", 
					query = "SELECT DISTINCT new uk.gov.scotland.afrc.applications.model.dto.ValidationJustificationDTO(v.code, v.description) " +
						 "FROM ValidationJustificationTypeDBO v order by v.code "),
            @NamedQuery(name = "ValidationJustificationTypeDBO.findJustificationTypeWithName", query = "SELECT v "
                + "FROM ValidationJustificationTypeDBO v WHERE v.name = :name ")
	            })
public class ValidationJustificationTypeDBO implements Serializable, BaseTableAware {

    private static final long serialVersionUID = 1L;

    @Column(name = "JPA_VERSION_NUMBER")
    @Version
    private Long jpaVersionNumber;

    @Embedded
    private BaseTable baseTable;

    @Id
    private long code;

    @Column(name = "BUSINESS_PRIORITY")
    private Long businessPriority;

    @Column(name = "DEFAULT_CHOICE")
    private boolean defaultChoice;

    @Column(name = "DESCRIPTION")
    private String description;

    @Temporal(TemporalType.DATE)
    @Column(name = "END_DATE")
    private Date endDate;

    @Column(name = "NAME")
    private String name;

    @Column(name = "PAPER_JUSTIFICATION_ONLY_FLAG")
    private boolean paperJustificationOnlyFlag;

    @Column(name = "VALIDATION_TYPE_CODE")
    private Long validationTypeCode;
    
    @Column(name = "SUPPRESSION_TYPE_FLAG")
    private boolean suppressionTypeFlag;

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

    public Long getBusinessPriority() {
        return businessPriority;
    }

    public void setBusinessPriority(Long businessPriority) {
        this.businessPriority = businessPriority;
    }

    public boolean isDefaultChoice() {
        return defaultChoice;
    }

    public void setDefaultChoice(boolean defaultChoice) {
        this.defaultChoice = defaultChoice;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isPaperJustificationOnlyFlag() {
        return paperJustificationOnlyFlag;
    }

    public void setPaperJustificationOnlyFlag(boolean paperJustificationOnlyFlag) {
        this.paperJustificationOnlyFlag = paperJustificationOnlyFlag;
    }

    public Long getValidationTypeCode() {
        return validationTypeCode;
    }

    public void setValidationTypeCode(Long validationTypeCode) {
        this.validationTypeCode = validationTypeCode;
    }

    public boolean isSuppressionTypeFlag() {
        return suppressionTypeFlag;
    }

    public void setSuppressionTypeFlag(boolean suppressionTypeFlag) {
        this.suppressionTypeFlag = suppressionTypeFlag;
    }    

    public String toString() {
        return "ValidationJustificationTypeDBO [baseTable=" + baseTable + ", code=" + code + ", businessPriority="
            + businessPriority + ", defaultChoice=" + defaultChoice + ", description=" + description + ", endDate="
            + endDate + ", name=" + name + ", paperJustificationOnlyFlag=" + paperJustificationOnlyFlag 
            + ", suppressionTypeFlag=" + suppressionTypeFlag + "]";
    }

}
