package com.prefect.system.app.facade.Impl;

import com.prefect.system.app.facade.EmployeeFacade;
import com.prefect.system.app.model.Employee;
import com.prefect.system.data.employee.dao.EmployeeDao;

import java.sql.SQLException;
import java.util.List;

public class EmployeeFacadeImpl implements EmployeeFacade {

    private EmployeeDao employeeDao;

    public EmployeeFacadeImpl(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    @Override
    public Employee saveEmployee(Employee employee) throws SQLException {
        return employeeDao.saveEmployee(employee);
    }

    @Override
    public List<Employee> getAllEmployees() throws SQLException {
        return employeeDao.getAllEmployee();
    }

    @Override
    public Employee getEmployeeById(long id) throws SQLException {
        return employeeDao.getEmployeeById(id);
    }
}
