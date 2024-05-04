package com.parkgihyeon.productmanagement.domain.order.dto.response;

import com.parkgihyeon.productmanagement.domain.order.entity.Order;
import com.parkgihyeon.productmanagement.domain.product.dto.ProductDTO;
import com.parkgihyeon.productmanagement.domain.order.entity.State;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@Getter
public class OrderResponseDTO {
    private Long id;
    private List<ProductDTO> productDTOS;
    private Integer totalPrice;
    private State state;

    @Builder
    public OrderResponseDTO(Long id, List<ProductDTO> productDTOS, Integer totalPrice, State state) {
        this.id = id;
        this.productDTOS = productDTOS;
        this.totalPrice = totalPrice;
        this.state = state;
    }

    public static OrderResponseDTO toDTO(Order order){

        List<ProductDTO> productDTOList = order.getProductList().stream()
                .map(product -> {
                    return new ProductDTO(product.getId(), product.getName(), product.getPrice(), product.getAmount());
                }).toList();

        return OrderResponseDTO.builder()
                .id(order.getId())
                .productDTOS(productDTOList)
                .totalPrice(order.getTotalPrice())
                .state(order.getState()).build();
    }


}
