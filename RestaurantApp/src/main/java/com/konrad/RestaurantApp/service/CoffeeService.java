package com.konrad.RestaurantApp.service;

import com.konrad.RestaurantApp.dto.CoffeeDTO;
import com.konrad.RestaurantApp.entity.Coffee;
import com.konrad.RestaurantApp.entity.Espresso;
import com.konrad.RestaurantApp.entity.Latte;

public interface CoffeeService {

    Coffee getCoffeeById(Long id);

    Coffee addCoffee(CoffeeDTO coffeeDTO);

    Espresso espresso();

    Latte latte();

    void deleteCoffee(Long coffeeId);
}
