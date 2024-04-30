package com.parkgihyeon.product.management.infrastructure;

import com.parkgihyeon.product.management.domain.Product;
import com.parkgihyeon.product.management.presentation.ProductDTO;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class ListProductRepository {

    private List<Product> products = new CopyOnWriteArrayList<>();
    private AtomicLong sequence = new AtomicLong(1L);

    public Product add(Product product){
        product.setId(sequence.getAndAdd(1L));
        products.add(product);
        return product;
    }

    public Product findById(Long id){
        return products.stream()
                .filter(product -> product.sameId(id))
                .findFirst()
                .orElseThrow();
    }

    public List<Product> findAll(){
        return products;
    }

    public List<Product> findByNamd(String name){
       return products.stream()
                .filter(product -> product.containsName(name))
                .toList();
    }

    public Product updateProduct(Product product){
        Integer indexToModify = products.indexOf(product);
        products.set(indexToModify, product);
        return product;
    }

    public void deleteProduct(Long id){
        Product product = this.findById(id);
        products.remove(product);
    }
}
