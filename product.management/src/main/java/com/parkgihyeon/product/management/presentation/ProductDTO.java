package com.parkgihyeon.product.management.presentation;

import jakarta.validation.constraints.NotNull;

public class ProductDTO {
    private Long id;
    @NotNull
    private String name;
    @NotNull
    private Integer price;
    @NotNull
    private Integer amount;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getPrice() {
        return price;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ProductDTO() {
    }

    public ProductDTO(@NotNull String name, @NotNull Integer price, @NotNull Integer amount) {
        this.name = name;
        this.price = price;
        this.amount = amount;
    }
}
