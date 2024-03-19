package com.konrad.RestaurantApp.repository;

import com.konrad.RestaurantApp.entity.Meal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MealRepository extends JpaRepository<Meal, Long> {
}
