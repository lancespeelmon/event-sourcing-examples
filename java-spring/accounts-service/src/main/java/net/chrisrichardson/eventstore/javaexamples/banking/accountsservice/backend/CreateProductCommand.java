package net.chrisrichardson.eventstore.javaexamples.banking.accountsservice.backend;

import java.util.Date;

public class CreateProductCommand implements ProductCommand {
	private String productId;
	private String productLongName;
	private String productAbbreviation;
	private String productCategory;
	private Date activeDate;

	public CreateProductCommand(String productId, String productLongName, String productAbbreviation,
			String productCategory, Date activeDate) {
		this.productId = productId;
		this.productLongName = productLongName;
		this.productAbbreviation = productAbbreviation;
		this.productCategory = productCategory;
		this.activeDate = activeDate;
	}

	public String getProductId() {
		return productId;
	}

	public String getProductLongName() {
		return productLongName;
	}

	public String getProductAbbreviation() {
		return productAbbreviation;
	}

	public String getProductCategory() {
		return productCategory;
	}

	public Date getActiveDate() {
		return activeDate;
	}

}
