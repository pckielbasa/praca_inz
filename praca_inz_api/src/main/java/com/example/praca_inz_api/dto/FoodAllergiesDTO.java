package com.example.praca_inz_api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FoodAllergiesDTO {
    private String username;
    private String allergyName;
    private String type;
    private String comment;
    private List<String> listOfFoodId;

}
