package com.nhnacademy.edu.springboot.student.domain;

import com.nhnacademy.edu.springboot.student.model.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class NhnStudentServiceTest {

    @Autowired
    NhnStudentService nhnStudentService;

    @Test
    void testGetStudent() {
        List<Student> students = nhnStudentService.getStudents();

        assertThat(students).hasSize(2);
    }
}