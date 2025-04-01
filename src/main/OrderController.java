package com.pizzashop.controller;

import com.pizzashop.model.Order;
import com.pizzashop.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/orders")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @GetMapping("/")
    public Flux<Order> getAllOrders() {
        return orderService.getAllOrders();
    }

    @GetMapping("/{id}")
    public Mono<Order> getOrderById(@PathVariable String id) {
        return orderService.getOrderById(id);
    }

    @PostMapping
    public Mono<Order> placeOrder(@RequestBody Order order) {
        return orderService.placeOrder(order);
    }

    @PutMapping("/{id}")
    public Mono<Order> updateOrderStatus(@PathVariable String id, @RequestParam String status) {
        return orderService.updateOrderStatus(id, status);
    }

    @DeleteMapping("/{id}")
    public Mono<Void> cancelOrder(@PathVariable String id) {
        return orderService.cancelOrder(id);
    }
}