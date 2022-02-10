package com.example.praca_inz_api.converter;

import com.example.praca_inz_api.dto.AddDayScheduleDTO;
import com.example.praca_inz_api.model.DaySchedule;


public class DayScheduleConverter {
    public static AddDayScheduleDTO toDTO(DaySchedule entity){
        return new AddDayScheduleDTO(
                entity.getUsername(),
                entity.getDayDate()
        );
    }

}
