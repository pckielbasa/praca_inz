package com.example.praca_inz_api.service;

import com.example.praca_inz_api.dao.ContactDao;
import com.example.praca_inz_api.model.Contact;
import com.example.praca_inz_api.model.Food;
import com.example.praca_inz_api.repository.ContactRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

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

    @Override
    public Collection<Contact> getAllType(String type) {
        return contactDao.findAll().stream()
                .filter(offer -> offer.getType().equals(type))
                .collect(Collectors.toList());
    }
}
