package com.nhnacademy.edu.jdbc.service;

import com.nhnacademy.edu.jdbc.domain.SpringTeacherRepository;
import com.nhnacademy.edu.jdbc.domain.Teacher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class JdbcTemplateTeacherService implements TeacherService {

    private final SpringTeacherRepository springTeacherRepository;

    public JdbcTemplateTeacherService(SpringTeacherRepository springTeacherRepository) {
        this.springTeacherRepository = springTeacherRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public Teacher getTeacher(long id) {
        return springTeacherRepository.findById(id);
    }

    @Override
    public List<Teacher> getTest() {
        return springTeacherRepository.findHi();
    }

    @Override
    public List<Teacher> getAllTeachers() {
        return springTeacherRepository.findAll();
    }

    @Override
    @Transactional
    public void insertAndDelete(Teacher teacher) {
        springTeacherRepository.insert(teacher);
        System.out.println(teacher);

        springTeacherRepository.deleteById(teacher.getId());
    }

    @Override
    public void insertAndDeleteWithoutTransaction(Teacher teacher) {
        springTeacherRepository.insert(teacher);

        springTeacherRepository.deleteById(teacher.getId());
    }
}
