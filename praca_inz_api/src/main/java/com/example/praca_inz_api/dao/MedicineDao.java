package com.example.praca_inz_api.dao;

import com.example.praca_inz_api.model.Medicine;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MedicineDao extends MongoRepository<Medicine, String> {
}
