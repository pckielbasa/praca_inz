package com.example.praca_inz_api.repository;

import com.example.praca_inz_api.model.Food;
import com.example.praca_inz_api.model.Meal;

import java.util.Collection;

public interface FoodRepo {
    Collection<Food> getAllFood();
    Food addFood(Food food);
}
