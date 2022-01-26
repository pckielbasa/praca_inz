package com.example.praca_inz_api.controller;

import com.example.praca_inz_api.converter.ItemDayConverter;
import com.example.praca_inz_api.dto.ItemDayDTO;
import com.example.praca_inz_api.repository.ItemDayRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/item")
@RequiredArgsConstructor
public class ItemDayController {

    @Autowired
    private ItemDayRepo itemDayRepo;

    @GetMapping("/{id}")
    public ResponseEntity<ItemDayDTO> getItemById(@PathVariable String id){
        return ResponseEntity.ok().body(ItemDayConverter.toDTO(itemDayRepo.getItemDayScheduleById(id)));
    }

    @PostMapping(path="/add")
    public ItemDayDTO addItemDay(@RequestBody ItemDayDTO itemDayDTO){
        return ItemDayConverter.toDTO(itemDayRepo.createItemDay(itemDayDTO));
    }
}
