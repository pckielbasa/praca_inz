package com.example.praca_inz_api.controller;

import com.example.praca_inz_api.converter.SnackConverter;
import com.example.praca_inz_api.dto.SnackDTO;
import com.example.praca_inz_api.model.Snack;
import com.example.praca_inz_api.repository.SnackRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/food/snack")
@RequiredArgsConstructor
public class SnackController {
    @Autowired
    private SnackRepo snackRepo;

    @GetMapping("/all")
    public List<SnackDTO> getAllSnacks() {
        return snackRepo.getAllSnacks().stream().map(SnackConverter::toDTO).collect(Collectors.toList());
    }

    @PostMapping
    public SnackDTO addSnack(@RequestBody Snack snack){
        return SnackConverter.toDTO(snackRepo.addSnack(snack));
    }
}
