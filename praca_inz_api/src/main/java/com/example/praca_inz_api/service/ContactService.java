package com.example.praca_inz_api.service;

import com.example.praca_inz_api.dao.ContactDao;
import com.example.praca_inz_api.dao.MealDao;
import com.example.praca_inz_api.model.Contact;
import com.example.praca_inz_api.model.Meal;
import com.example.praca_inz_api.repository.ContactRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactService implements ContactRepo {
    @Autowired
    private ContactDao contactDao;


    @Override
    public List<Contact> getAllContact(){
        return contactDao.findAll();
    }

    @Override
    public Contact addContact(Contact contact) {
        return contactDao.save(contact);
    }
}
