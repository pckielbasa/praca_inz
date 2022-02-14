package com.example.praca_inz_api.controller;

import com.example.praca_inz_api.converter.ItemDayConverter;
import com.example.praca_inz_api.dto.ItemDayDTO;
import com.example.praca_inz_api.model.DaySchedule;
import com.example.praca_inz_api.model.ItemDaySchedule;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;


class ItemDayControllerTest {

    @Test
    void addItemToDay() {
        ItemDayController itemDayController = mock(ItemDayController.class);
        List<DaySchedule> daysList = new ArrayList<>();
        DaySchedule daySchedule = new DaySchedule();
        daySchedule.setDayDate("21/12/2022");
        daysList.add(daySchedule);

        ItemDaySchedule itemDaySchedule = new ItemDaySchedule(
                "6208299a5adf15753afs33fd4",
                "21/12/2022",
                "aqPxpvWbRxSmTRgs9JoPovjxETn2",
                "2 hour",
                "6208299a5adf15753a523f34",
                "Meal",
                "component",
                "Meal" );

        given(itemDayController.addItemToDay(Mockito.any(ItemDayDTO.class)))
                .willReturn( ItemDayConverter.toAddDTO(itemDaySchedule));
        Assertions.assertEquals(daySchedule.getDayDate(),"21/12/2022");
    }

}