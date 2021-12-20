package com.example.praca_inz_api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ComponentDTO {
    private String componentName;
    private String commentAlertAllergies;
    private String type = "component";
    private Boolean favourite;
}
