package com.example.praca_inz_api.repository;

import com.example.praca_inz_api.dto.ItemDayDTO;
import com.example.praca_inz_api.model.Allergies;
import com.example.praca_inz_api.model.ItemDaySchedule;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Collection;

public interface ItemDayRepo  {
    ItemDaySchedule addItemDay(ItemDayDTO itemDayDTO);
    ItemDaySchedule getItemDayScheduleById(String itemDayId);
}
