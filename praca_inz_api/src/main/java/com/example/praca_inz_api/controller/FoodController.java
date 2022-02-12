package com.example.praca_inz_api.controller;

import com.example.praca_inz_api.converter.FoodConverter;
import com.example.praca_inz_api.dao.FoodDao;
import com.example.praca_inz_api.dto.AddFoodDTO;
import com.example.praca_inz_api.dto.FoodDTO;
import com.example.praca_inz_api.dto.FoodListDTO;
import com.example.praca_inz_api.dto.UpdateFoodAllergyDTO;
import com.example.praca_inz_api.model.Food;
import com.example.praca_inz_api.model.User;
import com.example.praca_inz_api.repository.FoodRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/food")
@RequiredArgsConstructor
public class FoodController {
    @Autowired
    private FoodRepo foodRepo;

    @Autowired
    private FoodDao foodDao;

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
    public ResponseEntity<AddFoodDTO> addFoodToUser(@RequestBody FoodDTO foodDTO){
        Food food = foodRepo.addFoodToUser(foodDTO);
        if (food==null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
        return ResponseEntity.ok().body(FoodConverter.toDTO(food));
    }

    @DeleteMapping("/delete")
    public void deleteFoodByIdFromUser(@RequestParam(value = "foodId") String foodId,
                                  @RequestParam(value = "username") String username){
        foodRepo.deleteFoodById(foodId, username);
    }


}
