package com.digitalscenery.commerce.retail.infrastructure.boundaries.outbound.repositories

import com.digitalscenery.commerce.retail.infrastructure.boundaries.outbound.repositories.entities.ProductCatalogEntity
import jakarta.persistence.EntityManager
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.test.context.ActiveProfiles
import kotlin.test.Test
import kotlin.test.assertNotNull

@DataJpaTest
@ActiveProfiles("test")
class ProductCatalogRepositoryTest @Autowired constructor(
    private val productCatalogRepository: ProductCatalogRepository,
    private val em: EntityManager
) {

    @Test
    fun `should work`() {
        assertNotNull(productCatalogRepository)
    }

    @Test
    fun `save product entity`() {
        val product = ProductCatalogEntity()
        product.id = 1L
        product.name = "Test Product"
        product.description = "This is a test product."
        productCatalogRepository.save(product)

        val savedProduct = em.find(ProductCatalogEntity::class.java, 1L)
        println(savedProduct)
    }
}
