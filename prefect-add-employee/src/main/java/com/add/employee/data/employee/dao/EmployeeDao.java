package com.add.employee.data.employee.dao;

import com.add.employee.app.model.employee.Employee;

import java.util.List;

public interface EmployeeDao {
    boolean addEmployee(Employee employee);

    List<Employee> getAllEmployees();

    Employee getEmployeeById(String id);
}