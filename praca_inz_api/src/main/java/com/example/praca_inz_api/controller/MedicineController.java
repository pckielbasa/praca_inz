package com.example.praca_inz_api.controller;

import com.example.praca_inz_api.converter.MedicineConverter;
import com.example.praca_inz_api.dto.MedicineDTO;
import com.example.praca_inz_api.model.Medicine;
import com.example.praca_inz_api.repository.MedicineRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/medicine")
@RequiredArgsConstructor
public class MedicineController {

    @Autowired
    private MedicineRepo medicineRepo;

    @GetMapping("/all")
    public List<MedicineDTO> getAllMedicines(){
        return medicineRepo.getAllMedicines().stream().map(MedicineConverter::toDTO).collect(Collectors.toList());
    }
    @PostMapping
    public MedicineDTO addMedicine(@RequestBody Medicine medicine){
        return MedicineConverter.toDTO(medicineRepo.addMedicine(medicine));
    }
}
