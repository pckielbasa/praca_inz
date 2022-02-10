package com.example.praca_inz_api.repository;

import com.example.praca_inz_api.dto.DayScheduleDTO;
import com.example.praca_inz_api.model.DaySchedule;
import com.example.praca_inz_api.model.ItemDaySchedule;

import java.util.Collection;
import java.util.List;


public interface DayScheduleRepo  {
    Collection<DaySchedule> getAllDays();
    DaySchedule getDayByDate(String dayDate);
    DaySchedule getDayScheduleById(String dayScheduleId);
    DaySchedule createDaySchedule(DayScheduleDTO dayScheduleDTO);
    DaySchedule addDayScheduleToUser(DayScheduleDTO dayScheduleDTO);
    List<ItemDaySchedule> getDaySchedule(String username, String date);
    DaySchedule addItemToDay(ItemDaySchedule itemDaySchedule, String date);
}
