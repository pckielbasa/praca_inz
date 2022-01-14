package com.example.praca_inz_api.service;

import com.example.praca_inz_api.dao.DayScheduleDao;
import com.example.praca_inz_api.dto.DayScheduleDTO;
import com.example.praca_inz_api.dto.ItemDayDTO;
import com.example.praca_inz_api.model.DaySchedule;
import com.example.praca_inz_api.model.ItemDaySchedule;
import com.example.praca_inz_api.repository.DayScheduleRepo;
import com.example.praca_inz_api.repository.ItemDayRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DayScheduleService implements DayScheduleRepo {
    @Autowired
    private DayScheduleDao dayScheduleDao;

    @Autowired
    private ItemDayRepo itemDayRepo;

    @Override
    public DaySchedule addDaySchedule(DayScheduleDTO dayScheduleDTO) {
        DaySchedule daySchedule = new DaySchedule();
        daySchedule.setDayDate(dayScheduleDTO.getDayDate());
        daySchedule.setDayScheduleIemList(itemDayRepo.getListOfItemsByIds(dayScheduleDTO.getListOfItemsId()));
         return dayScheduleDao.save(daySchedule);
    }

    public DaySchedule getDayScheduleById(String dayScheduleId) {
        return dayScheduleDao.findById(dayScheduleId).
                orElseThrow(() -> new IllegalStateException("Day schedule with "+dayScheduleId +"  does not exists."));
    }


}
