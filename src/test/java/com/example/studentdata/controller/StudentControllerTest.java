//package com.example.studentdata.controller;
//
//import com.example.studentdata.UtilsTestData;
//import com.example.studentdata.model.StudentDTO;
//import com.example.studentdata.model.StudentsDTO;
//import com.example.studentdata.service.StudentService;
//import lombok.AccessLevel;
//import lombok.experimental.FieldDefaults;
//import lombok.extern.slf4j.Slf4j;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.boot.test.web.client.TestRestTemplate;
//import org.springframework.http.ResponseEntity;
//
//import java.util.Objects;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.mockito.Mockito.when;
//
//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//@FieldDefaults(level = AccessLevel.PRIVATE)
//@Slf4j
//class StudentControllerTest {
//
//    @Autowired
//    TestRestTemplate testRestTemplate;
//
//    @MockBean
//    StudentService studentService;
//
//    @Test
//    @DisplayName("call endpoint /student should get student list size = 2 as StudentsDTO")
//    void getStudents() {
//
//        StudentsDTO studentsDTO = UtilsTestData.genStudentsData();
//
//        when(studentService.getStudentList()).thenReturn(studentsDTO);
//
//        ResponseEntity<StudentsDTO> result = testRestTemplate.getForEntity("/student",StudentsDTO.class);
//        log.info("{}",result.getBody());
////        assertEquals(2, result.getBody().getStudents().size());
//    }
//
//}