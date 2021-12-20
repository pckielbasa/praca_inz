package com.example.praca_inz_api.converter;

import com.example.praca_inz_api.dto.MedicineDTO;
import com.example.praca_inz_api.model.Medicine;

public class MedicineConverter {
    public static MedicineDTO toDTO(Medicine entity){
        return new MedicineDTO(
                entity.getMedicineName(),
                entity.getMedicineComment()
        );
    }
}
