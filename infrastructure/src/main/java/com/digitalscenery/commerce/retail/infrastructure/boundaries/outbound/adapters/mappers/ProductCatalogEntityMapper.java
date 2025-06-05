package com.digitalscenery.commerce.retail.infrastructure.boundaries.outbound.adapters.mappers;

import com.digitalscenery.commerce.retail.domain.product.ProductCatalog;
import com.digitalscenery.commerce.retail.infrastructure.boundaries.outbound.repositories.entities.ProductCatalogEntity;
import org.mapstruct.Mapper;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

@Mapper(componentModel = SPRING)
public interface ProductCatalogEntityMapper {

    ProductCatalog map(ProductCatalogEntity productCatalogEntity);
}
