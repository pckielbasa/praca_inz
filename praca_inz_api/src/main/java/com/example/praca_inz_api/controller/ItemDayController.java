package com.example.praca_inz_api.controller;

import com.example.praca_inz_api.converter.DayScheduleConverter;
import com.example.praca_inz_api.converter.ItemDayConverter;
import com.example.praca_inz_api.dto.AddDayScheduleDTO;
import com.example.praca_inz_api.dto.AddItemDayDTO;
import com.example.praca_inz_api.dto.DayScheduleDTO;
import com.example.praca_inz_api.dto.ItemDayDTO;
import com.example.praca_inz_api.model.DaySchedule;
import com.example.praca_inz_api.model.ItemDaySchedule;
import com.example.praca_inz_api.model.User;
import com.example.praca_inz_api.repository.ItemDayRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


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
        ItemDaySchedule itemDaySchedule = itemDayRepo.addItemToDaySchedule(itemDayDTO);
        return ItemDayConverter.toAddDTO(itemDaySchedule);
    }
}
