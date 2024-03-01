package com.add.employee.data.employee.dao.impl;

import com.add.employee.app.model.employee.Employee;
import com.add.employee.data.employee.dao.EmployeeDao;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class EmployeeDaoImplTest {

    private EmployeeDao employeeDao;
    private List<Employee> employees;

    @BeforeEach
    void setUp() {
        Employee employee1 = new Employee("John", "Doe", "Joe", "Teacher", "10-10-2012", "09-16-1992", "USA", "Male", "Single", "Filipino", "Catholic", "177", "75", "me@gmail.com", null, null, null, null);

        employees = new ArrayList<>();
        employees.add(employee1);

        employeeDao = mock(EmployeeDao.class);
    }

    @Test
    void testAddEmployee() {
        Employee employee = new Employee("Joan", "Doe", "Smith", "Teacher", "10-10-2012", "09-16-1992", "USA", "Male", "Single", "Filipino", "Catholic", "177", "75", "me@gmail.com", null, null, null, null);


        when(employeeDao.addEmployee(employee)).thenAnswer(new Answer<Boolean>() {

            @Override
            public Boolean answer(InvocationOnMock invocationOnMock) throws Throwable {
                Object[] arguments = invocationOnMock.getArguments();
                if (arguments != null &&arguments.length > 0 && arguments[0] != null) {
                    return true;
                }
                return false;
            }
        });

        employeeDao.addEmployee(employee);
        when(employeeDao.getAllEmployees()).thenReturn(employees);
        List<Employee> customerList = employeeDao.getAllEmployees();

        assertEquals(customerList.size(), 18);
    }

    @Test
    void testGetAllEmployees() {
        when(employeeDao.getAllEmployees()).thenReturn(employees);

        List<Employee> expectedEmployees = employeeDao.getAllEmployees();

        assertEquals(expectedEmployees, employees);
        assertEquals(expectedEmployees.size(), 2);
    }

}
