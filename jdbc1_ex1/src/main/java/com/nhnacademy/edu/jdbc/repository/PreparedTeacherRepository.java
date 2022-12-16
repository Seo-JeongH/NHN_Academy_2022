package com.nhnacademy.edu.jdbc.repository;

import com.nhnacademy.edu.jdbc.domain.Teacher;
import com.nhnacademy.edu.jdbc.domain.TeacherRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PreparedTeacherRepository implements TeacherRepository {
    @Override
    public Optional<Teacher> findById(Connection connection,Long id) {
        try (
                PreparedStatement statement = connection.prepareStatement("SELECT id, name, created_at FROM JdbcTeachers  WHERE id=?");
        ) {

            statement.setLong(1, id);

            ResultSet rs = statement.executeQuery();

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
        List<Teacher> teachers = new ArrayList<>();
        try (
             PreparedStatement statement
                     = connection.prepareStatement("SELECT id, name, created_at FROM JdbcTeachers");
             ResultSet rs = statement.executeQuery();
        ) {

            while (rs.next()) {
                teachers.add(
                        new Teacher(
                                rs.getLong("id"),
                                rs.getString("name"),
                                rs.getTimestamp("created_at")
                        )
                );
            }
            return teachers;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int insert(Connection connection, Teacher teacher) {
        try (
             PreparedStatement statement = connection.prepareStatement("INSERT INTO JdbcTeachers (id, name, created_at) VALUES (?,?,?)");
        ) {
            statement.setLong(1, teacher.getId());
            statement.setString(2, teacher.getName());
            statement.setTimestamp(3, new Timestamp(new java.util.Date().getTime()));
            return statement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int updateNameById(Connection connection, Long id, String name) {
        try (
             PreparedStatement statement = connection.prepareStatement("UPDATE JdbcTeachers SET name=? WHERE id=?");
        ) {
            statement.setString(1, name);
            statement.setLong(2, id);
            return statement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int deleteById(Connection connection, Long id) {
        try (
             PreparedStatement statement = connection.prepareStatement("DELETE FROM JdbcTeachers WHERE id=?");
        ) {
            statement.setLong(1, id);
            return statement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
