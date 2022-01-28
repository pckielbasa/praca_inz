package com.example.praca_inz_api.repository;

import com.example.praca_inz_api.dto.FoodDTO;
import com.example.praca_inz_api.model.Food;

import java.util.Collection;
import java.util.List;
import java.util.stream.Stream;

public interface FoodRepo {
    Collection<Food> getAllFood();
    Collection<Food> getAllType(String type, String username);
    Food getFoodById(String foodId);
    String getFoodId(String foodId);
    List<Food> getListOfFoodByIds(List<String> idList);
    Food createFood(FoodDTO foodDTO);
    Food addFoodToUser(FoodDTO foodDTO);
    String findByFoodName(String foodName);

}
