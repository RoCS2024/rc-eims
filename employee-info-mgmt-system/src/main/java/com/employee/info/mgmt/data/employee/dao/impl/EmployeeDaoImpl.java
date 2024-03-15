package com.employee.info.mgmt.data.employee.dao.impl;

import com.employee.info.mgmt.app.model.Employee;
import com.employee.info.mgmt.data.connection.ConnectionHelper;
import com.employee.info.mgmt.data.employee.dao.EmployeeDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import static com.employee.info.mgmt.data.utils.QueryConstants.*;

public class EmployeeDaoImpl implements EmployeeDao {
    Connection c = ConnectionHelper.getConnection();

    public EmployeeDaoImpl() {
    }

    @Override
    public List<Employee> getAllEmployees() {
        try {
            PreparedStatement stmt = c.prepareStatement(GET_ALL_EMPLOYEE_STATEMENT);
            ResultSet rs = stmt.executeQuery();
            List<Employee> employees = new ArrayList<>();

            while (rs.next()) {
                employees.add(setEmployee(rs));
            }
            return employees;
        } catch (Exception e) {

        }
        return null;
    }

    @Override
    public List<Employee> getAllEmployee() {
        return null;
    }

    @Override
    public Employee getEmployeeById(String id) {
        try {
            PreparedStatement stmt = c.prepareStatement(GET_EMPLOYEE_BY_ID_STATEMENT);
            stmt.setString(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return setEmployee(rs);
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public boolean addEmployee(Employee employee) {
        try {
            PreparedStatement stmt = c.prepareStatement(ADD_EMPLOYEE_STATEMENT);
            stmt.setString(1, employee.getLastName());
            stmt.setString(2, employee.getFirstName());
            stmt.setString(3, employee.getMiddleName());
            stmt.setString(4, employee.getPositionInRC());
            stmt.setString(5, employee.getDateEmployed());
            stmt.setTimestamp(6, Timestamp.valueOf(employee.getBirthdate()));
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
            throw new RuntimeException("Error adding employee", e);
        }
    }

    @Override
    public boolean updateEmployee(Employee employee) {
        try {
            PreparedStatement stmt = c.prepareStatement(UPDATE_STATEMENT);
            stmt.setString(1, employee.getLastName());
            stmt.setString(2, employee.getFirstName());
            stmt.setString(3, employee.getMiddleName());
            stmt.setString(4, employee.getPositionInRC());
            stmt.setString(5, employee.getDateEmployed());
            stmt.setString(6, employee.getBirthdate());
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
            throw new RuntimeException("Error updating employee", e);
        }
    }

    private Employee setEmployee(ResultSet rs) {
        try{
            Employee employee = new Employee();
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
            employee.setHeight(Double.parseDouble(rs.getString("height")));
            employee.setWeight(Double.parseDouble(rs.getString("weight")));
            employee.setEmail(rs.getString("email"));
            employee.setSssNo(rs.getString("sss_no"));
            employee.setTinNo(rs.getString("tin_no"));
            employee.setPagibigNo(rs.getString("pagibig_no"));
            employee.setEmployeeNo(rs.getString("employee_no"));
            return employee;
        } catch (Exception e) {

        }
        return null;
    }


}