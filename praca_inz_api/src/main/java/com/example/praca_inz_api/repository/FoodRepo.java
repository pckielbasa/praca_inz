package com.example.praca_inz_api.repository;

import com.example.praca_inz_api.dto.FoodDTO;

import com.example.praca_inz_api.model.Food;

import java.util.Collection;


public interface FoodRepo {
    Collection<Food> getAllType(String type);
    Food getFoodById(String foodId);
    Food createFood(FoodDTO foodDTO);
    Food addFoodToUser(FoodDTO foodDTO);
    void deleteFoodById(String foodId, String username );


}
