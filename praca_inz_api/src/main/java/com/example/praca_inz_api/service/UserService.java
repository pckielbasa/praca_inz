package com.example.praca_inz_api.service;

import com.example.praca_inz_api.dao.UserDao;
import com.example.praca_inz_api.dto.RegisterUserDTO;
import com.example.praca_inz_api.model.*;

import com.example.praca_inz_api.repository.UserRepo;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

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
    public User addScheduleToList(DaySchedule daySchedule, String username) {
        User user = getUserByUsername(username);
        user.getDayScheduleList().add(daySchedule);
        return userDao.save(user);
    }

    @Override
    public User addFoodToList(Food food, String username) {
        User user = getUserByUsername(username);
        user.getMyFood().add(food);
        return userDao.save(user);
    }

    @Override
    public User addContactToList(Contact contact, String username) {
        User user = getUserByUsername(username);
        user.getMyContact().add(contact);
        return userDao.save(user);
    }

    @Override
    public User addAllergiesToList(Allergies allergies, String username) {
        User user = getUserByUsername(username);
        user.getMyAllergies().add(allergies);
        return userDao.save(user);
    }

    @Override
    public List<Food> getMyFoodList(String type, String username) {
        return getUserByUsername(username)
                .getMyFood()
                .stream()
                .filter(food -> food.getType().equals(type)).collect(Collectors.toList());
    }

    @Override
    public List<Contact> getMyContactList(String type, String username) {
        return getUserByUsername(username)
                .getMyContact()
                .stream()
                .filter(contact -> contact.getType().equals(type)).collect(Collectors.toList());
    }

    @Override
    public User deleteFoodFromUser(User user, Food food){

        List<Food> myFood =user.getMyFood();
        Food deleteFood = myFood.stream().filter(item -> item.get_id().equals(food.get_id()))
                .findFirst()
                .orElseThrow(()-> new ResourceNotFoundException("no food with id: "+ food.get_id()));
        myFood.remove(deleteFood);
        user.setMyFood(myFood);
        return user;
    }


}
