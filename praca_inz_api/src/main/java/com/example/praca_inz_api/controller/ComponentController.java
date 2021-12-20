package com.example.praca_inz_api.controller;

import com.example.praca_inz_api.converter.ComponentConverter;
import com.example.praca_inz_api.dao.ComponentDao;
import com.example.praca_inz_api.dto.ComponentDTO;
import com.example.praca_inz_api.model.Component;
import com.example.praca_inz_api.repository.ComponentRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("food/component")
@RequiredArgsConstructor
public class ComponentController {
    @Autowired
    private ComponentRepo  componentRepo;

    @GetMapping("/all")
    public List<ComponentDTO> getAllComponents(){
        return componentRepo.getAllComponents().stream().map(ComponentConverter::toDTO).collect(Collectors.toList());
    }

    @PostMapping
    public ComponentDTO addComponent(@RequestBody Component component){
        return ComponentConverter.toDTO(componentRepo.addComponent(component));
    }
}
