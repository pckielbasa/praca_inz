package com.example.praca_inz_api.converter;

import com.example.praca_inz_api.dto.AddFoodDTO;
import com.example.praca_inz_api.dto.FoodDTO;
import com.example.praca_inz_api.dto.FoodListDTO;
import com.example.praca_inz_api.model.Food;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class FoodConverterTest {

    @Test
    public void toDTO() {
        Food food = new Food();
        food.setType("Meal");

        AddFoodDTO addFoodDTO = FoodConverter.toDTO(food);

        Assert.assertEquals(addFoodDTO.getType(), food.getType());
    }

    @Test
    public void toFoodDTO() {
        Food food = new Food();
        food.setType("Meal");

         FoodListDTO foodListDTO = FoodConverter.toFoodDTO(food);

        Assert.assertEquals(foodListDTO.getType(), food.getType());
    }

    @Test
    public void foodToFoodDTO() {
        Food food = new Food();
        food.setType("Meal");

        FoodDTO foodDTO = new FoodDTO();
        foodDTO.setType("Meal");

        Assert.assertEquals(foodDTO.getType(), food.getType());
    }
}