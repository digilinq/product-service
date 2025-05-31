package com.digitalscenery.commerce.retail.domain.product.service

import com.digitalscenery.commerce.retail.domain.product.ProductNotFoundException
import com.digitalscenery.commerce.retail.domain.product.port.api.ProductCatalogService
import com.digitalscenery.commerce.retail.domain.product.port.spi.ProductCatalogRepositoryPort
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import java.util.*
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertFailsWith

class ProductCatalogServiceImplTest {

    private lateinit var productCatalogService: ProductCatalogService
    private val productCatalogRepositoryPort: ProductCatalogRepositoryPort = mockk()

    @BeforeTest
    fun setUp() {
        productCatalogService = ProductCatalogServiceImpl(productCatalogRepositoryPort)
    }

    @Test
    fun `should throw ProductNotFoundException when product not exists in repository`() {

        val id: UUID = UUID.randomUUID()
        every { productCatalogRepositoryPort.findProductById(id) } returns Optional.empty()

        assertFailsWith<ProductNotFoundException> {
            productCatalogService.findProductById(id)
        }
        verify { productCatalogRepositoryPort.findProductById(id) }
    }
}
