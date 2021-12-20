package com.example.praca_inz_api.controller;

import com.example.praca_inz_api.converter.PersonConverter;
import com.example.praca_inz_api.dto.PersonDTO;
import com.example.praca_inz_api.model.Person;
import com.example.praca_inz_api.repository.PersonRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/person")
@RequiredArgsConstructor
public class PersonController {
    @Autowired
    private PersonRepo personRepo;

    @GetMapping("/all")
    public List<PersonDTO> getAllPersons(){
        return personRepo.getAllPersons().stream().map(PersonConverter::toDTO).collect(Collectors.toList());
    }
    @PostMapping
    public PersonDTO addPerson(@RequestBody Person person){
        return PersonConverter.toDTO(personRepo.addPerson(person));
    }
}
