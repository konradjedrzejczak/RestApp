package com.konrad.RestaurantApp.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CoffeeRatingRequest {

    private Long coffeId;
    private Long userId;
    private int rating;
    private String review;
}
