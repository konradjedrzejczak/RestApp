package com.konrad.RestaurantApp.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

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

    public Orders(User user, Coffee coffees, Drink drinks) {
        this.user = user;
        this.coffees = coffees;
        this.drinks = drinks;
    }

    public Orders() {
    }
}
