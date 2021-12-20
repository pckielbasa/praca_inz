package com.example.praca_inz_api.dao;

import com.example.praca_inz_api.model.Snack;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SnackDao extends MongoRepository<Snack, String> {
}
