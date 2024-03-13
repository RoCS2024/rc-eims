package com.employee.information.management.data.employee.dao.impl;

import com.employee.information.management.app.model.Employee;
import com.employee.information.management.data.connection.ConnectionHelper;
import com.employee.information.management.data.employee.dao.EmployeeDao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeDaoImpl implements EmployeeDao {

    @Override
    public Employee getEmployeeByNo(String employeeNo)  {
        String sql = "SELECT * FROM employee WHERE employee_no = ?";
        try (Connection con = ConnectionHelper.getConnection();
             PreparedStatement statement = con.prepareStatement(sql)) {
            statement.setString(1, employeeNo);
            try (ResultSet rs = statement.executeQuery()) {
                if (rs.next()) {
                    String lastName = rs.getString("last_name");
                    String firstName = rs.getString("first_name");
                    String middleName = rs.getString("middle_name");
                    String positionInRc = rs.getString("position_in_rc");
                    String dateEmployed = rs.getString("date_employed");
                    String birthDate = rs.getString("birthdate");
                    String birthPlace = rs.getString("birthplace");
                    String sex = rs.getString("sex");
                    String civilStatus = rs.getString("civil_status");
                    String citizenship = rs.getString("citizenship");
                    String religion = rs.getString("religion");
                    double height = rs.getDouble("height");
                    double weight = rs.getDouble("weight");
                    String email = rs.getString("email");
                    String sssNo = rs.getString("sss_no");
                    String tinNo = rs.getString("tin_no");
                    String pagibigNo = rs.getString("pagibig_no");
                    String employee_no = rs.getString("employee_no");
                    return new Employee(lastName, firstName, middleName, positionInRc, dateEmployed, birthDate, birthPlace, sex, civilStatus, citizenship, religion, height, weight, email, sssNo, tinNo, pagibigNo, employee_no);
                } else {
                    System.err.println("No employee found with employee no: " + employeeNo);
                }
            }
        } catch (SQLException ex) {
            System.err.println("Error retrieving employee with employee no " + employeeNo + ": " + ex.getMessage());
            ex.printStackTrace();
        }
        return null;
    }
    @Override
    public boolean updateEmployee(Employee employee)  {
        String sql = "UPDATE employee SET last_name = ?, first_name = ?, middle_name = ?, position_in_rc = ?, date_employed = ?, birthdate = ?, birthplace = ?, sex = ?, civil_status = ?, citizenship = ?, religion = ?, height = ?, weight = ?, email = ?, sss_no = ?, tin_no = ?, pagibig_no = ? WHERE employee_no = ?";
        try  (Connection con = ConnectionHelper.getConnection();
              PreparedStatement statement = con.prepareStatement(sql)) {
            statement.setString(1, employee.getLastName());
            statement.setString(2, employee.getFirstName());
            statement.setString(3, employee.getMiddleName());
            statement.setString(4, employee.getPositionInRC());
            statement.setString(5, employee.getDateEmployed());
            statement.setString(6, employee.getBirthDate());
            statement.setString(7, employee.getBirthPlace());
            statement.setString(8, employee.getSex());
            statement.setString(9, employee.getCivilStatus());
            statement.setString(10, employee.getCitizenship());
            statement.setString(11, employee.getReligion());
            statement.setDouble(12, employee.getHeight());
            statement.setDouble(13, employee.getWeight());
            statement.setString(14, employee.getEmail());
            statement.setString(15, employee.getSssNo());
            statement.setString(16, employee.getTinNo());
            statement.setString(17, employee.getPagibigNo());
            statement.setString(18, employee.getEmployeeNo());
            int affectedRows = statement.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException ex) {
            System.err.println("Error updating employee with no. " + employee.getEmployeeNo() + ": " + ex.getMessage());
            ex.printStackTrace();
            return false;
        }
    }
}
