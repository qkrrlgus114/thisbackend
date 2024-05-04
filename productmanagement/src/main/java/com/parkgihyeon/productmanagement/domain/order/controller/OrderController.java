package com.parkgihyeon.productmanagement.domain.order.controller;

import com.parkgihyeon.productmanagement.domain.order.dto.request.OrderRequestDTO;
import com.parkgihyeon.productmanagement.domain.order.dto.response.OrderResponseDTO;
import com.parkgihyeon.productmanagement.domain.order.service.OrderService;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("orders")
public class OrderController {

    private final OrderService orderService;

    // 상품 주문
    @PostMapping
    public ResponseEntity<OrderResponseDTO> orderProduct(@RequestBody List<OrderRequestDTO> orderRequestDTOS){
        OrderResponseDTO orderResponseDTO = orderService.createOrder(orderRequestDTOS);
        return new ResponseEntity<>(orderResponseDTO, HttpStatus.OK);
    }

    // 주문 상태 변경
    @PatchMapping("/{orderId}")
    public ResponseEntity<OrderResponseDTO> changeStateOrder(@PathVariable(name = "orderId") Long id){
        OrderResponseDTO orderResponseDTO = orderService.changeOrderState(id);
        return new ResponseEntity<>(orderResponseDTO, HttpStatus.OK);
    }

    // 주문 번호로 조회
    @GetMapping("/{orderId}")
    public ResponseEntity<OrderResponseDTO> findByIdOrder(@PathVariable(name = "orderId") Long id){
        OrderResponseDTO orderResponseDTO = orderService.findByIdOrder(id);
        return new ResponseEntity<>(orderResponseDTO, HttpStatus.OK);
    }

    // 주문 상태로 조회
    @GetMapping
    public ResponseEntity<List<OrderResponseDTO>> findByStateOrders(@RequestParam("state") String state){
        List<OrderResponseDTO> orderResponseDTOS = orderService.findByStateOrders(state);
        return new ResponseEntity<>(orderResponseDTOS, HttpStatus.OK);
    }
}
