package com.example.praca_inz_api.converter;

import com.example.praca_inz_api.dto.AddAllergiesDTO;
import com.example.praca_inz_api.model.Allergies;
;

public class AllergiesConverter {
    public static AddAllergiesDTO toDTO(Allergies entity){
        return new AddAllergiesDTO(
                entity.getUsername(),
                entity.getAllergenId(),
                entity.getType(),
                entity.getAllergenName(),
                entity.getAllergiesName(),
                entity.getAfterTime(),
                entity.getSymptoms(),
                entity.getHelp()
        );
    }
}
