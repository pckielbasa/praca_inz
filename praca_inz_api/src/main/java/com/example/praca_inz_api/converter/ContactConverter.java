package com.example.praca_inz_api.converter;

import com.example.praca_inz_api.dto.ContactDTO;
import com.example.praca_inz_api.model.Contact;

public class ContactConverter {
    public static ContactDTO toDTO(Contact entity){
        return new ContactDTO(
                entity.getContactName(),
                entity.getComposition(),
                entity.getType());
    }
}
