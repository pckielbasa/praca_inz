package com.example.praca_inz_api.repository;

import com.example.praca_inz_api.model.ItemDaySchedule;

import java.util.Collection;

public interface ItemDayRepo {
    Collection<ItemDaySchedule> getAllItems();
    ItemDaySchedule addItem(ItemDaySchedule itemDaySchedule);
}
