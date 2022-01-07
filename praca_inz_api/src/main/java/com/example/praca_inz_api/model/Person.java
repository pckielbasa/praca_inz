package com.example.praca_inz_api.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "Person")
public class Person {

    @Id
    private String _id;
    private String personName;
    private String personSurname;
    private String dateOfBirth;
    private String imgURL;

    @DBRef
    private List<Meal> personAllergies = new ArrayList<>();

    @DBRef
    private List<DaySchedule> personSchedules = new ArrayList<>();
}
