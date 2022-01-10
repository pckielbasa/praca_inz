package com.example.praca_inz_api.dao;

import com.example.praca_inz_api.model.Contact;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ContactDao extends MongoRepository<Contact,String> {
}
