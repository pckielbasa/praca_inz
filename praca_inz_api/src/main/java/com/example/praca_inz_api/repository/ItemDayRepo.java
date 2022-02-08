package com.example.praca_inz_api.repository;

import com.example.praca_inz_api.dto.DayScheduleDTO;
import com.example.praca_inz_api.dto.ItemDayDTO;
import com.example.praca_inz_api.model.*;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Collection;
import java.util.List;

public interface ItemDayRepo  {
    Collection<ItemDaySchedule> getAllItems();

    ItemDaySchedule getItemDayScheduleById(String itemDayId);
    List<ItemDaySchedule> getListOfItemsByIds(List<String> idList);
    ItemDaySchedule createItem(ItemDayDTO itemDayDTO);
    ItemDaySchedule addItemToMyDay(ItemDayDTO itemDayDTO);
    List<Food> getFoodList(String itemId);
    List<Contact> getContactList(String itemId);
    ItemDaySchedule findItemDayByUsername(String username);
    ItemDaySchedule deleteFoodFromDay(ItemDaySchedule itemDaySchedule, Food food);
    ItemDaySchedule deleteContactFromDay(ItemDaySchedule itemDaySchedule, Contact contact);
}
