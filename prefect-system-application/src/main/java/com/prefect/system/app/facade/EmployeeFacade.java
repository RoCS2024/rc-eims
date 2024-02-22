package com.prefect.system.app.facade;

import com.prefect.system.app.model.Employee;

import java.sql.SQLException;
import java.util.List;

public interface EmployeeFacade  {
    Employee saveEmployee(Employee employee) throws SQLException;

    List<Employee> getAllEmployees() throws SQLException;

    Employee getEmployeeById(long id) throws SQLException;
}
