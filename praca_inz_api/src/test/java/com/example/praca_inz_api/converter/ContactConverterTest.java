package com.example.praca_inz_api.converter;

import com.example.praca_inz_api.dto.AddContactDTO;
import com.example.praca_inz_api.dto.ContactDTO;
import com.example.praca_inz_api.dto.ContactListDTO;
import com.example.praca_inz_api.model.Contact;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class ContactConverterTest {

    @Test
    public void toContactDTO() {
        Contact contact = new Contact();
        contact.setContactName("Test");

        ContactListDTO contactListDTO = ContactConverter.toContactDTO(contact);

        Assert.assertEquals(contactListDTO.getContactName(), contact.getContactName());
    }

    @Test
    public void toDTO() {
        Contact contact = new Contact();
        contact.setContactName("Test");

        AddContactDTO addContactDTO = ContactConverter.toDTO(contact);

        Assert.assertEquals(addContactDTO.getContactName(), contact.getContactName());
    }

    @Test
    public void contactToDTO() {
        Contact contact = new Contact();
        contact.setContactName("Test");

        ContactDTO contactDTO = new ContactDTO();
        contactDTO.setContactName("Test");

        Assert.assertEquals(contactDTO.getContactName(), contact.getContactName());
    }
}