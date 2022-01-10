package com.example.praca_inz_api.repository;

import com.example.praca_inz_api.model.User;

import java.util.Collection;

public interface UserRepo {
    Collection<User> getAllUsers();
    User addUser(User user);
    User getUserByUsername(String username);

}
