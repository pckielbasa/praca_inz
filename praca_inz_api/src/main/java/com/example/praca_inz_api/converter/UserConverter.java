package com.example.praca_inz_api.converter;

import com.example.praca_inz_api.dto.UserDTO;
import com.example.praca_inz_api.model.User;

public class UserConverter {
    public static UserDTO toDTO(User entity){
        return new UserDTO(
                entity.get_id(),
                entity.getUsername(),
                entity.getPassword(),
                entity.getEmail(),
                entity.getPhoneNumber());
    }


}
