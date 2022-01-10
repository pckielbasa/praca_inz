package com.example.praca_inz_api.service;

import com.example.praca_inz_api.dao.ItemDayDao;
import com.example.praca_inz_api.model.ItemDaySchedule;
import com.example.praca_inz_api.repository.ItemDayRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class ItemDayService implements ItemDayRepo {
    @Autowired
    private ItemDayDao itemDayDao;

    @Override
    public Collection<ItemDaySchedule> getAllItems() {

        return itemDayDao.findAll();
    }

    @Override
    public ItemDaySchedule addItem(ItemDaySchedule itemDaySchedule) {

        return itemDayDao.save(itemDaySchedule);
    }
}
