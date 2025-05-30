package com.digitalscenery.commerce.retail.infrastructure.boundaries.inbound.web.mappers;

import com.digitalscenery.commerce.generated.web.model.Product;
import com.digitalscenery.commerce.retail.domain.product.ProductCatalog;
import org.mapstruct.Mapper;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

@Mapper(componentModel = SPRING)
public interface ProductMapper {

    ProductCatalog map(Product product);

}
