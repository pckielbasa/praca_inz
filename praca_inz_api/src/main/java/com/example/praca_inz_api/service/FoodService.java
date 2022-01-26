package com.example.praca_inz_api.service;

import com.example.praca_inz_api.dao.FoodDao;

import com.example.praca_inz_api.dto.FoodDTO;
import com.example.praca_inz_api.model.DaySchedule;
import com.example.praca_inz_api.model.Food;

import com.example.praca_inz_api.repository.FoodRepo;
import com.example.praca_inz_api.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FoodService implements FoodRepo {
    @Autowired
    private FoodDao foodDao;

    @Autowired
    private UserRepo userRepo;

    @Override
    public List<Food> getAllFood(){
        return foodDao.findAll();
    }

    @Override
    public Collection<Food> getAllType(String type) {
        return foodDao.findAll().stream()
                .filter(offer -> offer.getType().equals(type))
                .collect(Collectors.toList());
    }

    @Override
    public Food getFoodById(String foodId) {
        return foodDao.findById(foodId)
                .orElseThrow(() -> new IllegalStateException(
                        "Food with " + foodId + " does not exists."));
    }

    @Override
    public String getFoodId(String foodId) {
        return foodDao.findById(foodId).get().get_id();
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

    @Override
    public Food createFood(FoodDTO foodDTO) {
        
        Food food = new Food();
        food.setFoodName(foodDTO.getFoodName());
        food.setComposition(foodDTO.getComposition());
        food.setType(foodDTO.getType());
        food.setFavourite(foodDTO.getFavourite());
        return foodDao.save(food);
    }


    @Override
    public Food addFoodToUser(FoodDTO foodDTO) {
        Food food = createFood(foodDTO);
        userRepo.addFoodToList(food,foodDTO.getUsername());
        return food;
    }

}
