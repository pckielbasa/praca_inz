package com.example.praca_inz_api.controller;

import com.example.praca_inz_api.converter.ContactConverter;
import com.example.praca_inz_api.converter.FoodConverter;
import com.example.praca_inz_api.dto.ContactDTO;
import com.example.praca_inz_api.dto.FoodDTO;
import com.example.praca_inz_api.model.Contact;
import com.example.praca_inz_api.model.Food;
import com.example.praca_inz_api.repository.ContactRepo;
import com.example.praca_inz_api.repository.FoodRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("food")
@RequiredArgsConstructor
public class FoodController {
    @Autowired
    private FoodRepo foodRepo;

    @GetMapping("/all")
    public List<FoodDTO> getAllFood(){
        return foodRepo.getAllFood().stream().map(FoodConverter::toDTO).collect(Collectors.toList());
    }
    @GetMapping("/type")
    public List<FoodDTO> getFoodType(@RequestParam(value = "type") String type){
        return foodRepo.getAllType(type).stream()
                .map(FoodConverter::toDTO)
                .collect(Collectors.toList());
    }

    @PostMapping
    public FoodDTO addFood(@RequestBody Food food){
        return FoodConverter.toDTO(foodRepo.addFood(food));
    }
}
