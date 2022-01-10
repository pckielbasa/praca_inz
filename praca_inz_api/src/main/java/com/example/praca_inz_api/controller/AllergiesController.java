package com.example.praca_inz_api.controller;

import com.example.praca_inz_api.converter.AllergiesConverter;
import com.example.praca_inz_api.converter.ItemDayConverter;
import com.example.praca_inz_api.dto.AllergiesDTO;
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
    @PostMapping
    public AllergiesDTO addItem(@RequestBody Allergies allergies){
        return AllergiesConverter.toDTO(allergiesRepo.addAllergies(allergies));
    }
}
