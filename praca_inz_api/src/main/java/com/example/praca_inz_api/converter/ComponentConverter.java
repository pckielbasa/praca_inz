package com.example.praca_inz_api.converter;

import com.example.praca_inz_api.dao.ComponentDao;
import com.example.praca_inz_api.dto.ComponentDTO;
import com.example.praca_inz_api.model.Component;

public class ComponentConverter {
    public static ComponentDTO toDTO(Component entity){
        return new ComponentDTO(
                entity.getComponentName(),
                entity.getCommentAlertAllergies(),
                entity.getType(),
                entity.getFavourite()
        );
    }
}
