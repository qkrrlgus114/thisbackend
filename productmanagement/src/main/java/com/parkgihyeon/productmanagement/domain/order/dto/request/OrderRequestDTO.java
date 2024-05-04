package com.parkgihyeon.productmanagement.domain.order.dto.request;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class OrderRequestDTO {
    private Long id;
    private Integer amount;

    public OrderRequestDTO(Long id, Integer amount) {
        this.id = id;
        this.amount = amount;
    }

    public Long getId() {
        return id;
    }

    public Integer getAmount() {
        return amount;
    }
}
