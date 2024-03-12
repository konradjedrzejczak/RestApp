package com.konrad.RestaurantApp.repository;

import com.konrad.RestaurantApp.entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Orders, Long> {
}
