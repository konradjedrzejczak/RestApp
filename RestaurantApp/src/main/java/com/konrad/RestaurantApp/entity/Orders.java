package com.konrad.RestaurantApp.entity;

import com.konrad.RestaurantApp.dto.DeliveryMethod;
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

    @Setter
    @ManyToOne
    private User user;

    @ManyToMany
    private List<Coffee> coffees = new ArrayList<>();

    @ManyToMany
    private List<Drink> drinks = new ArrayList<>();

    @ManyToMany
    private List<Meal> meals = new ArrayList<>();

    @Column()
    private double totalPrice;

    @Column()
    private int totalCalories;

    @Enumerated(EnumType.STRING)
    private DeliveryMethod deliveryMethod;

    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;

    private String firstName;
    private String lastName;
    private String street;
    private String city;

    @Column()
    private Integer postalCode;

    public Orders() {
        this.totalPrice = 0.0;
        this.totalCalories = 0;
    }

    public Orders(User user, Coffee coffee, Drink drink, Meal meal, double totalPrice, int totalCalories, DeliveryMethod deliveryMethod) {
        this.user = user;
        this.coffees.add(coffee);
        this.drinks.add(drink);
        this.meals.add(meal);
        this.totalPrice = totalPrice;
        this.totalCalories = totalCalories;
        this.deliveryMethod = deliveryMethod;
        this.orderStatus = OrderStatus.NEW;
    }


    public void addCoffee(Coffee coffee) {
        this.coffees.add(coffee);
        this.totalPrice += coffee.getPrice();
        this.totalCalories += coffee.getCalories();
    }

    public void addDrink(Drink drink) {
        this.drinks.add(drink);
        this.totalPrice += drink.getPrice();
        this.totalCalories += drink.getCalories();
    }

    public void addMeal(Meal meal) {
        this.meals.add(meal);
        this.totalPrice += meal.getPrice();
        this.totalCalories += meal.getCalories();
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
