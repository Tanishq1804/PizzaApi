package com.pizzashop.service;

import com.pizzashop.model.Order;
import com.pizzashop.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    public Flux<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public Mono<Order> getOrderById(String id) {
        return orderRepository.findById(id);
    }

    public Mono<Order> placeOrder(Order order) {
        return orderRepository.save(order);
    }

    public Mono<Order> updateOrderStatus(String id, String status) {
        return orderRepository.findById(id)
                .flatMap(order -> {
                    order.setStatus(status);
                    return orderRepository.save(order);
                });
    }

    public Mono<Void> cancelOrder(String id) {
        return orderRepository.deleteById(id);
    }
}