package com.konrad.RestaurantApp.service;

import com.konrad.RestaurantApp.dto.DeliveryMethod;
import com.konrad.RestaurantApp.entity.*;

import java.util.List;

public interface OrderService {


    List<Orders> getAllOrders();

    Orders getOrderById(Long id);

    Orders confirmOrder(Long orderId);

    Orders cancelOrder(Long orderId);

    void addCoffeeToOrder(Coffee coffee);

    void addDrinkToOrder(Drink drink);

    void addMealToOrder(Meal meal);

    Orders getCurrentOrder();

    void confirmOrder(Orders order);

    Orders updateOrderStatus(Long orderId, OrderStatus status);

    void setUserForCurrentOrder(Long userId);

}
