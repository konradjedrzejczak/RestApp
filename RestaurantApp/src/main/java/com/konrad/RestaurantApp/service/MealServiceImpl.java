package com.konrad.RestaurantApp.service;

import com.konrad.RestaurantApp.dto.MealDTO;
import com.konrad.RestaurantApp.entity.Meal;
import com.konrad.RestaurantApp.exception.ServiceException;
import com.konrad.RestaurantApp.repository.MealRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class MealServiceImpl implements MealService {

    private final MealRepository mealRepository;

    @Autowired
    public MealServiceImpl(MealRepository mealRepository) {
        this.mealRepository = mealRepository;
    }

    @Override
    public void readyMeals() {

        Meal meal1 = new Meal("Dinner", 20.0, 750);
        Meal meal2 = new Meal("Lunch", 15.0, 450);
        Meal meal3 = new Meal("Breakfast", 10.0, 350);

        mealRepository.saveAll(Arrays.asList(meal1, meal2, meal3));
    }

    @Override
    public Meal addMeal(MealDTO mealDTO) {
        Meal meal = new Meal(mealDTO.getName(), mealDTO.getPrice(), mealDTO.getCalories());
        return mealRepository.save(meal);
    }

    @Override
    public double getMealsSum(){
       return mealRepository.findAll().stream()
                .mapToDouble(Meal::getPrice)
                .sum();
    }

    @Override
    public List<Meal> getAllMeals() {
        return mealRepository.findAll();
    }

    @Override
    public Meal getMealById(Long id) {
        return mealRepository.findById(id)
                .orElseThrow(() -> new ServiceException("Meal not found"));
    }

    @Override
    public void deleteMealById(Long id) {
        Optional<Meal> byId = mealRepository.findById(id);
        boolean present = byId.isPresent();
        if (present) {
            mealRepository.deleteById(id);
        } else {
            throw new ServiceException("Meal not Found");
        }
    }
}
