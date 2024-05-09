package com.konrad.RestaurantApp.service;

import com.konrad.RestaurantApp.entity.Coffee;
import com.konrad.RestaurantApp.entity.CoffeeRating;
import com.konrad.RestaurantApp.entity.User;
import com.konrad.RestaurantApp.exception.ServiceException;
import com.konrad.RestaurantApp.repository.CoffeeRatingRepository;
import com.konrad.RestaurantApp.repository.CoffeeRepository;
import com.konrad.RestaurantApp.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class CoffeeRatingService {

    private final CoffeeRatingRepository coffeeRatingRepository;
    private final CoffeeRepository coffeeRepository;
    private final UserRepository userRepository;

    public CoffeeRatingService(CoffeeRatingRepository coffeeRatingRepository, CoffeeRepository coffeeRepository, UserRepository userRepository) {
        this.coffeeRatingRepository = coffeeRatingRepository;
        this.coffeeRepository = coffeeRepository;
        this.userRepository = userRepository;
    }

    public CoffeeRating addRating(Long coffeeId, Long userId, int rating, String review) {
        Coffee coffee = coffeeRepository.findById(coffeeId)
                .orElseThrow(() -> new ServiceException("Coffee not found"));

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ServiceException("User not found"));

        CoffeeRating coffeeRating = new CoffeeRating();
        coffeeRating.setCoffee(coffee);
        coffeeRating.setUser(user);
        coffeeRating.setRating(rating);
        coffeeRating.setReview(review);

        return coffeeRatingRepository.save(coffeeRating);
    }

    public void deleteRating(Long coffeeRating){
        coffeeRatingRepository.deleteById(coffeeRating);
    }
}
