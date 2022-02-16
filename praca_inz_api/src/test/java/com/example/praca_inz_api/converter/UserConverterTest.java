package com.example.praca_inz_api.converter;

import com.example.praca_inz_api.dto.RegisterUserDTO;
import com.example.praca_inz_api.dto.UserDTO;
import com.example.praca_inz_api.model.User;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserConverterTest {

    @Test
    public void toDTO() {
        User user =new  User();
        user.setUsername("fae0g4509ns897f8234");

        UserDTO userDTO = UserConverter.toDTO(user);

        Assert.assertEquals(userDTO.getUsername(), user.getUsername());
    }

    @Test
    public void registerToDTO() {
        User user =new  User();
        user.setUsername("fae0g4509ns897f8234");

        RegisterUserDTO registerUserDTO = new RegisterUserDTO();
        registerUserDTO.setUsername("fae0g4509ns897f8234");

        Assert.assertEquals(registerUserDTO.getUsername(), user.getUsername());
    }
}