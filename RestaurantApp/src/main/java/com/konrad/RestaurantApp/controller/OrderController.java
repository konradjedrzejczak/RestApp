package com.konrad.RestaurantApp.controller;

import com.konrad.RestaurantApp.dto.DeliveryMethod;
import com.konrad.RestaurantApp.entity.*;
import com.konrad.RestaurantApp.service.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;
    private final CoffeeService coffeeService;
    private final DrinkService drinkService;
    private final MealService mealService;
    private final UserService userService;

    public OrderController(OrderService orderService, CoffeeService coffeeService, DrinkService drinkService, MealService mealService, UserService userService) {
        this.orderService = orderService;
        this.coffeeService = coffeeService;
        this.drinkService = drinkService;
        this.mealService = mealService;
        this.userService = userService;
    }

    @GetMapping("/cart")
    public String viewCart(Model model) {
        model.addAttribute("order", orderService.getCurrentOrder());
        return "cart";
    }

    @GetMapping
    public List<Orders> getAllOrders() {
        return orderService.getAllOrders();
    }


    @GetMapping("/{id}")
    public Orders getOrderById(@PathVariable Long id) {
        return orderService.getOrderById(id);
    }

    @PostMapping("/{orderId}/confirm")
    public String confirmOrder(@PathVariable Long orderId) {
        orderService.updateOrderStatus(orderId, OrderStatus.CONFIRMED);
        return "redirect:/orders/manage";
    }

    @PostMapping("/{orderId}/cancel")
    public String cancelOrder(@PathVariable Long orderId) {
        orderService.updateOrderStatus(orderId, OrderStatus.CANCELED);
        return "redirect:/orders/manage";
    }

    @PostMapping("/confirm")
    public String createOrder(@RequestParam("deliveryMethod") DeliveryMethod deliveryMethod,
                              @RequestParam(value = "firstName", required = false) String firstName,
                              @RequestParam(value = "lastName", required = false) String lastName,
                              @RequestParam(value = "street", required = false) String street,
                              @RequestParam(value = "city", required = false) String city,
                              @RequestParam(value = "postalCode", required = false) Integer postalCode) {
        Orders currentOrder = orderService.getCurrentOrder();
        User currentUser = userService.getCurrentUser();

        currentOrder.setUser(currentUser);
        currentOrder.setDeliveryMethod(deliveryMethod);

        if (deliveryMethod == DeliveryMethod.DELIVERY) {
            currentOrder.setFirstName(firstName);
            currentOrder.setLastName(lastName);
            currentOrder.setStreet(street);
            currentOrder.setCity(city);
            currentOrder.setPostalCode(postalCode);
        }

        orderService.confirmOrder(currentOrder);

        return "redirect:/orders/confirmationMessage";
    }

    @GetMapping("/confirmationMessage")
    public String orderConfirmationMessage(Model model) {
        model.addAttribute("message", "Twoje zamówienie zostało złożone.");
        return "confirmationMessage";
    }

    @GetMapping("/manage")
    public String manageOrders(Model model) {
        List<Orders> orders = orderService.getAllOrders();
        model.addAttribute("orders", orders);
        return "manageOrders";
    }

    @GetMapping("/summary")
    public String orderSummary(Model model) {
        model.addAttribute("order", orderService.getCurrentOrder());
        return "orderSummary";
    }

    @PostMapping("/coffees/{id}/add")
    public String addCoffeeToOrder(@PathVariable Long id) {
        Coffee coffee = coffeeService.getCoffeeById(id);
        if (coffee != null) {
            orderService.addCoffeeToOrder(coffee);
        }
        return "redirect:/order";
    }

    @PostMapping("/drinks/{id}/add")
    public String addDrinkToOrder(@PathVariable Long id) {
        Drink drink = drinkService.getDrinkById(id);
        if (drink != null) {
            orderService.addDrinkToOrder(drink);
        }
        return "redirect:/order";
    }

    @PostMapping("/meals/{id}/add")
    public String addMealToOrder(@PathVariable Long id) {
        Meal meal = mealService.getMealById(id);
        if (meal != null) {
            orderService.addMealToOrder(meal);
        }
        return "redirect:/order";
    }
}
