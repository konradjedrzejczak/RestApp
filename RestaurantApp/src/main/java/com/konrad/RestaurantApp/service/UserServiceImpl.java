package com.konrad.RestaurantApp.service;

import com.konrad.RestaurantApp.exception.ServiceException;
import com.konrad.RestaurantApp.dto.UserDTO;
import com.konrad.RestaurantApp.entity.User;
import com.konrad.RestaurantApp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User createUser(UserDTO userDTO) throws ServiceException {

        User user = new User(userDTO.getName(), userDTO.getEmail());
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
    public User viewUserById(Long userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new ServiceException("Wrong User id"));
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
}

