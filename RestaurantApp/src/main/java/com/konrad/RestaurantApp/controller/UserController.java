package com.konrad.RestaurantApp.controller;

import com.konrad.RestaurantApp.dto.UserDTO;
import com.konrad.RestaurantApp.entity.Orders;
import com.konrad.RestaurantApp.entity.User;
import com.konrad.RestaurantApp.service.UserService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@Validated
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public UserDTO createUser(@Validated @RequestBody UserDTO userDTO) {
        userService.createUser(userDTO);
        return userDTO;
    }

    @GetMapping
    public List<User> findAllUsers() {
        return userService.findAllUsers();
    }

    @GetMapping("/getMails")
    public List<String> getAllMails() {
        return userService.getAllMails();
    }

    @GetMapping("/{userId}/orders")
    public List<Orders> getUserOrders(@PathVariable Long userId) {
        return userService.viewAllOrders(userId);
    }

    @PostMapping("/{userId}")
    public void addFavouriteMeal(@PathVariable Long userId, @RequestBody Long mealId) {
        userService.addFavouriteMeal(userId, mealId);
    }

    @GetMapping("/{userId}")
    public User viewUserById(@PathVariable Long userId) {
        return userService.viewUserById(userId);
    }

    @DeleteMapping("/{userId}")
    public void deleteUser(@PathVariable Long userId) {
        userService.deleteUser(userId);
    }
}
