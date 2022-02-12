package com.example.praca_inz_api.controller;

import com.example.praca_inz_api.converter.ContactConverter;
import com.example.praca_inz_api.converter.FoodConverter;
import com.example.praca_inz_api.converter.ItemDayConverter;
import com.example.praca_inz_api.dto.*;
import com.example.praca_inz_api.model.*;
import com.example.praca_inz_api.repository.ItemDayRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/item")
@RequiredArgsConstructor
public class ItemDayController {

    @Autowired
    private ItemDayRepo itemDayRepo;

    @GetMapping("/all")
    public List<ItemDaySchedule> getAllItems(){
        return new ArrayList<>(itemDayRepo.getAllItems());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ItemDayDTO> getItemById(@PathVariable String id){
        return ResponseEntity.ok().body(ItemDayConverter.toDTO(itemDayRepo.getItemDayScheduleById(id)));
    }


    @PostMapping(path = "/add")
    public AddItemDayDTO addItemToDay(@RequestBody ItemDayDTO itemDayDTO){
        ItemDaySchedule itemDaySchedule = itemDayRepo.addItemToMyDay(itemDayDTO);
        return ItemDayConverter.toAddDTO(itemDaySchedule);
    }


}
