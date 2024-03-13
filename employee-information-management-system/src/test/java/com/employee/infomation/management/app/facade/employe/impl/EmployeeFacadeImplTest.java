package com.employee.infomation.management.app.facade.employe.impl;

import com.employee.information.management.app.facade.employee.impl.EmployeeFacadeImpl;
import com.employee.information.management.app.model.Employee;
import com.employee.information.management.data.employee.dao.EmployeeDao;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class EmployeeFacadeImplTest {
    @Mock
    private EmployeeDao employeeDao;

    @InjectMocks
    private EmployeeFacadeImpl employeeFacade;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetEmployeeByNo() {
        String employeeNo = "123";
        Employee mockedEmployee = new Employee();
        mockedEmployee.setEmployeeNo(employeeNo);
        when(employeeDao.getEmployeeByNo(employeeNo)).thenReturn(mockedEmployee);


        Employee resultEmployee = employeeFacade.getEmployeeByNo(employeeNo);
        assertNotNull(resultEmployee);
        assertEquals(employeeNo, resultEmployee.getEmployeeNo());
    }

    @Test
    void testUpdateEmployee() {

        String employeeNo = "123";
        Employee employeeToUpdate = new Employee();
        employeeToUpdate.setEmployeeNo(employeeNo);
        when(employeeDao.getEmployeeByNo(employeeNo)).thenReturn(employeeToUpdate);
        when(employeeDao.updateEmployee(employeeToUpdate)).thenReturn(true);


        boolean result = employeeFacade.updateEmployee(employeeToUpdate);


        assertTrue(result);
        verify(employeeDao).getEmployeeByNo(employeeNo);
        verify(employeeDao).updateEmployee(employeeToUpdate);
    }

    @Test
    void testUpdateEmployeeNotFound() {

        String employeeNo = "123";
        Employee employeeToUpdate = new Employee();
        employeeToUpdate.setEmployeeNo(employeeNo);
        when(employeeDao.getEmployeeByNo(employeeNo)).thenReturn(null);


        assertThrows(RuntimeException.class, () -> employeeFacade.updateEmployee(employeeToUpdate));


        verify(employeeDao).getEmployeeByNo(employeeNo);
        verify(employeeDao, never()).updateEmployee(employeeToUpdate);
    }
}
