package com.example.praca_inz_api.repository;

import com.example.praca_inz_api.model.Person;

import java.util.Collection;

public interface PersonRepo {
    Collection<Person> getAllPersons();
    Person addPerson(Person person);
}
