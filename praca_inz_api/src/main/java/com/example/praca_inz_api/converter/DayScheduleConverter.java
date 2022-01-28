package com.example.praca_inz_api.converter;

import com.example.praca_inz_api.dto.AddDayScheduleDTO;
import com.example.praca_inz_api.dto.DayScheduleDTO;
import com.example.praca_inz_api.model.DaySchedule;
import com.example.praca_inz_api.model.ItemDaySchedule;

import java.util.stream.Collectors;


public class DayScheduleConverter {
    public static AddDayScheduleDTO toDTO(DaySchedule entity){
        return new AddDayScheduleDTO(
                entity.getUsername(),
                entity.getDayDate(),
                entity.getDayScheduleIemList().stream().map(ItemDaySchedule::get_id).collect(Collectors.toList())
        );
    }

}
