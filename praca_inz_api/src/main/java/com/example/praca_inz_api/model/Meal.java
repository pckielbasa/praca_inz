package com.example.praca_inz_api.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "Meal")
public class Meal {

    @Id
    private String _id;
    @Indexed(unique = true)
    private String mealName;
    private String commentAlertAllergies;
    @Field
    private Boolean favourite;

    @DBRef
    private List<Component> mealComponents = new ArrayList<>();
}
