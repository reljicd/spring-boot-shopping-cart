package com.reljicd.service;

import com.reljicd.exception.*;
import com.reljicd.model.Product;

import java.math.BigDecimal;
import java.util.Map;

public interface ShoppingCartService {

    void addProduct(Product product);

    void removeProduct(Product product);

    Map<Product, Integer> getProductsInCart();

    void checkout() throws NotEnoughProductsInStockException, ProductNotFoundException;

    BigDecimal getTotal();
}
