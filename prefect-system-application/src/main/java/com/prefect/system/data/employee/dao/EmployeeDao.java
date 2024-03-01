package com.prefect.system.data.employee.dao;

import com.prefect.system.app.model.Employee;

import java.sql.SQLException;
import java.util.List;

/**
 * Interface for accessing and manipulating Employee data in the database.
 */
public interface EmployeeDao {

    /**
     * Retrieves all employees from the database.
     */
    List<Employee> getAllEmployee() throws RuntimeException;

    /**
     * Retrieves an employee by their employee number.
     **/
    Employee getEmployeeByNo(String employee_no) throws RuntimeException;


}
