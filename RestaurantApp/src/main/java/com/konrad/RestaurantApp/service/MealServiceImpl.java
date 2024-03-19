package com.konrad.RestaurantApp.service;

import com.konrad.RestaurantApp.dto.MealDTO;
import com.konrad.RestaurantApp.entity.Meal;
import com.konrad.RestaurantApp.exception.ServiceException;
import com.konrad.RestaurantApp.repository.MealRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.List;

public class MealServiceImpl implements MealService {

    private final MealRepository mealRepository;

    @Autowired
    public MealServiceImpl(MealRepository mealRepository) {
        this.mealRepository = mealRepository;
    }

    public void readyMeals(MealDTO mealDTO) {

        Meal meal1 = new Meal("Danie 1", 20.0, 2);
        Meal meal2 = new Meal("Danie 2", 15.0, 2);
        Meal meal3 = new Meal("Danie 3", 25.0, 2);

        mealRepository.saveAll(Arrays.asList(meal1, meal2, meal3));
    }

    @Override
    public Meal addMeal(MealDTO mealDTO) {
        Meal meal = new Meal(mealDTO.getName(), mealDTO.getPrice(), mealDTO.getCalories());
        return mealRepository.save(meal);
    }

    @Override
    public List<Meal> getAllMeals() {
        return mealRepository.findAll();
    }

    @Override
    public Meal getMealById(Long id) {
        return mealRepository.findById(id)
                .orElseThrow(() -> new ServiceException("Meal not found"));
    }
}
