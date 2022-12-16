package com.nhnacademy.edu.jdbc.domain;

import java.sql.Connection;
import java.util.List;

public interface CourseRepository {
    void insert(Connection connection, Course course);

    List<Course> findAll(Connection connection);
}
