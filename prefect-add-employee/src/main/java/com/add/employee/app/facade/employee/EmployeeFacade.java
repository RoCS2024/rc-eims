package com.add.employee.app.facade.employee;

import com.add.employee.app.model.employee.Employee;

import java.util.List;

public interface EmployeeFacade {
    List<Employee> getAllEmployees();

    Employee getEmployeeById(String id);

    boolean addEmployee(Employee employee);
}
