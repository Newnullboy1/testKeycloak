package com.example.studentdata.mapper;

import com.example.studentdata.model.StudentDTO;
import com.example.studentdata.model.entity.Student;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface StudentMapper {

    @Mapping(source = "FName", target = "firstName")
    @Mapping(source = "LName", target = "lastName")
    StudentDTO toStudentDTO(Student student);

    @Mapping(source = "FName", target = "firstName")
    @Mapping(source = "LName", target = "lastName")
    List<StudentDTO> toStudentDTO(List<Student> student);


}
