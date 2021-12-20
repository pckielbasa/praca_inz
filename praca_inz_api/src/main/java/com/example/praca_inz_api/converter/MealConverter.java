package com.example.praca_inz_api.converter;

import com.example.praca_inz_api.dto.MealDTO;
import com.example.praca_inz_api.dto.UserDTO;
import com.example.praca_inz_api.model.Meal;
import com.example.praca_inz_api.model.User;

public class MealConverter {
    public static MealDTO toDTO(Meal entity){
        return new MealDTO(
                entity.getMealName(),
                entity.getCommentAlertAllergies(),
                entity.getFavourite());
    }
}
