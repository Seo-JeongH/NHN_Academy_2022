package com.nhnacademy.edu.jdbc.service;

import com.nhnacademy.edu.jdbc.domain.Student;
import com.nhnacademy.edu.jdbc.domain.Teacher;

import java.util.List;

public interface TeacherService {
    Teacher getTeacher(long id);

    List<Teacher> getTest();

    List<Teacher> getAllTeachers();

    void insertAndDelete(Teacher teacher);

    void insertAndDeleteWithoutTransaction(Teacher teacher);
}
