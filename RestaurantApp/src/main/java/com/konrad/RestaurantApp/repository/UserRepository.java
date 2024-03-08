package com.konrad.RestaurantApp.repository;

import com.konrad.RestaurantApp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
