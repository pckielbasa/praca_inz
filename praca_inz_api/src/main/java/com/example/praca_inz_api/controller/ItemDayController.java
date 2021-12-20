package com.example.praca_inz_api.controller;

import com.example.praca_inz_api.converter.ItemDayConverter;
import com.example.praca_inz_api.dto.ItemDayDTO;
import com.example.praca_inz_api.model.ItemDaySchedule;
import com.example.praca_inz_api.repository.ItemDayRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/item")
@RequiredArgsConstructor
public class ItemDayController {
    @Autowired
    private ItemDayRepo itemDayRepo;

    @GetMapping("/all")
    public List<ItemDayDTO> getAllItems(){
        return itemDayRepo.getAllItems().stream().map(ItemDayConverter::toDTO).collect(Collectors.toList());
    }
    @PostMapping
    public ItemDayDTO addItem(@RequestBody ItemDaySchedule itemDaySchedule){
        return ItemDayConverter.toDTO(itemDayRepo.addItem(itemDaySchedule));
    }
}
