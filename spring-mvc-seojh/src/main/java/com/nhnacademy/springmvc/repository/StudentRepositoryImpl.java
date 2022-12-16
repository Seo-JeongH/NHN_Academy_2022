package com.nhnacademy.springmvc.repository;

import com.nhnacademy.springmvc.domain.Student;
import com.nhnacademy.springmvc.exception.StudentNotFoundException;
import org.springframework.stereotype.Repository;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;

@Repository("studentRepository")
public class StudentRepositoryImpl implements StudentRepository {

    private final Map<Long, Student> students = new HashMap<>();

    @Override
    public boolean exists(long id) {
        return students.containsKey(id);
    }

    @Override
    public Student register(String name, String email, int score, String comment) {
        long id = students.keySet()
                .stream()
                .max(Comparator.comparing(Function.identity()))
                .map(l -> l + 1)
                .orElse(1L);

        Student student = Student.create(name, email, score, comment);
        student.setId(id);

        students.put(id, student);

        return student;
    }

    @Override
    public Student getStudent(long id) {
        return exists(id) ? students.get(id) : null;
    }

    @Override
    public void modify(Student student) {
        Student dbUser = getStudent(student.getId());
        if (Objects.isNull(dbUser)) {
            throw new StudentNotFoundException();
        }

        dbUser.setName(student.getName());
        dbUser.setEmail(student.getEmail());
        dbUser.setScore(student.getScore());
        dbUser.setComment(student.getComment());

    }
}
