package net.chrisrichardson.eventstore.javaexamples.banking.common.accounts;

import java.math.BigDecimal;

public class AccountRewardResponse {

	private BigDecimal rewardAmount;

	public AccountRewardResponse(BigDecimal rewardAmount) {
		this.rewardAmount = rewardAmount;
	}

	public BigDecimal getRewardAmount() {
		return rewardAmount;
	}

	public void setRewardAmount(BigDecimal rewardAmount) {
		this.rewardAmount = rewardAmount;
	}

}
