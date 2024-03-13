package com.employee.infomation.management.app.facade.employe.impl;


import com.employee.information.management.app.facade.employee.impl.EmployeeFacadeImpl;
import com.employee.information.management.app.model.Employee;
import com.employee.information.management.data.employee.dao.EmployeeDao;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static javax.management.Query.times;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

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


    //add employee
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