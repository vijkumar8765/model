package uk.gov.scotland.afrc.applications.model.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import uk.gov.scotland.afrc.applications.model.base.BaseTable;
import uk.gov.scotland.afrc.applications.model.base.BaseTableListener;

/**
 * Entity implementation class for Entity: AppQuestEligibleCapitalItemDBO
 *
 */
@Entity
@Table(name="APP_QUEST_ELIGIBLE_CAP_ITEM")
@EntityListeners(BaseTableListener.class)
@NamedQuery(name="AppQuestEligibleCapitalItemDBO.findByChoicType", query="SELECT a FROM AppQuestEligibleCapitalItemDBO a where a.appQuestionChoiceType.code = :choiceTypeCode ")
public class AppQuestEligibleCapitalItemDBO implements Serializable, uk.gov.scotland.afrc.applications.model.base.BaseTableAware {

	
	private static final long serialVersionUID = 1L;

	public AppQuestEligibleCapitalItemDBO() {
		
	}

	@Embedded
    private BaseTable baseTable;
	
    @Id
    @Column(name="APP_QUEST_ELIG_CAP_ITEM_ID")
    private long appQuestEligCapItemId;

    @Temporal(TemporalType.DATE)
    @Column(name="END_DATE")
    private Date endDate;


    //bi-directional many-to-one association to AppQuestionChoiceType
    @ManyToOne
    @JoinColumn(name="APP_QUEST_CHOICE_TYPE_CODE")
    private ApplicationQuestionChoiceTypeDBO appQuestionChoiceType;

    //bi-directional many-to-one association to AppQuestionChoiceType
    @ManyToOne
    @JoinColumn(name="ELIGIBLE_CAPITAL_ITEM_TYPE_ID")
    private EligibleCapitalItemTypeDBO eligibleCapitalItemTypeId;
    
    public long getAppQuestEligCapItemId() {
        return this.appQuestEligCapItemId;
    }

    public void setAppQuestEligCapItemId(long appQuestEligCapItemId) {
        this.appQuestEligCapItemId = appQuestEligCapItemId;
    }

    public EligibleCapitalItemTypeDBO getEligibleCapitalItemTypeId() {
        return this.eligibleCapitalItemTypeId;
    }

    public void setEligibleCapitalItemTypeId(EligibleCapitalItemTypeDBO eligibleCapitalItemTypeId) {
        this.eligibleCapitalItemTypeId = eligibleCapitalItemTypeId;
    }

    public Date getEndDate() {
        return this.endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public ApplicationQuestionChoiceTypeDBO getAppQuestionChoiceType() {
        return this.appQuestionChoiceType;
    }

    public void setAppQuestionChoiceType(ApplicationQuestionChoiceTypeDBO appQuestionChoiceType) {
        this.appQuestionChoiceType = appQuestionChoiceType;
    }

    @Override
    public BaseTable getBaseTable() {
        if (baseTable == null) {
           baseTable = new BaseTable();
        }
        return baseTable;
     }

    @Override
    public void setBaseTable(BaseTable baseTable) {
      this.baseTable = baseTable;
    }
   
}
