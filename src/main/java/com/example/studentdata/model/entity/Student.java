package com.example.studentdata.model.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@Table(name = "STUDENT")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Student {

    @Id
    @Column(name = "STUDENT_ID")
    String id;

    @Column(name = "FIRST_NAME")
    String fName;

    @Column(name = "LAST_NAME")
    String lName;

    @Column(name = "DATE_OF_BIRTH")
    String dateOfBirth;

    @Column(name = "LEVEL")
    String level;
}
