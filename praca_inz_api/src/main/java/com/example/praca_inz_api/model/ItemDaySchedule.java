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
    private Integer hour;
    private Integer minute;
    private String comment;

    @DBRef
    private List<Component> itemComponents = new ArrayList<>();

    @DBRef
    private List<Snack> itemSnacks = new ArrayList<>();

    @DBRef
    private List<Meal> itemMeals = new ArrayList<>();
}
