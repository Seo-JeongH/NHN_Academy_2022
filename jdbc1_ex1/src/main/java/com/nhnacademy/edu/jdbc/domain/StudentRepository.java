package com.nhnacademy.edu.jdbc.domain;
import java.sql.Connection;
import java.util.List;
import java.util.Optional;

public interface StudentRepository {
    Optional<Student> findById(Connection connection, Long id);
    List<Student> findAll(Connection connection);

    int insert(Connection connection, Student student);

    int updateNameById(Connection connection,Long id, String name);
    int deleteById(Connection connection,Long id);
}