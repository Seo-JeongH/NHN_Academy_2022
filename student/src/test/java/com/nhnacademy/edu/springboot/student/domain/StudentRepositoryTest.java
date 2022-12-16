package com.nhnacademy.edu.springboot.student.domain;


import com.nhnacademy.edu.springboot.student.model.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class StudentRepositoryTest {

    @Autowired
    StudentRepository studentRepository;

    @Test
    void testStudentRepository() throws Exception {
        Student hi = new Student(1L, "HI", 1);
        studentRepository.save(hi);

        Optional<Student> actual = studentRepository.findById(1L);

        assertThat(actual).isPresent();
        assertThat(actual).isEqualTo(hi);
    }
}