package com.employee.info.mgmt.data.employee.dao;

import com.employee.info.mgmt.app.model.Employee;

import java.util.List;

public interface EmployeeDao {
    List<Employee> getAllEmployees();
    Employee getEmployeeById(String id);
    boolean addEmployee(Employee employee);
    boolean updateEmployee(Employee employee);
}
