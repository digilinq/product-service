package com.digitalscenery.commerce.retail.domain.product;

import java.util.NoSuchElementException;

public class ProductNotFoundException extends NoSuchElementException {
    public ProductNotFoundException(String message) {
        super(message);
    }
}
