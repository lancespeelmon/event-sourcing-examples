package net.chrisrichardson.eventstore.javaexamples.banking.accountsservice.backend;

import java.util.Date;

import io.eventuate.ReflectiveMutableCommandProcessingAggregate;

public class Product extends ReflectiveMutableCommandProcessingAggregate<Product, ProductCommand> {
	private String productId;
	private String productLongName;
	private String productAbbreviation;
	private String productCategory;
	private Date activeDate;

	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public String getProductLongName() {
		return productLongName;
	}
	public void setProductLongName(String productLongName) {
		this.productLongName = productLongName;
	}
	public String getProductAbbreviation() {
		return productAbbreviation;
	}
	public void setProductAbbreviation(String productAbbreviation) {
		this.productAbbreviation = productAbbreviation;
	}
	public String getProductCategory() {
		return productCategory;
	}
	public void setProductCategory(String productCategory) {
		this.productCategory = productCategory;
	}
	public Date getActiveDate() {
		return activeDate;
	}
	public void setActiveDate(Date activeDate) {
		this.activeDate = activeDate;
	}
}
