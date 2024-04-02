package com.employee.info.mgmt.data.employee.dao.impl;

import com.employee.info.mgmt.appl.model.Employee;
import com.employee.info.mgmt.data.connection.ConnectionHelper;
import com.employee.info.mgmt.data.employee.dao.EmployeeDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static com.employee.info.mgmt.data.utils.QueryConstants.*;

public class EmployeeDaoImpl implements EmployeeDao {

    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeDaoImpl.class);

    @Override
    public List<Employee> getAllEmployees() {
        List<Employee> employees = new ArrayList<>();
        Connection connection = null;
        try {
            connection = ConnectionHelper.getConnection();
            PreparedStatement stmt = connection.prepareStatement(GET_ALL_EMPLOYEE_STATEMENT);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Employee employee = setEmployee(rs);
                employees.add(employee);
            }
            LOGGER.info("Employee retrieved successfully.");
        } catch (SQLException e) {
            LOGGER.warn("Error retrieving all Employees." + e.getMessage());
            e.printStackTrace();
        } finally {
            closeConnection(connection);
        }
        LOGGER.debug("Employee database is empty.");
        return employees;
    }

    @Override
    public Employee getEmployeeById(String id) {
        Connection connection = null;
        try {
            connection = ConnectionHelper.getConnection();
            PreparedStatement stmt = connection.prepareStatement(GET_EMPLOYEE_BY_ID_STATEMENT);
            stmt.setString(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                LOGGER.debug("Employee retrieved successfully.");
                return setEmployee(rs);
            }

        } catch (SQLException e) {
            LOGGER.error("An SQL Exception occurred." + e.getMessage());
        } finally {
            closeConnection(connection);
        }
        LOGGER.debug("Employee not found.");
        return null;
    }

    @Override
    public boolean addEmployee(Employee employee) {
        Connection connection = null;
        try {
            connection = ConnectionHelper.getConnection();
            PreparedStatement stmt = connection.prepareStatement(ADD_EMPLOYEE_STATEMENT);
            setEmployeeParameters(stmt, employee);
            int result = stmt.executeUpdate();
            return result == 1;
        } catch (SQLException e) {
            LOGGER.error("An SQL Exception occurred." + e.getMessage());
        } finally {
            closeConnection(connection);
        }
        LOGGER.debug("Adding employee failed.");
        return false;
    }

    @Override
    public boolean updateEmployee(Employee employee) {
        Connection connection = null;
        try {
            connection = ConnectionHelper.getConnection();
            PreparedStatement stmt = connection.prepareStatement(UPDATE_STATEMENT);
            setEmployeeParameters(stmt, employee);
            int result = stmt.executeUpdate();
            return result == 1;
        } catch (SQLException e) {
            LOGGER.error("An SQL Exception occurred." + e.getMessage());
        } finally {
            closeConnection(connection);
        }
        LOGGER.debug("Updating employee failed.");
        return false;
    }

    private void setEmployeeParameters(PreparedStatement stmt, Employee employee) throws SQLException {
        stmt.setString(1, employee.getLastName());
        stmt.setString(2, employee.getFirstName());
        stmt.setString(3, employee.getMiddleName());
        stmt.setString(4, employee.getPositionInRC());
        stmt.setString(5, employee.getDateEmployed());
        stmt.setDate(6, java.sql.Date.valueOf(employee.getBirthdate()));
        stmt.setString(7, employee.getBirthplace());
        stmt.setString(8, employee.getSex());
        stmt.setString(9, employee.getCivilStatus());
        stmt.setString(10, employee.getCitizenship());
        stmt.setString(11, employee.getReligion());
        stmt.setDouble(12, employee.getHeight());
        stmt.setDouble(13, employee.getWeight());
        stmt.setString(14, employee.getEmail());
        stmt.setString(15, employee.getSssNo());
        stmt.setString(16, employee.getTinNo());
        stmt.setString(17, employee.getPagibigNo());
        stmt.setString(18, employee.getEmployeeNo());
    }

    private Employee setEmployee(ResultSet rs) throws SQLException {
        Employee employee = new Employee();
        employee.setEmployeeNo(rs.getString("employee_no"));
        employee.setLastName(rs.getString("last_name"));
        employee.setFirstName(rs.getString("first_name"));
        employee.setMiddleName(rs.getString("middle_name"));
        employee.setPositionInRC(rs.getString("position_in_rc"));
        employee.setDateEmployed(rs.getString("date_employed"));
        employee.setBirthdate(rs.getString("birthdate"));
        employee.setBirthplace(rs.getString("birthplace"));
        employee.setSex(rs.getString("sex"));
        employee.setCivilStatus(rs.getString("civil_status"));
        employee.setCitizenship(rs.getString("citizenship"));
        employee.setReligion(rs.getString("religion"));
        employee.setHeight(rs.getDouble("height"));
        employee.setWeight(rs.getDouble("weight"));
        employee.setEmail(rs.getString("email"));
        employee.setSssNo(rs.getString("sss_no"));
        employee.setTinNo(rs.getString("tin_no"));
        employee.setPagibigNo(rs.getString("pagibig_no"));
        return employee;
    }

    private void closeConnection(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                LOGGER.error("Error closing connection: " + e.getMessage());
            }
        }
    }
}
