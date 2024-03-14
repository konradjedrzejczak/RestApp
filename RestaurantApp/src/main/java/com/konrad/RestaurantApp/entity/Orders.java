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

    @OneToMany
    private User user;

    @OneToMany
    private Coffee coffees;

    @OneToMany
    private Drink drinks;

    public Orders(User user, Coffee coffees, Drink drinks) {
        this.user = user;
        this.coffees = coffees;
        this.drinks = drinks;
    }

    public Orders() {
    }
}
