package com.prefect.system.data.employee.dao.Impl;

import com.prefect.system.app.model.Employee;
import com.prefect.system.data.employee.dao.EmployeeDao;
import com.prefect.system.data.employee.dao.Impl.EmployeeDaoImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


/**
 * Unit tests for the EmployeeDaoImpl class.
 */

public class EmployeeDaoImplTest {

    @Mock
    private EmployeeDao employeeDao;

    @InjectMocks
    private EmployeeDaoImpl employeeDaoImpl;


    /**
     * Initializes Mockito annotations before each test.
     */

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    /**
     * Tests the getAllEmployee method.
     */

    @Test
    public void testGetAllEmployee() {

        Employee employee1 = new Employee("Mercader","Kyla","A","Prof","May 1, 2020",
                new Timestamp(System.currentTimeMillis()), "Tagaytay","Female",
                "Single","Filipino","Catholic", 149,43, "k@gmail.com",
                "123456", "123456", "123456", "01");

        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(employee1);

        EmployeeDao employeeDao = mock(EmployeeDao.class);
        when(employeeDao.getAllEmployee()).thenReturn(employeeList);

        List<Employee> expectedResult = employeeDao.getAllEmployee();

        assertEquals(expectedResult.size(), 1);
          }


    /**
     * Tests the getEmployeeByNo method.
     */

    @Test
    public void testGetEmployeeByNo() {

        Employee employee1 = new Employee("Mercader","Kyla","A","IT PROF","January 1",
                new Timestamp(System.currentTimeMillis()), "Tagaytay","Female",
                "Single","Fil","Catholic", 149,43, "kyla@gmail.com",
                "12345", "12345", "12345", "01");

        EmployeeDao employeeDao = mock(EmployeeDao.class);
        when(employeeDao.getEmployeeByNo("1")).thenReturn(employee1);

        Employee expectedEmployee = employeeDao.getEmployeeByNo("1");

        assertEquals(expectedEmployee, employee1);
    }
}
