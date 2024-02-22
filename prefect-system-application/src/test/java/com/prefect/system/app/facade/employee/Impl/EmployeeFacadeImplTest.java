package com.prefect.system.app.facade.employee.Impl;

import com.prefect.system.app.facade.Impl.EmployeeFacadeImpl;
import com.prefect.system.app.model.Employee;
import com.prefect.system.data.employee.dao.EmployeeDao;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeFacadeImplTest {

    private EmployeeDao employeeDao;

    private EmployeeFacadeImpl employeeFacade;

    @BeforeEach
    void setUp() {
        employeeDao = mock(EmployeeDao.class);
        employeeFacade = new EmployeeFacadeImpl(employeeDao);
    }

    @Test
    void testSaveEmployee() throws SQLException {
        Employee employee = new Employee();

        when(employeeDao.saveEmployee(employee)).thenReturn(employee);

        Employee savedEmployee = employeeFacade.saveEmployee(employee);

        verify(employeeDao, times(1)).saveEmployee(employee);
        assertEquals(employee, savedEmployee);
    }


    @Test
    void testGetAllEmployee() throws SQLException {
        List<Employee>  EmployeeList = new ArrayList<>();
        EmployeeList.add(new Employee());
        EmployeeList.add(new Employee());

        when(employeeDao.getAllEmployee()).thenReturn(EmployeeList);

        List<Employee> retrievedEmployeeList = employeeFacade.getAllEmployees();

        verify(employeeDao, times(1)).getAllEmployee();
        assertEquals(EmployeeList, retrievedEmployeeList);
    }

    @Test
    void testGetEmployeeById() throws SQLException {
        long id = 1;
        Employee employee = new Employee();

        when(employeeDao.getEmployeeById(id)).thenReturn(employee);

        Employee retrievedEmployee = employeeFacade.getEmployeeById(id);

        verify(employeeDao, times(1)).getEmployeeById(id);
        assertEquals(employee, retrievedEmployee);
    }

}
