package com.example.praca_inz_api.repository;

import com.example.praca_inz_api.model.Food;

import java.util.Collection;

public interface FoodRepo {
    Collection<Food> getAllFood();
    Food addFood(Food food);
    Collection<Food> getAllType(String type);
}
