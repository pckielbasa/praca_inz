package com.example.praca_inz_api.service;

import com.example.praca_inz_api.dao.DayScheduleDao;
import com.example.praca_inz_api.dto.DayScheduleDTO;
import com.example.praca_inz_api.model.Allergies;
import com.example.praca_inz_api.model.DaySchedule;
import com.example.praca_inz_api.model.ItemDaySchedule;
import com.example.praca_inz_api.repository.DayScheduleRepo;
import com.example.praca_inz_api.repository.UserRepo;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

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
        DaySchedule daySchedule1 = dayScheduleDao.findDayScheduleByUsernameAndDayDate(dayScheduleDTO.getUsername(), dayScheduleDTO.getDayDate());
        daySchedule.setUsername(dayScheduleDTO.getUsername());
        daySchedule.setDayDate(dayScheduleDTO.getDayDate());
        return Objects.requireNonNullElseGet(daySchedule1, () -> dayScheduleDao.save(daySchedule));
    }

    @Override
    public DaySchedule addDayScheduleToUser(DayScheduleDTO dayScheduleDTO) {
        DaySchedule daySchedule = createDaySchedule(dayScheduleDTO);
        List<DaySchedule> myList = userRepo.getMyDay(dayScheduleDTO.getUsername(), dayScheduleDTO.getDayDate());
        boolean anyMatch =  myList.stream().anyMatch(item -> item.getDayDate().equals(dayScheduleDTO.getDayDate()));
        if (anyMatch){
            return daySchedule;
        }else {
            userRepo.addDayToCalendar(daySchedule,dayScheduleDTO.getUsername());
            return daySchedule;
        }
    }

    @Override
    public List<ItemDaySchedule> getDaySchedule(String username, String date) {
        DaySchedule daySchedule = dayScheduleDao.findDayScheduleByUsernameAndDayDate(username, date);
        if (daySchedule == null){
            return null;
        }else {
            return daySchedule.getItemList();
        }
    }

    @Override
    public DaySchedule addItemToDay(ItemDaySchedule itemDaySchedule, String date) {
        DaySchedule daySchedule = dayScheduleDao.findDayScheduleByUsernameAndDayDate(itemDaySchedule.getUsername(), date);
        daySchedule.getItemList().add(itemDaySchedule);
        return dayScheduleDao.save(daySchedule);
    }

    @Override
    public DaySchedule deleteItemFromDay(DaySchedule daySchedule, ItemDaySchedule itemDaySchedule) {
        List<ItemDaySchedule> daysItem = daySchedule.getItemList();
        ItemDaySchedule deleteItem = daysItem.stream().filter(item->item.get_id().equals(itemDaySchedule.get_id()))
                .findFirst()
                .orElseThrow(()->new ResourceNotFoundException("No items with id: "+itemDaySchedule.getItemId()));
        daysItem.remove(deleteItem);
        daySchedule.setItemList(daysItem);
        return daySchedule;
    }

}
