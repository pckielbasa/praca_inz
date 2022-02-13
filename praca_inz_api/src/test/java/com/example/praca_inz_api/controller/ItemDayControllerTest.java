package com.example.praca_inz_api.controller;

import com.example.praca_inz_api.converter.ItemDayConverter;
import com.example.praca_inz_api.dto.ItemDayDTO;
import com.example.praca_inz_api.model.ItemDaySchedule;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;


class ItemDayControllerTest {

    @Test
    void addItemToDay() {
        ItemDayController itemDayController = mock(ItemDayController.class);
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

        Assertions.assertEquals(itemDaySchedule.getItemId(),"6208299a5adf15753a523f34");
    }

}