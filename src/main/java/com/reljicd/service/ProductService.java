package com.reljicd.service;

import com.reljicd.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Created by Dusan on 19-May-17.
 */
public interface ProductService {

    Product findById(Long id);

    Page<Product> findAllProductsPageable(Pageable pageable);

}
