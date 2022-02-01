package com.example.praca_inz_api.controller;

import com.example.praca_inz_api.converter.FoodConverter;
import com.example.praca_inz_api.dto.AddFoodDTO;
import com.example.praca_inz_api.dto.FoodDTO;
import com.example.praca_inz_api.model.Food;
import com.example.praca_inz_api.repository.FoodRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
@RequestMapping("/food")
@RequiredArgsConstructor
public class FoodController {
    @Autowired
    private FoodRepo foodRepo;


    @GetMapping("/type")
    public List<AddFoodDTO> getFoodType(@RequestParam(value = "type") String type){
        return foodRepo.getAllType(type).stream()
                .map(FoodConverter::toDTO)
                .collect(Collectors.toList());
    }


    @GetMapping("/{id}")
    public ResponseEntity<AddFoodDTO> getFoodById(@PathVariable String id){
        return ResponseEntity.ok().body(FoodConverter.toDTO(foodRepo.getFoodById(id)));
    }

    @PostMapping(path = "/add")
    public AddFoodDTO addFoodToUser(@RequestBody FoodDTO foodDTO){
        return FoodConverter.toDTO(foodRepo.addFoodToUser(foodDTO));
    }


    @DeleteMapping("/delete")
    public void deleteFoodById(@RequestParam(value = "foodId") String foodId,
                                  @RequestParam(value = "username") String username){
        foodRepo.deleteFoodById(foodId, username);
    }
}
