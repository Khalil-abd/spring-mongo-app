package com.ka.springmongoapp.bootstrap;

import com.ka.springmongoapp.model.Address;
import com.ka.springmongoapp.model.Gender;
import com.ka.springmongoapp.model.Student;
import com.ka.springmongoapp.repository.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Component
public class DataBootstrap implements CommandLineRunner {

    private final StudentRepository repository;

    public DataBootstrap(StudentRepository repository){
        this.repository = repository ;
    }

    @Override
    public void run(String... args) {
        Student student = new Student();
        student.setCne("M1523435");
        student.setFirstName("Assil");
        student.setLastName("Khaled");
        student.setGender(Gender.Male);
        student.setEmail("khaled@gmail.com");
        student.setAddress(new Address("Maroc","20000", "Casablanca"));
        student.setFavoriteSubjects(List.of("Data Science","Programming","Statistics"));
        student.setTotalSpentInBooks(BigDecimal.TEN);
        student.setCreatedAt(LocalDateTime.now());

        repository.findByCne(student.getCne()).ifPresentOrElse(
          s -> System.out.println("Student already exists with same cne"),
          () -> {
              System.out.println("Inserting student...");
              repository.insert(student);
          }
        );

    }
}
