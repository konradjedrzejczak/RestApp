package com.konrad.RestaurantApp.controller;

import com.konrad.RestaurantApp.dto.OrderRequest;
import com.konrad.RestaurantApp.service.OrderService;
import org.springframework.web.bind.annotation.*;
import com.konrad.RestaurantApp.entity.Orders;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping
    public List<Orders> getAllOrders() {
        return orderService.getAllOrders();
    }

    @GetMapping("/{id}")
    public Orders getOrderById(@PathVariable Long id) {
        return orderService.getOrderById(id);
    }

    @PostMapping
    public Orders createOrder(@RequestBody OrderRequest orderRequest) {
        return orderService.createOrder(orderRequest.getUserId(), orderRequest.getCoffeeId(), orderRequest.getDrinkId());
    }
}
