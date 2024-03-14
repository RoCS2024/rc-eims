package com.employee.information.management.data.employee.dao;

import com.employee.information.management.app.model.Employee;

import java.util.List;

public interface EmployeeDao {
    List<Employee> getAllEmployee();

    Employee getEmployeeByNo(String employee_no) throws RuntimeException;

    //update employee
    boolean updateEmployee(Employee employee);

    //add employee
    boolean addEmployee(Employee employee);
    Employee getEmployeeById(String id);
}
