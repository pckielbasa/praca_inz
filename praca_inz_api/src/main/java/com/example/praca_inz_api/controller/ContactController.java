package com.example.praca_inz_api.controller;


import com.example.praca_inz_api.converter.ContactConverter;
import com.example.praca_inz_api.dto.AddContactDTO;
import com.example.praca_inz_api.dto.ContactDTO;
import com.example.praca_inz_api.model.Contact;
import com.example.praca_inz_api.repository.ContactRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/contact")
@RequiredArgsConstructor
public class ContactController {
    @Autowired
    private ContactRepo contactRepo;


    @GetMapping("/type")
    public List<AddContactDTO> getFoodType(@RequestParam(value = "type") String type){
        return contactRepo.getAllType(type).stream()
                .map(ContactConverter::toDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AddContactDTO> getFoodById(@PathVariable String id){
        return ResponseEntity.ok().body(ContactConverter.toDTO(contactRepo.getContactById(id)));
    }

    @PostMapping(path = "/add")
    public AddContactDTO addContactToUser(@RequestBody ContactDTO contactDTO){
        return ContactConverter.toDTO(contactRepo.addContactToUser(contactDTO));
    }


    @DeleteMapping("/delete")
    public void deleteContactById(@RequestParam(value = "contactId") String contactId,
                                  @RequestParam(value = "username") String username){
        contactRepo.deleteContactById(contactId, username);
    }
}
