package com.example.studentdata.service.impl;

import com.example.studentdata.UtilsTestData;
import com.example.studentdata.mapper.StudentMapper;
import com.example.studentdata.mapper.StudentMapperImpl;
import com.example.studentdata.model.StudentsDTO;
import com.example.studentdata.model.entity.Student;
import com.example.studentdata.repository.StudentRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class StudentServiceImplTest {

    @InjectMocks
    StudentServiceImpl studentService;

    @Mock
    StudentRepository studentRepository;

    StudentMapper studentMapper = spy(StudentMapperImpl.class);

    @Test
    @DisplayName("when call method getStudent should return Student list size = 2 as StudentsDTO")
    void getStudentList() {

        List<Student> students = UtilsTestData.genStudentList();

        when(studentRepository.findAll()).thenReturn(students);
        when(studentMapper.toStudentDTO(anyList())).thenCallRealMethod();

        StudentsDTO result = studentService.getStudentList();
        assertEquals(2,result.getStudents().size());

    }
}