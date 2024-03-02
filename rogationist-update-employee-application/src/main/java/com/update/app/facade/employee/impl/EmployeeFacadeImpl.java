package com.update.app.facade.employee.impl;

import com.update.app.facade.employee.EmployeeFacade;
import com.update.app.model.employee.Employee;
import com.update.data.employee.dao.EmployeeDao;

import java.util.List;

public class EmployeeFacadeImpl implements EmployeeFacade {
    EmployeeDao employeeDao = new EmployeeDao() {
        @Override
        public List<Employee> getAllEmployees() {
            return null;
        }

        @Override
        public Employee getEmployeeById(String employee_id) throws RuntimeException {
            return null;
        }
    };

    @Override
    public List<Employee> getAllEmployee() {
        return null;
    }

    @Override
    public Employee getEmployeeById(String employee_id) throws RuntimeException {
        return null;
    }
}
