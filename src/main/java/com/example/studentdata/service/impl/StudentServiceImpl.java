package com.example.studentdata.service.impl;

import com.example.studentdata.mapper.StudentMapper;
import com.example.studentdata.model.StudentsDTO;
import com.example.studentdata.repository.StudentRepository;
import com.example.studentdata.service.StudentService;
import com.example.studentdata.utils.OptionalConsumer;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class StudentServiceImpl implements StudentService {

    StudentRepository studentRepository;

    StudentMapper studentMapper;

    @Override
    public StudentsDTO getStudentList() {

        return OptionalConsumer.of(studentRepository::findAll)
                .map(studentMapper::toStudentDTO)
                .map(new StudentsDTO()::students)
                .get();
    }

}
