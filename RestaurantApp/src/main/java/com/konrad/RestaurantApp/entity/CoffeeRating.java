package com.konrad.RestaurantApp.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class CoffeeRating {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Coffee coffee;

    @ManyToOne
    private User user;

    private int rating;
    private String review;

}
