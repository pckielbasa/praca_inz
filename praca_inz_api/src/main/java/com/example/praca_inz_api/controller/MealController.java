package com.example.praca_inz_api.controller;

import com.example.praca_inz_api.converter.MealConverter;
import com.example.praca_inz_api.dto.MealDTO;
import com.example.praca_inz_api.model.Meal;
import com.example.praca_inz_api.repository.MealRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/food/meal")
@RequiredArgsConstructor
public class MealController {
    @Autowired
    private MealRepo mealRepo;

    @GetMapping("/all")
    public List<MealDTO> getAllMeals(){
        return mealRepo.getAllMeals().stream().map(MealConverter::toDTO).collect(Collectors.toList());
    }

    @PostMapping
    public MealDTO addMeal(@RequestBody Meal meal){

        return MealConverter.toDTO(mealRepo.addMeal(meal));
    }

}
