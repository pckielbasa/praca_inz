package com.example.praca_inz_api.converter;

import com.example.praca_inz_api.dto.AddFoodDTO;
import com.example.praca_inz_api.dto.FoodDTO;
import com.example.praca_inz_api.model.Food;

public class FoodConverter {
    public static AddFoodDTO toDTO(Food entity){
        return new AddFoodDTO(
                entity.getUsername(),
                entity.getFoodName(),
                entity.getComposition(),
                entity.getType(),
                entity.getFavourite()
        );
    }
}
