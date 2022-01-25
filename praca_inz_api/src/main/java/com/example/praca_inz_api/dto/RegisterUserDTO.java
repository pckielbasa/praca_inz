package com.example.praca_inz_api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.index.Indexed;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegisterUserDTO {

    private String username;
    private String email;
    private String name;
    private String surname;
    private String phoneNumber;
}
