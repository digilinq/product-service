package com.digitalscenery.commerce.retail.domain.product.port.spi;

import com.digitalscenery.commerce.retail.domain.product.ProductCatalog;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ProductCatalogRepositoryPort {
    /**
     * Finds a product by its unique identifier.
     *
     * @param id the unique identifier of the product
     * @return an Optional containing the ProductCatalog if found, or empty if not found
     */
    Optional<ProductCatalog> findProductById(UUID id);

    /**
     * Retrieves all products in the catalog.
     *
     * @return a List of ProductCatalog objects representing all products
     */
    List<ProductCatalog> findAllProducts();
}
