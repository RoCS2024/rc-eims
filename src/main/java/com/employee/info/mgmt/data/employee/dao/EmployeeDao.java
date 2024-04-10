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
     *
     * @param id the ID of the employee to retrieve
     * @return the Employee object to the given ID, or null if not found
     */
    Employee getEmployeeById(String id);

    /**
     * Adds a new employee.
     *
     * @param employee the Employee object to add
     * @return true if the employee is added, false if not
     */
    boolean addEmployee(Employee employee);

    /**
     * Updates an employee.
     *
     * @param employee the Employee object to update
     * @return true if the employee is updated, false if not
     */
    boolean updateEmployee(Employee employee);
}
