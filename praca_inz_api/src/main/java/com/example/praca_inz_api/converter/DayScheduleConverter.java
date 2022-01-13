package com.example.praca_inz_api.converter;

import com.example.praca_inz_api.dto.DayScheduleDTO;


public class DayScheduleConverter {
    public static DayScheduleDTO toDTO(DayScheduleDTO entity){
        return new DayScheduleDTO(
                entity.getId(),
                entity.getDayDate(),
                entity.getDayScheduleIemList()
        );
    }
}
