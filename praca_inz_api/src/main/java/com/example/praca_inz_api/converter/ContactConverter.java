package com.example.praca_inz_api.converter;

import com.example.praca_inz_api.dto.AddContactDTO;
import com.example.praca_inz_api.dto.ContactListDTO;
import com.example.praca_inz_api.model.Contact;

public class ContactConverter {
    public static AddContactDTO toDTO(Contact entity){
        return new AddContactDTO(
                entity.getUsername(),
                entity.getContactName(),
                entity.getPossibleAllergen(),
                entity.getType(),
                entity.getFavourite()
        );
    }

    public static ContactListDTO toContactDTO(Contact entity){
        return new ContactListDTO(
                entity.get_id(),
                entity.getContactName(),
                entity.getPossibleAllergen(),
                entity.getType(),
                entity.getFavourite()
        );
    }
}
