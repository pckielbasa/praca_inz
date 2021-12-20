package com.example.praca_inz_api.controller;

import com.example.praca_inz_api.converter.UserConverter;
import com.example.praca_inz_api.dto.UserDTO;
import com.example.praca_inz_api.model.User;
import com.example.praca_inz_api.repository.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    @Autowired
    private UserRepo userRepo;

    @GetMapping("/all")
    public List<UserDTO> getAllUsers(){
        return userRepo.getAllUsers().stream().map(UserConverter::toDTO).collect(Collectors.toList());
    }

    @PostMapping
    public UserDTO addUser(@RequestBody User user){

        return UserConverter.toDTO(userRepo.addUser(user));
    }

}
