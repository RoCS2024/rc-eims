package com.employee.information.management.data.employee.dao;

import com.employee.information.management.app.model.Employee;

import java.util.List;

public interface EmployeeDao {
    List<Employee> getAllEmployee();

    Employee getEmployeeByNo(String employee_no) throws RuntimeException;

    //for update employee
    boolean updateEmployee(Employee employee);
}
