package com.konrad.RestaurantApp.service;

import com.konrad.RestaurantApp.entity.*;
import com.konrad.RestaurantApp.exception.ServiceException;
import com.konrad.RestaurantApp.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class OrderService {

    private final OrderRepository orderRepository;
    private final DrinkRepository drinkRepository;
    private final CoffeeRepository coffeeRepository;
    private final UserRepository userRepository;
    private final MealRepository mealRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository, DrinkRepository drinkRepository,
                        CoffeeRepository coffeeRepository, UserRepository userRepository, MealRepository mealRepository) {
        this.orderRepository = orderRepository;
        this.drinkRepository = drinkRepository;
        this.coffeeRepository = coffeeRepository;
        this.userRepository = userRepository;
        this.mealRepository = mealRepository;
    }

    public Orders createOrder(Long userId, Long coffeeId, Long drinkId, Long mealId) {
        User user = userRepository.findById(userId).
                orElseThrow(() -> new ServiceException("User not found"));

        Coffee coffee = coffeeRepository.findById(coffeeId)
                .orElseThrow(() -> new ServiceException("Coffee not found"));

        Drink drink = drinkRepository.findById(drinkId)
                .orElseThrow(() -> new ServiceException("Drink not found"));

        Meal meal = mealRepository.findById(mealId)
                .orElseThrow(() -> new ServiceException("Meal not found"));

        double totalPrice = coffee.calculatePrice() + drink.getPrice() + meal.getPrice();
        Orders orders = new Orders(user, coffee, drink, meal, totalPrice);

        orderRepository.save(orders);
        return orders;
    }

    public List<Orders> getAllOrders() {
        return orderRepository.findAll();
    }

    public Orders getOrderById(Long id) {
        return orderRepository.findById(id)
                .orElseThrow(() -> new ServiceException("Order not found with id: " + id));
    }

    public Orders confirmOrder(Long orderId) {
        Orders order = orderRepository.findById(orderId)
                .orElseThrow(() -> new ServiceException("Order not found"));

        order.setOrderStatus(OrderStatus.CONFIRMED);
        return orderRepository.save(order);
    }

    public Orders cancelOrder(Long orderId) {
        Orders order = orderRepository.findById(orderId)
                .orElseThrow(() -> new ServiceException("Order not found"));

        order.setOrderStatus(OrderStatus.CANCELED);
        orderRepository.delete(order);
        return order;
    }
}