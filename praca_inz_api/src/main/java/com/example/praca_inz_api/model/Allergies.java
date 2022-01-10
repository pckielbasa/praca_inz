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
@Document(collection = "Allergies")
public class Allergies {
    @Id
    private String _id;

    private String nameAllergy;

    @DBRef
    private List<Food> allergiesFood = new ArrayList<>();

    @DBRef
    private List<Contact> allergiesFoodContact = new ArrayList<>();


}