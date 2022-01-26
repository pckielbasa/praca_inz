package com.example.praca_inz_api.repository;

import com.example.praca_inz_api.dao.DayScheduleDao;
import com.example.praca_inz_api.dto.DayScheduleDTO;
import com.example.praca_inz_api.dto.ItemDayDTO;
import com.example.praca_inz_api.model.DaySchedule;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


public interface DayScheduleRepo  {
    DaySchedule getDayScheduleById(String dayScheduleId);
    DaySchedule createDaySchedule(DayScheduleDTO dayScheduleDTO);
    DaySchedule addDayScheduleToUser(DayScheduleDTO dayScheduleDTO);


}
