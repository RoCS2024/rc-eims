package com.prefect.system.data.employee.dao;

import com.prefect.system.app.model.Employee;

import java.sql.SQLException;
import java.util.List;

public interface EmployeeDao {
    Employee saveEmployee(Employee employee) throws SQLException;

    List<Employee> getAllEmployee() throws SQLException;

    Employee getEmployeeById(long id) throws SQLException;



}
