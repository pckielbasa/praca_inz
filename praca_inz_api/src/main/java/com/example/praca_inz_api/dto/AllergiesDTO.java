package com.example.praca_inz_api.dto;

import com.example.praca_inz_api.model.Contact;
import com.example.praca_inz_api.model.Food;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AllergiesDTO {
    private String nameAllergy;
    private Food food;
    private Contact contact;
}
