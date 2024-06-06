package com.konrad.RestaurantApp.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderRequest {

    private Long userId;
    private Long coffeeId;
    private Long drinkId;
    private Long mealId;
    private DeliveryMethod deliveryMethod;
}
