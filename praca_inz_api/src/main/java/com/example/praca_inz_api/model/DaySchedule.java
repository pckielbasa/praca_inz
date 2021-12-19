package com.example.praca_inz_api.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "DaySchedule")
public class DaySchedule {
    @Id
    private String _id;
    private Integer year;
    private Integer month;
    private Integer numberOfDay;

    @DBRef
    private List<ItemDaySchedule> dayScheduleIem = new ArrayList<>();


}
