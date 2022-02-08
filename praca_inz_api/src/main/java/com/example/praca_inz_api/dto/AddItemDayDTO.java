package com.example.praca_inz_api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddItemDayDTO {
    private String dayDate;
    private String username;
    private String hour;
    private String minute;
    private List<String> listOfFoodId;
    private List<String> listOfContactId;
}
