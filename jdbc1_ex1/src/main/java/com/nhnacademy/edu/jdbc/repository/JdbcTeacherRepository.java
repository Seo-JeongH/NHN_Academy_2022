package com.nhnacademy.edu.jdbc.repository;

import com.nhnacademy.edu.jdbc.domain.Teacher;
import com.nhnacademy.edu.jdbc.domain.TeacherRepository;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class JdbcTeacherRepository implements TeacherRepository {
    @Override
    public Optional<Teacher> findById(Connection connection,Long id) {
        try (
                Statement statement = connection.createStatement();
        ) {

            ResultSet rs = statement.executeQuery("SELECT id, name, created_at FROM JdbcTeachers  WHERE id=" + id);

            if (rs.next()) {
                return Optional.of(
                        new Teacher(rs.getLong("id"), rs.getString("name"), rs.getTimestamp("created_at"))
                );
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return Optional.empty();
    }

    @Override
    public List<Teacher> findAll(Connection connection) {
        List<Teacher> teacher = new ArrayList<>();
        try (
             Statement statement = connection.createStatement();
        ) {
            ResultSet rs = statement.executeQuery("SELECT id, name, created_at FROM JdbcTeachers");

            while (rs.next()) {
                teacher.add(
                        new Teacher(
                                rs.getLong("id"),
                                rs.getString("name"),
                                rs.getTimestamp("created_at")
                        )
                );
            }
            return teacher;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public int insert(Connection connection, Teacher teacher) {
        try (
             Statement statement = connection.createStatement();
        ) {
            return statement
                    .executeUpdate(
                            "INSERT INTO JdbcTeachers (id, name, created_at) VALUES (" + teacher.getId()
                                    + ", '" + teacher.getName() + "', now())");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int updateNameById(Connection connection, Long id, String name) {
        try (
             Statement statement = connection.createStatement();
        ) {
            return statement
                    .executeUpdate(
                            "UPDATE JdbcTeachers SET name="+name+" WHERE id="+id);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int deleteById(Connection connection, Long id) {
        try (
             Statement statement = connection.createStatement();
        ) {
            return statement
                    .executeUpdate(
                            "DELETE FROM JdbcTeachers WHERE id="+id);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public long count(Connection connection) {
        try (
                Statement statement = connection.createStatement();
        ) {
            ResultSet resultSet = statement.executeQuery("SELECT count(id) FROM JdbcTeachers");
            if (resultSet.next()) {
                return resultSet.getLong(1);
            }
            return 0;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
