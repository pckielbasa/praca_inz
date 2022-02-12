package com.example.praca_inz_api.converter;

import com.example.praca_inz_api.dto.AddItemDayDTO;
import com.example.praca_inz_api.dto.ItemDayDTO;
import com.example.praca_inz_api.dto.ItemsListDTO;
import com.example.praca_inz_api.model.Contact;
import com.example.praca_inz_api.model.Food;
import com.example.praca_inz_api.model.ItemDaySchedule;

import java.util.stream.Collectors;

public class ItemDayConverter {
    public static ItemDayDTO toDTO(ItemDaySchedule entity){
        return new ItemDayDTO(
                entity.get_id(),
                entity.getDayDate(),
                entity.getUsername(),
                entity.getTime(),
                entity.getItemId(),
                entity.getItemName(),
                entity.getItemCompo(),
                entity.getType()
        );
    }

    public static AddItemDayDTO toAddDTO(ItemDaySchedule entity){
        return new AddItemDayDTO(
                entity.getDayDate(),
                entity.getUsername(),
                entity.getTime(),
                entity.getItemId(),
                entity.getItemName(),
                entity.getItemCompo(),
                entity.getType()
        );
    }
    public static ItemsListDTO toListDTO(ItemDaySchedule entity){
        return new ItemsListDTO(
                entity.get_id(),
                entity.getDayDate(),
                entity.getTime(),
                entity.getItemId(),
                entity.getItemName(),
                entity.getItemCompo(),
                entity.getType()
        );
    }
}
