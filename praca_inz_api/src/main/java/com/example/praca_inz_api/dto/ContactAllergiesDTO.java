package com.example.praca_inz_api.dto;

import com.example.praca_inz_api.model.Contact;
import com.example.praca_inz_api.model.Food;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ContactAllergiesDTO {
    private String username;
    private String allergyName;
    private String type;
    private String comment;
    private List<String> listOfContactId;

}

