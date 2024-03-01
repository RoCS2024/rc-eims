package com.add.employee.data.employee.dao.impl;

import com.add.employee.app.model.employee.Employee;
import com.add.employee.data.connection.ConnectionHelper;
import com.add.employee.data.employee.dao.EmployeeDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class EmployeeDaoImpl implements EmployeeDao {
    public boolean addEmployee(Employee employee) {
        try (Connection connection = ConnectionHelper.getConnection()) {
            String sql = "INSERT INTO EMPLOYEE VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, employee.getLastName());
                preparedStatement.setString(2, employee.getFirstName());
                preparedStatement.setString(3, employee.getMiddleName());
                preparedStatement.setString(4, employee.getPositionInRC());
                preparedStatement.setString(5, employee.getDateEmployed());
                preparedStatement.setString(6, employee.getBirthdate());
                preparedStatement.setString(7, employee.getBirthplace());
                preparedStatement.setString(8, employee.getSex());
                preparedStatement.setString(9, employee.getCivilStatus());
                preparedStatement.setString(10, employee.getCitizenship());
                preparedStatement.setString(11, employee.getReligion());
                preparedStatement.setDouble(12, employee.getHeight());
                preparedStatement.setDouble(13, employee.getWeight());
                preparedStatement.setString(14, employee.getEmail());
                preparedStatement.setString(15, employee.getSssNo());
                preparedStatement.setString(16, employee.getTinNo());
                preparedStatement.setString(17, employee.getPagibigNo());
                preparedStatement.setString(18, employee.getEmployeeNo());

                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public List<Employee> getAllEmployees() {
        return null;
    }

    @Override
    public Employee getEmployeeById(String id) {
        return null;
    }
}

