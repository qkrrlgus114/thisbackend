package com.parkgihyeon.productmanagement.domain.order.entity;

import com.parkgihyeon.productmanagement.domain.product.dto.ProductDTO;
import com.parkgihyeon.productmanagement.domain.product.entity.Product;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@Getter
public class Order {
    private Long id;
    private List<Product> productList;
    private Integer totalPrice;
    private State state;

    public Order(List<Product> productList, Integer totalPrice) {
        this.productList = productList;
        this.totalPrice = totalPrice;
        this.state = State.CREATED;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean sameId(Long id){
        return this.id == id;
    }

    public boolean sameState(String state){
        return this.state.name().equals(state);
    }

    public void changeOrderState_SHIPPING(){
        this.state = State.SHIPPING;
    }
}
