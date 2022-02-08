package com.example.praca_inz_api.service;

import com.example.praca_inz_api.dao.FoodDao;

import com.example.praca_inz_api.dao.ItemDayDao;
import com.example.praca_inz_api.dao.UserDao;
import com.example.praca_inz_api.dto.FoodDTO;
import com.example.praca_inz_api.dto.FoodListDTO;
import com.example.praca_inz_api.model.Food;

import com.example.praca_inz_api.model.ItemDaySchedule;
import com.example.praca_inz_api.model.User;
import com.example.praca_inz_api.repository.FoodRepo;
import com.example.praca_inz_api.repository.ItemDayRepo;
import com.example.praca_inz_api.repository.UserRepo;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class FoodService implements FoodRepo {
    @Autowired
    private FoodDao foodDao;

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private UserDao userDao;



    @Override
    public List<Food> getAllFood(){
        return foodDao.findAll();
    }

    @Override
    public Collection<Food> getAllType(String type) {
        return foodDao.findAll().stream()
                .filter(food -> food.getType().equals(type))
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
//            Food food1 = foodDao.findByFoodName(foodDTO.getFoodName());
            List<Food> myList = userRepo.getMyFoodList(foodDTO.getType(), foodDTO.getUsername());
            food.setFoodName(foodDTO.getFoodName());
            food.setComposition(foodDTO.getComposition());
            food.setType(foodDTO.getType());
            food.setFavourite(foodDTO.getFavourite());
            food.setAllergy(foodDTO.getAllergy());
            boolean anyMatch = myList.stream().anyMatch(item -> item.getFoodName().equals(food.getFoodName()));
            if (anyMatch){
                return null;
            }
            return foodDao.save(food);
    }


    @Override
    public Food addFoodToUser(FoodDTO foodDTO) {
        Food food = createFood(foodDTO);
        if(food ==null){
            return null;
        }
        userRepo.addFoodToList(food,foodDTO.getUsername());
        return food;
    }



    @Override
    public String findByFoodName(String foodName) {
        return foodDao.findByFoodName(foodName).getFoodName();
    }

    @Override
    public void deleteFoodById(String foodId, String username) {
        Food food = foodDao.findBy_id(foodId);
        User user = userRepo.getUserByUsername(username);
        user = userRepo.deleteFoodFromUser(user, food);
        userDao.save(user);
        foodDao.delete(food);
    }




}
