package com.parkgihyeon.productmanagement.domain.product.repository;

import com.parkgihyeon.productmanagement.domain.product.entity.Product;

import java.util.List;

public interface ProductRepository {
    Product findById(Long id);
    List<Product> findAll();
    void update(Product product);
}
