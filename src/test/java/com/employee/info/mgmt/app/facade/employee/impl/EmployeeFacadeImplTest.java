package com.employee.info.mgmt.app.facade.employee.impl;

import static org.junit.jupiter.api.Assertions.*;

import com.employee.info.mgmt.app.facade.employee.EmployeeFacade;
import com.employee.info.mgmt.app.model.Employee;
import com.employee.info.mgmt.data.employee.dao.EmployeeDao;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

class EmployeeFacadeImplTest {
    @Mock
    private EmployeeDao employeeDao;
    private EmployeeFacade employeeFacade;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        employeeFacade = new EmployeeFacadeImpl();
    }

    @Test
    public void testGetAllEmployees() {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee());

        when(employeeDao.getAllEmployees()).thenReturn(employees);

        List<Employee> result = employeeFacade.getAllEmployees();

        assertNotNull(result);
        assertEquals(1, result.size());
    }

    @Test
    public void testGetEmployeeById() {
        Employee employee = new Employee();
        String employeeId = "EMP001";

        when(employeeDao.getEmployeeById(employeeId)).thenReturn(employee);

        Employee result = employeeFacade.getEmployeeById(employeeId);

        assertNotNull(result);
        assertEquals(employeeId, result.getEmployeeNo());
    }

    @Test
    public void testAddEmployee() {
        Employee employee = new Employee();

        when(employeeDao.addEmployee(employee)).thenReturn(true);

        boolean result = employeeFacade.addEmployee(employee);

        assertTrue(result);
    }

    @Test
    public void testUpdateEmployee() {
        Employee employee = new Employee();

        when(employeeDao.updateEmployee(employee)).thenReturn(true);

        boolean result = employeeFacade.updateEmployee(employee);

        assertTrue(result);
    }
}