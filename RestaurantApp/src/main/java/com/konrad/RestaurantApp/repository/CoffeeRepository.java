package com.konrad.RestaurantApp.repository;

import com.konrad.RestaurantApp.entity.Coffee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CoffeeRepository extends JpaRepository<Coffee, Long> {


}
