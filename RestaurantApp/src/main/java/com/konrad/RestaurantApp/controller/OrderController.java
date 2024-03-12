package com.konrad.RestaurantApp.controller;

import com.konrad.RestaurantApp.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.konrad.RestaurantApp.entity.Orders;
import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping
    public Orders createOrder(@RequestParam Long userId, @RequestBody List<Long> coffeeIds) {
        return orderService.createOrder(userId, coffeeIds);
    }
}
