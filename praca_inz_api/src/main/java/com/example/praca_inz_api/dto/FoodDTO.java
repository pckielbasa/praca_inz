package com.example.praca_inz_api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FoodDTO {
    private String foodName;
    private String composition;
    private String commentAlertAllergies;
    private String type;
    private Boolean favourite;
    private Boolean allergy;
}
