package com.example.praca_inz_api.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "Allergies")
public class Allergies {
    @Id
    private String _id;
    private String username;
    private String allergiesName;
    private String afterTime;
    private String symptoms;
    private String type;
    private String help;
    @DBRef(lazy = true)
    private String allergenId;

}