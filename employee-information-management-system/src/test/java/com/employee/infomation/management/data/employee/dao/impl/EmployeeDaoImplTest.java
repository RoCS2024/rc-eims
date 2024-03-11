package com.employee.infomation.management.data.employee.dao.impl;

<<<<<<< Updated upstream
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.employee.information.management.app.facade.employee.impl.EmployeeFacadeImpl;
import com.employee.information.management.app.model.Employee;
import com.employee.information.management.data.connection.ConnectionHelper;
import com.employee.information.management.data.employee.dao.EmployeeDao;
=======
import com.employee.information.management.app.model.Employee;
import com.employee.information.management.data.connection.ConnectionHelper;
>>>>>>> Stashed changes
import com.employee.information.management.data.employee.dao.impl.EmployeeDaoImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

<<<<<<< Updated upstream
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class EmployeeDaoImplTest {
=======
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

public class EmployeeDaoImplTest {

    //update employee
>>>>>>> Stashed changes
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
