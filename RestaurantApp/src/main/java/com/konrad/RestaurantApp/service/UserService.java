package com.konrad.RestaurantApp.service;


import com.konrad.RestaurantApp.dto.UserDTO;
import com.konrad.RestaurantApp.entity.User;

import java.util.List;

public interface UserService {

    User createUser(UserDTO userDTO);

    List<User> findAllUsers();

    void deleteUser(Long userId);

}
