package com.example.praca_inz_api.repository;

import com.example.praca_inz_api.dto.RegisterUserDTO;
import com.example.praca_inz_api.model.*;

import java.util.Collection;

public interface UserRepo {
    Collection<User> getAllUsers();
    User addUser(User user);
    User getUserByEmail(String email);
    User registerUser(RegisterUserDTO user);
    User getUserByUsername(String username);
    User addScheduleToList(DaySchedule daySchedule, String username);
    User addFoodToList (Food food, String username);
    User addContactToList (Contact contact, String username);
    User addAllergiesToList(Allergies allergies, String username);

}
