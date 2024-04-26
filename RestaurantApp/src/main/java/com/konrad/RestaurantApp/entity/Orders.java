package com.konrad.RestaurantApp.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    private User user;

    @ManyToOne
    private Coffee coffees;

    @ManyToOne
    private Drink drinks;

    @ManyToOne
    private Meal meal;

    @Column(nullable = true)
    private double price;

    @Column(nullable = true)
    private int calories;

    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;

    public Orders(User user, Coffee coffees, Drink drinks, Meal meal, double price, int calories) {
        this.user = user;
        this.coffees = coffees;
        this.drinks = drinks;
        this.price = price;
        this.meal = meal;
        this.calories = calories;
    }

    public Orders() {
    }
}
