package com.employee.info.mgmt.appl.facade.employee.impl;

import com.employee.info.mgmt.appl.facade.employee.EmployeeFacade;
import com.employee.info.mgmt.appl.model.Employee;
import com.employee.info.mgmt.data.employee.dao.EmployeeDao;

import java.util.List;

/**
 * This is the implementation class for the EmployeeFacade
 */
public class EmployeeFacadeImpl implements EmployeeFacade {

    private EmployeeDao employeeDao;

    /**
     * This creates a new EmployeeFacadeImpl
     * @param employeeDao this helps for managing employee data.
     */
    public EmployeeFacadeImpl(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeDao.getAllEmployees();
    }

    @Override
    public Employee getEmployeeById(String employee_id) {
        return employeeDao.getEmployeeById(employee_id);
    }

    @Override
    public boolean addEmployee(Employee employee) throws RuntimeException {
        boolean result = false;
        try {
            Employee targetEmployee = getEmployeeById(employee.getEmployeeNo());
            if (targetEmployee != null) {
                throw new Exception("Employee to add already exists. ");
            }
            result = employeeDao.addEmployee(employee);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
        return result;
    }

    @Override
    public boolean updateEmployee(Employee employee) throws RuntimeException {
        try {
            Employee existingEmployee = getEmployeeById(employee.getEmployeeNo());
            if (existingEmployee == null) {
                throw new RuntimeException("Employee to update does not exist.");
            }
            return employeeDao.updateEmployee(employee);
        } catch (Exception e) {
            throw new RuntimeException("Error updating employee", e);
        }
    }
}