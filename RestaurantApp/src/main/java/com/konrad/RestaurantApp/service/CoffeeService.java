package com.konrad.RestaurantApp.service;

import com.konrad.RestaurantApp.dto.CoffeeDTO;
import com.konrad.RestaurantApp.entity.Coffee;


import java.util.List;

public interface CoffeeService {

    Coffee getCoffeeById(Long id);

    List<Coffee> getAllCoffee();

    Coffee addCoffee(CoffeeDTO coffeeDTO);

    List<Coffee> getCoffeeWithMilk();

    void deleteCoffee(Long coffeeId);
}
