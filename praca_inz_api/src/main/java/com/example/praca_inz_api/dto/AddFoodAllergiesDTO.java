package com.example.praca_inz_api.dto;

import com.example.praca_inz_api.model.Food;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.DBRef;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddFoodAllergiesDTO {
    private String username;
    private String allergyName;
    private String type;
    private String comment;
    private List<String> listOfFoodId;
}
