package com.example.praca_inz_api.controller;

import com.example.praca_inz_api.converter.ItemDayConverter;
import com.example.praca_inz_api.dto.ItemDayDTO;
import com.example.praca_inz_api.repository.ItemDayRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/item")
@RequiredArgsConstructor
public class ItemDayController {

    @Autowired
    private ItemDayRepo itemDayRepo;

    @GetMapping
    public ItemDayDTO getItemDayById(@RequestParam(value = "itemDayId") String itemDayId){
        return ItemDayConverter.toDTO(itemDayRepo.getItemDayScheduleById(itemDayId));
    }

    @PostMapping(path="/add")
    public ItemDayDTO addItemDay(@RequestBody ItemDayDTO itemDayDTO){
        return ItemDayConverter.toDTO(itemDayRepo.addItemDay(itemDayDTO));
    }
}
