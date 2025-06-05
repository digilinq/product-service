package com.digitalscenery.commerce.retail.configuration;

import com.digitalscenery.commerce.retail.domain.product.port.api.ProductCatalogService;
import com.digitalscenery.commerce.retail.domain.product.port.spi.ProductCatalogRepositoryPort;
import com.digitalscenery.commerce.retail.domain.product.service.ProductCatalogServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfiguration {

    @Bean
    public ProductCatalogService productCatalogService(ProductCatalogRepositoryPort productCatalogRepositoryPort) {
        return new ProductCatalogServiceImpl(productCatalogRepositoryPort);
    }
}
