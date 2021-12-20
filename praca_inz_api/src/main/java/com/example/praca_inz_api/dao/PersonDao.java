package com.example.praca_inz_api.dao;

import com.example.praca_inz_api.model.Person;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PersonDao extends MongoRepository<Person, String> {
}
