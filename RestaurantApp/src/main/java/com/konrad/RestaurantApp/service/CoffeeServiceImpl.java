package com.konrad.RestaurantApp.service;

import com.konrad.RestaurantApp.dto.CoffeeDTO;
import com.konrad.RestaurantApp.entity.Coffee;
import com.konrad.RestaurantApp.exception.ServiceException;
import com.konrad.RestaurantApp.repository.CoffeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CoffeeServiceImpl implements CoffeeService {

    private final CoffeeRepository coffeeRepository;

    @Autowired
    public CoffeeServiceImpl(CoffeeRepository coffeeRepository) {
        this.coffeeRepository = coffeeRepository;
    }

    @Override
    public Coffee getCoffeeById(Long id) {
        return coffeeRepository.findById(id)
                .orElseThrow(() -> new ServiceException("Coffee not found"));
    }

    @Override
    public List<Coffee> getAllCoffee() {
        return coffeeRepository.findAll();
    }

    @Override
    public Coffee addCoffee(CoffeeDTO coffeeDTO) {
        Coffee coffee = new Coffee(coffeeDTO.getName(), coffeeDTO.isMilk(), coffeeDTO.getSugar(), coffeeDTO.isLactose(), coffeeDTO.getGrindType(), coffeeDTO.getCalories(), coffeeDTO.getPrice());
        return coffeeRepository.save(coffee);
    }

    @Override
    public List<Coffee> getCoffeeWithMilk() {
        return coffeeRepository.findAll()
                .stream()
                .filter(Coffee::isMilk)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteCoffee(Long coffeeId) {
        Optional<Coffee> byId = coffeeRepository.findById(coffeeId);
        boolean present = byId.isPresent();
        if (present) {
            coffeeRepository.deleteById(coffeeId);
        } else {
            throw new ServiceException("Not found drink with id" + coffeeId);
        }
    }
}
