package com.prefect.system.data.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Helper class for establishing a connection to the database.
 */
public class ConnectionHelper {
    public static final String URL = "jdbc:oracle:thin:@localhost:1521:rogate";
    public static final String ORACLE_DRIVER = "oracle.jdbc.driver.OracleDriver";
    public static final String USERNAME = "system";
    public static final String PASSWORD = "Changeme0";

/**
 * Retrieves a connection to the database.
 * */
    public static Connection getConnection() throws RuntimeException {
        try {
            Class.forName(ORACLE_DRIVER).newInstance();
            return DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (Exception ex) {
            throw new RuntimeException("Error connecting to the database", ex);
        }
    }
}
