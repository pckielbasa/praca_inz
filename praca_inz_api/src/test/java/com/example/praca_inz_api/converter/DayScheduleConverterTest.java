package com.example.praca_inz_api.converter;

import com.example.praca_inz_api.dto.AddDayScheduleDTO;
import com.example.praca_inz_api.dto.DayScheduleDTO;
import com.example.praca_inz_api.model.DaySchedule;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class DayScheduleConverterTest {

    @Test
    public void toDTO() {
        DaySchedule daySchedule =  new DaySchedule();
        daySchedule.setDayDate("test date");

        AddDayScheduleDTO addDayScheduleDTO = DayScheduleConverter.toDTO(daySchedule);

        Assert.assertEquals(addDayScheduleDTO.getDayDate(), daySchedule.getDayDate());
    }

    @Test
    public void dayToDTO() {
        DaySchedule daySchedule =  new DaySchedule();
        daySchedule.setDayDate("test date");

        DayScheduleDTO dayScheduleDTO =  new DayScheduleDTO();
        dayScheduleDTO.setDayDate("test date");

        Assert.assertEquals(dayScheduleDTO.getDayDate(), daySchedule.getDayDate());
    }

}