package com.konrad.RestaurantApp.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Coffee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Getter
    private boolean milk;
    private int sugar;
    private boolean lactose;
    private int grindType;
    private int calories;

    public Coffee(boolean milk, int sugar, boolean lactose, int grindType, int calories) {
        this.milk = milk;
        this.sugar = sugar;
        this.lactose = lactose;
        this.grindType = grindType;
        this.calories = calories;
    }

    @JsonIgnore
    @ManyToMany(mappedBy = "coffees")
    private List<Orders> orders = new ArrayList<>();

    public double calculatePrice() {
        double basePrice = 0;

        if (milk) {
            basePrice += 2;
        }

        if (sugar > 5) {
            basePrice += 1;
        }

        if (lactose) {
            basePrice += 1.5;
        }

        if (grindType > 5) {
            basePrice += 2;
        }

        return basePrice;
    }
}
