package com.konrad.RestaurantApp.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Meal {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String name;
    private double price;
    private int calories;

    @ManyToMany(mappedBy = "favouriteMeals")
    private Set<User> users;

    public Meal(String name, double price, int calories) {
        this.name = name;
        this.price = price;
        this.calories = calories;
    }

    @JsonIgnore
    @ManyToMany(mappedBy = "meals")
    private List<Orders> orders = new ArrayList<>();
}
