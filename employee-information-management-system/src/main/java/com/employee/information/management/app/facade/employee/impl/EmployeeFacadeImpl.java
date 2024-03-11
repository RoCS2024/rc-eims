package com.employee.information.management.app.facade.employee.impl;

<<<<<<< Updated upstream
=======
import com.employee.information.management.app.facade.employee.EmployeeFacade;
>>>>>>> Stashed changes
import com.employee.information.management.app.model.Employee;
import com.employee.information.management.data.employee.dao.EmployeeDao;
import com.employee.information.management.data.employee.dao.impl.EmployeeDaoImpl;

<<<<<<< Updated upstream
public class EmployeeFacadeImpl {
    EmployeeDao employeeDao = new EmployeeDaoImpl();

    public EmployeeFacadeImpl(EmployeeDao employeeDao) {
=======
public class EmployeeFacadeImpl implements EmployeeFacade {

    //update employee
    EmployeeDao employeeDao = new EmployeeDaoImpl();

    public EmployeeFacadeImpl(EmployeeDaoImpl employeeDao) {
>>>>>>> Stashed changes
    }

    @Override
    public Employee getEmployeeByNo(String employeeNo) {
        return employeeDao.getEmployeeByNo(employeeNo);
    }
<<<<<<< Updated upstream
=======

>>>>>>> Stashed changes
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
