package com.example.praca_inz_api.controller;

import com.example.praca_inz_api.converter.AllergiesConverter;
import com.example.praca_inz_api.converter.DayScheduleConverter;
import com.example.praca_inz_api.dto.*;
import com.example.praca_inz_api.repository.AllergiesRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/allergies")
@RequiredArgsConstructor
public class AllergiesController {
    @Autowired
    private AllergiesRepo allergiesRepo;

    @PostMapping(path = "/food")
    public AddFoodAllergiesDTO addFoodAllergiesToUser(@RequestBody FoodAllergiesDTO foodAllergiesDTO){
        return AllergiesConverter.toFoodDTO(allergiesRepo.addFoodAllergiesToUser(foodAllergiesDTO));
    }
    @PostMapping(path = "/contact")
    public AddContactAllergiesDTO addContactAllergiesToUser(@RequestBody ContactAllergiesDTO contactAllergiesDTO){
        return AllergiesConverter.toContactDTO(allergiesRepo.addContactAllergiesToUser(contactAllergiesDTO));
    }




}
