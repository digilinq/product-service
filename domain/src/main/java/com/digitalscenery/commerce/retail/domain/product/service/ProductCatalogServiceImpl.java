package com.digitalscenery.commerce.retail.domain.product.service;

import com.digitalscenery.commerce.retail.domain.product.ProductCatalog;
import com.digitalscenery.commerce.retail.domain.product.ProductNotFoundException;
import com.digitalscenery.commerce.retail.domain.product.port.api.ProductCatalogService;
import com.digitalscenery.commerce.retail.domain.product.port.spi.ProductCatalogRepositoryPort;

import java.util.List;
import java.util.UUID;

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
    public ProductCatalog updateProduct(ProductCatalog product) {
        return null;
    }

    @Override
    public void deleteProduct(String id) {

    }

    @Override
    public ProductCatalog findProductById(UUID id) {
        return productCatalogRepositoryPort.findProductById(id).orElseThrow(
                () -> new ProductNotFoundException("Product not found with id: " + id));
    }

    @Override
    public List<ProductCatalog> findProducts(String name) {
        return productCatalogRepositoryPort.findAllProducts();
    }
}
