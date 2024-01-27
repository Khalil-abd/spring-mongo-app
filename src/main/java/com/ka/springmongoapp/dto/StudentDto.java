package com.ka.springmongoapp.dto;

import com.ka.springmongoapp.model.Address;
import com.ka.springmongoapp.model.Gender;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public record StudentDto(
        String firstName,
        String lastName,
        String cne,
        String email,
        Gender gender,
        Address address,
        List<String> favoriteSubjects,
        BigDecimal totalSpentInBooks,
        LocalDateTime createdAt
) {}