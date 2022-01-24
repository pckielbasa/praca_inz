package com.example.praca_inz_api.converter;

import com.example.praca_inz_api.dto.UserDTO;
import com.example.praca_inz_api.model.User;

public class UserConverter {
    public static UserDTO toDTO(User entity){
        return new UserDTO(
                entity.getUsername(),
                entity.getName(),
                entity.getEmail(),
                entity.getSurname(),
                entity.getPhoneNumber());
    }


}
