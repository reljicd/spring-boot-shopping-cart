package com.reljicd.repository;

import com.reljicd.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Dusan on 18-May-17.
 */
public interface ProductRepository extends JpaRepository<Product, Long> {
}
