package com.reljicd.controller.exception;

import com.reljicd.model.Product;

/**
 * Created by reljicd on 2/2/17.
 */
public class NotEnoughProductsInStockException extends Exception {

    private Product product;
    private static final String DEFAULT_MESSAGE = "Not enough products in stock";

    public NotEnoughProductsInStockException() {
        super(DEFAULT_MESSAGE);
    }

    public NotEnoughProductsInStockException(Product product) {
        super("Not enough " + product.getName() + " products in stock. Only " + product.getQuantity() + " left");

        this.product = product;
    }

}
