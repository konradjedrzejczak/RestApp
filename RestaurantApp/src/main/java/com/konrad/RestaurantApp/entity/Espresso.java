package com.konrad.RestaurantApp.entity;

import jakarta.persistence.Entity;

@Entity
public class Espresso extends Coffee {

    private static final boolean IS_MILK = false;
    private static final int SUGAR = 0;
    private static final boolean IS_LACTOSE = false;
    private static final int GRINDTYPE = 5;

    public Espresso() {
        super(IS_MILK, SUGAR, IS_LACTOSE, GRINDTYPE);
    }
}

