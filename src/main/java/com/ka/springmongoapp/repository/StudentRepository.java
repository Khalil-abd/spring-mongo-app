package com.ka.springmongoapp.repository;

import com.ka.springmongoapp.model.Student;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface StudentRepository extends MongoRepository<Student, String> {
    public Optional<Student> findByCne(String cne);
}
