package com.example.praca_inz_api.converter;

import com.example.praca_inz_api.dto.AddItemDayDTO;
import com.example.praca_inz_api.dto.ItemDayDTO;
import com.example.praca_inz_api.dto.ItemsListDTO;
import com.example.praca_inz_api.model.ItemDaySchedule;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class ItemDayConverterTest {

    @Test
    public void toDTO() {
        ItemDaySchedule itemDaySchedule = new ItemDaySchedule();
        itemDaySchedule.setItemId("ibg893iaqtbafsd09hga0i");

        ItemDayDTO itemDayDTO = ItemDayConverter.toDTO(itemDaySchedule);

        Assert.assertEquals(itemDayDTO.getItemId(), itemDaySchedule.getItemId());
    }

    @Test
    public void toAddDTO() {
        ItemDaySchedule itemDaySchedule = new ItemDaySchedule();
        itemDaySchedule.setItemId("ibg893iaqtbafsd09hga0i");

        AddItemDayDTO addItemDayDTO = ItemDayConverter.toAddDTO(itemDaySchedule);

        Assert.assertEquals(addItemDayDTO.getItemId(), itemDaySchedule.getItemId());
    }

    @Test
    public void toListDTO() {
        ItemDaySchedule itemDaySchedule = new ItemDaySchedule();
        itemDaySchedule.setItemId("ibg893iaqtbafsd09hga0i");

        ItemsListDTO itemsListDTO = ItemDayConverter.toListDTO(itemDaySchedule);

        Assert.assertEquals(itemsListDTO.getItemId(), itemDaySchedule.getItemId());
    }
}