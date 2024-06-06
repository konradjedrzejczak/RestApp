package com.konrad.RestaurantApp.service;


import com.konrad.RestaurantApp.dto.UserDTO;
import com.konrad.RestaurantApp.entity.Orders;
import com.konrad.RestaurantApp.entity.User;

import java.util.List;

public interface UserService {

    User createUser(UserDTO userDTO);

    List<User> findAllUsers();

    User findByUsername(String username);

    List<String> getAllMails();

    User viewUserById(Long userId);

    void deleteUser(Long userId);

    void addFavouriteMeal(Long userId, Long mealId);

    List<Orders> viewAllOrders(Long userId);

    User getCurrentUser();

    void updateUserMail(String mail);

    void updateUserPhone(int phoneNumber);

}
