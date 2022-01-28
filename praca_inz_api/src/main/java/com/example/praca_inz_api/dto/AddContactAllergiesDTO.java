package com.example.praca_inz_api.dto;

import com.example.praca_inz_api.model.Contact;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddContactAllergiesDTO {
    private String username;
    private String allergyName;
    private String type;
    private String comment;
    private List<String> listOfContactId;
}
