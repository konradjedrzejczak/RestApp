package com.konrad.RestaurantApp.service;

import com.konrad.RestaurantApp.dto.DrinkDTO;
import com.konrad.RestaurantApp.entity.Drink;
import com.konrad.RestaurantApp.exception.ServiceException;
import com.konrad.RestaurantApp.repository.DrinkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DrinkServiceImpl implements DrinkService {

    private final DrinkRepository drinkRepository;

    @Autowired
    public DrinkServiceImpl(DrinkRepository drinkRepository) {
        this.drinkRepository = drinkRepository;
    }

    @Override
    public Drink addDrink(DrinkDTO drinkDTO) {
        Drink drink = new Drink(drinkDTO.getName(), drinkDTO.getPrice(), drinkDTO.getCalories());
        return drinkRepository.save(drink);
    }

    @Override
    public Drink getDrinkById(Long id) {
        return drinkRepository.findById(id)
                .orElseThrow(() -> new ServiceException("Coffee not found"));
    }

    @Override
    public List<Drink> getAllDrink() {
        return drinkRepository.findAll();
    }

    @Override
    public List<Drink> getDrinkWithLowCalories() {
        return drinkRepository.findAll()
                .stream().filter(drink -> drink.getCalories() < 15)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteDrink(Long drinkId) {
        Optional<Drink> byId = drinkRepository.findById(drinkId);
        boolean present = byId.isPresent();
        if (present) {
            drinkRepository.deleteById(drinkId);
        } else {
            throw new ServiceException("Drink not found with id" + drinkId);
        }
    }
}
