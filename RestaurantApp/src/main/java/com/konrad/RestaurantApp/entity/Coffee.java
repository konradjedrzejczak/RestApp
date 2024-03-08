package com.konrad.RestaurantApp.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
}
