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
public class OrderServiceImpl implements OrderService {

    private Orders currentOrder = new Orders();

    private final OrderRepository orderRepository;
    private final DrinkRepository drinkRepository;
    private final CoffeeRepository coffeeRepository;
    private final UserRepository userRepository;
    private final MealRepository mealRepository;

    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository, DrinkRepository drinkRepository,
                            CoffeeRepository coffeeRepository, UserRepository userRepository, MealRepository mealRepository) {
        this.orderRepository = orderRepository;
        this.drinkRepository = drinkRepository;
        this.coffeeRepository = coffeeRepository;
        this.userRepository = userRepository;
        this.mealRepository = mealRepository;
    }

    @Override
    public void addCoffeeToOrder(Coffee coffee) {
        currentOrder.getCoffees().add(coffee);
        currentOrder.setTotalPrice(currentOrder.getTotalPrice() + coffee.getPrice());
        currentOrder.setTotalCalories(currentOrder.getTotalCalories() + coffee.getCalories());
    }

    @Override
    public void addDrinkToOrder(Drink drink) {
        currentOrder.getDrinks().add(drink);
        currentOrder.setTotalPrice(currentOrder.getTotalPrice() + drink.getPrice());
        currentOrder.setTotalCalories(currentOrder.getTotalCalories() + drink.getCalories());
    }

    @Override
    public void addMealToOrder(Meal meal) {
        currentOrder.getMeals().add(meal);
        currentOrder.setTotalPrice(currentOrder.getTotalPrice() + meal.getPrice());
        currentOrder.setTotalCalories(currentOrder.getTotalCalories() + meal.getCalories());
    }

    @Override
    public Orders getCurrentOrder() {
        return currentOrder;
    }

    @Transactional
    public void confirmOrder(Orders order) {
        currentOrder.setOrderStatus(OrderStatus.NEW);
        orderRepository.save(order);
        currentOrder = new Orders();
    }

    public Orders updateOrderStatus(Long orderId, OrderStatus status) {
        Orders order = orderRepository.findById(orderId).orElse(null);
        if (order != null) {
            order.setOrderStatus(status);
            orderRepository.save(order);
        }
        return order;
    }
    @Override
    public void setUserForCurrentOrder(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ServiceException("User not found"));
        currentOrder.setUser(user);
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