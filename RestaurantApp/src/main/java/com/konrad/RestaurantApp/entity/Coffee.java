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
    private String name;
    private boolean milk;
    private int sugar;
    private boolean lactose;
    private int grindType;

    @Column(nullable = false, columnDefinition = "integer default 0")
    private Integer price;

    @Column(nullable = false, columnDefinition = "default 0")
    private Integer calories;

    public Coffee(String name, boolean milk, int sugar, boolean lactose, int grindType, int calories, int price) {
        this.name = name;
        this.milk = milk;
        this.sugar = sugar;
        this.lactose = lactose;
        this.grindType = grindType;
        this.calories = calories;
        this.price = price;
    }

    @JsonIgnore
    @ManyToMany(mappedBy = "coffees")
    private List<Orders> orders = new ArrayList<>();

}
