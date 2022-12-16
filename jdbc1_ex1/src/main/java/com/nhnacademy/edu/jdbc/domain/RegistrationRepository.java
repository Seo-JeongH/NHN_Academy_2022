package com.nhnacademy.edu.jdbc.domain;

import java.sql.Connection;
import java.util.List;

public interface RegistrationRepository {

    List<Registration> findAll(Connection connection);

}