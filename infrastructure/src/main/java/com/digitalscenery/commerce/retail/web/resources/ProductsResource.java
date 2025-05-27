package com.digitalscenery.commerce.retail.web.resources;

import com.digitalscenery.commerce.generated.web.api.ProductsApi;
import com.digitalscenery.commerce.generated.web.model.Product;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1")
public class ProductsResource implements ProductsApi {
    @Override
    public ResponseEntity<Product> findProductById(UUID id) {
        return ProductsApi.super.findProductById(id);
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
