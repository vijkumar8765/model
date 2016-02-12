package uk.gov.scotland.afrc.applications.model.domain;

import uk.gov.scotland.afrc.applications.model.base.BaseTable;
import uk.gov.scotland.afrc.applications.model.base.BaseTableAware;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


/**
 * The persistent class for the SCHEME_OPT_PAYMENT_RATE_BAND database table.
 */
@Entity
@Table(name="SCHEME_OPT_PAYMENT_RATE_BAND")
@NamedQueries(
		value = {
				@NamedQuery(
						name = "SchemeOptPaymentRateBandDBO.findPaymentRateBandsBySchemeIds",
						query = "SELECT sprb.schemeOptionId, sprb.paymentRateBand FROM SchemeOptPaymentRateBandDBO sprb, SchemeOptionDBO so " +
									"WHERE sprb.schemeOptionId = so.schemeOptionId AND so.schemeId IN :schemeIds")
		})
public class SchemeOptPaymentRateBandDBO implements Serializable, BaseTableAware {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="SCHEME_OPT_PAY_RATE_BAND_ID")
	private long schemeOptPayRateBandId;

	@Column(name="JPA_VERSION_NUMBER")
	private long jpaVersionNumber;

	@OneToOne
	@JoinColumn(name = "PAYMENT_RATE_BAND_ID", nullable = false)
	private PaymentRateBandDBO paymentRateBand;

	@Column(name="PAYMENT_RATE_BAND_ID")
	private long paymentRateBandId;

	@OneToOne
	@JoinColumn(name = "SCHEME_OPTION_ID", nullable = false)
	private SchemeOptionDBO schemeOption;

	@Column(name="SCHEME_OPTION_ID")
	private long schemeOptionId;

	@Column(name="APPLICABLE_YR_ORDINAL")
	private long applicableYearOrdinal;

	@Column(name="OUTCOME_FACTR")
	private String outcomeFactor;

	@Temporal(TemporalType.DATE)
	@Column(name="END_DATE")
	private Date endDate;

	@Embedded
	private BaseTable baseTable;

	public SchemeOptPaymentRateBandDBO() {}

	public long getPaymentRateBandId() {
		return paymentRateBandId;
	}

	public void setPaymentRateBandId(long paymentRateBandId) {
		this.paymentRateBandId = paymentRateBandId;
	}

	public long getSchemeOptionId() {
		return schemeOptionId;
	}

	public void setSchemeOptionId(long schemeOptionId) {
		this.schemeOptionId = schemeOptionId;
	}

	public Date getEndDate() {
		return this.endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
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
	public long getJpaVersionNumber() {
		return this.jpaVersionNumber;
	}

	public void setJpaVersionNumber(long jpaVersionNumber) {
		this.jpaVersionNumber = jpaVersionNumber;
	}

	public long getSchemeOptPayRateBandId() {
		return schemeOptPayRateBandId;
	}

	public void setSchemeOptPayRateBandId(long schemeOptPayRateBandId) {
		this.schemeOptPayRateBandId = schemeOptPayRateBandId;
	}

	public PaymentRateBandDBO getPaymentRateBand() {
		return paymentRateBand;
	}

	public void setPaymentRateBand(PaymentRateBandDBO paymentRateBand) {
		this.paymentRateBand = paymentRateBand;
	}

	public SchemeOptionDBO getSchemeOption() {
		return schemeOption;
	}

	public void setSchemeOption(SchemeOptionDBO schemeOption) {
		this.schemeOption = schemeOption;
	}

	public long getApplicableYearOrdinal() {
		return applicableYearOrdinal;
	}

	public void setApplicableYearOrdinal(long applicableYearOrdinal) {
		this.applicableYearOrdinal = applicableYearOrdinal;
	}

	public String getOutcomeFactor() {
		return outcomeFactor;
	}

	public void setOutcomeFactor(String outcomeFactor) {
		this.outcomeFactor = outcomeFactor;
	}
}