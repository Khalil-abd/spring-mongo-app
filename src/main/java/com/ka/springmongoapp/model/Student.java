package com.ka.springmongoapp.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Document
public class Student {
    @Id
    private String id;
    private String firstName;
    private String lastName;
    @Indexed(unique = true)
    private String cne;
    private String email;
    private Gender gender;
    private Address address;

    private List<String> favoriteSubjects;
    private BigDecimal totalSpentInBooks;

    private LocalDateTime createdAt;
}
