package com.example.praca_inz_api.service;

import com.example.praca_inz_api.dao.UserDao;
import com.example.praca_inz_api.model.User;

import com.example.praca_inz_api.repository.UserRepo;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements UserRepo {
    @Autowired
    private UserDao userDao;

    @Override
    public User addUser(User user){
        return userDao.save(user);
    }

    @Override
    public List<User> getAllUsers(){
        return userDao.findAll();
    }

    @Override
    public User getUserByUsername(String username) {
        return userDao.findUserByUsername(username);
    }




}
