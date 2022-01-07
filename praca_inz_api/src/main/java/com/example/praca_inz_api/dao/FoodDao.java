package com.example.praca_inz_api.dao;

import com.example.praca_inz_api.model.Food;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface FoodDao extends MongoRepository<Food,String> {
}
