package com.example.praca_inz_api.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Meal implements Serializable {

    @Id
    private String _id;
    private String mealName;
    private String commentAlertAllergies;
    private String type = "meal";
    private Boolean favourite;

    @DBRef
    private List<Component> mealComponents = new ArrayList<>();
}
