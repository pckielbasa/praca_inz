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
                entity.getHour(),
                entity.getMinute(),
                entity.getItemDayFood().stream().map(Food::get_id).collect(Collectors.toList()),
                entity.getItemDayContact().stream().map(Contact::get_id).collect(Collectors.toList())
        );
    }

    public static AddItemDayDTO toAddDTO(ItemDaySchedule entity){
        return new AddItemDayDTO(
                entity.getDayDate(),
                entity.getUsername(),
                entity.getHour(),
                entity.getMinute(),
                entity.getItemDayFood().stream().map(Food::get_id).collect(Collectors.toList()),
                entity.getItemDayContact().stream().map(Contact::get_id).collect(Collectors.toList())
        );
    }
    public static ItemsListDTO toListDTO(ItemDaySchedule entity){
        return new ItemsListDTO(
                entity.get_id(),
                entity.getHour(),
                entity.getMinute()
        );
    }
}
