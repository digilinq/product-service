package com.digitalscenery.commerce.retail.domain.product.port.spi;

import com.digitalscenery.commerce.retail.domain.product.ProductCatalog;

import java.util.Optional;
import java.util.UUID;

public interface ProductCatalogRepositoryPort {
    Optional<ProductCatalog> findProductById(UUID id);
}
