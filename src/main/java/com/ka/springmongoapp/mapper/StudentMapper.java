package com.ka.springmongoapp.mapper;

import com.ka.springmongoapp.dto.StudentDto;
import com.ka.springmongoapp.model.Student;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface StudentMapper {

    StudentDto fromStudent(Student student);
    Student fromStudentDto(StudentDto studentDto);
    Student updateStudentFromDto(StudentDto dto, @MappingTarget Student student);
}
