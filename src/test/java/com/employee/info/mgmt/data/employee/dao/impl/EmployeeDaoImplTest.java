package com.employee.info.mgmt.data.employee.dao.impl;

import com.employee.info.mgmt.app.model.Employee;
import com.employee.info.mgmt.data.employee.dao.EmployeeDao;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class EmployeeDaoImplTest {

//    @Mock
//    private EmployeeDao employeeDao;
//
//    @InjectMocks
//    private EmployeeDaoImpl employeeDaoImpl;
//
//    @BeforeEach
//    void setUp() {
//        MockitoAnnotations.initMocks(this);
//    }
//
//    @Test
//    void testGetAllEmployees() {
//        List<Employee> employees = new ArrayList<>();
//        employees.add(new Employee());
//
//        when(employeeDao.getAllEmployees()).thenReturn(employees);
//
//        List<Employee> result = employeeDaoImpl.getAllEmployees();
//
//        assertEquals(1, result.size());
//        assertEquals("John", result.get(0).getFirstName());
//        assertEquals("Doe", result.get(0).getLastName());
//        assertEquals("Engineer", result.get(0).getPositionInRC());
//    }
//
//    @Test
//    void testGetEmployeeById() {
//        String employeeId = "EMP-001";
//        Employee employee = new Employee();
//        employee.setEmployeeNo(employeeId);
//
//        when(employeeDao.getEmployeeById(employeeId)).thenReturn(employee);
//
//        Employee result = employeeDaoImpl.getEmployeeById(employeeId);
//
//        assertEquals("John", result.getFirstName());
//        assertEquals("Doe", result.getLastName());
//        assertEquals("Engineer", result.getPositionInRC());
//    }
//
//    @Test
//    void testAddEmployee() {
//        Employee employee = new Employee();
//
//        when(employeeDao.addEmployee(employee)).thenReturn(true);
//
//        boolean result = employeeDaoImpl.addEmployee(employee);
//
//        assertEquals(true, result);
//    }
//
//    @Test
//    void testUpdateEmployee() {
//        String employeeId = "EMP-001";
//        Employee employee = new Employee();
//        employee.setEmployeeNo(employeeId);
//
//        when(employeeDao.updateEmployee(employee)).thenReturn(true);
//
//        boolean result = employeeDaoImpl.updateEmployee(employee);
//
//        assertEquals(true, result);
//    }
}