package com.konrad.RestaurantApp.service;

import com.konrad.RestaurantApp.entity.Orders;

import java.util.List;

public interface OrderService {

    Orders createOrder(Long userId, Long coffeeId, Long drinkId, Long mealId);

    List<Orders> getAllOrders();

    Orders getOrderById(Long id);

    Orders confirmOrder(Long orderId);

    Orders cancelOrder(Long orderId);


}
