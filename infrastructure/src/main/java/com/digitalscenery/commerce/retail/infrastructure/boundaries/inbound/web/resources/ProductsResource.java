package com.digitalscenery.commerce.retail.infrastructure.boundaries.inbound.web.resources;

import com.digitalscenery.commerce.generated.web.api.ProductsApi;
import com.digitalscenery.commerce.generated.web.model.Product;
import com.digitalscenery.commerce.retail.domain.product.ProductCatalog;
import com.digitalscenery.commerce.retail.domain.product.port.api.ProductCatalogService;
import com.digitalscenery.commerce.retail.infrastructure.boundaries.inbound.web.mappers.ProductMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

import static com.digitalscenery.commerce.retail.infrastructure.boundaries.inbound.web.configuration.WebConfig.API_BASE_PATH;

@RestController
@RequestMapping(API_BASE_PATH)
public class ProductsResource implements ProductsApi {

    private final ProductCatalogService productCatalogService;
    private final ProductMapper productMapper;

    public ProductsResource(ProductCatalogService productCatalogService, ProductMapper productMapper) {
        this.productCatalogService = productCatalogService;
        this.productMapper = productMapper;
    }

    @Override
    public ResponseEntity<Product> findProductById(UUID id) {
        Product product = productMapper.map(productCatalogService.findProductById(id));
        return ResponseEntity.ok(product);
    }

    @Override
    public ResponseEntity<List<Product>> findProducts(String productName) {
        return ProductsApi.super.findProducts(productName);
    }

    @Override
    public ResponseEntity<Void> remove(UUID id) {
        return ProductsApi.super.remove(id);
    }

    @Override
    public ResponseEntity<Void> saveProduct(Product product) {
        return ProductsApi.super.saveProduct(product);
    }
}
