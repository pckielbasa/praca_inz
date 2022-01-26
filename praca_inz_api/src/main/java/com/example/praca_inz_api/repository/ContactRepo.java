package com.example.praca_inz_api.repository;

import com.example.praca_inz_api.dto.ContactDTO;
import com.example.praca_inz_api.model.Contact;
import com.example.praca_inz_api.model.Food;

import java.util.Collection;
import java.util.List;

public interface ContactRepo {
    Collection<Contact> getAllContact();
    Collection<Contact> getAllType(String type);
    Contact getContactById(String contactId);
    String getContactId(String contactId);
    List<Contact> getListOfContactsByIds(List<String> idList);
    Contact createContact(ContactDTO contactDTO);
    Contact addContactToUser(ContactDTO contactDTO);
}
