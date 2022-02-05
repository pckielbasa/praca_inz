package com.example.praca_inz_api.controller;

import com.example.praca_inz_api.converter.DayScheduleConverter;
import com.example.praca_inz_api.converter.FoodConverter;
import com.example.praca_inz_api.dto.AddDayScheduleDTO;
import com.example.praca_inz_api.dto.AddFoodDTO;
import com.example.praca_inz_api.dto.DayScheduleDTO;
import com.example.praca_inz_api.dto.FoodDTO;
import com.example.praca_inz_api.model.DaySchedule;
import com.example.praca_inz_api.model.Food;
import com.example.praca_inz_api.model.ItemDaySchedule;
import com.example.praca_inz_api.repository.DayScheduleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/calendar")

public class DayScheduleController {

    @Autowired
    private DayScheduleRepo dayScheduleRepo;

    @GetMapping("/all")
    public List<DaySchedule> getAllDays(){
        return new ArrayList<>(dayScheduleRepo.getAllDays());
    }

    @PostMapping(path = "/add")
    public AddDayScheduleDTO addDayScheduleToUser(@RequestBody DayScheduleDTO dayScheduleDTO){
        DaySchedule daySchedule = dayScheduleRepo.addDayScheduleToUser(dayScheduleDTO);
        return DayScheduleConverter.toDTO(daySchedule);
    }

    @GetMapping("/{id}")
    public AddDayScheduleDTO getDayById(@PathVariable String id){
        return DayScheduleConverter.toDTO(dayScheduleRepo.getDayScheduleById(id));
    }

}
