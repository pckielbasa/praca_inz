package com.example.praca_inz_api.converter;

import com.example.praca_inz_api.dto.DayScheduleDTO;
import com.example.praca_inz_api.model.DaySchedule;
import com.example.praca_inz_api.model.ItemDaySchedule;

import java.util.stream.Collectors;


public class DayScheduleConverter {
    public static DayScheduleDTO toDTO(DaySchedule entity){
        return new DayScheduleDTO(
                entity.getDayDate(),
                entity.getDayScheduleIemList().stream().map(ItemDaySchedule::get_id).collect(Collectors.toList())
        );
    }
}
