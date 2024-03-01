package com.update.data.utils;

public class QueryConstant {
    private QueryConstant() {
    }

    public static final String GET_ALL_EMPLOYEE_STATEMENT = "SELECT * FROM EMPLOYEE";
    public static final String GET_EMPLOYEE_BY_EMPLOYEE_ID_STATEMENT = "SELECT * FROM EMPLOYEE WHERE EMPLOYEE_ID = ?";
}
