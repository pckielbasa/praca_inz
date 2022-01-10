package com.example.praca_inz_api.repository;

import com.example.praca_inz_api.model.Allergies;
import com.example.praca_inz_api.model.ItemDaySchedule;

import java.util.Collection;

public interface AllergiesRepo {
    Collection<Allergies> getAllAllergies();
    Allergies addAllergies(Allergies allergies);
}
