package com.example.praca_inz_api.converter;

import com.example.praca_inz_api.dto.AddContactDTO;
import com.example.praca_inz_api.dto.ContactDTO;
import com.example.praca_inz_api.model.Contact;

public class ContactConverter {
    public static AddContactDTO toDTO(Contact entity){
        return new AddContactDTO(
                entity.getContactName(),
                entity.getComposition(),
                entity.getType());
    }
}
