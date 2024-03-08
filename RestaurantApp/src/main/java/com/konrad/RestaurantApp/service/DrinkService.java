package com.konrad.RestaurantApp.service;

import com.konrad.RestaurantApp.dto.DrinkDTO;
import com.konrad.RestaurantApp.entity.Drink;

import java.util.List;

public interface DrinkService {

    Drink addDrink(DrinkDTO drinkDTO);

    List<Drink> getAllDrink();

    void deleteDrink(Long drinkId);

}

