package com.example.praca_inz_api.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "Food")
public class Food {
    @Id
    private String _id;
    private String username;
    private String foodName;
    private String composition;
    private String type;
    private Boolean favourite;

}
