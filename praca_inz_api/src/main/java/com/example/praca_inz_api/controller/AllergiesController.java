package com.example.praca_inz_api.controller;

import com.example.praca_inz_api.converter.AllergiesConverter;
import com.example.praca_inz_api.converter.ItemDayConverter;
import com.example.praca_inz_api.dto.AllergiesContactDTO;
import com.example.praca_inz_api.dto.AllergiesDTO;
import com.example.praca_inz_api.dto.AllergiesFoodDTO;
import com.example.praca_inz_api.dto.ItemDayDTO;
import com.example.praca_inz_api.model.Allergies;
import com.example.praca_inz_api.repository.AllergiesRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/allergies")
@RequiredArgsConstructor
public class AllergiesController {
    @Autowired
    private AllergiesRepo allergiesRepo;

    @GetMapping("/all")
    public List<AllergiesDTO> getAllAllergies(){
        return allergiesRepo.getAllAllergies().stream().map(AllergiesConverter::toDTO).collect(Collectors.toList());
    }
    @PostMapping(path="/addFood")
    public AllergiesFoodDTO addItemDay(@RequestBody AllergiesFoodDTO allergiesFoodDTO){
        return AllergiesConverter.toFoodDTO(allergiesRepo.addFoodAllergies(allergiesFoodDTO));
    }

    @PostMapping(path="/addContact")
    public AllergiesContactDTO addItemDay(@RequestBody AllergiesContactDTO allergiesContactDTO){
        return AllergiesConverter.toContactDTO(allergiesRepo.addContactAllergies(allergiesContactDTO));
    }
}
