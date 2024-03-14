package com.employee.infomation.management.data.employee.dao.impl;


import com.employee.information.management.app.model.Employee;
import com.employee.information.management.data.connection.ConnectionHelper;
import com.employee.information.management.data.employee.dao.EmployeeDao;
import com.employee.information.management.data.employee.dao.impl.EmployeeDaoImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

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

//update employee
    @Mock
    private ConnectionHelper connectionHelper;

    @Mock
    private Connection connection;

    @Mock
    private PreparedStatement preparedStatement;

    @Mock
    private ResultSet resultSet;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetEmployeeByNo() throws SQLException {

        String employeeNo = "123";
        Employee expectedEmployee = new Employee();
        expectedEmployee.setEmployeeNo(employeeNo);
        when(connectionHelper.getConnection()).thenReturn(connection);
        when(connection.prepareStatement(anyString())).thenReturn(preparedStatement);
        when(preparedStatement.executeQuery()).thenReturn(resultSet);
        when(resultSet.next()).thenReturn(true);
        when(resultSet.getString("employee_no")).thenReturn(employeeNo);
        when(resultSet.getString("last_name")).thenReturn("Doe");



        Employee resultEmployee = employeeDao.getEmployeeByNo(employeeNo);


        assertNotNull(resultEmployee);
        assertEquals(expectedEmployee.getEmployeeNo(), resultEmployee.getEmployeeNo());

    }

    @Test
    void testUpdateEmployee() throws SQLException {

        Employee employeeToUpdate = new Employee();
        employeeToUpdate.setEmployeeNo("123");
        when(connectionHelper.getConnection()).thenReturn(connection);
        when(connection.prepareStatement(anyString())).thenReturn(preparedStatement);
        when(preparedStatement.executeUpdate()).thenReturn(1);

        boolean result = employeeDao.updateEmployee(employeeToUpdate);

        assertTrue(result);
    }

    //add employee
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