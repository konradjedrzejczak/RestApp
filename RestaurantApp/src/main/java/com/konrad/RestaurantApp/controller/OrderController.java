package com.konrad.RestaurantApp.controller;

import com.konrad.RestaurantApp.dto.OrderRequest;
import com.konrad.RestaurantApp.service.OrderService;
import org.springframework.web.bind.annotation.*;
import com.konrad.RestaurantApp.entity.Orders;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public Orders createOrder(@RequestBody OrderRequest orderRequest) {
        return orderService.createOrder(orderRequest.getUserId(), orderRequest.getCoffeeId(), orderRequest.getDrinkId());
    }
}
