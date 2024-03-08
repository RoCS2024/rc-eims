package com.employee.information.management.app.facade.employee;

import com.employee.information.management.app.model.Employee;

import java.awt.*;
import java.util.List;

public interface EmployeeFacade {
    List<Employee> getAllEmployees() throws RuntimeException;

    Employee getEmployeeByNo(String employee_no) throws RuntimeException;
}
