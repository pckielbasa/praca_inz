package com.example.praca_inz_api.controller;

import com.example.praca_inz_api.converter.DayScheduleConverter;
import com.example.praca_inz_api.converter.ItemDayConverter;
import com.example.praca_inz_api.dto.DayScheduleDTO;
import com.example.praca_inz_api.dto.ItemDayDTO;
import com.example.praca_inz_api.repository.DayScheduleRepo;
import com.example.praca_inz_api.service.DayScheduleService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/calendar")

public class DayScheduleController {

    @Autowired
    private DayScheduleRepo dayScheduleRepo;

    @GetMapping("/{id}")
    public ResponseEntity<DayScheduleDTO> getDayById(@PathVariable String id){
        return ResponseEntity.ok().body(DayScheduleConverter.toDTO(dayScheduleRepo.getDayScheduleById(id)));
    }

    @GetMapping(path = "/add")
    public DayScheduleDTO addDaySchedule(@RequestBody DayScheduleDTO dayScheduleDTO){
        return DayScheduleConverter.toDTO(dayScheduleRepo.addDaySchedule(dayScheduleDTO));
    }


}
