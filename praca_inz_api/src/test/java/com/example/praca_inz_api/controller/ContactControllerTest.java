package com.example.praca_inz_api.controller;

import com.example.praca_inz_api.converter.ContactConverter;
import com.example.praca_inz_api.dto.ContactDTO;
import com.example.praca_inz_api.model.Contact;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

class ContactControllerTest {

    @Test
    void addContactToUser() {
        ContactController contactController = mock(ContactController.class);
        Contact contact = new Contact(
                "6208299a5adf15753a523f34",
                "620733937afc0720579330ae",
                "Animal Test",
                "Allergen test",
                "Animal",
                false
        );

        given(contactController.addContactToUser(Mockito.any(ContactDTO.class)))
                .willReturn(ResponseEntity.ok().body(ContactConverter.toDTO(contact)));
        Assertions.assertEquals(contact.getType(), "Animal" );
    }
}