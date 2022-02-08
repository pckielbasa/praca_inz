package com.example.praca_inz_api.service;

import com.example.praca_inz_api.dao.DayScheduleDao;
import com.example.praca_inz_api.dto.DayScheduleDTO;
import com.example.praca_inz_api.dto.ItemDayDTO;
import com.example.praca_inz_api.model.DaySchedule;
import com.example.praca_inz_api.model.Food;
import com.example.praca_inz_api.model.ItemDaySchedule;
import com.example.praca_inz_api.model.User;
import com.example.praca_inz_api.repository.DayScheduleRepo;
import com.example.praca_inz_api.repository.ItemDayRepo;
import com.example.praca_inz_api.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DayScheduleService implements DayScheduleRepo {
    @Autowired
    private DayScheduleDao dayScheduleDao;


    @Autowired
    private UserRepo userRepo;

    @Override
    public List<DaySchedule> getAllDays(){
        return dayScheduleDao.findAll();
    }

    @Override
    public DaySchedule getDayByDate(String dayDate) {
        return dayScheduleDao.findByDayDate(dayDate);
    }

    public DaySchedule getDayScheduleById(String dayScheduleId) {
        return dayScheduleDao.findById(dayScheduleId).
                orElseThrow(() -> new IllegalStateException("Day schedule with "+dayScheduleId +"  does not exists."));
    }

    @Override
    public DaySchedule createDaySchedule(DayScheduleDTO dayScheduleDTO) {
        DaySchedule daySchedule = new DaySchedule();
        List<DaySchedule> myList = userRepo.getMyDay(dayScheduleDTO.getDayDate(), dayScheduleDTO.getUsername());
        daySchedule.setUsername(dayScheduleDTO.getUsername());
        daySchedule.setDayDate(dayScheduleDTO.getDayDate());
        boolean anyMatch = myList.stream().anyMatch(item -> item.getDayDate().equals(daySchedule.getDayDate()));
        if (anyMatch){
            return dayScheduleDao.findByDayDate(dayScheduleDTO.getDayDate());
        }
        return dayScheduleDao.save(daySchedule);
    }

    @Override
    public DaySchedule addDayScheduleToUser(DayScheduleDTO dayScheduleDTO) {
        DaySchedule daySchedule = createDaySchedule(dayScheduleDTO);
        List<DaySchedule> myList = userRepo.getMyDay(dayScheduleDTO.getDayDate(), dayScheduleDTO.getUsername());
        boolean anyMatch = myList.stream().anyMatch(item -> item.getDayDate().equals(daySchedule.getDayDate()));
        if (anyMatch){
            return dayScheduleDao.findByDayDate(dayScheduleDTO.getDayDate());
        }else{
            userRepo.addDayToCalendar(daySchedule,dayScheduleDTO.getUsername());
            return daySchedule;
        }

    }

    @Override
    public DaySchedule addItemToDay(ItemDaySchedule itemDaySchedule, String dayDate) {
        DaySchedule daySchedule = getDayByDate(dayDate);
        daySchedule.getItemList().add(itemDaySchedule);
        return dayScheduleDao.save(daySchedule);
    }

    @Override
    public List<ItemDaySchedule> getMyItems( String date, String username) {
        List<DaySchedule> day = userRepo.getMyDay(username, date);
        if (day == null){
            return null;
        }else{
            return getDayByDate(date).getItemList();
        }

    }


}
