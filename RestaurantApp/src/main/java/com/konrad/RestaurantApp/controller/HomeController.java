package com.konrad.RestaurantApp.controller;

import com.konrad.RestaurantApp.repository.CoffeeRepository;
import com.konrad.RestaurantApp.repository.DrinkRepository;
import com.konrad.RestaurantApp.repository.MealRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    private final CoffeeRepository coffeeRepository;
    private final DrinkRepository drinkRepository;
    private final MealRepository mealRepository;

    @Autowired
    public HomeController(CoffeeRepository coffeeRepository, DrinkRepository drinkRepository, MealRepository mealRepository) {
        this.coffeeRepository = coffeeRepository;
        this.drinkRepository = drinkRepository;
        this.mealRepository = mealRepository;
    }

    @GetMapping("/order")
    public String showHomePage(Model model) {
        model.addAttribute("coffees", coffeeRepository.findAll());
        model.addAttribute("drinks", drinkRepository.findAll());
        model.addAttribute("meals", mealRepository.findAll());
        return "order";
    }

    @GetMapping("/")
    public String showHomePage() {
        return "homepage";
    }

    @GetMapping("/home")
    public String ownerHome(Model model, Authentication authentication) {
        String username = authentication.getName();
        model.addAttribute("username", username);
        return "home";
    }
}

