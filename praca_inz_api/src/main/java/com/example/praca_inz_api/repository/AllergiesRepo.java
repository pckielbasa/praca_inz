package com.example.praca_inz_api.repository;

import com.example.praca_inz_api.dto.ContactAllergiesDTO;
import com.example.praca_inz_api.dto.FoodAllergiesDTO;
import com.example.praca_inz_api.model.Allergies;
import com.example.praca_inz_api.model.Food;

import java.util.Collection;


public interface AllergiesRepo {
    Collection<Allergies> getAllAllergies();
    Allergies createFoodAllergies(FoodAllergiesDTO foodAllergiesDTO);
    Allergies addFoodAllergiesToUser(FoodAllergiesDTO foodAllergiesDTO);
    Allergies createContactAllergies(ContactAllergiesDTO contactAllergiesDTO);
    Allergies addContactAllergiesToUser(ContactAllergiesDTO contactAllergiesDTO);
}
