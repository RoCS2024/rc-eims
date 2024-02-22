package com.prefect.system.data.employee.dao.Impl;

import com.prefect.system.app.model.Employee;
import com.prefect.system.data.connection.ConnectionHelper;
import com.prefect.system.data.employee.dao.EmployeeDao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDaoImpl implements EmployeeDao {

    private static final String SAVE_EMPLOYEE_QUERY = "INSERT INTO employee (last_name, first_name, middle_name,position_in_rc, date_employed, birthdate, birthplace, sex, civil_status, citizenship, religion, height, weight, email, sss_no, tin_no, pagibig_no, employee_id ) VALUES (?, ?, ?, ?, ? ,? , ? ,? ,? ,? ,? ,? , ? ,? ,? ,? ,? ,?)";
    private static final String GET_ALL_EMPLOYEE_QUERY = "SELECT * FROM employee";


    @Override
    public Employee saveEmployee(Employee employee) throws SQLException {
        try (Connection connection = ConnectionHelper.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SAVE_EMPLOYEE_QUERY, Statement.RETURN_GENERATED_KEYS)) {

            preparedStatement.setString(1,employee.getLastName());
            preparedStatement.setString(2, employee.getFirstName());
            preparedStatement.setString(3, employee.getMiddleName());
            preparedStatement.setString(4, employee.getPositionInRc()); // POSITION_IN_RC VARCHAR2(64)
            preparedStatement.setString(5, employee.getDateEmployed()); // DATE_EMPLOYED VARCHAR2(32)
            preparedStatement.setTimestamp(6, employee.getBirthdate());     // BIRTHDATE VARCHAR2(32)
            preparedStatement.setString(7, employee.getBirthplace());   // BIRTHPLACE VARCHAR2(64)
            preparedStatement.setString(8, employee.getSex());           // SEX VARCHAR2(8)
            preparedStatement.setString(9, employee.getCivilStatus());  // CIVIL_STATUS VARCHAR2(32)
            preparedStatement.setString(10, employee.getCitizenship()); // CITIZENSHIP VARCHAR2(32)
            preparedStatement.setString(11, employee.getReligion());    // RELIGION VARCHAR2(32)
            preparedStatement.setDouble(12, employee.getHeight());       // HEIGHT NUMBER(8)
            preparedStatement.setDouble(13, employee.getWeight());       // WEIGHT NUMBER(8)
            preparedStatement.setString(14, employee.getEmail());       // EMAIL VARCHAR2(64)
            preparedStatement.setString(15, employee.getSssNo());       // SSS_NO VARCHAR2(16)
            preparedStatement.setString(16, employee.getTinNo());       // TIN_NO VARCHAR2(16)
            preparedStatement.setString(17, employee.getPagibigNo());   // PAGIBIG_NO VARCHAR2(16)
            preparedStatement.setString(18, employee.getEmployeeId());  // EMPLOYEE_ID VARCHAR2(16)


            int affectedRows = preparedStatement.executeUpdate();

            if (affectedRows == 0) {
                throw new SQLException("Saving employee failed, no rows affected.");
            }

            try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    employee.setId(generatedKeys.getLong(1));
                } else {
                    throw new SQLException("Saving diagnosis failed, no ID obtained.");
                }
            }
        }
        return employee;
        }
    private Employee extractEmployeeFromResultSet(ResultSet resultSet) throws SQLException {
        Employee employee = new Employee();
        employee.setLastName(resultSet.getString("last_name"));
        employee.setFirstName(resultSet.getString("first_name"));
        employee.setMiddleName(resultSet.getString("middle_name"));
        employee.setPositionInRc(resultSet.getString("position_in_rc"));
        employee.setDateEmployed(resultSet.getString("date_employed"));
        employee.setBirthdate(resultSet.getTimestamp("birthdate"));
        employee.setBirthplace(resultSet.getString("birthplace"));
        employee.setSex(resultSet.getString("sex"));
        employee.setCivilStatus(resultSet.getString("civil_status"));
        employee.setCitizenship(resultSet.getString("citizenship"));
        employee.setReligion(resultSet.getString("religion"));
        employee.setHeight(resultSet.getDouble("height"));
        employee.setWeight(resultSet.getDouble("weight"));
        employee.setEmail(resultSet.getString("email"));
        employee.setSssNo(resultSet.getString("sss_no"));
        employee.setTinNo(resultSet.getString("tin_no"));
        employee.setPagibigNo(resultSet.getString("pagibig_no"));
        employee.setEmployeeId(resultSet.getString("employee_id"));

        return employee;
    }

    @Override
    public List<Employee> getAllEmployee() throws SQLException {
        List<Employee> employees = new ArrayList<>();

        try (Connection connection = ConnectionHelper.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(GET_ALL_EMPLOYEE_QUERY)) {

            while (resultSet.next()) {
                Employee employee = new Employee();
                employee.setLastName(resultSet.getString("last_name"));
                employee.setFirstName(resultSet.getString("first_name"));
                employee.setMiddleName(resultSet.getString("middle_name"));
                employee.setPositionInRc(resultSet.getString("position_in_rc"));
                employee.setDateEmployed(resultSet.getString("date_employed"));
                employee.setBirthdate(resultSet.getTimestamp("birthdate"));
                employee.setBirthplace(resultSet.getString("birthplace"));
                employee.setSex(resultSet.getString("sex"));
                employee.setCivilStatus(resultSet.getString("civil_status"));
                employee.setCitizenship(resultSet.getString("citizenship"));
                employee.setReligion(resultSet.getString("religion"));
                employee.setHeight(resultSet.getDouble("height"));
                employee.setWeight(resultSet.getDouble("weight"));
                employee.setEmail(resultSet.getString("email"));
                employee.setSssNo(resultSet.getString("sss_no"));
                employee.setTinNo(resultSet.getString("tin_no"));
                employee.setPagibigNo(resultSet.getString("pagibig_no"));
                employee.setEmployeeId(resultSet.getString("employee_id"));

                employees.add(employee);
            }
        }

        return employees;
    }
    @Override
    public Employee getEmployeeById(long id) throws SQLException {
        String query = "SELECT * FROM employee WHERE id = ?";
        try (Connection connection = ConnectionHelper.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setLong(1, id);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    return extractEmployeeFromResultSet(resultSet);
                }
            }
        }
        return null;
    }
    
}
