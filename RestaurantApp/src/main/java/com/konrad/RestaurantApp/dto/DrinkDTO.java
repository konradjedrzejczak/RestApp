package com.konrad.RestaurantApp.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DrinkDTO {

    private String name;
    private double price;
    private int calories;
}
