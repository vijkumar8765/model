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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

import uk.gov.scotland.afrc.applications.model.base.BaseTable;
import uk.gov.scotland.afrc.applications.model.base.BaseTableAware;
import uk.gov.scotland.afrc.applications.model.base.BaseTableListener;

@Entity
@Table(name = "ANIMAL_CLAIM")
@EntityListeners(BaseTableListener.class)
@NamedQueries(
    value = {
            @NamedQuery(
                name = "AnimalClaimDBO.findByEarTagAndApplication",
                query = "SELECT d FROM AnimalClaimDBO d WHERE UPPER(d.earTag) = UPPER(:earTag) and d.applicationId = :applicationId"),
            @NamedQuery(name = "AnimalClaimDBO.animalClaimsListByEarTag",
                query = "SELECT d FROM AnimalClaimDBO d WHERE UPPER(d.earTag) = UPPER(:earTag)"),
            @NamedQuery(name = "AnimalClaimDBO.animalClaimsListByApplication",
                query = "SELECT a FROM AnimalClaimDBO a where a.applicationId = :applicationId") })
public class AnimalClaimDBO implements Serializable, BaseTableAware {

	private static final long serialVersionUID = 1L;

	@Column(name = "JPA_VERSION_NUMBER")
    @Version
    private Long jpaVersionNumber;

    @Embedded
    private BaseTable baseTable;

    @Id
    @Column(name = "ANIMAL_CLAIM_ID")
    @SequenceGenerator(name = "ANIMAL_CLAIM_SEQ_GENERATOR", sequenceName = "ANIMAL_CLAIM_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ANIMAL_CLAIM_SEQ_GENERATOR")
    private long animalClaimId;

    @Column(name = "APPLICATION_ID")
    private Long applicationId;

    @Column(name = "SCHEME_OPT_ID")
    private Long schemeOptionId;

    @Column(name = "EAR_TAG", length = 15)
    private String earTag;

    @Column(name = "ANIMAL_CLAIM_STS_TYPE_CODE")
    private Long animalClaimStatusType;

    @Temporal(TemporalType.DATE)
    @Column(name = "STS_DATE")
    private Date statusDate;

    @Column(name = "EAR_TAG_ENTRY_ORDER")
    private long earTagEntryOrder;

    public Long getJpaVersionNumber() {
        return jpaVersionNumber;
    }

    public void setJpaVersionNumber(Long jpaVersionNumber) {
        this.jpaVersionNumber = jpaVersionNumber;
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

    public long getAnimalClaimId() {
        return animalClaimId;
    }

    public void setAnimalClaimId(long animalClaimId) {
        this.animalClaimId = animalClaimId;
    }

    public Long getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(Long applicationId) {
        this.applicationId = applicationId;
    }

    public Long getSchemeOptionId() {
        return schemeOptionId;
    }

    public void setSchemeOptionId(Long schemeOptionId) {
        this.schemeOptionId = schemeOptionId;
    }

    public String getEarTag() {
        return earTag;
    }

    public void setEarTag(String earTag) {
        this.earTag = earTag;
    }

    public Long getAnimalClaimStatusType() {
        return animalClaimStatusType;
    }

    public void setAnimalClaimStatusType(Long animalClaimStatusType) {
        this.animalClaimStatusType = animalClaimStatusType;
    }

    public Date getStatusDate() {
        return statusDate;
    }

    public void setStatusDate(Date statusDate) {
        this.statusDate = statusDate;
    }

    public long getEarTagEntryOrder() {
        return earTagEntryOrder;
    }

    public void setEarTagEntryOrder(long earTagEntryOrder) {
        this.earTagEntryOrder = earTagEntryOrder;
    }

    public String toString() {
        return "AnimalClaimDBO [animalClaimId=" + animalClaimId + ", applicationId=" + applicationId
            + ", schemeOptionId=" + schemeOptionId + ", earTag=" + earTag + ", animalClaimStatusType="
            + animalClaimStatusType + ", statusDate=" + statusDate + ", earTagEntryOrder=" + earTagEntryOrder + "]";
    }

}
