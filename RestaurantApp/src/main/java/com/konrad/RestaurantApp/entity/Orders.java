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

    @ManyToMany
    private List<Coffee> coffees = new ArrayList<>();


    public Orders(User user, List<Coffee> coffees) {
        this.user = user;
        this.coffees = coffees;
    }

    public Orders() {
    }
}
