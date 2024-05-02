package com.parkgihyeon.product.management.presentation;

import com.parkgihyeon.product.management.domain.Product;
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

    public ProductDTO(String name, Integer price, Integer amount) {
        this.name = name;
        this.price = price;
        this.amount = amount;
    }

    public ProductDTO(Long id, @NotNull String name, @NotNull Integer price, @NotNull Integer amount) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.amount = amount;
    }

    public static Product toEntity(ProductDTO productDTO){
        Product product = new Product(productDTO.getId(), productDTO.getName(), productDTO.getPrice(), productDTO.getAmount());

        return product;
    }

    public static ProductDTO toDTO(Product product){
        ProductDTO productDTO = new ProductDTO(product.getId(), product.getName(), product.getPrice(), product.getAmount());
        return productDTO;
    }
}
