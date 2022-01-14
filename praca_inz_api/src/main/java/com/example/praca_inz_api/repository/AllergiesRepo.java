package com.example.praca_inz_api.repository;

import com.example.praca_inz_api.dto.AllergiesContactDTO;
import com.example.praca_inz_api.dto.AllergiesFoodDTO;
import com.example.praca_inz_api.model.Allergies;
import com.example.praca_inz_api.model.ItemDaySchedule;

import java.util.Collection;


public interface AllergiesRepo {
    Collection<Allergies> getAllAllergies();
    Allergies addFoodAllergies(AllergiesFoodDTO allergiesFoodDTO);
    Allergies addContactAllergies(AllergiesContactDTO allergiesContactDTO);
}
