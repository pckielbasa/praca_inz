package com.example.praca_inz_api.repository;

import com.example.praca_inz_api.model.Meal;



import java.util.Collection;

public interface MealRepo{
    Collection<Meal> getAllMeals();
    Meal addMeal(Meal meal);

}
