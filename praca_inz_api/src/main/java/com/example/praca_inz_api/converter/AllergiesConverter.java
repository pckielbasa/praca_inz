package com.example.praca_inz_api.converter;

import com.example.praca_inz_api.dto.AllergiesContactDTO;
import com.example.praca_inz_api.dto.AllergiesDTO;
import com.example.praca_inz_api.dto.AllergiesFoodDTO;
import com.example.praca_inz_api.model.Allergies;


public class AllergiesConverter {
    public static AllergiesDTO toDTO(Allergies entity){
        return new AllergiesDTO(
                entity.getNameAllergy(),
                entity.getComment(),
                entity.getFoodId(),
                entity.getContactId()
        );
    }
    public static AllergiesFoodDTO toFoodDTO(Allergies entity){
        return new AllergiesFoodDTO(
                entity.getNameAllergy(),
                entity.getComment(),
                entity.getFoodId()
        );
    }
    public static AllergiesContactDTO toContactDTO(Allergies entity){
        return new AllergiesContactDTO(
                entity.getNameAllergy(),
                entity.getComment(),
                entity.getContactId()
        );
    }
}
