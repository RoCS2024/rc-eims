package com.prefect.system.app.facade;

import com.prefect.system.app.model.Employee;

import java.sql.SQLException;
import java.util.List;

/**
 * Interface defining methods for interacting with employees.
 */
public interface EmployeeFacade  {

/**
 * Retrieves a list of all employees.
 */
    List<Employee> getAllEmployees() throws RuntimeException;

    Employee getEmployeeByNo(String employee_no) throws RuntimeException;
}
