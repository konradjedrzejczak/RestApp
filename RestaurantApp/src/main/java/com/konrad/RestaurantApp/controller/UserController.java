package com.konrad.RestaurantApp.controller;

import com.konrad.RestaurantApp.dto.UserDTO;
import com.konrad.RestaurantApp.entity.Orders;
import com.konrad.RestaurantApp.entity.User;
import com.konrad.RestaurantApp.service.UserService;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
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
    public String viewAllUsers(Model model) {
        List<User> users = userService.findAllUsers();
        model.addAttribute("users", users);
        return "users";
    }

    @GetMapping("/delete/{userId}")
    public String deleteUser(@PathVariable Long userId) {
        userService.deleteUser(userId);
        return "redirect:/users";
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


    @GetMapping("/me")
    public String viewCurrentUser(Model model, Authentication authentication) {
        String username = authentication.getName();
        User user = userService.findByUsername(username);
        model.addAttribute("user", user);
        return "userDetails";
    }


    @GetMapping("/updateMail")
    public String updateMailPage(Model model) {
        model.addAttribute("user", userService.getCurrentUser());
        return "updateMail";
    }

    @PostMapping("/updateEmail")
    public String updateEmail(@RequestParam("email") String email) {
        userService.updateUserMail(email);
        return "redirect:/api/users/me";
    }

    @GetMapping("/updatePhone")
    public String updatePhonePage(Model model) {
        model.addAttribute("user", userService.getCurrentUser());
        return "updatePhoneNumber";
    }

    @PostMapping("/updatePhone")
    public String updatePhone(@RequestParam("number") int number) {
        userService.updateUserPhone(number);
        return "redirect:/api/users/me";
    }
}
