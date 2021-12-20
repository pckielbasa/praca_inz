package com.example.praca_inz_api.dao;

import com.example.praca_inz_api.model.Component;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ComponentDao extends MongoRepository<Component, String> {
}
