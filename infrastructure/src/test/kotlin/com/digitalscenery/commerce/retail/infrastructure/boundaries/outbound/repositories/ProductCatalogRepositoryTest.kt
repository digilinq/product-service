package com.digitalscenery.commerce.retail.infrastructure.boundaries.outbound.repositories

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.test.context.ActiveProfiles
import kotlin.test.Test
import kotlin.test.assertNotNull

@DataJpaTest
@ActiveProfiles("test")
class ProductCatalogRepositoryTest @Autowired constructor(
    private val productCatalogRepository: ProductCatalogRepository,
) {

    @Test
    fun `should work`() {
        assertNotNull(productCatalogRepository)
    }

}
