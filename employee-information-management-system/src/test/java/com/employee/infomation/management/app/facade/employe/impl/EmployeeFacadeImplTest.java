package com.employee.infomation.management.app.facade.employe.impl;


import com.employee.information.management.app.facade.employee.impl.EmployeeFacadeImpl;
import com.employee.information.management.app.model.Employee;
import com.employee.information.management.data.employee.dao.EmployeeDao;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static javax.management.Query.times;
import static org.junit.jupiter.api.Assertions.*;

class EmployeeFacadeImplTest {
    private EmployeeDao employeeDao;

    private EmployeeFacadeImpl employeeFacade;

    @BeforeEach
    public void setUp() {
        employeeDao = mock(EmployeeDao.class);
        employeeFacade = new EmployeeFacadeImpl();
    }



    @Test
    public void testGetAllEmployee() {
        List<Employee> EmployeeList = new ArrayList<>();
        EmployeeList.add(new Employee());
        EmployeeList.add(new Employee());
        when(employeeDao.getAllEmployee()).thenReturn(EmployeeList);

        List<Employee> retrievedEmployeeList = employeeFacade.getAllEmployees();

        verify(employeeDao, times(1).getAllEmployee();
        assertEquals(EmployeeList, retrievedEmployeeList);
    }

    @Test
    void testGetEmployeeByNo() {
        String employeeNo = "1";
        Employee employee = new Employee();
        when(employeeDao.getEmployeeByNo(employeeNo)).thenReturn(employee);

        Employee retrievedEmployee = employeeFacade.getEmployeeByNo(employeeNo);

        verify(employeeDao, times(1)).getEmployeeByNo(employeeNo);
        assertEquals(employee, retrievedEmployee);
    }

}