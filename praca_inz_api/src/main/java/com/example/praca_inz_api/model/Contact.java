package com.example.praca_inz_api.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "Contact")
public class Contact {
    @Id
    private String _id;
    private String username;
    private String contactName;
    private String possibleAllergen;
    private String type;
    private Boolean favourite;
}
