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
        assertNotNull(em)
    }

    @Test
    fun `id should be generated while save product`() {
        val product = ProductCatalogEntity()
        product.name = "Test Product"
        product.description = "This is a test product."

        val savedProduct = productCatalogRepository.save(product)
        assertNotNull(savedProduct.id)
    }

    @Test
    fun `list all table names`() {
        em.metamodel?.entities?.forEach { e ->
            println(e)
            println("Entity Name: ${e?.name}, Table Name: ${e?.name}")
        }
    }
}
