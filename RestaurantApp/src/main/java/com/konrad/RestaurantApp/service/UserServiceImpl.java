package com.konrad.RestaurantApp.service;

import com.konrad.RestaurantApp.dto.Role;
import com.konrad.RestaurantApp.entity.Meal;
import com.konrad.RestaurantApp.entity.Orders;
import com.konrad.RestaurantApp.exception.ServiceException;
import com.konrad.RestaurantApp.dto.UserDTO;
import com.konrad.RestaurantApp.entity.User;
import com.konrad.RestaurantApp.repository.MealRepository;
import com.konrad.RestaurantApp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final MealRepository mealRepository;
    private final PasswordEncoder passwordEncoder;


    @Autowired
    public UserServiceImpl(UserRepository userRepository, MealRepository mealRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.mealRepository = mealRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User createUser(UserDTO userDTO) throws ServiceException {

        User user = new User();
        user.setUsername(userDTO.getUsername());
        user.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        user.setEmail(userDTO.getEmail());
        user.setPhoneNumber(userDTO.getPhoneNumber());
        user.setRole(Role.USER);

        if (user.validName()) {
            return userRepository.save(user);
        } else {
            throw new ServiceException("User not added, the name should be longer than 3 characters");
        }
    }

    @Override
    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User findByUsername(String username) {
        Optional<User> optionalUser = userRepository.findByUsername(username);
        return optionalUser.orElse(null); // to fix
    }

    @Override
    public List<String> getAllMails() {
        return userRepository.findAll()
                .stream()
                .map(User::getEmail)
                .collect(Collectors.toList());
    }

    @Override
    public User viewUserById(Long userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new ServiceException("Wrong User id"));
    }

    @Override
    public List<Orders> viewAllOrders(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ServiceException("User not found"));
        return user.getOrders();
    }


    @Override
    public void addFavouriteMeal(Long userId, Long mealId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ServiceException("User not found"));

        Meal meal = mealRepository.findById(mealId)
                .orElseThrow(() -> new ServiceException("Meal not found"));

        user.getFavouriteMeals().add(meal);
        userRepository.save(user);
    }


    @Override
    public void deleteUser(Long userId) {
        Optional<User> byId = userRepository.findById(userId);
        boolean present = byId.isPresent();
        if (present) {
            userRepository.deleteById(userId);
        } else {
            throw new ServiceException("User not found");
        }
    }

    @Override
    public User getCurrentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || !authentication.isAuthenticated()) {
            throw new ServiceException("No authenticated user found");
        }

        Object principal = authentication.getPrincipal();
        String username;

        if (principal instanceof UserDetails) {
            username = ((UserDetails) principal).getUsername();
        } else {
            username = principal.toString();
        }

        return userRepository.findByUsername(username)
                .orElseThrow(() -> new ServiceException("User not found"));
    }

    @Override
    public void updateUserMail(String mail) {
        String currentUsername = SecurityContextHolder.getContext().getAuthentication().getName();

        User existingUser = userRepository.findByUsername(currentUsername)
                .orElseThrow(() -> new ServiceException("User not found"));

        existingUser.setEmail(mail);
        userRepository.save(existingUser);
    }

    @Override
    public void updateUserPhone(int phoneNumber) {
        String currentUsername = SecurityContextHolder.getContext().getAuthentication().getName();

        User existingUser = userRepository.findByUsername(currentUsername)
                .orElseThrow(() -> new ServiceException("User not found"));

        existingUser.setPhoneNumber(phoneNumber);
        userRepository.save(existingUser);
    }
}

