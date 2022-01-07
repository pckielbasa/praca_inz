package com.example.praca_inz_api.converter;

import com.example.praca_inz_api.dto.FoodDTO;
import com.example.praca_inz_api.dto.MealDTO;
import com.example.praca_inz_api.model.Food;
import com.example.praca_inz_api.model.Meal;

public class FoodConverter {
    public static FoodDTO toDTO(Food entity){
        return new FoodDTO(
                entity.getFoodName(),
                entity.getComposition(),
                entity.getCommentAlertAllergies(),
                entity.getType(),
                entity.getFavourite(),
                entity.getAllergy()
        );
    }
}
