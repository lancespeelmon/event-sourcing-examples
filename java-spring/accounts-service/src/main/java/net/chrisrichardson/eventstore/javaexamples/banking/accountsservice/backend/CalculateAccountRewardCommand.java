package net.chrisrichardson.eventstore.javaexamples.banking.accountsservice.backend;

import java.math.BigDecimal;
import java.util.Date;

public class CalculateAccountRewardCommand implements AccountCommand {
	private final String customer_id;
	private final String ar_product_id;
	private final Date transaction_date;
	private final BigDecimal amount;

	public CalculateAccountRewardCommand(String customer_id, String ar_product_id, Date transaction_date,
			BigDecimal amount) {
		this.customer_id = customer_id;
		this.ar_product_id = ar_product_id;
		this.transaction_date = transaction_date;
		this.amount = amount;
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
