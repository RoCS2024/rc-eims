package com.add.employee.app.facade.employee.impl;

import com.add.employee.app.facade.employee.EmployeeFacade;
import com.add.employee.app.model.employee.Employee;
import com.add.employee.data.employee.dao.EmployeeDao;

import java.util.List;

public class EmployeeFacadeImpl implements EmployeeFacade {

    private EmployeeDao employeeDao;

    public EmployeeFacadeImpl(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    public boolean addEmployee(Employee employee) {
        boolean result = false;
        try {
            Employee targetEmployee = employeeDao.getEmployeeById(employee.getEmployeeNo());
            if (targetEmployee != null) {
                throw new RuntimeException("Employee to add already exists.");
            }
            result = employeeDao.addEmployee(employee);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }

        if (result) {
            System.out.println("Employee added successfully.");
        } else {
            System.out.println("Failed to add employee.");
        }
        return result;
    }

    @Override
    public List<Employee> getAllEmployees() {
        return null;
    }

    @Override
    public Employee getEmployeeById(String id) {
        return null;
    }
}
