package com.example.praca_inz_api.dao;

import com.example.praca_inz_api.model.ItemDaySchedule;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemDayDao extends MongoRepository<ItemDaySchedule, String> {
    ItemDaySchedule findItemDayScheduleByUsername(String username);
    ItemDaySchedule findBy_id(String itemId);
}
