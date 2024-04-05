package com.employee.info.mgmt.appl.facade.employee.impl;

import com.employee.info.mgmt.appl.model.Employee;
import com.employee.info.mgmt.data.employee.dao.EmployeeDao;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

import static org.mockito.Mockito.*;

class EmployeeFacadeImplTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeFacadeImplTest.class);

    @InjectMocks
    private EmployeeFacadeImpl employeeFacade;

    @Mock
    private EmployeeDao employeeDao;

    @Mock
    private List<Employee> employeeList;

    @Mock
    private Employee employee;

    @Mock
    private Employee addEmployee;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        employeeFacade = new EmployeeFacadeImpl(employeeDao);
        employee.setEmployeeNo("1");
        addEmployee.setEmployeeNo("2");
        when(employeeDao.getAllEmployees()).thenReturn(employeeList);
    }

    @AfterEach
    public void validate() {
        validateMockitoUsage();
    }

    @Test
    public void testGetAllEmployees() {
        List expectedList = employeeFacade.getAllEmployees();

        assert (expectedList.equals(employeeList));

        verify(employeeDao).getAllEmployees();
    }

    @Test
    public void testGetEmployeeById() {
        when(employeeDao.getEmployeeById("1")).thenReturn(employee);
        Employee expectedEmployee = employeeFacade.getEmployeeById("1");

        assert (expectedEmployee.equals(employee));

        verify(employeeDao).getEmployeeById("1");
    }

    @Test
    public void testAddEmployee() {
        try {
            when(employeeDao.getEmployeeById(addEmployee.getEmployeeNo())).thenReturn(null);
            when(employeeDao.addEmployee(addEmployee)).thenReturn(true);

            boolean result = employeeFacade.addEmployee(addEmployee);

            assert (result == true);

            assert (employeeFacade.getEmployeeById("2") == null);

            verify(employeeDao).addEmployee(addEmployee);
        } catch (Exception e) {
            LOGGER.error("Exception caught: " + e.getMessage());
        }

    }
    @Test
    public void testUpdateEmployee() {
        try {
            when(employeeDao.getEmployeeById(employee.getEmployeeNo())).thenReturn(employee);
            when(employeeDao.updateEmployee(employee)).thenReturn(true);

            boolean result = employeeFacade.updateEmployee(employee);

            assert(result == true);

            assert(employeeFacade.getEmployeeById("1").equals(employee));

            verify(employeeDao).updateEmployee(employee);
        } catch (Exception e) {
            LOGGER.error("Exception caught: " + e.getMessage());
        }
    }
}