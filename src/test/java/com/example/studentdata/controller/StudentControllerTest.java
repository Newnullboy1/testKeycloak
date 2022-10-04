package com.example.studentdata.controller;

import com.example.studentdata.UtilsTestData;
import com.example.studentdata.model.StudentDTO;
import com.example.studentdata.model.StudentsDTO;
import com.example.studentdata.service.StudentService;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@FieldDefaults(level = AccessLevel.PRIVATE)
class StudentControllerTest {

    @Autowired
    TestRestTemplate testRestTemplate;

    @Autowired
    UtilsTestData utilsTestData;

    @MockBean
    StudentService studentService;

    @Test
    @DisplayName("call endpoint /student should get student list size = 2 as StudentsDTO")
    void getStudents() {

        StudentsDTO studentsDTO = utilsTestData.genStudentsData();

        when(studentService.getStudentList()).thenReturn(studentsDTO);

        ResponseEntity<StudentsDTO> result = testRestTemplate.getForEntity("/student",StudentsDTO.class);
        assertEquals(2, Objects.requireNonNull(result.getBody()).getStudents().size());
    }

}