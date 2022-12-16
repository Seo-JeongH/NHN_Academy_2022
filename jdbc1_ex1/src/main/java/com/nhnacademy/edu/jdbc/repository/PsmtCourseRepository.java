package com.nhnacademy.edu.jdbc.repository;

import com.nhnacademy.edu.jdbc.domain.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PsmtCourseRepository implements CourseRepository {
    @Override
    public void insert(Connection connection, Course course) {

    }

    @Override
    public List<Course> findAll(Connection connection) {

//        String sql = "SELECT c.id as c_id, c.teacher_id, c.subject_id, c.created_at as c_created_at, \n" +
//                " s.id as s_id, s.name as s_name, s.created_at as s_created_at, \n" +
//                " t.id as t.name"

        List<Course> courses = new ArrayList<>();
        try (
                PreparedStatement statement
                        = connection.prepareStatement("SELECT id, course, student, score, created_at FROM JdbcRegistrations");
                ResultSet rs = statement.executeQuery();
        ) {

            while (rs.next()) {
                courses.add(
                        new Course(
                                rs.getLong("id"),
                                (Subject) rs.getObject("subject"),
                                (Teacher) rs.getObject("teacher"),
                        rs.getTimestamp("created_at")
                        )
                );
            }
            return courses;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
