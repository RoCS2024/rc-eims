package com.update.app.facade.employee;


import com.update.app.model.employee.Employee;

import java.util.List;

public interface EmployeeFacade {
    List<Employee> getAllEmployee();
    Employee getEmployeeById(String employee_id) throws RuntimeException;
}
