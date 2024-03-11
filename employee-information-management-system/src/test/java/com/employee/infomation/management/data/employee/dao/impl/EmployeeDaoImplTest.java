package com.employee.infomation.management.data.employee.dao.impl;


import com.employee.information.management.data.employee.dao.EmployeeDao;
import com.employee.information.management.data.employee.dao.impl.EmployeeDaoImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeDaoImplTest {
    @Mock
    private EmployeeDao employeeDao;

    @InjectMocks
    private EmployeeDaoImpl employeeDaoImpl;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetAllEmployee() {

        Employee employee1 = new Employee("Dela Cruz","Juan","B","Prof","May 1, 2020",
                new Timestamp(System.currentTimeMillis()), "Maragondon","Male",
                "Single","Filipino","Catholic", 149,43, "JuanB@gmail.com",
                "123456", "123456", "123456", "01");

        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(employee1);

        EmployeeDao employeeDao = mock(EmployeeDao.class);
        when(employeeDao.getAllEmployee()).thenReturn(employeeList);

        List<Employee> expectedResult = employeeDao.getAllEmployee();

        assertEquals(expectedResult.size(), 1);
    }

    @Test
    public void testGetEmployeeByNo() {

        Employee employee1 = new Employee("Dela Cruz","Juan","B","IT PROF","January 1",
                new Timestamp(System.currentTimeMillis()), "Maragondon","Male",
                "Single","Fil","Catholic", 149,43, "JuanB@gmail.com",
                "12345", "12345", "12345", "01");

        EmployeeDao employeeDao = mock(EmployeeDao.class);
        when(employeeDao.getEmployeeByNo("1")).thenReturn(employee1);

        Employee expectedEmployee = employeeDao.getEmployeeByNo("1");

        assertEquals(expectedEmployee, employee1);
    }

}