package com.digitalscenery.commerce.retail.infrastructure.boundaries.outbound.repositories;

import com.digitalscenery.commerce.retail.infrastructure.boundaries.outbound.repositories.entities.ProductCatalogEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ProductCatalogRepository extends JpaRepository<ProductCatalogEntity, UUID> {
}
