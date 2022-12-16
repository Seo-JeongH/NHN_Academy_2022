package com.nhnacademy.edu.jdbc.repository;

import org.apache.commons.dbcp2.BasicDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbUtils {

    private static final DataSource DATASOURCE;

    private DbUtils() {
    }

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(
                    "jdbc:mysql://133.186.211.156:3306/nhn_academy_23",
                    "nhn_academy_23",
                    "o5.WNs/X5Fb*NQ5K");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static DataSource getDataSource() {
        return DATASOURCE;
    }

    static {
        BasicDataSource basicDataSource = new BasicDataSource();
        basicDataSource.setUrl("jdbc:mysql://133.186.211.156:3306/nhn_academy_23");
        basicDataSource.setUsername("nhn_academy_23");
        basicDataSource.setPassword("o5.WNs/X5Fb*NQ5K");
        basicDataSource.setInitialSize(2);
        basicDataSource.setMaxTotal(2);
        basicDataSource.setTestOnBorrow(true);
        basicDataSource.setValidationQuery("select 1");
        basicDataSource.setMaxWaitMillis(1000L);

        DATASOURCE = basicDataSource;
    }

}
