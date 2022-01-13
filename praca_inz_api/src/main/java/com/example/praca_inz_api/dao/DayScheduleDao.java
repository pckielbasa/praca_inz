package com.example.praca_inz_api.dao;

import com.example.praca_inz_api.model.DaySchedule;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DayScheduleDao extends MongoRepository<DaySchedule,String> {
}
