package com.reljicd.service;

import com.reljicd.controller.exception.NotEnoughProductsInStockException;
import com.reljicd.model.Product;

import java.math.BigDecimal;
import java.util.Map;

/**
 * Created by Dusan on 21-May-17.
 */
public interface ShoppingCartService {

    void addProduct(Product product);

    void removeProduct(Product product);

    Map<Product, Integer> getProductsInCart();

    void checkout() throws NotEnoughProductsInStockException;

    BigDecimal getTotal();
}
