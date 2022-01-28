package com.example.praca_inz_api.converter;

import com.example.praca_inz_api.dto.ItemDayDTO;
import com.example.praca_inz_api.model.Contact;
import com.example.praca_inz_api.model.Food;
import com.example.praca_inz_api.model.ItemDaySchedule;

import java.util.stream.Collectors;

public class ItemDayConverter {
    public static ItemDayDTO toDTO(ItemDaySchedule entity){
        return new ItemDayDTO(
                entity.getUsername(),
                entity.getHour(),
                entity.getMinute(),
                entity.getItemDayFood().stream().map(Food::get_id).collect(Collectors.toList()),
                entity.getItemDayContact().stream().map(Contact::get_id).collect(Collectors.toList())
        );
    }

}
