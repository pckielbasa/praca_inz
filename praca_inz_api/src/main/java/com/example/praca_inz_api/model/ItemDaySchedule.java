package com.example.praca_inz_api.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "ItemDaySchedule")
public class ItemDaySchedule {
    @Id
    private String _id;
    private String dayDate;
    private String username;
    private String hour;
    private String minute;

    @DBRef
    private List<Food> itemDayFood = new ArrayList<>();

    @DBRef
    private List<Contact> itemDayContact = new ArrayList<>();



}
