package com.example.praca_inz_api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MealDTO {

    private String mealName;
    private String commentAlertAllergies;
    private String type = "meal";
    private Boolean favourite;
}
