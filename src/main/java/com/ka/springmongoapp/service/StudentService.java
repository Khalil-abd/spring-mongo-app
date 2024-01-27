package com.ka.springmongoapp.service;

import com.ka.springmongoapp.dto.StudentDto;
import com.ka.springmongoapp.exception.DuplicatedCneException;

import java.util.List;
import java.util.NoSuchElementException;

public interface StudentService {

    List<StudentDto> findAll();
    StudentDto insertStudent(StudentDto student) throws DuplicatedCneException;
    StudentDto updateStudent(StudentDto student) throws NoSuchElementException;
    StudentDto findByCne(String cne) throws NoSuchElementException;
    void deleteStudent(String cne) throws NoSuchElementException;
}
