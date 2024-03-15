package com.konrad.RestaurantApp.service;

import com.konrad.RestaurantApp.entity.Coffee;
import com.konrad.RestaurantApp.entity.Drink;
import com.konrad.RestaurantApp.entity.Orders;
import com.konrad.RestaurantApp.entity.User;
import com.konrad.RestaurantApp.exception.ServiceException;
import com.konrad.RestaurantApp.repository.CoffeeRepository;
import com.konrad.RestaurantApp.repository.DrinkRepository;
import com.konrad.RestaurantApp.repository.OrderRepository;
import com.konrad.RestaurantApp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class OrderService {

    private final OrderRepository orderRepository;
    private final DrinkRepository drinkRepository;
    private final CoffeeRepository coffeeRepository;
    private final UserRepository userRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository, DrinkRepository drinkRepository, CoffeeRepository coffeeRepository, UserRepository userRepository) {
        this.orderRepository = orderRepository;
        this.drinkRepository = drinkRepository;
        this.coffeeRepository = coffeeRepository;
        this.userRepository = userRepository;
    }

    public Orders createOrder(Long userId, Long coffeeId, Long drinkId) {

        User user = userRepository.findById(userId).
                orElseThrow(() -> new ServiceException("User not Found"));

        Coffee coffee = coffeeRepository.findById(coffeeId)
                .orElseThrow(() -> new ServiceException("Coffee not Found"));

        Drink drink = drinkRepository.findById(drinkId)
                .orElseThrow(() -> new ServiceException("Drink not found"));

        double totalPrice = coffee.calculatePrice() + drink.getPrice();
        Orders orders = new Orders(user, coffee, drink, totalPrice);

        orderRepository.save(orders);
        return orders;
    }
}
