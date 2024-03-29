package com.konrad.RestaurantApp.service;

import com.konrad.RestaurantApp.dto.CoffeeDTO;
import com.konrad.RestaurantApp.entity.Coffee;
import com.konrad.RestaurantApp.entity.Espresso;
import com.konrad.RestaurantApp.entity.Latte;

import java.util.List;

public interface CoffeeService {

    Coffee getCoffeeById(Long id);

    List<Coffee> getAllCoffee();

    Coffee addCoffee(CoffeeDTO coffeeDTO);

    Espresso espresso();

    Latte latte();

    List<Coffee> getCoffeeWithMilk();
    void deleteCoffee(Long coffeeId);
}
