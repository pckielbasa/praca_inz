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
    private Date dateOfBirth;

    @DBRef
    private List<Meal> mealAllergies = new ArrayList<>();

    @DBRef
    private List<Component> componentAllergies = new ArrayList<>();

    @DBRef
    private List<Snack> snackAllergies = new ArrayList<>();

    @DBRef
    private List<Medicine> personMedicines = new ArrayList<>();

    @DBRef
    private List<DaySchedule> personSchedules = new ArrayList<>();
}
