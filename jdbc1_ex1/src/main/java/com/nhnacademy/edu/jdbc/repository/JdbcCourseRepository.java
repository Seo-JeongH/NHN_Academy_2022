package com.nhnacademy.edu.jdbc.repository;

import com.nhnacademy.edu.jdbc.domain.Course;
import com.nhnacademy.edu.jdbc.domain.CourseRepository;
import com.nhnacademy.edu.jdbc.domain.Teacher;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import static java.time.LocalTime.now;

public class JdbcCourseRepository implements CourseRepository {

    @Override
    public void insert(Connection connection, Course course) {
//        try (
//                Statement statement = connection.createStatement();
//        ) {
//            statement.executeUpdate(
//                            "INSERT INTO JdbcCourses (id, teacher_id, subject_id, created_at) VALUES (" + course.getId() + ", " + course.getTeacher_id() + ", "
//                                    + course.getSubject_id() + ", '" + now() + "'");
//
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
    }

    @Override
    public List<Course> findAll(Connection connection) {
//        List<Course> courses = new ArrayList<>();
//        try (
//                Statement statement = connection.createStatement();
//        ) {
//            ResultSet rs = statement.executeQuery("SELECT id, teacher_id, subject_id, created_at FROM JdbcCourses");
//
//            while (rs.next()) {
//                courses.add(
//                        new Course(
//                                rs.getLong("id"),
//                                rs.getLong("teacher_id"),
//                                rs.getLong("id"),
//                                rs.getTimestamp("created_at")
//                        )
//                );
//            }
//            return courses;
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
        return null;
    }
}
