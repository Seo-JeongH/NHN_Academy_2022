package com.nhnacademy.edu.jdbc.domain;

import java.util.List;

public interface SpringTeacherRepository {

    Teacher findById(long id);



    List<Teacher> findAll();
    List<Teacher> findHi();

    int insert(Teacher teacher);

    int deleteById(long id);
}
