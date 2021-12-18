package com.example.praca_inz_api.dao;

import com.example.praca_inz_api.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserDao  extends MongoRepository<User,String> {
}
