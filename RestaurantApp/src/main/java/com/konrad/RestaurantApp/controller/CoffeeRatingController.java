package com.konrad.RestaurantApp.controller;

import com.konrad.RestaurantApp.dto.CoffeeRatingRequest;
import com.konrad.RestaurantApp.entity.CoffeeRating;
import com.konrad.RestaurantApp.service.CoffeeRatingService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("api/ratings")
public class CoffeeRatingController {

    private CoffeeRatingService coffeeRatingService;

    public CoffeeRatingController(CoffeeRatingService coffeeRatingService) {
        this.coffeeRatingService = coffeeRatingService;
    }

    @PostMapping()
    public CoffeeRating coffeeRating(@RequestBody CoffeeRatingRequest coffeeRatingRequest) {
        return coffeeRatingService.addRating(coffeeRatingRequest.getCoffeeId(), coffeeRatingRequest.getUserId(),
                coffeeRatingRequest.getRating(), coffeeRatingRequest.getReview());
    }

    @DeleteMapping("/{coffeeRating}")
    public void deleteRating(Long coffeeRating){
        coffeeRatingService.deleteRating(coffeeRating);
    }
}
