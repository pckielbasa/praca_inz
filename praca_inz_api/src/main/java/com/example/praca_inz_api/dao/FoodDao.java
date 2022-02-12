package com.example.praca_inz_api.dao;

import com.example.praca_inz_api.model.Food;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FoodDao extends MongoRepository<Food,String> {
    Food findByFoodName(String foodName);
    Food findBy_id(String foodId);

}
