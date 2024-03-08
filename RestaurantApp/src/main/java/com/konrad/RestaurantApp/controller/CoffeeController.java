package com.konrad.RestaurantApp.controller;

import com.konrad.RestaurantApp.dto.CoffeeDTO;
import com.konrad.RestaurantApp.entity.Coffee;
import com.konrad.RestaurantApp.entity.Espresso;
import com.konrad.RestaurantApp.entity.Latte;
import com.konrad.RestaurantApp.service.CoffeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/coffees")
public class CoffeeController {

    private final CoffeeService coffeeService;

    @Autowired
    public CoffeeController(CoffeeService coffeeService) {
        this.coffeeService = coffeeService;
    }

    @GetMapping
    public Coffee getCoffeeById(@PathVariable Long id) {
        return coffeeService.getCoffeeById(id);
    }

    @PostMapping
    public Coffee addCoffee(@Validated @RequestBody CoffeeDTO coffeeDTO) {
        return coffeeService.addCoffee(coffeeDTO);
    }

    @PostMapping("/espresso")
    public Espresso brewEspresso() {
        return coffeeService.espresso();
    }

    @PostMapping("/latte")
    public Latte brewLatte() {
        return coffeeService.latte();
    }

    @DeleteMapping("/{coffeeId}")
    public void deleteCoffee(@PathVariable Long coffeeId) {
        coffeeService.deleteCoffee(coffeeId);
    }

}
