package com.example.praca_inz_api.converter;

import com.example.praca_inz_api.dto.SnackDTO;
import com.example.praca_inz_api.model.Snack;
import com.example.praca_inz_api.repository.SnackRepo;

public class SnackConverter {
    public static SnackDTO toDTO(Snack entity){
        return new SnackDTO(
                entity.getSnackName(),
                entity.getCommentAlertAllergies(),
                entity.getFavourite()
        );
    }
}
