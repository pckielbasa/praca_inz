package com.example.praca_inz_api.controller;

import com.example.praca_inz_api.converter.DayScheduleConverter;
import com.example.praca_inz_api.repository.DayScheduleRepo;
import com.example.praca_inz_api.service.DayScheduleService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/calendar")

public class DayScheduleController {
    @Autowired
    private  DayScheduleService dayScheduleService;


    @PatchMapping(path = "/addItemDaySchedule")
    public void addItemDayScheduleToDay(@RequestParam(value = "dayScheduleId") String dayScheduleId,
                                     @RequestParam(value = "itemDayScheduleId") String itemDayScheduleId){
        dayScheduleService.addDayItemToSchedule(dayScheduleId,itemDayScheduleId);
    }
}
