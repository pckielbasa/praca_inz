package com.example.praca_inz_api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ItemDayDTO {
    private String _id;
    private String dayDate;
    private String username;
    private String time;
    private String itemId;
    private String itemName;
    private String itemCompo;
    private String type;

}
