package com.konrad.RestaurantApp.repository;

import com.konrad.RestaurantApp.entity.CoffeeRating;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CoffeeRatingRepository extends JpaRepository<CoffeeRating, Long> {
}
