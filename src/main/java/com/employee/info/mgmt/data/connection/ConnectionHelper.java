package com.employee.info.mgmt.data.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ConnectionHelper {
    private static final Logger logger = LogManager.getLogger(ConnectionHelper.class);

    /**
     * Database URL
     */
    public static final String URL = "jdbc:oracle:thin:@localhost:1521:rogate";

    /**
     * Oracle JDBC Driver
     */
    public static final String ORACLE_DRIVER = "oracle.jdbc.driver.OracleDriver";

    /**
     * Database username
     */
    public static final String username = "system";

    /**
     * Database password
     */
    public static final String password = "Changeme0";

    /**
     * Establishes a connection to the database.
     *
     * @return Connection object
     * @throws RuntimeException if there is an error connecting to the database
     */
    public static Connection getConnection() {
        try {
            Class.forName(ORACLE_DRIVER).newInstance();
            Connection connection = DriverManager.getConnection(URL, username, password);
            logger.info("Connection established successfully");
            return connection;
        } catch (Exception e) {
            logger.error("Error connecting to the database", e);
            throw new RuntimeException("Error connecting to the database", e);
        }
    }
}