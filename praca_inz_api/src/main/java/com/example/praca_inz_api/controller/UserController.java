package com.example.praca_inz_api.controller;

import com.example.praca_inz_api.converter.UserConverter;
import com.example.praca_inz_api.dto.RegisterUserDTO;
import com.example.praca_inz_api.dto.UserDTO;
import com.example.praca_inz_api.model.User;
import com.example.praca_inz_api.repository.UserRepo;
import com.example.praca_inz_api.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

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

    @GetMapping("/email")
    public User getUserByEmail(@RequestParam(value = "email") String email){
        return userRepo.getUserByEmail(email);
    }

    @GetMapping("")
    public User getUserByUsername(@RequestParam(value = "username") String username){
        return userRepo.getUserByUsername(username);
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
