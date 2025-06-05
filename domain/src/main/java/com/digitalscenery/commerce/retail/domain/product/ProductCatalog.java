package com.digitalscenery.commerce.retail.domain.product;

import java.util.UUID;

public record ProductCatalog(
    UUID id,
    String name,
    String description
) {
}
