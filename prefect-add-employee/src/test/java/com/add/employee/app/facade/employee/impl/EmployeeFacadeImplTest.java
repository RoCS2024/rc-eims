package com.add.employee.app.facade.employee.impl;

import com.add.employee.app.model.employee.Employee;
import com.add.employee.data.employee.dao.EmployeeDao;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class EmployeeFacadeImplTest {

    @Test
    void testAddEmployee() {
        EmployeeDao employeeDao = mock(EmployeeDao.class);
        EmployeeFacadeImpl employeeFacade = new EmployeeFacadeImpl(employeeDao);

        Employee employee = new Employee("Joan", "Doe", "Smith", "Teacher", "10-10-2012", "09-16-1992", "USA", "Male", "Single", "Filipino", "Catholic", "177", "75", "me@gmail.com", null, null, null, null);

        when(employeeDao.getEmployeeById("123")).thenReturn(null);
        when(employeeDao.addEmployee(employee)).thenReturn(true);

        boolean result = employeeFacade.addEmployee(employee);

        assertTrue(result, "Employee should be added successfully");
        verify(employeeDao, times(1)).getEmployeeById("123");
        verify(employeeDao, times(1)).addEmployee(employee);
    }

    @Test
    void testAddExistingEmployee() {
        EmployeeDao employeeDao = mock(EmployeeDao.class);
        EmployeeFacadeImpl employeeFacade = new EmployeeFacadeImpl(employeeDao);

        Employee employee = new Employee("Joan", "Doe", "Smith", "Teacher", "10-10-2012", "09-16-1992", "USA", "Male", "Single", "Filipino", "Catholic", "177", "75", "me@gmail.com", null, null, null, null);

        when(employeeDao.getEmployeeById("123")).thenReturn(employee);

        assertThrows(RuntimeException.class, () -> employeeFacade.addEmployee(employee),
                "Adding an existing employee should throw RuntimeException");

        verify(employeeDao, times(1)).getEmployeeById("123");
        verify(employeeDao, never()).addEmployee(any(Employee.class));
    }
}
