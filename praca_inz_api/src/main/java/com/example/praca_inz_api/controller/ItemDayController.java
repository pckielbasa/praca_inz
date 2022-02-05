package com.example.praca_inz_api.controller;

import com.example.praca_inz_api.converter.ContactConverter;
import com.example.praca_inz_api.converter.DayScheduleConverter;
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

    @GetMapping("/itemfood")
    public List<FoodListDTO> getMyFoodList(@RequestParam(value = "itemId") String itemId){
        return itemDayRepo.getFoodList(itemId).stream().map(FoodConverter::toFoodDTO).collect(Collectors.toList());
    }

    @GetMapping("/itemcontact")
    public List<ContactListDTO> getMyContactList(@RequestParam(value = "itemId") String itemId){
        return itemDayRepo.getContactList(itemId).stream().map(ContactConverter::toContactDTO).collect(Collectors.toList());
    }

    @PostMapping(path = "/add")
    public AddItemDayDTO addItemToDay(@RequestBody ItemDayDTO itemDayDTO){
        ItemDaySchedule itemDaySchedule = itemDayRepo.addItemToDaySchedule(itemDayDTO);
        return ItemDayConverter.toAddDTO(itemDaySchedule);
    }
}
