package com.digitalscenery.commerce.retail.infrastructure.boundaries.inbound.web.resources

import com.digitalscenery.commerce.retail.infrastructure.boundaries.inbound.web.configuration.WebConfig.API_BASE_PATH
import com.digitalscenery.commerce.retail.integration.IntegrationTest
import org.hamcrest.core.IsIterableContaining
import org.junit.jupiter.api.Disabled
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.test.context.jdbc.Sql
import org.springframework.test.web.servlet.get
import kotlin.test.Test
import kotlin.test.assertNotNull

@IntegrationTest
@Sql("classpath:sql/products.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_CLASS)
class ProductsResourceIT @Autowired constructor(
    private val mockMvc: org.springframework.test.web.servlet.MockMvc
) {

    fun `should work`() {
        assertNotNull(mockMvc)
    }

    @Test
    fun `should return OK when get product by product id`() {
        mockMvc.get("$API_BASE_PATH/products/123e4567-e89b-12d3-a456-426614174000")
            .andExpect {
                status { isOk() }
                content { contentType("application/json") }
                jsonPath("$.id") { value("123e4567-e89b-12d3-a456-426614174000") }
                jsonPath("$.name") { value("Product C") }
                jsonPath("$.description") { value("Description for Product C") }
            }
    }

    @Test
    fun `should return Not Found when product does not exist`() {
        mockMvc.get("/products/123e4567-e89b-12d3-a456-426614174999")
            .andExpect {
                status { isNotFound() }
            }
    }

    @Disabled
    @Test
    fun `should return Bad Request when product id is invalid`() {
        mockMvc.get("/products/invalid-id")
            .andExpect {
                status { isBadRequest() }
            }
    }

    @Test
    fun `should contains Product A when return all products`() {
        mockMvc.get("$API_BASE_PATH/products")
            .andExpect {
                status { isOk() }
                content { contentType("application/json") }
                jsonPath("$[*].id") { value(IsIterableContaining.hasItem(PRODUCT_ID)) }
                jsonPath("$[?(@.id==\"$PRODUCT_ID\")].name") { value(PRODUCT_NAME) }
                jsonPath("$[?(@.id==\"$PRODUCT_ID\")].description") { value(PRODUCT_DESCRIPTION) }
            }
    }

    @Disabled
    @Test
    fun `should return 401 unauthorized when no authentication provided`() {
        mockMvc.get("/products/123e4567-e89b-12d3-a456-426614174000")
            .andExpect {
                status { isUnauthorized() }
            }
    }

    @Disabled
    @Test
    fun `should return 403 forbidden when user does not have access`() {
        mockMvc.get("/products/123e4567-e89b-12d3-a456-426614174000")
            .andExpect {
                status { isForbidden() }
            }
    }

    companion object {
        private const val PRODUCT_ID = "04017bf8-cadc-11ec-a70f-acde48001122"
        private const val PRODUCT_NAME = "Product A"
        private const val PRODUCT_DESCRIPTION = "Description for Product A"
    }

}
