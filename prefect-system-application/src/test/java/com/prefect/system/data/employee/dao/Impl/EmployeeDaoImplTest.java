package com.prefect.system.data.employee.dao.Impl;

import com.prefect.system.app.model.Employee;
import com.prefect.system.data.employee.dao.EmployeeDao;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.sql.SQLException;
import java.util.List;

public class EmployeeDaoImplTest {
    private EmployeeDao employeeDao;

    @BeforeEach
    void setUp() {
        employeeDao = new EmployeeDaoImpl();
    }

    @Test
    void testSaveEmployee() {
        Employee employee = new Employee(/* initialize employee data */);
        try {
            Employee savedEmployee = employeeDao.saveEmployee(employee);
            assertNotNull(savedEmployee);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    void testGetAllEmployee() {
        try {
            List<Employee> employees = employeeDao.getAllEmployee();
            assertEquals(1, employees.size());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    void testGetEmployeeById() {
        long employeeId = 1;
        try {
            Employee employee = employeeDao.getEmployeeById(employeeId);
            assertNotNull(employee);
            assertEquals(employeeId, Long.parseLong(employee.getEmployeeId()));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}