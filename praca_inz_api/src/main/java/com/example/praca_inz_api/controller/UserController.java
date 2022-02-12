package com.example.praca_inz_api.controller;

import com.example.praca_inz_api.converter.*;
import com.example.praca_inz_api.dao.UserDao;
import com.example.praca_inz_api.dto.*;
import com.example.praca_inz_api.model.ItemDaySchedule;
import com.example.praca_inz_api.model.User;
import com.example.praca_inz_api.repository.DayScheduleRepo;
import com.example.praca_inz_api.repository.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    @Autowired
    private UserRepo userRepo;

    @Autowired
    private UserDao userDao;

    @Autowired
    private DayScheduleRepo dayScheduleRepo;

    @GetMapping("/all")
    public List<User> getAllUsers(){
        return new ArrayList<>(userRepo.getAllUsers());
    }

    @GetMapping("/email")
    public UserDTO getUserByEmail(@RequestParam(value = "email") String email){
        return UserConverter.toDTO(userRepo.getUserByEmail(email));
    }

    @GetMapping("/username")
    public UserDTO getUserByUsername(@RequestParam(value = "username") String username){
        return UserConverter.toDTO(userRepo.getUserByUsername(username));
    }

    @GetMapping("/finbyname")
    public User getUserBYName(@RequestParam(value = "name") String name){
        return userDao.findByName(name);
    }

    @GetMapping("/myfood")
    public List<FoodListDTO> getMyFoodList(@RequestParam(value = "type") String type,
                                           @RequestParam(value = "username") String username){
        return userRepo.getMyFoodList(type, username).stream().map(FoodConverter::toFoodDTO).collect(Collectors.toList());
    }

    @GetMapping("/mycontact")
    public List<ContactListDTO> getMyContactList(@RequestParam(value = "type") String type,
                                              @RequestParam(value = "username") String username){
        return userRepo.getMyContactList(type, username).stream().map(ContactConverter::toContactDTO).collect(Collectors.toList());
    }

    @GetMapping("/myallergies")
    public List<AllergiesListDTO> getMyAllergiesList(@RequestParam(value = "type") String type,
                                                 @RequestParam(value = "username") String username){
        return userRepo.getMyAllergiesList(type, username).stream().map(AllergiesConverter::toListDTO).collect(Collectors.toList());
    }


    @GetMapping("/myday")
    public List<ItemsListDTO> getMyDay(@RequestParam(value = "date") String date,
                                                 @RequestParam(value = "username") String username){
        List<ItemDaySchedule> daySchedule = dayScheduleRepo.getDaySchedule(username, date);
        if (daySchedule == null){
            return null;
        }
        return dayScheduleRepo.getDaySchedule(username, date).stream().map(ItemDayConverter::toListDTO).collect(Collectors.toList());
    }


    @PostMapping("/register")
    public ResponseEntity<UserDTO> registerUser(@RequestBody RegisterUserDTO registerUserDTO){
        User user = userRepo.registerUser(registerUserDTO);

        if(user != null)
            return ResponseEntity.ok(UserConverter.toDTO(user));

        return ResponseEntity.status(BAD_REQUEST).body(null);
    }

    @PostMapping
    public UserDTO addUser(@RequestBody User user){

        return UserConverter.toDTO(userRepo.addUser(user));
    }

}
