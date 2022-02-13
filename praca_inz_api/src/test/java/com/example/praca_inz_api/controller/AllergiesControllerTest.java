package com.example.praca_inz_api.controller;

import com.example.praca_inz_api.converter.AllergiesConverter;
import com.example.praca_inz_api.dto.AllergiesDTO;
import com.example.praca_inz_api.model.Allergies;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.http.ResponseEntity;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

class AllergiesControllerTest {

    @Test
    void addAllergiesToUser() {
        AllergiesController allergiesController = mock(AllergiesController.class);
        Allergies allergies = new Allergies();
        allergies.setAllergenId("6208299a5adf15753a523f34");

        given(allergiesController.addAllergiesToUser(Mockito.any(AllergiesDTO.class)))
                .willReturn(ResponseEntity.ok().body(AllergiesConverter.toDTO(allergies)));

        Assertions.assertEquals(allergies.getAllergenId(), "6208299a5adf15753a523f34");


    }
}