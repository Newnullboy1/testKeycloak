package com.example.studentdata.repository;

import com.example.studentdata.model.entity.Student;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface StudentRepository extends CrudRepository<Student, String> {

    List<Student> findAll();

}
