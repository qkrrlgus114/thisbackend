package com.parkgihyeon.productmanagement.domain.order.service;

import com.parkgihyeon.productmanagement.domain.order.entity.Order;
import com.parkgihyeon.productmanagement.domain.product.dto.ProductDTO;
import com.parkgihyeon.productmanagement.domain.order.dto.request.OrderRequestDTO;
import com.parkgihyeon.productmanagement.domain.order.dto.response.OrderResponseDTO;
import com.parkgihyeon.productmanagement.domain.order.repository.OrderRepository;
import com.parkgihyeon.productmanagement.domain.product.entity.Product;
import com.parkgihyeon.productmanagement.domain.product.exception.NoProductAmountException;
import com.parkgihyeon.productmanagement.domain.product.exception.NotFoundProductException;
import com.parkgihyeon.productmanagement.domain.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService{

    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;

    // 주문 생성
    @Override
    public OrderResponseDTO createOrder(List<OrderRequestDTO> orderRequestDTOS) {
        // 상품 검색(없으면 에러 발생)
        List<Product> products = orderRequestDTOS.stream()
                .map(orderRequestDTO -> {
                    Long productId = orderRequestDTO.getId();
                    Product product = productRepository.findById(productId);
                    if (product == null) throw new NotFoundProductException("Product를 찾을 수 없습니다.");

                    checkAmountProduct(product, orderRequestDTO.getAmount());

                    return new Product(product.getId(), product.getName(), product.getPrice(), orderRequestDTO.getAmount());
                }).toList();

        // 상품 재고 감소 진행
        products.stream()
                .forEach(product -> {
                    Long productId = product.getId();
                    Product findProduct = productRepository.findById(productId);

                    findProduct.decrementAmount(product.getAmount());

                    productRepository.update(findProduct);
                });

        int totalPrice = products.stream()
                .mapToInt(product ->
                        product.getAmount() * product.getPrice()
                ).sum();

        Order order = new Order(products, totalPrice);
        // 주문 저장
        Order savedOrder = orderRepository.add(order);

        return OrderResponseDTO.toDTO(savedOrder);
    }

    // 주문 상태 강제 변경
    @Override
    public OrderResponseDTO changeOrderState(Long id) {
        Order order = orderRepository.findById(id);
        order.changeOrderState_SHIPPING();

        OrderResponseDTO orderResponseDTO = OrderResponseDTO.toDTO(order);
        return orderResponseDTO;
    }

    // 주문 조회
    @Override
    public OrderResponseDTO findByIdOrder(Long id) {
        Order order = orderRepository.findById(id);

        return OrderResponseDTO.toDTO(order);
    }

    // 주문 상태로 조회
    @Override
    public List<OrderResponseDTO> findByStateOrders(String state) {
        List<Order> orders = orderRepository.findByState(state);

        System.out.println(orders);

        List<OrderResponseDTO> list = orders.stream()
                .map(order -> {
                    return OrderResponseDTO.toDTO(order);
                }).toList();

        return list;
    }

    private void checkAmountProduct(Product product, Integer orderAmount){
        if(!product.checkAmount(orderAmount)) throw new NoProductAmountException(product.getId() + "번 재고가 부족합니다.");
    }
}
