package com.konrad.RestaurantApp.controller;

import com.konrad.RestaurantApp.dto.DrinkDTO;
import com.konrad.RestaurantApp.entity.Drink;
import com.konrad.RestaurantApp.service.DrinkService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/drink")
public class DrinkController {

    private final DrinkService drinkService;

    public DrinkController(DrinkService drinkService) {
        this.drinkService = drinkService;
    }

    @GetMapping
    public List<Drink> getAllDrinks() {
        return drinkService.getAllDrink();
    }

    @PostMapping
    public Drink addDrink(@Validated @RequestBody DrinkDTO drinkDTO) {
        return drinkService.addDrink(drinkDTO);
    }

    @DeleteMapping("/{drinkId}")
    public void deleteDrink(@PathVariable Long drinkId) {
        drinkService.deleteDrink(drinkId);
    }
}
