package com.nhnacademy.edu.jdbc.repository;

import com.nhnacademy.edu.jdbc.domain.Course;
import com.nhnacademy.edu.jdbc.domain.Subject;
import com.nhnacademy.edu.jdbc.domain.SubjectRepository;
import com.nhnacademy.edu.jdbc.domain.Teacher;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class JdbcSubjectRepository implements SubjectRepository {
    @Override
    public void insert(Connection connection, Subject subject) {
        try (
                Statement statement = connection.createStatement();
        ) {
            statement.executeUpdate(
                            "INSERT INTO JdbcSubjects (id, name, created_at) VALUES (" + subject.getId()
                                    + ", '" + subject.getName() + "', now())");
            System.out.println("subject insert");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Subject> findAll(Connection connection) {
        List<Subject> subjects = new ArrayList<>();
        try (
                Statement statement = connection.createStatement();
        ) {
            ResultSet rs = statement.executeQuery("SELECT id, name, created_at FROM JdbcSubjects");

            while (rs.next()) {
                subjects.add(
                        new Subject(
                                rs.getLong("id"),
                                rs.getString("name"),
                                rs.getTimestamp("created_at")
                        )
                );
            }
            return subjects;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
