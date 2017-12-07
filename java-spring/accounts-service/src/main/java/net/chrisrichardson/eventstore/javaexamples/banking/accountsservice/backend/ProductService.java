package net.chrisrichardson.eventstore.javaexamples.banking.accountsservice.backend;

import java.util.Date;
import java.util.concurrent.CompletableFuture;

import io.eventuate.AggregateRepository;
import io.eventuate.EntityWithIdAndVersion;
import io.eventuate.EntityWithMetadata;

public class ProductService {

	private final AggregateRepository<Product, ProductCommand> productRepository;

	public ProductService(AggregateRepository<Product, ProductCommand> productRepository) {
		this.productRepository = productRepository;
	}

	public CompletableFuture<EntityWithIdAndVersion<Product>> createProduct(Integer productId, String productLongName,
			String productAbbreviation, String productCategory, Date activeDate) {
		return productRepository.save((ProductCommand) new CreateProductCommand(productId, productLongName,
				productAbbreviation, productCategory, activeDate));
	}

	public CompletableFuture<EntityWithIdAndVersion<Product>> deleteProduct(String productId) {
		return productRepository.update(productId, new DeleteProductCommand());
	}

	public CompletableFuture<EntityWithMetadata<Product>> getProduct(String productId) {
		return productRepository.find(productId);
	}

}
