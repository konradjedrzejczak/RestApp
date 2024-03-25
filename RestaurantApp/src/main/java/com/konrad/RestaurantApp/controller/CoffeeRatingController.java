package com.konrad.RestaurantApp.controller;

import com.konrad.RestaurantApp.service.CoffeeRatingService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ratings")
public class CoffeeRatingController {

    private CoffeeRatingService coffeeRatingService;

    public CoffeeRatingController(CoffeeRatingService coffeeRatingService) {
        this.coffeeRatingService = coffeeRatingService;
    }

    @PostMapping("/coffee/{coffeeId}/user/{userId}")
    public ResponseEntity<Void> addRating(@PathVariable Long coffeeId,
                                          @PathVariable Long userId,
                                          @RequestParam int rating,
                                          @RequestParam String review) {
        coffeeRatingService.addRating(coffeeId, userId, rating, review);
        return ResponseEntity.ok().build();
    }
}
