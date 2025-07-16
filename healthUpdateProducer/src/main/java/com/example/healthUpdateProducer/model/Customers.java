package com.example.healthUpdateProducer.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "customers")
public class Customers {
    @Id
    private Integer id;
    private String firstName;
    private String lastName;
    private String email;
    private String dateOfBirth;
    private String address;
}

