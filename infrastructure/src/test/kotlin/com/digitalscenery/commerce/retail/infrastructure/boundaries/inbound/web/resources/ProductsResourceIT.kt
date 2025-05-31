package com.digitalscenery.commerce.retail.infrastructure.boundaries.inbound.web.resources

import com.digitalscenery.commerce.retail.infrastructure.boundaries.inbound.web.configuration.WebConfig.API_BASE_PATH
import com.digitalscenery.commerce.retail.integration.IntegrationTest
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.test.context.jdbc.Sql
import org.springframework.test.web.servlet.get
import kotlin.test.Test
import kotlin.test.assertNotNull

@IntegrationTest
@Sql("classpath:sql/products.sql")
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

    @Test
    fun `should return Bad Request when product id is invalid`() {
        mockMvc.get("/products/invalid-id")
            .andExpect {
                status { isBadRequest() }
            }
    }

    @Test
    fun `should return all products`() {
        mockMvc.get("/products")
            .andExpect {
                status { isOk() }
                content { contentType("application/json") }
                jsonPath("$[0].id") { value("123e4567-e89b-12d3-a456-426614174000") }
                jsonPath("$[0].name") { value("Sample Product") }
                jsonPath("$[0].price") { value(19.99) }
            }
    }

    @Test
    fun `should return 401 unauthorized when no authentication provided`() {
        mockMvc.get("/products/123e4567-e89b-12d3-a456-426614174000")
            .andExpect {
                status { isUnauthorized() }
            }
    }

    @Test
    fun `should return 403 forbidden when user does not have access`() {
        mockMvc.get("/products/123e4567-e89b-12d3-a456-426614174000")
            .andExpect {
                status { isForbidden() }
            }
    }

}
