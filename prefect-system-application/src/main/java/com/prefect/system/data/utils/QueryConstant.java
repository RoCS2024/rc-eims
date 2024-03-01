package com.prefect.system.data.utils;
/**
 * Contains constants for SQL queries related to employee data.
 */
public class QueryConstant {
    private QueryConstant() {
    }

    /**
     * SQL statement to retrieve all employees.
     */
    public static final String GET_ALL_EMPLOYEE_STATEMENT = "SELECT * FROM EMPLOYEE";

    /**
     * SQL statement to retrieve an employee by their employee number.
     * Uses a placeholder (?) for the employee number parameter.
     */
    public static final String GET_EMPLOYEE_BY_EMPLOYEE_NO_STATEMENT = "SELECT * FROM EMPLOYEE WHERE EMPLOYEE_NO = ?";

}
