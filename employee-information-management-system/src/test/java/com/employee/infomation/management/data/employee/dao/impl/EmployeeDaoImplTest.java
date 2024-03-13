package com.employee.infomation.management.data.employee.dao.impl;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.employee.information.management.app.model.Employee;
import com.employee.information.management.data.connection.ConnectionHelper;

import com.employee.information.management.data.employee.dao.EmployeeDao;
import com.employee.information.management.data.employee.dao.impl.EmployeeDaoImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;



import static org.junit.jupiter.api.Assertions.*;



import static org.mockito.ArgumentMatchers.anyString;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class EmployeeDaoImplTest {
    //update employee
        @Mock
        private ConnectionHelper connectionHelper;

        @Mock
        private Connection connection;

        @Mock
        private PreparedStatement preparedStatement;

        @Mock
        private ResultSet resultSet;

        @InjectMocks
        private EmployeeDaoImpl employeeDao;

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

    //update employee
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
}
