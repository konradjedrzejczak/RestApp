package com.konrad.RestaurantApp.service;

import com.konrad.RestaurantApp.dto.MealDTO;
import com.konrad.RestaurantApp.entity.Meal;

import java.util.List;

public interface MealService {

    Meal addMeal(MealDTO mealDTO);

    List<Meal> getAllMeals();

    Meal getMealById(Long id);

    void readyMeals();

    void deleteMealById(Long id);
}
