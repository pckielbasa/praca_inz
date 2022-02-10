package com.example.praca_inz_api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AllergiesListDTO {
    private String type;
    private String allergenName;
    private String allergiesName;
    private String afterTime;
    private String symptoms;
    private String help;
}
