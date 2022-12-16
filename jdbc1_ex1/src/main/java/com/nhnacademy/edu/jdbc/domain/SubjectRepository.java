package com.nhnacademy.edu.jdbc.domain;

import java.sql.Connection;
import java.util.List;

public interface SubjectRepository {
    void insert(Connection connection, Subject subject);

    List<Subject> findAll(Connection connection);
}
