package com.example.studentdata.controller;

import com.example.studentdata.api.StudentApi;
import com.example.studentdata.model.StudentsDTO;
import com.example.studentdata.service.StudentService;
import com.example.studentdata.utils.OptionalConsumer;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class StudentController implements StudentApi {

    StudentService studentService;

    @Override
    public ResponseEntity<StudentsDTO> getStudents(){
        return new ResponseEntity<>(
                OptionalConsumer.of(studentService::getStudentList)
                        .orElseThrow(RuntimeException::new),
                HttpStatus.OK
        );
    }

}
