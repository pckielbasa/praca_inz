package com.example.praca_inz_api.converter;

import com.example.praca_inz_api.dto.ContactDTO;
import com.example.praca_inz_api.dto.MealDTO;
import com.example.praca_inz_api.model.Contact;
import com.example.praca_inz_api.model.Meal;

public class ContactConverter {
    public static ContactDTO toDTO(Contact entity){
        return new ContactDTO(
                entity.getContactName(),
                entity.getComposition(),
                entity.getCommentAlertAllergies(),
                entity.getType(),
                entity.getAllergy());
    }
}
