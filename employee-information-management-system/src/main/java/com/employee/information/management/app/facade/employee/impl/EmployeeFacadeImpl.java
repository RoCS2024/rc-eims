package com.employee.information.management.app.facade.employee.impl;

import com.employee.information.management.app.model.Employee;
import com.employee.information.management.data.employee.dao.EmployeeDao;
import com.employee.information.management.data.employee.dao.impl.EmployeeDaoImpl;

public class EmployeeFacadeImpl {
    EmployeeDao employeeDao = new EmployeeDaoImpl();

    public EmployeeFacadeImpl(EmployeeDao employeeDao) {
    }

    @Override
    public Employee getEmployeeByNo(String employeeNo) {
        return employeeDao.getEmployeeByNo(employeeNo);
    }
    @Override
    public boolean updateEmployee(Employee employee) {
        boolean result = false;
        try {
            Employee targetEmployee = getEmployeeByNo(employee.getEmployeeNo());
            if(targetEmployee == null) {
                throw new Exception("Offense to update not found. ");
            }
            result = employeeDao.updateEmployee(employee);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
        return result;
    }
}
