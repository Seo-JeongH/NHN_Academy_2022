package com.nhnacademy.edu.jdbc;

import com.nhnacademy.edu.jdbc.domain.Course;
import com.nhnacademy.edu.jdbc.domain.Subject;
import com.nhnacademy.edu.jdbc.domain.Teacher;
import com.nhnacademy.edu.jdbc.domain.TeacherRepository;
import com.nhnacademy.edu.jdbc.repository.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Optional;

import static java.time.LocalTime.now;

public class Main {
    public static void main(String[] args) throws Exception{
        Main main = new Main();
        //main.loadDriver();

        Connection connection = DbUtils.getDataSource().getConnection();
//        connection(connection);
//        TeacherRepository teacherRepository = new PreparedTeacherRepository();


        System.out.println("===============> Prepared!!");
        JdbcTeacherRepository teacherRepository = new JdbcTeacherRepository();
        System.out.println(teacherRepository.count(connection));
//
//        System.out.println("==> findAll()");
//        teacherRepository.findAll(connection)
//                .forEach(System.out::println);

//        System.out.println("==> findById(1L)");
//        Optional<Teacher> teacher = teacherRepository.findById(connection, 1L);
//        teacher.ifPresent(System.out::println);
//
//
//
//        int insertedCount = teacherRepository.insert(connection, new Teacher(4L, "선생님5", null));
//        System.out.println("inserted count : "+insertedCount);
//
//        System.out.println("==> findAll()");
//        teacherRepository.findAll(connection)
//                .forEach(System.out::println);
//
//
//
//        int updateCount = teacherRepository.updateNameById(connection, 4L, "선생님4");
//        System.out.println("updated count : "+updateCount);
//
//        System.out.println("==> findAll()");
//        teacherRepository.findAll(connection)
//                .forEach(System.out::println);
//
//
//
//        int deletedCount = teacherRepository.deleteById(connection, 4L);
//        System.out.println("deleted count : "+deletedCount);
//
//        System.out.println("==> findAll()");
//        teacherRepository.findAll(connection)
//                .forEach(System.out::println);

    }

    private void loadDriver() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private static Connection getConnection() {
        try {
            return DriverManager.getConnection("jdbc:mysql://133.186.211.156:3306/nhn_academy_23",
                    "nhn_academy_23",
                    "o5.WNs/X5Fb*NQ5K");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    private static void connection(Connection connection) throws SQLException {
        try {
            connection.setAutoCommit(false);
            Statement stmt = connection.createStatement();

            JdbcTeacherRepository jdbcTeacherRepository = new JdbcTeacherRepository();
            jdbcTeacherRepository.insert(connection,new Teacher(4, "콤틴", null));

//            JdbcSubjectRepository jdbcSubjectRepository = new JdbcSubjectRepository();
//            jdbcSubjectRepository.insert(connection, new Subject(5, "HTML", null));
//
//            JdbcCourseRepository jdbcCourseRepository = new JdbcCourseRepository();
//            jdbcCourseRepository.insert(connection, new Course(2, 4, 5, null));

            //만약 에러가 없다면 COMMIT 하게 됩니다.
            connection.commit();
        } catch (Exception e) {
            // Exception 이 발생하면 ROLLBACK 됩니다.
            connection.rollback();
        } finally {
            connection.close();
        }
    }

}