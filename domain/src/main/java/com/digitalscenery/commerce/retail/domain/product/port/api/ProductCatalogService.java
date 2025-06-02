package com.digitalscenery.commerce.retail.domain.product.port.api;

import com.digitalscenery.commerce.retail.domain.product.ProductCatalog;

import java.util.List;
import java.util.UUID;

public interface ProductCatalogService {

    ProductCatalog addProduct(ProductCatalog product);

    ProductCatalog updateProduct(ProductCatalog product);

    void deleteProduct(String id);

    ProductCatalog findProductById(UUID id);

    List<ProductCatalog> findProducts(String name);
}
