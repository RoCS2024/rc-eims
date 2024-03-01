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

<<<<<<< HEAD
/**
 * Unit tests for the EmployeeFacadeImpl class.
 */

=======
>>>>>>> 0b59a48e0c9e6b11bda34d9fa989d259d815dbbf
public class EmployeeFacadeImplTest {

    private EmployeeDao employeeDao;

    private EmployeeFacadeImpl employeeFacade;

<<<<<<< HEAD
    /**
     * Sets up before each test.
     */
=======
>>>>>>> 0b59a48e0c9e6b11bda34d9fa989d259d815dbbf
    @BeforeEach
    public void setUp() {
        employeeDao = mock(EmployeeDao.class);
        employeeFacade = new EmployeeFacadeImpl();
    }


<<<<<<< HEAD
    /**
     * Tests the getAllEmployees method.
     */
=======
>>>>>>> 0b59a48e0c9e6b11bda34d9fa989d259d815dbbf
    @Test
    public void testGetAllEmployee() {
        List<Employee>  EmployeeList = new ArrayList<>();
        EmployeeList.add(new Employee());
        EmployeeList.add(new Employee());
        when(employeeDao.getAllEmployee()).thenReturn(EmployeeList);

        List<Employee> retrievedEmployeeList = employeeFacade.getAllEmployees();

        verify(employeeDao, times(1)).getAllEmployee();
        assertEquals(EmployeeList, retrievedEmployeeList);
    }

<<<<<<< HEAD
    /**
     * Tests the getEmployeeByNo method.
     */
=======
>>>>>>> 0b59a48e0c9e6b11bda34d9fa989d259d815dbbf
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
