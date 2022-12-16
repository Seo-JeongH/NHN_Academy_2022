package com.nhnacademy.edu.jdbc;

import com.nhnacademy.edu.jdbc.domain.Registration;
import com.nhnacademy.edu.jdbc.domain.RegistrationRepository;
import com.nhnacademy.edu.jdbc.repository.DbUtils;
import com.nhnacademy.edu.jdbc.repository.PsmtRegistrationRepository;

import java.sql.Connection;
import java.sql.SQLException;

public class RegistrationMain {
    public static void main(String[] args) throws SQLException {
        try (Connection connection = DbUtils.getDataSource().getConnection()) {

            RegistrationRepository registrationRepository = new PsmtRegistrationRepository();
            registrationRepository.findAll(connection)
                    .stream()
                    .map(Registration::toFormattedString)
                    .forEach(System.out::println);

        }
    }

}

//    Registration{id=1, course_teacher_name=만티,
//            course_subject_name=JDBC를 이용한 애플리케이션개발,
//            student_name=학생1, score=0, created_at=2022-11-21 16:34:36.0}