package com.example.praca_inz_api.controller;

import com.example.praca_inz_api.converter.ContactConverter;
import com.example.praca_inz_api.converter.DayScheduleConverter;
import com.example.praca_inz_api.converter.FoodConverter;
import com.example.praca_inz_api.converter.ItemDayConverter;
import com.example.praca_inz_api.dao.DayScheduleDao;
import com.example.praca_inz_api.dto.*;
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
import java.util.stream.Collectors;

@RestController
@RequestMapping("/calendar")

public class DayScheduleController {

    @Autowired
    private DayScheduleRepo dayScheduleRepo;

    @Autowired
    private DayScheduleDao dayScheduleDao;

    @GetMapping("/all")
    public List<DaySchedule> getAllDays(){
        return new ArrayList<>(dayScheduleRepo.getAllDays());
    }

    @GetMapping("/{id}")
    public DaySchedule getDayById(@PathVariable String id){
        return dayScheduleRepo.getDayScheduleById(id);
    }

    @GetMapping("/date")
    public DaySchedule getDayByDate(@RequestParam(value = "date") String date){
        return dayScheduleDao.findByDayDate(date);
    }

    @PostMapping(path = "/add")
    public AddDayScheduleDTO addDayScheduleToUser(@RequestBody DayScheduleDTO dayScheduleDTO){
        DaySchedule daySchedule = dayScheduleRepo.addDayScheduleToUser(dayScheduleDTO);
        return DayScheduleConverter.toDTO(daySchedule);
    }

}
