package com.update.data.employee.dao;

import com.update.app.model.employee.Employee;

import java.util.List;

public interface EmployeeDao {
    List<Employee> getAllEmployees();
    Employee getEmployeeById(String employee_id) throws RuntimeException;
}
