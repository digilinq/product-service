package com.digitalscenery.commerce.retail.domain.product.service;

import com.digitalscenery.commerce.retail.domain.product.ProductCatalog;
import com.digitalscenery.commerce.retail.domain.product.port.api.ProductCatalogService;
import com.digitalscenery.commerce.retail.domain.product.port.spi.ProductCatalogRepositoryPort;

public class ProductCatalogServiceImpl implements ProductCatalogService {

    private final ProductCatalogRepositoryPort productCatalogRepositoryPort;

    public ProductCatalogServiceImpl(ProductCatalogRepositoryPort productCatalogRepositoryPort) {
        this.productCatalogRepositoryPort = productCatalogRepositoryPort;
    }


    @Override
    public ProductCatalog addProduct(ProductCatalog product) {
        return null;
    }

    @Override
    public ProductCatalog getProduct(String id) {
        return null;
    }

    @Override
    public ProductCatalog updateProduct(ProductCatalog product) {
        return null;
    }

    @Override
    public void deleteProduct(String id) {

    }
}
