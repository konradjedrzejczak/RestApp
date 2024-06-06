package com.konrad.RestaurantApp.controller;

import com.konrad.RestaurantApp.dto.DrinkDTO;
import com.konrad.RestaurantApp.entity.Drink;
import com.konrad.RestaurantApp.service.DrinkService;
import com.konrad.RestaurantApp.service.OrderService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/drink")
public class DrinkController {

    private final DrinkService drinkService;
    private final OrderService orderService;

    public DrinkController(DrinkService drinkService, OrderService orderService) {
        this.drinkService = drinkService;
        this.orderService = orderService;
    }

    @GetMapping
    public String viewAllDrinks(Model model) {
        List<Drink> drinks = drinkService.getAllDrink();
        model.addAttribute("drinks", drinks);
        return "drinksList";
    }

    @GetMapping("/add")
    public String showAddDrinkForm(Model model) {
        model.addAttribute("drink", new DrinkDTO());
        return "addDrink";
    }

    @GetMapping("/lowCalories")
    public List<Drink> getDrinkWithLowCalories() {
        return drinkService.getDrinkWithLowCalories();
    }

    @PostMapping("/add")
    public String addDrink(@ModelAttribute DrinkDTO drinkDTO) {
        drinkService.addDrink(drinkDTO);
        return "redirect:/";
    }

    @PostMapping("/{id}/add")
    public String addDrinkToOrder(@PathVariable Long id) {
        Drink drink = drinkService.getDrinkById(id);
        if (drink != null) {
            orderService.addDrinkToOrder(drink);
        }
        return "redirect:/";
    }

    @GetMapping("/delete/{drinkId}")
    public String deleteDrink(@PathVariable Long drinkId) {
        drinkService.deleteDrink(drinkId);
        return "redirect:/api/drink";
    }
}
