package com.prefect.system.app.facade.Impl;

import com.prefect.system.app.facade.EmployeeFacade;
import com.prefect.system.app.model.Employee;
import com.prefect.system.data.employee.dao.EmployeeDao;
import com.prefect.system.data.employee.dao.Impl.EmployeeDaoImpl;

import java.sql.SQLException;
import java.util.List;

/**
 * Implementation of the EmployeeFacade interface for retrieving employee data.
 */
public class EmployeeFacadeImpl implements EmployeeFacade {

    EmployeeDao employeeDao = new EmployeeDaoImpl();


    @Override
    public List<Employee> getAllEmployees() { return employeeDao.getAllEmployee();}

    @Override
    public Employee getEmployeeByNo(String employee_no) throws RuntimeException {
        return employeeDao.getEmployeeByNo(employee_no);
    }

}
