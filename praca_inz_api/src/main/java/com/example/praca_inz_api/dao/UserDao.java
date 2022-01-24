package com.example.praca_inz_api.dao;

import com.example.praca_inz_api.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao  extends MongoRepository<User,String> {
    User findUserByEmail(String email);
}
