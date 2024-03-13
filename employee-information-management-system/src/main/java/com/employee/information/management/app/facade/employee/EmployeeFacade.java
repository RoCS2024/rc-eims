package com.employee.information.management.app.facade.employee;

import com.employee.information.management.app.model.Employee;

import java.util.List;

public interface EmployeeFacade {
    List<Employee> getAllEmployees() throws RuntimeException;

    Employee getEmployeeByNo(String employee_no) throws RuntimeException;
    boolean updateEmployee(Employee employee);

    //add employee
    boolean addEmployee(Employee employee) throws RuntimeException;
}
