package com.konrad.RestaurantApp.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "users_list")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private String email;
    private String phoneNumber;

    @ManyToMany
    private Set<Meal> favouriteMeals;

    public User(String name, String email, String phoneNumber) {
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public boolean validName() {
        return this.name != null && this.name.length() >= 3;
    }

    @JsonIgnore
    @OneToMany(mappedBy = "user")
    private List<Orders> orders = new ArrayList<>();


}
