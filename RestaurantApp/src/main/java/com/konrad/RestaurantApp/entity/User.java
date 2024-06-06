package com.konrad.RestaurantApp.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.konrad.RestaurantApp.dto.Role;
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

    private String username;
    private String password;
    private String email;
    private int phoneNumber;

    @Enumerated(EnumType.STRING)
    private Role role;

    @ManyToMany
    private Set<Meal> favouriteMeals;
    
    public User(String username, String password, String email, int phoneNumber) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public boolean validName() {
        return this.username != null && this.username.length() >= 3;
    }

    @JsonIgnore
    @OneToMany(mappedBy = "user")
    private List<Orders> orders = new ArrayList<>();

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
