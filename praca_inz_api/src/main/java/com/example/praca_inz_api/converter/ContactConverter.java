package com.example.praca_inz_api.converter;

import com.example.praca_inz_api.dto.AddContactDTO;
import com.example.praca_inz_api.dto.ContactListDTO;
import com.example.praca_inz_api.model.Contact;
import com.example.praca_inz_api.model.Food;

public class ContactConverter {
    public static AddContactDTO toDTO(Contact entity){
        return new AddContactDTO(
                entity.getContactName(),
                entity.getComposition(),
                entity.getType(),
                entity.getFavourite(),
                entity.getAllergy()
        );
    }

    public static ContactListDTO toContactDTO(Contact entity){
        return new ContactListDTO(
                entity.getContactName(),
                entity.getComposition(),
                entity.getType(),
                entity.getFavourite(),
                entity.getAllergy()
        );
    }
}
