package com.employee.information.management.data.employee.dao.impl;
import com.employee.information.management.app.model.Employee;
import com.employee.information.management.data.connection.ConnectionHelper;
import com.employee.information.management.data.employee.dao.EmployeeDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDaoImpl implements EmployeeDao {
    Connection c = ConnectionHelper.getConnection();
    private String GET_ALL_EMPLOYEE_STATEMENT;
    private String GET_EMPLOYEE_BY_EMPLOYEE_NO_STATEMENT;


    @Override
    public List<Employee> getAllEmployee()  {
        try {
            PreparedStatement stmt = c.prepareStatement(GET_ALL_EMPLOYEE_STATEMENT);
            ResultSet rs = stmt.executeQuery();
            List<Employee> employees = new ArrayList<>();

            while(rs.next()) {
                employees.add(setEmployee(rs));
            }
            return employees;
        } catch (Exception e) {
        }
        return null;
    }


    @Override
    public Employee getEmployeeByNo(String employee_no) throws RuntimeException {
        try {
            PreparedStatement stmt = c.prepareStatement(GET_EMPLOYEE_BY_EMPLOYEE_NO_STATEMENT);
            stmt.setString(1, employee_no);
            ResultSet rs = stmt.executeQuery();

            if(rs.next()) {
                return setEmployee(rs);
            }

        } catch (Exception ignored) {

        }
        return null;
    }
    /**
     * Helper method to create an Employee object from a ResultSet.
     */
    public Employee setEmployee(ResultSet rs) {
        try{
            Employee employee = new Employee();
            employee.setLastName(rs.getString("last_name"));
            employee.setFirstName(rs.getString("first_name"));
            employee.setMiddleName(rs.getString("middle_name"));
            employee.setPositionInRc(rs.getString("position_in_rc"));
            employee.setDateEmployed(rs.getString("date_employed"));
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
            employee.setEmployeeNo(rs.getString("employee_no"));
            return employee;
        }catch(Exception ignored){

        }
        return null;
    }
}
