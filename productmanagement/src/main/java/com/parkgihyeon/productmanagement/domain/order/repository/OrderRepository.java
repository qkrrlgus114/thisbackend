package com.parkgihyeon.productmanagement.domain.order.repository;

import com.parkgihyeon.productmanagement.domain.order.entity.Order;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface OrderRepository {
    Order add(Order order);
    Order findById(Long id);
    List<Order> findByState(String state);
}
