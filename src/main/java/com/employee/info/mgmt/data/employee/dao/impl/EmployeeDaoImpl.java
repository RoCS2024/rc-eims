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

/**
 * The EmployeeDaoImpl class implements the EmployeeDao interface
 * it provides methods for interacting with the employee database.
 * It includes methods for retrieving, adding, and updating employee records.
 */
public class EmployeeDaoImpl implements EmployeeDao {

    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeDaoImpl.class);

    /**
     * Constructor for EmployeeDaoImpl.
     * */
    public EmployeeDaoImpl() {
    }

    @Override
    public List<Employee> getAllEmployees() {
        List<Employee> employees = new ArrayList<>();

        try (Connection connection = ConnectionHelper.getConnection()){
            PreparedStatement stmt = connection.prepareStatement(GET_ALL_EMPLOYEE_STATEMENT);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Employee employee = new Employee();
                employee.setEmployeeNo(rs.getString("employee_no"));
                employee.setLastName(rs.getString("last_name"));
                employee.setFirstName(rs.getString("first_name"));
                employee.setMiddleName(rs.getString("middle_name"));
                employee.setPositionInRC(rs.getString("position_in_rc"));
                employee.setDateEmployed(rs.getTimestamp("date_employed"));
                employee.setBirthdate(rs.getTimestamp("birthdate"));
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
                employees.add(employee);
            }
            LOGGER.info("Employee retrieved successfully.");
        } catch (SQLException e) {
            LOGGER.warn("Error retrieving all Employees." + e.getMessage());
            e.printStackTrace();
        }
        LOGGER.debug("Employee database is empty.");
        return employees;
    }


    @Override
    public Employee getEmployeeById(String id) {
        try (Connection connection = ConnectionHelper.getConnection()){
            PreparedStatement stmt = connection.prepareStatement(GET_EMPLOYEE_BY_ID_STATEMENT);
            stmt.setString(1, id);
            try (ResultSet rs = stmt.executeQuery()){
                if (rs.next()) {
                    LOGGER.debug("Employee retrieved successfully.");
                    return setEmployee(rs);
                }
            }
        } catch (Exception e) {
            LOGGER.error("An SQL Exception occurred." + e.getMessage());
        }
        LOGGER.debug("Employee not found.");
        return null;
    }


    @Override
    public boolean addEmployee(Employee employee) {
        try (Connection connection = ConnectionHelper.getConnection()){
            PreparedStatement stmt = connection.prepareStatement(ADD_EMPLOYEE_STATEMENT);
            stmt.setString(1, employee.getLastName());
            stmt.setString(2, employee.getFirstName());
            stmt.setString(3, employee.getMiddleName());
            stmt.setString(4, employee.getPositionInRC());
            stmt.setTimestamp(5, employee.getDateEmployed());
            stmt.setTimestamp(6, employee.getBirthdate());
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

            int result = stmt.executeUpdate();
            return result == 1;
        } catch (Exception e) {
            LOGGER.error("An SQL Exception occurred." + e.getMessage());
        }
        LOGGER.debug("Adding employee failed.");
        return false;
    }


    @Override
    public boolean updateEmployee(Employee employee) {
        try (Connection connection = ConnectionHelper.getConnection()){
            PreparedStatement stmt = connection.prepareStatement(UPDATE_STATEMENT);
            stmt.setString(1, employee.getLastName());
            stmt.setString(2, employee.getFirstName());
            stmt.setString(3, employee.getMiddleName());
            stmt.setString(4, employee.getPositionInRC());
            stmt.setTimestamp(5, employee.getDateEmployed());
            stmt.setTimestamp(6, employee.getBirthdate());
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

            int result = stmt.executeUpdate();
            return result == 1;
        } catch (Exception e) {
            LOGGER.error("An SQL Exception occurred." + e.getMessage());
        }
        LOGGER.debug("Updating employee failed.");
        return false;
    }


    private Employee setEmployee(ResultSet rs) {
        try {
            Employee employee = new Employee();
            employee.setLastName(rs.getString("last_name"));
            employee.setFirstName(rs.getString("first_name"));
            employee.setMiddleName(rs.getString("middle_name"));
            employee.setPositionInRC(rs.getString("position_in_rc"));
            employee.setDateEmployed(rs.getTimestamp("date_employed"));
            employee.setBirthdate(rs.getTimestamp("birthdate"));
            employee.setBirthplace(rs.getString("birthplace"));
            employee.setSex(rs.getString("sex"));
            employee.setCivilStatus(rs.getString("civil_status"));
            employee.setCitizenship(rs.getString("citizenship"));
            employee.setReligion(rs.getString("religion"));
            employee.setHeight(Double.parseDouble(rs.getString("height")));
            employee.setWeight(Double.parseDouble(rs.getString("weight")));
            employee.setEmail(rs.getString("email"));
            employee.setSssNo(rs.getString("sss_no"));
            employee.setTinNo(rs.getString("tin_no"));
            employee.setPagibigNo(rs.getString("pagibig_no"));
            employee.setEmployeeNo(rs.getString("employee_no"));
            return employee;
        } catch (Exception e) {
            LOGGER.error("An SQL Exception occurred." + e.getMessage());
        }
        LOGGER.debug("No employee was set.");
        return null;
    }
}



