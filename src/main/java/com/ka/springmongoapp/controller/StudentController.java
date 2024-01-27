package com.ka.springmongoapp.controller;

import com.ka.springmongoapp.dto.StudentDto;
import com.ka.springmongoapp.exception.StudentNotFoundException;
import com.ka.springmongoapp.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/students")
public class StudentController {

    private final StudentService service;

    @GetMapping
    public ResponseEntity<List<StudentDto>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{cne}")
    public ResponseEntity<StudentDto> findByCne(@PathVariable String cne) {
        return ResponseEntity.ok(service.findByCne(cne));
    }

    @PostMapping("/add")
    public ResponseEntity<StudentDto> addStudent(@RequestBody StudentDto student) {
            student = service.insertStudent(student);
            return ResponseEntity.status(HttpStatus.CREATED).body(student);
    }

    @PutMapping("/update")
    public ResponseEntity<StudentDto> updateStudent(@RequestBody StudentDto student) {
        return ResponseEntity.ok(service.updateStudent(student));
    }

    @DeleteMapping("/delete/{cne}")
    public ResponseEntity<?> deleteStudent(@PathVariable String cne) {
            service.deleteStudent(cne);
            return ResponseEntity.ok().build();
    }
}
