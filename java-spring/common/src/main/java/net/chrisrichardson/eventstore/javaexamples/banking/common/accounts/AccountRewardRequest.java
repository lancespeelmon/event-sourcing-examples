package net.chrisrichardson.eventstore.javaexamples.banking.common.accounts;

import java.math.BigDecimal;
import java.util.Date;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;

public class AccountRewardRequest {
	@NotNull
	private String accountId;
	@NotNull
	private final String customer_id;
	@NotNull
	private final String ar_product_id;
	@NotNull
	private final Date transaction_date;
	@NotNull
	@DecimalMin("0")
	private final BigDecimal amount;

	public AccountRewardRequest(String customer_id, String ar_product_id, Date transaction_date, BigDecimal amount) {
		this.customer_id = customer_id;
		this.ar_product_id = ar_product_id;
		this.transaction_date = transaction_date;
		this.amount = amount;
	}

	public String getAccountId() {
		return accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	public String getCustomer_id() {
		return customer_id;
	}

	public String getAr_product_id() {
		return ar_product_id;
	}

	public Date getTransaction_date() {
		return transaction_date;
	}

	public BigDecimal getAmount() {
		return amount;
	}

}
