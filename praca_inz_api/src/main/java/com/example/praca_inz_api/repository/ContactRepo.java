package com.example.praca_inz_api.repository;

import com.example.praca_inz_api.dto.ContactDTO;
import com.example.praca_inz_api.model.Contact;

import java.util.Collection;
import java.util.List;

public interface ContactRepo {
    Collection<Contact> getAllType(String type);
    Contact getContactById(String contactId);
    Contact createContact(ContactDTO contactDTO);
    Contact addContactToUser(ContactDTO contactDTO);
    void deleteContactById(String contactId, String username );
}
