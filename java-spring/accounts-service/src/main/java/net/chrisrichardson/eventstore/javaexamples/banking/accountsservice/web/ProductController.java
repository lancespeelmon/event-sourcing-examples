package net.chrisrichardson.eventstore.javaexamples.banking.accountsservice.web;

import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import net.chrisrichardson.eventstore.javaexamples.banking.accountsservice.backend.ProductService;
import net.chrisrichardson.eventstore.javaexamples.banking.common.accounts.CreateAccountResponse;
import net.chrisrichardson.eventstore.javaexamples.banking.common.accounts.CreateProductRequest;

@RestController
@RequestMapping("/api/products")
public class ProductController {

	private ProductService productService;

	@Autowired
	public ProductController(ProductService productService) {
		this.productService = productService;
	}

	@RequestMapping(method = RequestMethod.POST)
	public CompletableFuture<CreateAccountResponse> createProduct(
			@Validated @RequestBody CreateProductRequest request) {
		return productService
				.createProduct(request.getProductId(), request.getProductLongName(), request.getProductAbbreviation(),
						request.getProductCategory(), request.getActiveDate())
				.thenApply(entityAndEventInfo -> new CreateAccountResponse(entityAndEventInfo.getEntityId()));
	}
}
