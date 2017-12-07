package net.chrisrichardson.eventstore.javaexamples.banking.accountsservice.backend;


import java.math.BigDecimal;
import java.util.Date;
import java.util.concurrent.CompletableFuture;

import io.eventuate.AggregateRepository;
import io.eventuate.EntityWithIdAndVersion;

public class AccountService  {

  private final AggregateRepository<Account, AccountCommand> accountRepository;

  public AccountService(AggregateRepository<Account, AccountCommand> accountRepository) {
    this.accountRepository = accountRepository;
  }

  public CompletableFuture<EntityWithIdAndVersion<Account>> openAccount(String customerId, String title, BigDecimal initialBalance, String description, String productId) {
    return accountRepository.save(new OpenAccountCommand(customerId, title, initialBalance, description, productId));
  }

  public CompletableFuture<EntityWithIdAndVersion<Account>> deleteAccount(String accountId) {
    return accountRepository.update(accountId, new DeleteAccountCommand());
  }

	public BigDecimal rewardAccount(String accountId, String customer_id, String ar_product_id, Date transaction_date,
			BigDecimal amount) {
		// FIXME started down the path of an event driven reward command... but not sure that was that ask.
		accountRepository.save(new CalculateAccountRewardCommand(customer_id, ar_product_id, transaction_date, amount));
		return calculateReward(customer_id, ar_product_id, transaction_date, amount);
	}

	private final BigDecimal sampleRewardRate = new BigDecimal(0.01); // 1% mock reward rate

	private BigDecimal calculateReward(String customer_id, String ar_product_id, Date transaction_date,
			BigDecimal amount) {
		return amount.multiply(sampleRewardRate); // mock business rule evaluation
	}
}
