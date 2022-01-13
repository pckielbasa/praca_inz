package com.example.praca_inz_api.service;

import com.example.praca_inz_api.dao.DayScheduleDao;
import com.example.praca_inz_api.model.DaySchedule;
import com.example.praca_inz_api.model.ItemDaySchedule;
import com.example.praca_inz_api.repository.DayScheduleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DayScheduleService implements DayScheduleRepo {
    @Autowired
    private DayScheduleDao dayScheduleDao;
    @Autowired
    private  ItemDayService itemDayService;

    public DaySchedule getDayScheduleById(String dayScheduleId) {
        return dayScheduleDao.findById(dayScheduleId).
                orElseThrow(() -> new IllegalStateException("Day schedule with "+dayScheduleId+" id does not exists."));
    }

    public void addDayItemToSchedule(String dayScheduleId, String itemDayId){
        DaySchedule daySchedule = getDayScheduleById(dayScheduleId);
        ItemDaySchedule itemDaySchedule = itemDayService.getItemDayScheduleById(itemDayId);

        List<ItemDaySchedule> itemDayScheduleList = daySchedule.getDayScheduleIemList();
        if (!itemDayScheduleList.contains(itemDaySchedule)){
            itemDayScheduleList.add(itemDaySchedule);
            daySchedule.setDayScheduleIemList(itemDayScheduleList);
            dayScheduleDao.save(daySchedule);
        }else {
            throw new IllegalStateException("Given itemDay("+dayScheduleId+" id) is already exists schedule.");
        }

    }
}
