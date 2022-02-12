package com.example.praca_inz_api.repository;

import com.example.praca_inz_api.dto.ItemDayDTO;
import com.example.praca_inz_api.model.Contact;
import com.example.praca_inz_api.model.Food;
import com.example.praca_inz_api.model.ItemDaySchedule;

import java.util.Collection;
import java.util.List;

public interface ItemDayRepo  {
    Collection<ItemDaySchedule> getAllItems();

    ItemDaySchedule getItemDayScheduleById(String itemDayId);
    List<ItemDaySchedule> getListOfItemsByIds(List<String> idList);
    ItemDaySchedule createItem(ItemDayDTO itemDayDTO);
    ItemDaySchedule addItemToMyDay(ItemDayDTO itemDayDTO);
    ItemDaySchedule findItemDayByUsername(String username);
    void deleteItemById(String itemId, String dayDate );
}
