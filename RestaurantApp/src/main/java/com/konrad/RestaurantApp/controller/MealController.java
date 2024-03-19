package com.konrad.RestaurantApp.controller;

import com.konrad.RestaurantApp.dto.MealDTO;
import com.konrad.RestaurantApp.entity.Meal;
import com.konrad.RestaurantApp.service.MealService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/meal")
public class MealController {

    private final MealService mealService;

    public MealController(MealService mealService) {
        this.mealService = mealService;
    }

    @PostMapping("/add")
    public Meal addMeal(@RequestBody MealDTO mealDTO) {
        return mealService.addMeal(mealDTO);
    }

    @GetMapping
    public List<Meal> getAllMeals() {
        return mealService.getAllMeals();
    }

    @GetMapping("/{id}")
    public Meal getMealById(Long id) {
        return mealService.getMealById(id);
    }

    @PostMapping("/ready")
    public void readyMeals() {
        mealService.readyMeals();
    }
}
