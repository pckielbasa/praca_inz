package com.example.praca_inz_api.converter;

import com.example.praca_inz_api.dto.AddContactAllergiesDTO;
import com.example.praca_inz_api.dto.AddFoodAllergiesDTO;
import com.example.praca_inz_api.model.Allergies;
import com.example.praca_inz_api.model.Contact;
import com.example.praca_inz_api.model.Food;

import java.util.stream.Collectors;


public class AllergiesConverter {
    public static AddFoodAllergiesDTO toFoodDTO(Allergies entity){
        return new AddFoodAllergiesDTO(
              entity.getAllergyName(),
                entity.getType(),
                entity.getComment(),
                entity.getFoodIdList().stream().map(Food::get_id).collect(Collectors.toList())
        );
    }
    public static AddContactAllergiesDTO toContactDTO(Allergies entity){
        return new AddContactAllergiesDTO(
                entity.getAllergyName(),
                entity.getType(),
                entity.getComment(),
                entity.getContactIdList().stream().map(Contact::get_id).collect(Collectors.toList())
        );
    }

}
