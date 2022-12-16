package com.nhnacademy.edu.jdbc;

import com.nhnacademy.edu.jdbc.repository.DbUtils;
import com.nhnacademy.edu.jdbc.repository.JdbcTeacherRepository;

import java.sql.Connection;
import java.sql.SQLException;

public class DBLoad {

    public static void main(String[] args) throws SQLException {
        loadDriver();
        Connection connection = DbUtils.getDataSource().getConnection();
        System.out.println("Success");

        JdbcTeacherRepository jdbcTeacherRepository = new JdbcTeacherRepository();
        System.out.println(jdbcTeacherRepository.findAll(connection));
    }

    private static void loadDriver() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
