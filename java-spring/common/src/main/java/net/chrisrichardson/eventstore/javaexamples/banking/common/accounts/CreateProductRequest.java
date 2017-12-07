package net.chrisrichardson.eventstore.javaexamples.banking.common.accounts;

import java.util.Date;

import javax.validation.constraints.NotNull;

public class CreateProductRequest {
	@NotNull
	private String productId;
	@NotNull
	private String productLongName;
	@NotNull
	private String productAbbreviation;
	@NotNull
	private String productCategory;
	@NotNull
	private Date activeDate;

	public void CreateAccountRequest(String productId, String productLongName, String productAbbreviation,
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
