package com.parkgihyeon.productmanagement.domain.product.repository;

import com.parkgihyeon.productmanagement.domain.product.entity.Product;
import com.parkgihyeon.productmanagement.domain.product.exception.NotFoundProductException;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@Repository
public class ListProductRepository implements ProductRepository{

    List<Product> products = new CopyOnWriteArrayList<>();

    @PostConstruct
    void addProduct(){
        Product product1 = new Product(1L, "상품1", 10000, 100);
        Product product2 = new Product(2L, "상품2", 25000, 300);
        Product product3 = new Product(3L, "상품3", 30000, 500);

        products.add(product1);
        products.add(product2);
        products.add(product3);
    }

    @Override
    public Product findById(Long id) {
        return products.stream()
                .filter(product -> product.sameId(id))
                .findFirst()
                .orElseThrow(() -> new NotFoundProductException("Product를 찾지 못했습니다."));
    }

    @Override
    public List<Product> findAll() {
        return null;
    }

    @Override
    public void update(Product product) {
        int index = products.indexOf(product);
        products.set(index, product);
    }

}
