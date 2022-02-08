package com.example.praca_inz_api.repository;

import com.example.praca_inz_api.dao.DayScheduleDao;
import com.example.praca_inz_api.dto.DayScheduleDTO;
import com.example.praca_inz_api.dto.ItemDayDTO;
import com.example.praca_inz_api.model.DaySchedule;
import com.example.praca_inz_api.model.ItemDaySchedule;
import com.example.praca_inz_api.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;


public interface DayScheduleRepo  {
    Collection<DaySchedule> getAllDays();
    DaySchedule getDayByDate(String dayDate);
    DaySchedule getDayScheduleById(String dayScheduleId);
    DaySchedule createDaySchedule(DayScheduleDTO dayScheduleDTO);
    DaySchedule addDayScheduleToUser(DayScheduleDTO dayScheduleDTO);
    DaySchedule addItemToDay (ItemDaySchedule itemDaySchedule, String dayDate);
    List<ItemDaySchedule> getMyItems(String date, String username);
}
