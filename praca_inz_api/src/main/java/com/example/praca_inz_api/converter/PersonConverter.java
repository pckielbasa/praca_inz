package com.example.praca_inz_api.converter;

import com.example.praca_inz_api.dto.PersonDTO;
import com.example.praca_inz_api.model.Person;

public class PersonConverter {
    public static PersonDTO toDTO(Person entity){
        return new PersonDTO(
                entity.getPersonName(),
                entity.getPersonSurname(),
                entity.getDateOfBirth(),
                entity.getImgURL()
        );
    }
}
