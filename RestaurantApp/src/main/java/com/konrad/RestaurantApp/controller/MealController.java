package com.konrad.RestaurantApp.controller;

import com.konrad.RestaurantApp.dto.MealDTO;
import com.konrad.RestaurantApp.entity.Meal;
import com.konrad.RestaurantApp.service.MealService;
import com.konrad.RestaurantApp.service.OrderService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/meal")
public class MealController {

    private final MealService mealService;
    private final OrderService orderService;

    public MealController(MealService mealService, OrderService orderService) {
        this.mealService = mealService;
        this.orderService = orderService;
    }

    @PostMapping("/add")
    public String addMeal(@ModelAttribute MealDTO mealDTO) {
        mealService.addMeal(mealDTO);
        return "redirect:/";
    }

    @GetMapping("/add")
    public String addMealForm(Model model) {
        model.addAttribute("meal", new MealDTO());
        return "mealsAdd";
    }
    @GetMapping
    public String viewAllMeals(Model model) {
        List<Meal> meals = mealService.getAllMeals();
        model.addAttribute("meals", meals);
        return "meals";
    }

    @PostMapping("/{id}/add")
    public String addMealToOrder(@PathVariable Long id) {
        Meal meal = mealService.getMealById(id);
        if (meal != null) {
            orderService.addMealToOrder(meal);
        }
        return "redirect:/";
    }

    @GetMapping("/{id}")
    public Meal getMealById(Long id) {
        return mealService.getMealById(id);
    }

    @PostMapping("/ready")
    public void readyMeals() {
        mealService.readyMeals();
    }

    @GetMapping("/delete/{mealId}")
    public String deleteMealById(@PathVariable Long mealId){
        mealService.deleteMealById(mealId);
        return "redirect:/api/meal";
    }
}
