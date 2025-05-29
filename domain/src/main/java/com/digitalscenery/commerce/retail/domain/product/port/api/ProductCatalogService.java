package com.digitalscenery.commerce.retail.domain.product.port.api;

import com.digitalscenery.commerce.retail.domain.product.ProductCatalog;

public interface ProductCatalogService {

    ProductCatalog addProduct(ProductCatalog product);

    ProductCatalog getProduct(String id);

    ProductCatalog updateProduct(ProductCatalog product);

    void deleteProduct(String id);
}
