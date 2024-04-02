package com.employee.info.mgmt.data.employee.dao.impl;

import com.employee.info.mgmt.appl.model.Employee;
import com.employee.info.mgmt.data.employee.dao.EmployeeDao;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
/**
 * This is to test the employee dao impl.
 */
public class EmployeeDaoImplTest {

    @Mock
    private EmployeeDao employeeDao;

    @Mock
    private List<Employee> employees;

    @BeforeEach
    public void setUp() {
        employees = new ArrayList<>();
        Employee employee1 = new Employee();
        Employee employee2 = new Employee();
        employees.add(employee1);
        employees.add(employee2);

        employeeDao = mock(EmployeeDao.class);
    }
    /**
     * This is to test get all employees.
     */
    @Test
    public void testGetAllEmployees() {
        when(employeeDao.getAllEmployees()).thenReturn(employees);
        List<Employee> employeeList = employeeDao.getAllEmployees();
        assertEquals(employeeList.size(), 2);
    }
    /**
     * This is to test get employee by id.
     */
    @Test
    public void testGetEmployeeByNo() {
        Employee employee1 = new Employee();
        employee1.setEmployeeNo("1");

        when(employeeDao.getEmployeeById("1")).thenReturn(employee1);

        Employee expectedEmployee = employeeDao.getEmployeeById("1");

        assertEquals(expectedEmployee, employee1);
        assertEquals(expectedEmployee.getEmployeeNo(), employee1.getEmployeeNo());
    }

    @Test
    public void testAddEmployee() {
        Employee employee = new Employee();
        employee.setEmployeeNo("1");

        when(employeeDao.addEmployee(employee)).thenReturn(true);
        when(employeeDao.getEmployeeById("1")).thenReturn(employee);

        Employee expectedEmployee = employeeDao.getEmployeeById("1");
        assertEquals(expectedEmployee.getEmployeeNo(), employee.getEmployeeNo());
    }

    @Test
    public void testUpdateEmployee() {
        Employee employee = new Employee();
        employee.setEmployeeNo("1");
        employee.setLastName("Dinglasan");

        when(employeeDao.addEmployee(employee)).thenReturn(true);
        when(employeeDao.updateEmployee(employee)).thenReturn(true);
        when(employeeDao.getEmployeeById("1")).thenReturn(employee);

        Employee expectedEmployee = employeeDao.getEmployeeById("1");
        assertEquals(expectedEmployee.getLastName(), employee.getLastName());
    }
}
