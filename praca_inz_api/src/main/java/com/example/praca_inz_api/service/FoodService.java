package com.example.praca_inz_api.service;

import com.example.praca_inz_api.dao.FoodDao;

import com.example.praca_inz_api.model.Food;

import com.example.praca_inz_api.repository.FoodRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodService implements FoodRepo {
    @Autowired
    private FoodDao foodDao;


    @Override
    public List<Food> getAllFood(){
        return foodDao.findAll();
    }

    @Override
    public Food addFood(Food food) {
        return foodDao.save(food);
    }

}
