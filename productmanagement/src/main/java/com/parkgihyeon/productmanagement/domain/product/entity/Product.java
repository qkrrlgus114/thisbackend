package com.parkgihyeon.productmanagement.domain.product.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.concurrent.atomic.AtomicInteger;

@NoArgsConstructor
@Getter
public class Product {
    private Long id;
    private String name;
    private Integer price;
    private Integer amount;

    public Product(Long id, String name, Integer price, Integer amount) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.amount = amount;
    }

    public boolean sameId(Long id){
        return this.id == id;
    }

    public boolean checkAmount(Integer orderAmount){
        if(this.amount < orderAmount) return false;
        return true;
    }

    public void decrementAmount(Integer orderAmount){
        this.amount -= orderAmount;
    }
}
