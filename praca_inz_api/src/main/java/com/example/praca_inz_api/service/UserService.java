package com.example.praca_inz_api.service;

import com.example.praca_inz_api.dao.UserDao;
import com.example.praca_inz_api.dto.RegisterUserDTO;
import com.example.praca_inz_api.model.DaySchedule;
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
    public User getUserByEmail(String email) {
        return userDao.findUserByEmail(email);
    }

    public User getUserById(String userId) {
        return userDao.findById(userId).
                orElseThrow(() -> new IllegalStateException(
                        "Tourist with "+userId+" id does not exists."));
    }

    @Override
    public User registerUser(RegisterUserDTO user){

        if(user != null
                && user.getUsername() != null
                && !user.getUsername().isEmpty()
                && user.getSurname() != null
                && !user.getSurname().isEmpty()
                && user.getEmail() != null
                && !user.getEmail().isEmpty()
                && user.getName() != null
                && !user.getName().isEmpty()) {
            if(userDao.findUserByEmail(user.getEmail()) != null)
                return null;

            User newUser = new User();
            newUser.setUsername(user.getUsername());
            newUser.setEmail(user.getEmail());
            newUser.setName(user.getName());
            newUser.setSurname(user.getSurname());
            newUser.setPhoneNumber(user.getPhoneNumber());

            return userDao.save(newUser);
        }

        return null;
    }

    @Override
    public User getUserByUsername(String username) {
        return userDao.findUserByUsername(username);
    }

    @Override
    public User addScheduleToList(DaySchedule daySchedule, String username) {
        User user = getUserByUsername(username);
        user.getDayScheduleList().add(daySchedule);
        return userDao.save(user);
    }

}
