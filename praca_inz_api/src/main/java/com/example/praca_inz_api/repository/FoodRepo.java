package com.example.praca_inz_api.repository;

import com.example.praca_inz_api.model.Food;

import java.util.Collection;
import java.util.List;

public interface FoodRepo {
    Collection<Food> getAllFood();
    Food addFood(Food food);
    Collection<Food> getAllType(String type);
    Food getFoodById(String foodId);
    String getFoodId(String foodId);
    List<Food> getListOfFoodByIds(List<String> idList);
}
