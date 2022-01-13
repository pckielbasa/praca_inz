package com.example.praca_inz_api.controller;


import com.example.praca_inz_api.converter.ContactConverter;
import com.example.praca_inz_api.converter.FoodConverter;
import com.example.praca_inz_api.dto.ContactDTO;
import com.example.praca_inz_api.dto.FoodDTO;
import com.example.praca_inz_api.model.Contact;
import com.example.praca_inz_api.repository.ContactRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/contact")
@RequiredArgsConstructor
public class ContactController {
    @Autowired
    private ContactRepo contactRepo;

    @GetMapping("/all")
    public List<ContactDTO> getAllContact(){
        return contactRepo.getAllContact().stream().map(ContactConverter::toDTO).collect(Collectors.toList());
    }
    @GetMapping("/type")
    public List<ContactDTO> getFoodType(@RequestParam(value = "type") String type){
        return contactRepo.getAllType(type).stream()
                .map(ContactConverter::toDTO)
                .collect(Collectors.toList());
    }

    @PostMapping
    public ContactDTO addContact(@RequestBody Contact contact){
        return ContactConverter.toDTO(contactRepo.addContact(contact));
    }
}
