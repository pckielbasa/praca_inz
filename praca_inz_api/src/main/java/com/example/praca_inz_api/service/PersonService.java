package com.example.praca_inz_api.service;

import com.example.praca_inz_api.dao.PersonDao;
import com.example.praca_inz_api.model.Person;
import com.example.praca_inz_api.repository.PersonRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class PersonService implements PersonRepo {

    @Autowired
    private PersonDao personDao;

    @Override
    public Collection<Person> getAllPersons() {
        return personDao.findAll();
    }

    @Override
    public Person addPerson(Person person) {
        return personDao.save(person);
    }
}
