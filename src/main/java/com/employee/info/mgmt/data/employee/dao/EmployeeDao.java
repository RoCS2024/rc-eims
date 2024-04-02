package com.employee.info.mgmt.data.employee.dao;

import com.employee.info.mgmt.appl.model.Employee;

import java.util.List;

/**
 * The EmployeeDao interface manages employee data.
 */
public interface EmployeeDao {

    /**
     * Retrieves all employees.
     *
     * @return a List of all employees
     */
    List<Employee> getAllEmployees();

    /**
     * Retrieves an employee by ID.
     */
    Employee getEmployeeById(String id);

    /**
     * Adds a new employee.
     */
    boolean addEmployee(Employee employee);

    /**
     * Updates an employee.
     */
    boolean updateEmployee(Employee employee);
}

