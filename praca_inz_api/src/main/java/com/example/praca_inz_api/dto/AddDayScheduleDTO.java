package com.example.praca_inz_api.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddDayScheduleDTO {

    private String dayDate;
    private List<String> listOfItemsId;
}
