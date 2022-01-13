package com.example.praca_inz_api.service;

import com.example.praca_inz_api.dao.UserDao;
import com.example.praca_inz_api.dto.RegisterUserDTO;
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

    public User getUserById(String userId) {
        return userDao.findById(userId).
                orElseThrow(() -> new IllegalStateException(
                        "Tourist with "+userId+" id does not exists."));
    }

    @Override
    public User registerUser(RegisterUserDTO user){

        if(user != null && user.getUsername() != null && !user.getUsername().isEmpty() && user.getEmail() != null && !user.getEmail().isEmpty() && user.getPassword() != null && !user.getPassword().isEmpty()) {
            if(userDao.findUserByUsername(user.getUsername()) != null)
                return null;

            User newUser = new User();
            newUser.setUsername(user.getUsername());
            newUser.setEmail(user.getEmail());
            newUser.setPassword(user.getPassword());
            newUser.setPhoneNumber(user.getPhoneNumber());

            return userDao.save(newUser);
        }

        return null;
    }

}
