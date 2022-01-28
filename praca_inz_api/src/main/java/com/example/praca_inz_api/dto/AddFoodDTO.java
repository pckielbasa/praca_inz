package com.example.praca_inz_api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddFoodDTO {
    private String username;
    private String foodName;
    private String composition;
    private String type;
    private Boolean favourite;
}
