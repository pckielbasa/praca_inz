package com.example.praca_inz_api.dao;

import com.example.praca_inz_api.model.ItemDaySchedule;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ItemDayDao extends MongoRepository<ItemDaySchedule, String> {
}
