package com.example.praca_inz_api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class PersonDTO {

    private String personName;
    private String personSurname;
    private String dateOfBirth;
    private String imgURL;
}
