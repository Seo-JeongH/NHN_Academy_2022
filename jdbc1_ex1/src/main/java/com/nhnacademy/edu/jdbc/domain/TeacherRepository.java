package com.nhnacademy.edu.jdbc.domain;

import java.sql.Connection;
import java.util.List;
import java.util.Optional;

public interface TeacherRepository {
    Optional<Teacher> findById(Connection connection, Long id);
    List<Teacher> findAll(Connection connection);

    int insert(Connection connection,Teacher teacher);

    int updateNameById(Connection connection,Long id, String name);
    int deleteById(Connection connection,Long id);
}
