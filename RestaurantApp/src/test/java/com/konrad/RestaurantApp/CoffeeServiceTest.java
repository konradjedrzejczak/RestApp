package com.konrad.RestaurantApp;

import com.konrad.RestaurantApp.dto.CoffeeDTO;
import com.konrad.RestaurantApp.entity.Coffee;
import com.konrad.RestaurantApp.entity.Espresso;
import com.konrad.RestaurantApp.entity.Latte;
import com.konrad.RestaurantApp.repository.CoffeeRepository;
import com.konrad.RestaurantApp.service.CoffeeServiceImpl;
import org.hibernate.service.spi.ServiceException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@SpringBootTest
class CoffeeServiceTest {

    @Mock
    private CoffeeRepository coffeeRepository;

    @InjectMocks
    private CoffeeServiceImpl coffeeService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAllCoffee() {

        Coffee espresso = new Espresso();
        Coffee latte = new Latte();
        List<Coffee> expectedCoffees = Arrays.asList(espresso, latte);
        when(coffeeRepository.findAll()).thenReturn(expectedCoffees);

        List<Coffee> actualCoffees = coffeeService.getAllCoffee();

        assertEquals(expectedCoffees.size(), actualCoffees.size());
        assertEquals(expectedCoffees, actualCoffees);
    }

    @Test
    void testAddCoffee() {
        // Given
        CoffeeDTO coffeeDTO = new CoffeeDTO(true, 2, false, 5);
        Coffee coffee = new Coffee(true, 2, false, 5);
        when(coffeeRepository.save(any())).thenReturn(coffee);

        // When
        Coffee addedCoffee = coffeeService.addCoffee(coffeeDTO);

        // Then
        assertNotNull(addedCoffee);
        assertEquals(coffee, addedCoffee);
    }
    @Test
    void testGetCoffeeById() {

        Long coffeeId = 1L;
        Coffee expectedCoffee = new Coffee(true,2,true,4);
        when(coffeeRepository.findById(coffeeId)).thenReturn(Optional.of(expectedCoffee));

        when(coffeeRepository.save(any())).thenReturn(expectedCoffee);
        coffeeService.addCoffee(new CoffeeDTO(true, 2, true, 4));

        Coffee actualCoffee = coffeeService.getCoffeeById(coffeeId);

        assertEquals(expectedCoffee, actualCoffee);
    }

    @Test
    void testBrewEspresso() {

        Espresso expectedEspresso = new Espresso();
        when(coffeeRepository.save(any(Espresso.class))).thenReturn(expectedEspresso);

        Espresso actualEspresso = coffeeService.espresso();

        assertEquals(expectedEspresso, actualEspresso);
    }

    @Test
    void testBrewLatte() {

        Latte expectedLatte = new Latte();
        when(coffeeRepository.save(any(Latte.class))).thenReturn(expectedLatte);

        Latte actualLatte = coffeeService.latte();

        assertEquals(expectedLatte, actualLatte);
    }

    @Test
    void testDeleteCoffee() {

        Long coffeeId = 1L;
        when(coffeeRepository.findById(coffeeId)).thenReturn(Optional.of(new Espresso()));

        coffeeService.deleteCoffee(coffeeId);

        verify(coffeeRepository, times(1)).deleteById(coffeeId);
    }

    @Test
    void testDeleteNonExistingCoffee() {

        Long coffeeId = 1L;
        when(coffeeRepository.findById(coffeeId)).thenReturn(Optional.empty());

        assertThrows(ServiceException.class, () -> coffeeService.deleteCoffee(coffeeId));
    }
}

