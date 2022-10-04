package com.example.studentdata;

import com.example.studentdata.model.StudentDTO;
import com.example.studentdata.model.StudentsDTO;
import com.example.studentdata.model.entity.Student;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UtilsTestData {

    public StudentsDTO genStudentsData(){

        StudentsDTO studentsDTO = new StudentsDTO();

        for (int i = 0; i < 2; i++) {

            String idNumber = "";

            for (int j = 0; j < 5 - Integer.toString(i).length(); j++) {
                idNumber = idNumber.concat("0");
            }

            idNumber = idNumber.concat(Integer.toString(i));

            StudentDTO studentDTO = new StudentDTO();
            studentDTO.setFirstName("Test".concat(idNumber));
            studentDTO.setLastName("Tester".concat(idNumber));
            studentDTO.setId("202201".concat(idNumber));

            studentsDTO.addStudentsItem(studentDTO);
        }

        return studentsDTO;
    }

    public List<Student> genStudentList(){
        List<Student> students = new ArrayList<>();

        for (int i = 0; i < 2; i++) {
            Student student = new Student();
            student.setId("0000".concat(Integer.toString(i)));
            students.add(student);
        }
        return students;
    }

}
