package com.konrad.RestaurantApp.service;

import com.konrad.RestaurantApp.entity.Coffee;
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

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private DrinkRepository drinkRepository;

    @Autowired
    private CoffeeRepository coffeeRepository;

    @Autowired
    private UserRepository userRepository;

    public Orders createOrder(Long userId, Long coffeeId /*, *//*List<Long> drinkId*/) {

        User user = userRepository.findById(userId).
                orElseThrow(() -> new ServiceException("User not Found"));

        /*List<Drink> drinks = drinkRepository.findAllById(drinkId);*/
        Coffee coffee = coffeeRepository.findById(coffeeId)
                .orElseThrow(() -> new ServiceException("Coffee not Found"));


        Orders orders = new Orders(user, coffee);
        /* orders.getDrinks().addAll(drinks);*/

        orderRepository.save(orders);
        return orders;
    }
}
