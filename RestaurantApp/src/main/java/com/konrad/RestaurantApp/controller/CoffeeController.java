package com.konrad.RestaurantApp.controller;

import com.konrad.RestaurantApp.dto.CoffeeDTO;
import com.konrad.RestaurantApp.entity.Coffee;
import com.konrad.RestaurantApp.service.CoffeeService;
import com.konrad.RestaurantApp.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/coffees")
public class CoffeeController {

    private final CoffeeService coffeeService;
    private final OrderService orderService;

    @Autowired
    public CoffeeController(CoffeeService coffeeService, OrderService orderService) {
        this.coffeeService = coffeeService;
        this.orderService = orderService;
    }

    @GetMapping
    public String viewAllCoffees(Model model) {
        List<Coffee> coffees = coffeeService.getAllCoffee();
        model.addAttribute("coffees", coffees);
        return "coffees";
    }

    @GetMapping("/{id}")
    public String getCoffeeById(@PathVariable Long id, Model model) {
        model.addAttribute("coffee", coffeeService.getCoffeeById(id));
        return "coffeeDetail";
    }

    @GetMapping("/milkCoffee")
    public String getCoffeeWithMilk(Model model) {
        model.addAttribute("coffees", coffeeService.getCoffeeWithMilk());
        return "coffeeList";
    }

    @GetMapping("/add")
    public String addCoffeeForm(Model model) {
        model.addAttribute("coffee", new CoffeeDTO());
        return "add";
    }

    @PostMapping("/add")
    public String addCoffee(@ModelAttribute CoffeeDTO coffeeDTO) {
        coffeeService.addCoffee(coffeeDTO);
        return "redirect:/coffee/list";
    }

    @GetMapping("/delete/{coffeeId}")
    public String deleteCoffee(@PathVariable Long coffeeId) {
        coffeeService.deleteCoffee(coffeeId);
        return "redirect:/api/coffees";
    }
}