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

    private boolean milk;
    private int sugar;
    private boolean lactose;
    private int grindType;

    public Coffee(boolean milk, int sugar, boolean lactose, int grindType) {
        this.milk = milk;
        this.sugar = sugar;
        this.lactose = lactose;
        this.grindType = grindType;
    }

    @JsonIgnore
    @ManyToMany(mappedBy = "coffees")
    private List<Orders> orders = new ArrayList<>();
}
