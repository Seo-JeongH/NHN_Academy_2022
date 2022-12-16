package com.nhnacademy.edu.jdbc.service;

import com.nhnacademy.edu.jdbc.domain.SpringStudentRepository;
import com.nhnacademy.edu.jdbc.domain.Student;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class JdbcTemplateStudentService implements StudentService {
    private final SpringStudentRepository springstudentRepository;


    public JdbcTemplateStudentService(SpringStudentRepository springstudentRepository) {
        this.springstudentRepository = springstudentRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public Student getStudent(long id) {
        return springstudentRepository.findById(id);
    }

    @Override
    public List<Student> getAllStudents() {
        return springstudentRepository.findAll();
    }

    @Override
    @Transactional
    public void insertAndDelete(Student student) {
        springstudentRepository.insert(student);
        if (student.getId() == 10L) {
            throw new RuntimeException("intended error!!");
        }
        springstudentRepository.deleteById(student.getId());
    }

    @Override
    public void insertAndDeleteWithoutTransaction(Student student) {
        springstudentRepository.insert(student);
        if (student.getId() == 10L) {
            throw new RuntimeException("intended error!!");
        }
        springstudentRepository.deleteById(student.getId());
    }
}
