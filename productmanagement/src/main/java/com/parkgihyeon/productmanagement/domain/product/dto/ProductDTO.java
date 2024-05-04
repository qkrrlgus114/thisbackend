package com.parkgihyeon.productmanagement.domain.product.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class ProductDTO {
    private Long id;
    private String name;
    private Integer price;
    private Integer amount;

    public ProductDTO(Long id, String name, Integer price, Integer amount) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.amount = amount;
    }
}
