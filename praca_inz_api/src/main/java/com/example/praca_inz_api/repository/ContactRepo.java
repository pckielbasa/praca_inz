package com.example.praca_inz_api.repository;

import com.example.praca_inz_api.model.Contact;
import com.example.praca_inz_api.model.Food;

import java.util.Collection;
import java.util.List;

public interface ContactRepo {
    Collection<Contact> getAllContact();
    Contact addContact(Contact contact);
    Collection<Contact> getAllType(String type);

    List<Contact> getListOfContactsByIds(List<String> idList);
}
