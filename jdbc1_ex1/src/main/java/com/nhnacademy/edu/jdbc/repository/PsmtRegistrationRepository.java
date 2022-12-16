package com.nhnacademy.edu.jdbc.repository;

import com.nhnacademy.edu.jdbc.domain.*;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PsmtRegistrationRepository implements RegistrationRepository {
    @Override
    public List<Registration> findAll(Connection connection) {
        String sql = "SELECT r.id as r_id, r.score as r_score, r.created_at as r_created_at, \n" +
                "c.id as c_id, c.teacher_id, c.subject_id, c.created_at as c_created_at, \n" +
                "s.id as s_id, s.name as s_name, s.created_at as s_created_at, \n" +
                "st.id as st_id, st.name as st_name, st.created_at as st_created_at, \n" +
                "t.id as t_id, t.name as t_name, t.created_at as t_created_at \n" +
                "FROM JdbcRegistrations as r" +
                "INNER JOIN JdbcCourses as c ON r.course_id = c.id \n" +
                "INNER JOIN JdbcStudents as st ON r.student_id = st.id \n" +
                "INNER JOIN JdbcSubjects as s ON c.subject_id = s.id \n" +
                "INNER JOIN JdbcTeachers as t ON c.teacher_id = t.id ;";

        List<Registration> registrations = new ArrayList<>();
        try (
                PreparedStatement statement
                        = connection.prepareStatement(sql);
                ResultSet rs = statement.executeQuery();
        ) {

            while (rs.next()) {
                Subject subject = new Subject(rs.getLong("s_id"),
                        rs.getString("s_name"),
                        rs.getTimestamp("s_created_at")
                );
                Teacher teacher = new Teacher(rs.getLong("t_id"),
                        rs.getString("t_name"),
                        rs.getTimestamp("t_created_at")
                );
                Course course = new Course(rs.getLong("c_id"),
                        subject,
                        teacher,
                        rs.getTimestamp("c.created_at"));
                Student student = new Student(rs.getLong("s_id"),
                        rs.getString("s_name"),
                        rs.getTimestamp("s_created_at")
                );

                registrations.add(
                        new Registration(
                                
                                rs.getLong("r.id"),
                                course,
                                student,
                                rs.getLong("r.score"),
                                rs.getTimestamp("r.created_at")
                        )
                );
            }
            return registrations;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
