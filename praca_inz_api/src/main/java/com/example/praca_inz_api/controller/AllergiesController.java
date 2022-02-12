package com.example.praca_inz_api.controller;

import com.example.praca_inz_api.converter.AllergiesConverter;
import com.example.praca_inz_api.dao.AllergiesDao;
import com.example.praca_inz_api.dto.AddAllergiesDTO;
import com.example.praca_inz_api.dto.AllergiesDTO;
import com.example.praca_inz_api.dto.AllergiesListDTO;
import com.example.praca_inz_api.model.Allergies;
import com.example.praca_inz_api.repository.AllergiesRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/allergies")
@RequiredArgsConstructor
public class AllergiesController {
    @Autowired
    private AllergiesRepo allergiesRepo;

    @Autowired
    private AllergiesDao allergiesDao;

    @GetMapping("find")
    public AllergiesListDTO findAllergiesBYAllergenId(@RequestParam(value = "allergenId") String allergenId ){
        Allergies allergies = allergiesDao.findByAllergenId(allergenId);
        if(allergies == null){
            return null;
        }
        return AllergiesConverter.toListDTO(allergies);
    }

    @PostMapping(path = "/add")
    public ResponseEntity<AddAllergiesDTO> addAllergiesToUser(@RequestBody AllergiesDTO allergiesDTO){
        Allergies allergies = allergiesRepo.addAllergiesToUser(allergiesDTO);
        if(allergies == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
        return ResponseEntity.ok().body(AllergiesConverter.toDTO(allergies));
    }

    @DeleteMapping("/delete")
    public void deleteAllergiesByIdFromUser(@RequestParam(value = "allergiesId") String allergiesId,
                                       @RequestParam(value = "username") String username){
        allergiesRepo.deleteAllergiesById(allergiesId, username);
    }


}
