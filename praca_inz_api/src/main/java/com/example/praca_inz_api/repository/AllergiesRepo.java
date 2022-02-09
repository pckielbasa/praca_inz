package com.example.praca_inz_api.repository;

import com.example.praca_inz_api.dto.AllergiesDTO;
import com.example.praca_inz_api.model.Allergies;

public interface AllergiesRepo {
    Allergies createAllergies(AllergiesDTO allergiesDTO);
    Allergies addAllergiesToUser(AllergiesDTO allergiesDTO);
}
