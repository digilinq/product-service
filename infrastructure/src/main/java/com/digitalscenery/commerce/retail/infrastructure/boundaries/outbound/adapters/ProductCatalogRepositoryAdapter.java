package com.digitalscenery.commerce.retail.infrastructure.boundaries.outbound.adapters;

import com.digitalscenery.commerce.retail.domain.product.ProductCatalog;
import com.digitalscenery.commerce.retail.domain.product.port.spi.ProductCatalogRepositoryPort;
import com.digitalscenery.commerce.retail.infrastructure.boundaries.outbound.adapters.mappers.ProductCatalogEntityMapper;
import com.digitalscenery.commerce.retail.infrastructure.boundaries.outbound.repositories.ProductCatalogRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class ProductCatalogRepositoryAdapter implements ProductCatalogRepositoryPort {

    private final ProductCatalogRepository repository;
    private final ProductCatalogEntityMapper mapper;

    public ProductCatalogRepositoryAdapter(ProductCatalogRepository repository, ProductCatalogEntityMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public Optional<ProductCatalog> findProductById(UUID id) {
        return repository.findById(id).map(mapper::map);
    }

    @Override
    public List<ProductCatalog> findAllProducts() {
        return Stream.of(repository.findAll())
                .flatMap(List::stream)
                .map(mapper::map)
                .collect(Collectors.toList());
    }
}
