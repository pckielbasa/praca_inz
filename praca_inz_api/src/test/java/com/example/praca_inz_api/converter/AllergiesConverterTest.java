package com.example.praca_inz_api.converter;

import com.example.praca_inz_api.dto.AddAllergiesDTO;
import com.example.praca_inz_api.dto.AllergiesDTO;
import com.example.praca_inz_api.dto.AllergiesListDTO;
import com.example.praca_inz_api.model.Allergies;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class AllergiesConverterTest {

    @Test
    public void toDTO() {
        Allergies allergies = new Allergies();
        allergies.setAllergenId("gfdfjd4qa56yzdrsgWQ");

        AddAllergiesDTO allergiesDTO = AllergiesConverter.toDTO(allergies);

        Assert.assertEquals(allergiesDTO.getAllergenId(),allergies.getAllergenId());
    }

    @Test
    public void toListDTO() {
        Allergies allergies = new Allergies();
        allergies.setAllergenName("Test");

        AllergiesListDTO allergiesListDTO = AllergiesConverter.toListDTO(allergies);

        Assert.assertEquals(allergiesListDTO.getAllergenName(),allergies.getAllergenName());
    }

    @Test
    public void allergiesToListDTO() {
        AllergiesDTO allergiesDTO = new AllergiesDTO();
        allergiesDTO.setAllergenName("Test");

        Allergies allergies = new Allergies();
        allergies.setAllergenName("Test");

        Assert.assertEquals(allergies.getAllergenName(),allergiesDTO.getAllergenName());
    }
}