package com.konrad.RestaurantApp.controller;

import com.konrad.RestaurantApp.dto.CoffeeRatingRequest;
import com.konrad.RestaurantApp.entity.CoffeeRating;
import com.konrad.RestaurantApp.service.CoffeeRatingService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/ratings")
public class CoffeeRatingController {

    private CoffeeRatingService coffeeRatingService;

    public CoffeeRatingController(CoffeeRatingService coffeeRatingService) {
        this.coffeeRatingService = coffeeRatingService;
    }

    @PostMapping()
    public CoffeeRating coffeeRating(@RequestBody CoffeeRatingRequest coffeeRatingRequest) {
        return coffeeRatingService.addRating(coffeeRatingRequest.getCoffeId(), coffeeRatingRequest.getUserId(),
                coffeeRatingRequest.getRating(), coffeeRatingRequest.getReview());

    }
}
