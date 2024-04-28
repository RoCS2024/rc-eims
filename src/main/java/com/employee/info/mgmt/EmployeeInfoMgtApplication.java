package com.employee.info.mgmt;

import com.employee.info.mgmt.appl.facade.employee.EmployeeFacade;
import com.employee.info.mgmt.appl.facade.employee.impl.EmployeeFacadeImpl;
import com.employee.info.mgmt.data.employee.dao.EmployeeDao;
import com.employee.info.mgmt.data.employee.dao.impl.EmployeeDaoImpl;
/**
 * This class is EmployeeInfoMgtApplication. This class represents the Employee information for website.
 * */
public class EmployeeInfoMgtApplication {
    private EmployeeFacade employeeFacade;
    /**
     * This creates a new EmployeeInfoMgtApplication
     * @return the employeeFacade this helps for managing employee data.
     */
    public EmployeeInfoMgtApplication() {
        EmployeeDao employeeDaoImpl = new EmployeeDaoImpl();
        this.employeeFacade = new EmployeeFacadeImpl(employeeDaoImpl);
    }
    /**
     * This gets the Employee Facade.
     * @return the employee facade.
     */
    public EmployeeFacade getEmployeeFacade() {
        return employeeFacade;
    }
}

