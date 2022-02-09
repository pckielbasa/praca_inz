package com.example.praca_inz_api.controller;

import com.example.praca_inz_api.converter.AllergiesConverter;
import com.example.praca_inz_api.converter.FoodConverter;
import com.example.praca_inz_api.dto.AddAllergiesDTO;
import com.example.praca_inz_api.dto.AddFoodDTO;
import com.example.praca_inz_api.dto.AllergiesDTO;
import com.example.praca_inz_api.dto.FoodDTO;
import com.example.praca_inz_api.model.Allergies;
import com.example.praca_inz_api.model.Food;
import com.example.praca_inz_api.repository.AllergiesRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/allergies")
@RequiredArgsConstructor
public class AllergiesController {
    @Autowired
    private AllergiesRepo allergiesRepo;

    @PostMapping(path = "/add")
    public ResponseEntity<AddAllergiesDTO> addAllergiesToUser(@RequestBody AllergiesDTO allergiesDTO){
        Allergies allergies = allergiesRepo.addAllergiesToUser(allergiesDTO);
        if(allergies == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
        return ResponseEntity.ok().body(AllergiesConverter.toDTO(allergies));
    }
}
