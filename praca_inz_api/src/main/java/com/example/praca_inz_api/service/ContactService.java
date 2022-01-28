package com.example.praca_inz_api.service;

import com.example.praca_inz_api.dao.ContactDao;
import com.example.praca_inz_api.dto.ContactDTO;
import com.example.praca_inz_api.model.Contact;
import com.example.praca_inz_api.model.DaySchedule;
import com.example.praca_inz_api.model.Food;
import com.example.praca_inz_api.repository.ContactRepo;
import com.example.praca_inz_api.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ContactService implements ContactRepo {
    @Autowired
    private ContactDao contactDao;

    @Autowired
    private UserRepo userRepo;

    @Override
    public List<Contact> getAllContact(){
        return contactDao.findAll();
    }

    @Override
    public Collection<Contact> getAllType(String type) {
        return contactDao.findAll().stream()
                .filter(offer -> offer.getType().equals(type))
                .collect(Collectors.toList());
    }

    @Override
    public Contact getContactById(String contactId) {
        return contactDao.findById(contactId)
                .orElseThrow(()-> new IllegalStateException(
                        "Contact with "+contactId+"does not exists"));
    }

    @Override
    public String getContactId(String contactId) {
        return contactDao.findById(contactId).get().get_id();
    }

    @Override
    public List<Contact> getListOfContactsByIds(List<String> idList) {
        return idList
                .stream()
                .map(item->
                        contactDao.findById(item)
                                .orElseThrow(()->new RuntimeException("Id not found"+item)))
                .collect(Collectors.toList());
    }

    @Override
    public Contact createContact(ContactDTO contactDTO) {
        Contact contact = new Contact();
        contact.setUsername(contactDTO.getUsername());
        contact.setContactName(contactDTO.getContactName());
        contact.setComposition(contactDTO.getComposition());
        contact.setType(contactDTO.getType());
        return contactDao.save(contact);

    }

    @Override
    public Contact addContactToUser(ContactDTO contactDTO) {
        Contact contact = createContact(contactDTO);
        userRepo.addContactToList(contact,contactDTO.getUsername());
        return contact;

    }


}
