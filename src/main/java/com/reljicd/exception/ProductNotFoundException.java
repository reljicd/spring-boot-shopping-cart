package com.reljicd.exception;

import com.reljicd.model.*;

public class ProductNotFoundException extends Exception {

    private static final String DEFAULT_MESSAGE = "Product not found.";

    public ProductNotFoundException() {
        super(DEFAULT_MESSAGE);
    }

    public ProductNotFoundException(Product product) {
        super(String.format("Product: %s not found.", product.getName()));
    }
}
