package com.konrad.RestaurantApp.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CoffeeDTO {

    private boolean milk;
    private int sugar;
    private boolean lactose;
    private int grindType;
    private int calories;
}
