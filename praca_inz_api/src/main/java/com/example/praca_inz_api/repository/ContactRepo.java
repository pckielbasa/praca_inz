package com.example.praca_inz_api.repository;

import com.example.praca_inz_api.model.Contact;
import com.example.praca_inz_api.model.Meal;

import java.util.Collection;

public interface ContactRepo {
    Collection<Contact> getAllContact();
    Contact addContact(Contact contact);
}
