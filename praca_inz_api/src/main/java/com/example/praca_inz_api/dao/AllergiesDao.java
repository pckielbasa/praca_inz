package com.example.praca_inz_api.dao;

import com.example.praca_inz_api.model.Allergies;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AllergiesDao extends MongoRepository<Allergies, String> {
}
