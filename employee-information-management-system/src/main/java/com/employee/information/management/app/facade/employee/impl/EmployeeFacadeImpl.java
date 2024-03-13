package com.employee.information.management.app.facade.employee.impl;

import com.employee.information.management.app.facade.employee.EmployeeFacade;
import com.employee.information.management.app.model.Employee;
import com.employee.information.management.data.employee.dao.EmployeeDao;
import com.employee.information.management.data.employee.dao.impl.EmployeeDaoImpl;

import java.util.List;

public class EmployeeFacadeImpl implements EmployeeFacade {

    EmployeeDao employeeDao = new EmployeeDaoImpl();
    @Override
    public List<Employee> getAllEmployees() throws RuntimeException {
        return employeeDao.getAllEmployee();
    }

    @Override
    public Employee getEmployeeByNo(String employee_no) throws RuntimeException {
        return employeeDao.getEmployeeByNo(employee_no);
    }
}