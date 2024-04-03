package com.employee.info.mgmt.appl.facade.employee;

import com.employee.info.mgmt.appl.model.Employee;

import java.util.List;

    /**
    * This is an interface to the Employee Facade
    */
public interface EmployeeFacade {

    /**
     * This gets all of the Employees from the database.
     *
     * @return list of all employees.
     */
    List<Employee> getAllEmployees();


    /**
     * This gets an Employee from the database using their recorded ID in the database.
     * @param id is the ID of the Employees.
     * @return the Employee.
     */
    Employee getEmployeeById(String id);


    /**
     * This adds an Employee to the database.
     *
     * @param employee is the employee to add.
     * @return true if the adding of the Employee is successful.
     */
    boolean addEmployee(Employee employee);


    /**
     * This updates an Employee information in the ddtabase.
     *
     * @param employee is the employee to update.
     * @return true if the updating of Employee information is successful.
     */
    boolean updateEmployee(Employee employee);
}