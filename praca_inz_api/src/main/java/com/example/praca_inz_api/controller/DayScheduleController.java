package com.example.praca_inz_api.controller;

import com.example.praca_inz_api.converter.DayScheduleConverter;
import com.example.praca_inz_api.dao.DayScheduleDao;
import com.example.praca_inz_api.dto.AddDayScheduleDTO;
import com.example.praca_inz_api.dto.DayScheduleDTO;
import com.example.praca_inz_api.model.DaySchedule;
import com.example.praca_inz_api.repository.DayScheduleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

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
