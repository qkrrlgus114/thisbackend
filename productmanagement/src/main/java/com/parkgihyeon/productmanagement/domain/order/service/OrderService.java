package com.parkgihyeon.productmanagement.domain.order.service;

import com.parkgihyeon.productmanagement.domain.order.dto.request.OrderRequestDTO;
import com.parkgihyeon.productmanagement.domain.order.dto.response.OrderResponseDTO;

import java.util.List;

public interface OrderService {
    OrderResponseDTO createOrder(List<OrderRequestDTO> orderRequestDTOS);
    OrderResponseDTO changeOrderState(Long id);
    OrderResponseDTO findByIdOrder(Long id);
    List<OrderResponseDTO> findByStateOrders(String state);
}
