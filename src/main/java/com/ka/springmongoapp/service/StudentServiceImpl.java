package com.ka.springmongoapp.service;

import com.ka.springmongoapp.dto.StudentDto;
import com.ka.springmongoapp.exception.DuplicatedCneException;
import com.ka.springmongoapp.exception.StudentNotFoundException;
import com.ka.springmongoapp.mapper.StudentMapper;
import com.ka.springmongoapp.model.Student;
import com.ka.springmongoapp.repository.StudentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
@AllArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository repository;
    private final StudentMapper mapper;

    @Override
    public List<StudentDto> findAll() {
        return repository.findAll().stream()
                .map(mapper::fromStudent)
                .collect(Collectors.toList());
    }

    @Override
    public StudentDto insertStudent(StudentDto student) {
        try {
            Student entity = mapper.fromStudentDto(student);
            return mapper.fromStudent(repository.save(entity));
        } catch (Exception e) {
            throw new DuplicatedCneException(student.cne());
        }
    }

    @Override
    public StudentDto updateStudent(StudentDto student) {
        Student entity = repository.findByCne(student.cne()).orElseThrow(() -> new StudentNotFoundException(student.cne()));
        entity = mapper.updateStudentFromDto(student, entity);
        return mapper.fromStudent(repository.save(entity));
    }

    @Override
    public StudentDto findByCne(String cne) {
        return repository.findByCne(cne)
                .map(mapper::fromStudent)
                .orElseThrow(() -> new StudentNotFoundException(cne));
    }

    @Override
    public void deleteStudent(String cne) {
        Student entity = repository.findByCne(cne).orElseThrow(() -> new StudentNotFoundException(cne));
        repository.delete(entity);
    }
}
