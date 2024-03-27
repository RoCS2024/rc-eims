package com.employee.info.mgmt.appl.facade.employee.impl;

import com.employee.info.mgmt.appl.facade.employee.EmployeeFacade;
import com.employee.info.mgmt.appl.model.Employee;
import com.employee.info.mgmt.data.employee.dao.EmployeeDao;
import com.employee.info.mgmt.data.employee.dao.impl.EmployeeDaoImpl;

import java.util.List;

public class EmployeeFacadeImpl implements EmployeeFacade {
    EmployeeDao employeeDao = new EmployeeDaoImpl();

    @Override
    public List<Employee> getAllEmployees() {
        return employeeDao.getAllEmployees();
    }

    @Override
    public Employee getEmployeeById(String employee_id) throws RuntimeException {
        return employeeDao.getEmployeeById(employee_id);
    }

    @Override
    public boolean addEmployee(Employee employee) {
        boolean result = false;
        try {
            Employee targetEmployee = getEmployeeById(employee.getEmployeeNo());
            if(targetEmployee != null) {
                throw new Exception("Employee to add already exists. ");
            }
            result = employeeDao.addEmployee(employee);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
        return result;
    }


    @Override
    public boolean updateEmployee(Employee employee) {
        try {
            return employeeDao.updateEmployee(employee);
        } catch (Exception e) {
            throw new RuntimeException("Error updating employee", e);
        }
    }
}