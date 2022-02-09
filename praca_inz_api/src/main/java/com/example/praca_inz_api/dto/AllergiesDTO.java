package com.example.praca_inz_api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AllergiesDTO {
    private String username;
    private String allergenId;
    private String type;
    private String allergenName;
    private String allergiesName;
    private String afterTime;
    private String symptoms;
    private String help;
}
