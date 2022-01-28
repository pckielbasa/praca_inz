package com.example.praca_inz_api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ItemDayDTO {

    private String username;
    private Integer hour;
    private Integer minute;
    private List<String> listOfFoodId;
    private List<String> listOfContactId;

}
