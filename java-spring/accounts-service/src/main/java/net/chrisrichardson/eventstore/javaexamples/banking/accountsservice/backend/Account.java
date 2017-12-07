package net.chrisrichardson.eventstore.javaexamples.banking.accountsservice.backend;

import io.eventuate.Event;
import io.eventuate.EventUtil;
import io.eventuate.ReflectiveMutableCommandProcessingAggregate;
import net.chrisrichardson.eventstore.javaexamples.banking.backend.common.accounts.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Account extends ReflectiveMutableCommandProcessingAggregate<Account, AccountCommand> {

  private BigDecimal balance;
  private boolean deleted;
  private String productId; // associated Product

  public List<Event> process(OpenAccountCommand cmd) {
    return EventUtil.events(new AccountOpenedEvent(cmd.getCustomerId(), cmd.getTitle(), cmd.getInitialBalance(), cmd.getDescription(), cmd.getProductId()));
  }

  public List<Event> process(DeleteAccountCommand cmd) {
    return EventUtil.events(new AccountDeletedEvent());
  }

  public List<Event> process(DebitAccountCommand cmd) {
    if(deleted)
      return new ArrayList<>();

    if (balance.compareTo(cmd.getAmount()) < 0)
      return EventUtil.events(new AccountDebitFailedDueToInsufficientFundsEvent(cmd.getTransactionId()));
    else
      return EventUtil.events(new AccountDebitedEvent(cmd.getAmount(), cmd.getTransactionId()));
  }

  public List<Event> process(CreditAccountCommand cmd) {
    if(deleted)
      return new ArrayList<>();

    return EventUtil.events(new AccountCreditedEvent(cmd.getAmount(), cmd.getTransactionId()));
  }

	public BigDecimal process(CalculateAccountRewardCommand cmd) {
		if (deleted) {
			return null;
		} else {
			return calculateReward(cmd.getCustomer_id(), cmd.getAr_product_id(), cmd.getTransaction_date(),
					cmd.getAmount());
		}

	}

  public void apply(AccountOpenedEvent event) {
    balance = event.getInitialBalance();
  }

  public void apply(AccountDeletedEvent event) {
    deleted = true;
  }

  public void apply(AccountDebitedEvent event) {
    balance = balance.subtract(event.getAmount());
  }

  public void apply(AccountDebitFailedDueToInsufficientFundsEvent event) {
  }

  public void apply(AccountCreditedEvent event) {
    balance = balance.add(event.getAmount());
  }

  public BigDecimal getBalance() {
    return balance;
  }

	private final BigDecimal sampleRewardRate = new BigDecimal(0.01); // 1% mock reward rate

	private BigDecimal calculateReward(String customer_id, String ar_product_id, Date transaction_date,
			BigDecimal amount) {
		return amount.multiply(sampleRewardRate); // mock business rule evaluation
	}
}


