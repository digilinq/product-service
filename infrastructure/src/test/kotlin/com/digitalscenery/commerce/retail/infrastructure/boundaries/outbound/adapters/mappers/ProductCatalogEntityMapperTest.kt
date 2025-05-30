package com.digitalscenery.commerce.retail.infrastructure.boundaries.outbound.adapters.mappers

import com.digitalscenery.commerce.retail.infrastructure.boundaries.outbound.repositories.entities.ProductCatalogEntity
import org.mapstruct.factory.Mappers
import java.util.*
import kotlin.test.Test
import kotlin.test.assertEquals

class ProductCatalogEntityMapperTest {

    private val productCatalogEntityMapper = Mappers.getMapper(ProductCatalogEntityMapper::class.java)

    @Test
    fun `should map product catalog entity to product catalog`() {
        val productCatalogEntity = ProductCatalogEntity()
        productCatalogEntity.id = UUID.fromString(PRODUCT_ID)
        productCatalogEntity.name = PRODUCT_NAME
        productCatalogEntity.description = PRODUCT_DESCRIPTION

        val productCatalog = productCatalogEntityMapper.map(productCatalogEntity)

        assertEquals(UUID.fromString(PRODUCT_ID), productCatalog.id)
        assertEquals(PRODUCT_NAME, productCatalog.name)
        assertEquals(PRODUCT_DESCRIPTION, productCatalog.description)
    }

    companion object {
        private const val PRODUCT_ID = "123e4567-e89b-12d3-a456-426614174000"
        private const val PRODUCT_NAME = "Test Product"
        private const val PRODUCT_DESCRIPTION = "This is a test product"
    }
}
