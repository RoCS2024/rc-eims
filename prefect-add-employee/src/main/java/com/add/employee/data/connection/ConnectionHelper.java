package com.add.employee.data.connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionHelper {
    public static final String URL = "jdbc:oracle:thin:@localhost:1521:orcl";
    public static final String ORACLE_DRIVER = "oracle.jdbc.driver.OracleDriver";
    public static final String username = "system";
    public static final String password = "tiger";

    public static Connection getConnection()
    {
        try {
            Class.forName(ORACLE_DRIVER).newInstance();
            return DriverManager.getConnection(URL, username, password);
        } catch (Exception e) {
            throw new RuntimeException("Error connecting to the database", e);
        }
    }
}
