package com.nhnacademy.edu.jdbc.domain;

import java.util.List;


public interface SpringStudentRepository {

    Student findById(long id);

    List<Student> findAll();

    int insert(Student student);

    int deleteById(long id);
}
