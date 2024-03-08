package com.konrad.RestaurantApp.repository;

import com.konrad.RestaurantApp.entity.Drink;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DrinkRepository extends JpaRepository<Drink, Long> {
}
