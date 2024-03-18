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

    @Column(nullable = true)
    private double price;

    public Orders(User user, Coffee coffees, Drink drinks, double price) {
        this.user = user;
        this.coffees = coffees;
        this.drinks = drinks;
        this.price = price;
    }

    public Orders() {
    }
}
