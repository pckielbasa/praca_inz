package com.example.praca_inz_api.controller;

import com.example.praca_inz_api.converter.FoodConverter;
import com.example.praca_inz_api.dto.FoodDTO;
import com.example.praca_inz_api.model.Food;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.http.ResponseEntity;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;


public class FoodControllerTest {


    @Test
    void addFoodToUser() {
        FoodController foodController = mock(FoodController.class);
        Food food = new Food(
                "6208299a5adf15753a523f34",
                "620733937afc0720579330ae",
                "Meal Test",
                "Composition test",
                "Meal",
                false
        );

        given(foodController.addFoodToUser(Mockito.any(FoodDTO.class)))
                .willReturn( ResponseEntity.ok().body(FoodConverter.toDTO(food)));

        Assertions.assertEquals(food.getType(), "Meal" );
    }

}