package com.konrad.RestaurantApp.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CoffeeRatingRequest {

    private Long coffeeId;
    private Long userId;
    private int rating;
    private String review;
}
