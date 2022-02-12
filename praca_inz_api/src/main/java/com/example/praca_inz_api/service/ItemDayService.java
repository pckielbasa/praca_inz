package com.example.praca_inz_api.service;

import com.example.praca_inz_api.dao.DayScheduleDao;
import com.example.praca_inz_api.dao.ItemDayDao;
import com.example.praca_inz_api.dto.ItemDayDTO;
import com.example.praca_inz_api.model.*;
import com.example.praca_inz_api.repository.ContactRepo;
import com.example.praca_inz_api.repository.DayScheduleRepo;
import com.example.praca_inz_api.repository.FoodRepo;
import com.example.praca_inz_api.repository.ItemDayRepo;
import lombok.AllArgsConstructor;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ItemDayService implements ItemDayRepo {

    @Autowired
    private  ItemDayDao itemDayDao;


    @Autowired
    private DayScheduleRepo dayScheduleRepo;

    @Autowired
    private DayScheduleDao dayScheduleDao;

    @Override
    public List<ItemDaySchedule> getAllItems(){
        return itemDayDao.findAll();
    }


    @Override
    public ItemDaySchedule getItemDayScheduleById(String itemDayId) {
        return itemDayDao.findById(itemDayId)
                .orElseThrow(() -> new IllegalStateException(
                        "ItemDay with " + itemDayId + " does not exists."));
    }

    @Override
    public List<ItemDaySchedule> getListOfItemsByIds(List<String> idList) {
        return  idList
                .stream()
                .map(item->
                        itemDayDao.findById(item)
                                .orElseThrow(()->new RuntimeException("Item day schedule Id not found"+item)))
                .collect(Collectors.toList());
    }

    @Override
    public ItemDaySchedule createItem(ItemDayDTO itemDayDTO) {
        ItemDaySchedule itemDaySchedule = new ItemDaySchedule();
        itemDaySchedule.setUsername(itemDayDTO.getUsername());
        itemDaySchedule.setDayDate(itemDayDTO.getDayDate());
        itemDaySchedule.setTime(itemDayDTO.getTime());
        itemDaySchedule.setItemId(itemDayDTO.getItemId());
        itemDaySchedule.setItemName(itemDayDTO.getItemName());
        itemDaySchedule.setItemCompo(itemDayDTO.getItemCompo());
        itemDaySchedule.setType(itemDayDTO.getType());
        return itemDayDao.save(itemDaySchedule);
    }

    @Override
    public ItemDaySchedule addItemToMyDay(ItemDayDTO itemDayDTO) {
        ItemDaySchedule itemDaySchedule = createItem(itemDayDTO);
        dayScheduleRepo.addItemToDay(itemDaySchedule, itemDayDTO.getDayDate());
        return itemDaySchedule;
    }



    @Override
    public ItemDaySchedule findItemDayByUsername(String username) {
        return itemDayDao.findItemDayScheduleByUsername(username);
    }

    @Override
    public void deleteItemById(String itemId, String dayDate) {
        ItemDaySchedule itemDaySchedule = itemDayDao.findBy_id(itemId);
        DaySchedule daySchedule = dayScheduleRepo.getDayByDate(dayDate);

        daySchedule = dayScheduleRepo.deleteItemFromDay(daySchedule, itemDaySchedule);
        dayScheduleDao.save(daySchedule);

        itemDayDao.delete(itemDaySchedule);
    }


}
