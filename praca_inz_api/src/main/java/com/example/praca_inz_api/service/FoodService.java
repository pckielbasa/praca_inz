package com.example.praca_inz_api.service;

import com.example.praca_inz_api.dao.FoodDao;

import com.example.praca_inz_api.model.Food;

import com.example.praca_inz_api.repository.FoodRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

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

    @Override
    public Collection<Food> getAllType(String type) {
        return foodDao.findAll().stream()
                .filter(offer -> offer.getType().equals(type))
                .collect(Collectors.toList());
    }

    @Override
    public List<Food> getListOfFoodByIds(List<String> idList) {
        return  idList
                .stream()
                .map(item->
                        foodDao.findById(item)
                                .orElseThrow(()->new RuntimeException("Id not found"+item)))
                .collect(Collectors.toList());
    }

}
