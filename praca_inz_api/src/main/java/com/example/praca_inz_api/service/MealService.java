package com.example.praca_inz_api.service;

import com.example.praca_inz_api.dao.MealDao;
import com.example.praca_inz_api.model.Meal;
import com.example.praca_inz_api.repository.MealRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MealService implements MealRepo {
    @Autowired
    private MealDao mealDao;


    @Override
    public List<Meal> getAllMeals(){
        return mealDao.findAll();
    }

    @Override
    public Meal addMeal(Meal meal) {
        return mealDao.save(meal);
    }

}
