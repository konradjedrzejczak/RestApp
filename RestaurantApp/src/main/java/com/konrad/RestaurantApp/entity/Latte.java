package com.konrad.RestaurantApp.entity;

import jakarta.persistence.Entity;

@Entity
public class Latte extends Coffee {

    private static final boolean ISMILK = true;
    private static final int SUGAR = 5;
    private static final boolean LACTOSE = true;
    private static final int GRINDTYPE = 2;
    private static final int CALORIES = 300;

    public Latte() {
        super(ISMILK, SUGAR, LACTOSE, GRINDTYPE, CALORIES);
    }
}
