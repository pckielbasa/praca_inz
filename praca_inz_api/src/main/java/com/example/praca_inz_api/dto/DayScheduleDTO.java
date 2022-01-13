package com.example.praca_inz_api.dto;

import com.example.praca_inz_api.model.ItemDaySchedule;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DayScheduleDTO {
    private String id;
    private String dayDate;
    private List<ItemDaySchedule> dayScheduleIemList;
}
