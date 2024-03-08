package com.employee.information.management.data.employee.dao;

import com.employee.information.management.app.model.Employee;

public interface EmployeeDao {
    Employee getEmployeeByNo(String employeeNo);
    boolean updateEmployee(Employee employee);
}
