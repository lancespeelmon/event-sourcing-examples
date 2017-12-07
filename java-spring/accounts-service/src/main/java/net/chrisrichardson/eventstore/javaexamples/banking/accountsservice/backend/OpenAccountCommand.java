package net.chrisrichardson.eventstore.javaexamples.banking.accountsservice.backend;


import java.math.BigDecimal;

public class OpenAccountCommand implements AccountCommand {

  private String customerId;
  private String title;
  private BigDecimal initialBalance;
  private String description;
  private String productId; // associated Product

  public OpenAccountCommand(String customerId, String title, BigDecimal initialBalance, String description, String productId) {
    this.customerId = customerId;
    this.title = title;
    this.initialBalance = initialBalance;
    this.description = description;
    this.productId = productId;
  }

  public BigDecimal getInitialBalance() {
    return initialBalance;
  }

  public String getCustomerId() {
    return customerId;
  }

  public String getTitle() {
    return title;
  }

  public String getDescription() {
    return description;
  }

  public String getProductId() {
    return productId;
  }

}
